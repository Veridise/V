// SPDX-License-Identifier: AGPL-3.0-or-later
/// Colander.sol -- A Stability Pool
// Copyright (C) 2022
//
// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU Affero General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU Affero General Public License for more details.
//
// You should have received a copy of the GNU Affero General Public License
// along with this program.  If not, see <https://www.gnu.org/licenses/>.
pragma solidity ^0.8.10;
import "@openzeppelin/contracts-upgradeable/token/ERC20/IERC20Upgradeable.sol";
import "@openzeppelin/contracts-upgradeable/token/ERC20/utils/SafeERC20Upgradeable.sol";
import "@openzeppelin/contracts-upgradeable/security/ReentrancyGuardUpgradeable.sol";
import "@openzeppelin/contracts-upgradeable/proxy/utils/Initializable.sol";
import "./ceros/interfaces/IDao.sol";
import "./interfaces/GemJoinLike.sol";
import "./interfaces/ClipperLike.sol";
import "./interfaces/SpotLike.sol";
import "./interfaces/DexV3Like.sol";
import "./interfaces/PipLike.sol";
import "./interfaces/IStabilityPool.sol";
import "./interfaces/IColanderRewards.sol";
/*
   "Donate StableCoins to the pool and earn rewards".
   This contract lets you deposit Stablecoins and earn
   Stablecoin rewards. Rewards are distributed over a 
   timeline. The pool is used to do loseless purchases
   from auctions.
*/
contract Colander is IStabilityPool, ReentrancyGuardUpgradeable {

    // --- Wrapper ---
    using SafeERC20Upgradeable for IERC20Upgradeable;
    
    // --- Auth ---
    mapping (address => uint) public wards;
    function rely(address _guy) external auth { wards[_guy] = 1; }
    function deny(address _guy) external auth { wards[_guy] = 0; }
    modifier auth { if(wards[msg.sender] != 1) revert Unauthorized(msg.sender); _; }

    // --- Derivative ---
    string public name;
    string public symbol;
    uint8 public decimals;
    uint256 public override totalSupply;
    mapping(address => uint) public override balanceOf;

    // --- State Vars ---
    IERC20Upgradeable public stablecoin;
    IDao public interaction;
    SpotLike public spotter;
    DexV3Like public dex;
    IColanderRewards public rewards;
    uint256 public profitRange;  // Minimum profit for surge in %  [ray]
    uint256 public priceImpact;  // Acceptable swap price in %     [wad]
    uint256 public surplus;      // Amount of profit after swap    [wad]
    mapping(address => uint) public entryTime;  // Anti flash loans     [sec]
    uint256 public flashDelay;                  // Exit function delay  [sec]
    uint256 public live;  // Active Flag

    // --- Mods ---
    modifier isLive {

        if (live != 1) revert NotLive(address(this));
        _;
    }

    // --- Init ---
    function initialize(string memory _name, string memory _symbol, address _stablecoin, address _interaction, address _spotter, address _dex, address _rewards, uint256 _flashDelay) public initializer {
        
        wards[msg.sender] = 1;
        live = 1;
        name = _name;
        symbol = _symbol;
        stablecoin = IERC20Upgradeable(_stablecoin);
        interaction = IDao(_interaction);
        spotter = SpotLike(_spotter);
        dex = DexV3Like(_dex);
        rewards = IColanderRewards(_rewards);
        flashDelay = _flashDelay;

        decimals = 18;

        __ReentrancyGuard_init_unchained();
        
        emit Initialize(msg.sender);
    }
    function setProfitRange(uint256 _ray) external isLive auth {

        profitRange = _ray;
        emit ProfitRange(msg.sender, _ray);
    }
    function setPriceImpact(uint256 _wad) external isLive auth {

        priceImpact = _wad;
        emit PriceImpact(msg.sender, _wad);
    }
    function setRewards(address _rewards) external isLive auth {

        rewards = IColanderRewards(_rewards);
        emit Rewards(_rewards);
    }
    function setFlashDelay(uint _flashDelay) external isLive auth {

        flashDelay = _flashDelay;
        emit FlashDelay(_flashDelay);
    }

    // --- Math ---
    uint256 constant BLN = 10 **  9;
    uint256 constant WAD = 10 ** 18;
    uint256 constant RAY = 10 ** 27;
    function rdiv(uint256 x, uint256 y) internal pure returns (uint256 z) {

        unchecked { z = (x * RAY) / y; }
    }

    // --- External ---
    function join(uint256 _wad) external isLive nonReentrant {

        // Set flash delay
        entryTime[msg.sender] = block.timestamp + flashDelay;

        // Update rewards
        rewards.reflect(msg.sender, 0);

        // State changes
        uint256 deposit = balanceOf[msg.sender];
        balanceOf[msg.sender] += _wad;
        totalSupply += _wad;

        // Method calls
        stablecoin.safeTransferFrom(msg.sender, address(this), _wad);

        // Events
        emit Join(msg.sender, deposit, balanceOf[msg.sender]);
    }
    function exit(uint256 _wad) external isLive nonReentrant {

        // Checks
        if (block.timestamp <= entryTime[msg.sender]) revert InFlashDelay();

        // Update rewards
        uint256 deposit = balanceOf[msg.sender];
        uint256 amount = _wad > deposit ? deposit: _wad;
        rewards.reflect(msg.sender, amount);

        // State changes
        balanceOf[msg.sender] -= amount;
        totalSupply -= amount;

        // Method calls
        stablecoin.safeTransfer(address(rewards), amount);

        // Events
        emit Exit(msg.sender, deposit, balanceOf[msg.sender]);
    }

    // --- Auction ---
    function surge(address _collateral, uint256 _auction_id) external isLive auth nonReentrant {

        // Measure the stablecoin expense
        uint256 abacusPrice;  // Decreasing price    [ray]
        uint256 feedPrice;    // Oracle price        [ray]
        uint256 tab;          // Auction debt        [rad]
        uint256 lot;          // Auction collateral  [wad]
        {
            (, bytes32 ilk,, address clip) = IDao(interaction).collaterals(_collateral);
            // CollateralType memory collateral = Interaction(interaction).collaterals(_collateral);
            (,abacusPrice,,) = ClipperLike(clip).getStatus(_auction_id);
            feedPrice = _getFeedPrice(ilk);  // [ray]

            if (abacusPrice >= feedPrice) revert IStabilityPool.BufZone();
            // require(abacusPrice < feedPrice, "Colander/buf-zone");

            tab = ClipperLike(clip).sales(_auction_id).tab;
            lot = ClipperLike(clip).sales(_auction_id).lot;

            if (tab == 0 || lot == 0) revert IStabilityPool.InvalidAuction();
            // require(tab > 0 && lot > 0, "Colander/invalid-auction");
            // Calculate debt per collateral

            uint256 auctionPrice = tab / lot;  // [ray]

            if (auctionPrice >= feedPrice) revert IStabilityPool.AbsurdPrice();
            else if (auctionPrice >= abacusPrice) revert IStabilityPool.SinZone();
            // require(auctionPrice < feedPrice, "Colander/absurd-price");
            // require(auctionPrice < abacusPrice, "Colander/sin-zone");

            uint256 y = (feedPrice * profitRange) / RAY;
            uint256 threshold = feedPrice - y;

            if (auctionPrice > threshold) revert IStabilityPool.AbsurdThreshold();
            else if (abacusPrice > threshold) revert IStabilityPool.InactiveZone();
            // require(auctionPrice <= threshold, "Colander/absurd-threshold");
            // require(abacusPrice <= threshold, "Colander/inactive-zone");
        }

        // Calculate lot and buy
        uint256 lotAmount = (totalSupply * RAY) / abacusPrice;
        if (lotAmount > lot) lotAmount = lot;
        stablecoin.safeApprove(address(interaction), type(uint256).max);
        interaction.buyFromAuction(_collateral, _auction_id, lotAmount, abacusPrice, address(this));
        stablecoin.safeApprove(address(interaction), 0);

        // Swap on dex
        uint256 amount = IERC20Upgradeable(_collateral).balanceOf(address(this));
        uint256 z = (feedPrice * amount) / RAY;
        uint256 expectedAmount = z - (z * priceImpact) / WAD;
        IERC20Upgradeable(_collateral).safeApprove(address(dex), amount);
        uint256 amountOut = _swap(_collateral, amount, expectedAmount, block.timestamp + 300);
        IERC20Upgradeable(_collateral).safeApprove(address(dex), 0);
       
        // Recalculate surplus
        surplus = stablecoin.balanceOf(address(this)) - totalSupply;

        // Emit event
        emit Surge(amount, expectedAmount, amountOut);
    }
    function _getFeedPrice(bytes32 _ilk) private returns(uint256 _feedPrice) {

        (PipLike pip, ) = spotter.ilks(_ilk);
        (bytes32 val, bool has) = pip.peek();
        if (!has) revert InvalidPrice();
        // require(has, "Colander/invalid-price");
        _feedPrice = rdiv((uint256(val) * BLN), spotter.par());
    }
    function _swap(address _tokenIn, uint256 _amountIn, uint256 _amountOutMin, uint256 _deadline) private returns(uint256) {

        uint24 fee = 3000;
        uint160 sqrtPriceLimitX96 = 0;
        
        DexV3Like.ExactInputSingleParams memory params = DexV3Like.ExactInputSingleParams(
            _tokenIn,             // tokenIn
            address(stablecoin),  // tokenOut
            fee,                  // fee
            address(this),        // recipient
            _deadline,            // deadline
            _amountIn,            // amountIn
            _amountOutMin,        // amountOut (priceImpact included)
            sqrtPriceLimitX96     // 0
        );
        return dex.exactInputSingle(params);
    }

    // --- Rewards ---
    function distribute(uint256 _wad) external isLive auth nonReentrant {

        if (surplus < _wad) revert InsufficientSurplus(surplus);

        surplus -= _wad;

        IERC20Upgradeable(stablecoin).approve(address(rewards), _wad);

        rewards.replenish(_wad);

        emit Distribute(msg.sender, _wad);
    }
    function cage() external auth {

        live = 0;
        
        rewards.cage();

        emit Cage();
    }
    uint256[33] private __gap;
}
contract ColanderRewards is Initializable, IColanderRewards {
    // --- Wrapper ---
    using SafeERC20Upgradeable for IERC20Upgradeable;
    // --- Auth ---
    mapping (address => uint) public wards;
    function rely(address _guy) external auth { wards[_guy] = 1; }
    function deny(address _guy) external auth { wards[_guy] = 0; }
    modifier auth { if(wards[msg.sender] != 1) revert IStabilityPool.Unauthorized(msg.sender); _; }
    // --- Reward Data ---
    uint public spread;      // Distribution time       [sec]
    uint public endTime;     // Time "now" + spread     [sec]
    uint public rate;        // Emission per second     [wad]
    uint public tps;         // Stablecoins per share   [wad]
    uint public lastUpdate;  // Last tps update         [sec]
    uint public exitDelay;   // User unstake delay      [sec]
    IERC20Upgradeable public stablecoin;  // The Stable Coin
    IStabilityPool public stabilityPool;  // The StabilityPool
    mapping(address => uint) public tpsPaid;      // Stablecoin per share paid
    mapping(address => uint) public rewards;      // Accumulated rewards
    mapping(address => uint) public withdrawn;    // Capital withdrawn
    mapping(address => uint) public unstakeTime;  // Time of Unstake
    uint public live;     // Active Flag
    // --- Events ---
    event Initialize(address indexed _token, uint indexed _duration, uint indexed _exitDelay);
    event Replenish(uint _reward);
    event Spread(uint _newDuration);
    event ExitDelay(uint _exitDelay);
    event Redeem(address[] indexed _user);
    // --- Init ---
    function initialize(address _stablecoin, address _stabilityPool, uint _spread, uint _exitDelay) public initializer {
        wards[msg.sender] = 1;
        live = 1;
        stablecoin = IERC20Upgradeable(_stablecoin);
        stabilityPool = IStabilityPool(_stabilityPool);
        spread = _spread;
        exitDelay = _exitDelay;
        emit Initialize(_stablecoin, _spread, _exitDelay);
    }
    // --- Mods ---
    modifier update(address _account) {
        tps = tokensPerShare();
        lastUpdate = lastTimeRewardApplicable();
        if (_account != address(0)) {
            rewards[_account] = earned(_account);
            tpsPaid[_account] = tps;
        }
        _;
    }
    // --- Math ---
    function _min(uint a, uint b) internal pure returns (uint) {
        return a < b ? a : b;
    }
    // --- Views ---
    function lastTimeRewardApplicable() public view returns (uint) {
        return _min(block.timestamp, endTime);
    }
    function tokensPerShare() public view returns (uint) {
        uint256 totalSupply = stabilityPool.totalSupply();
        if (totalSupply <= 0 || block.timestamp <= lastUpdate) {
            return tps;
        }
        uint latest = lastTimeRewardApplicable();
        return tps + (((latest - lastUpdate) * rate * 1e18) / totalSupply);
    }
    function earned(address _account) public view returns (uint) {
        uint perToken = tokensPerShare() - tpsPaid[_account];
        return ((stabilityPool.balanceOf(_account) * perToken) / 1e18) + rewards[_account];
    }
    function redeemable(address account) public view returns (uint) {
        return stabilityPool.balanceOf(account) + earned(account);
    }
    function getRewardForDuration() external view returns (uint) {
        return rate * spread;
    }
    function getAPR() external view returns (uint) {
        uint256 totalSupply = stabilityPool.totalSupply();
        if(spread == 0 || totalSupply == 0) {
            return 0;
        }
        return ((rate * 31536000 * 1e18) / totalSupply) * 100;
    }
    // --- External ---
    function reflect(address _depositor, uint256 _wad) external auth update(_depositor) {
        if (_wad != 0) {
            withdrawn[_depositor] += _wad;
            unstakeTime[_depositor] = block.timestamp + exitDelay;
        }
    }
    function replenish(uint _wad) external update(address(0)) {
        if (live != 1) revert IStabilityPool.NotLive(address(this));
        if (block.timestamp >= endTime) {
            rate = _wad / spread;
        } else {
            uint remaining = endTime - block.timestamp;
            uint leftover = remaining * rate;
            rate = (_wad + leftover) / spread;
        }
        lastUpdate = block.timestamp;
        endTime = block.timestamp + spread;
        IERC20Upgradeable(stablecoin).safeTransferFrom(msg.sender, address(this), _wad);
        
        emit Replenish(_wad);
    }
    function redeemBatch(address[] memory accounts) external {
        if (live != 1) revert IStabilityPool.NotLive(address(this));
        for (uint i = 0; i < accounts.length; i++) {
            if (block.timestamp < unstakeTime[accounts[i]] && unstakeTime[accounts[i]] != 0)
                continue;
            
            uint _amount = rewards[accounts[i]] + withdrawn[accounts[i]];
            if (_amount > 0) {
                rewards[accounts[i]] = 0;
                withdrawn[accounts[i]] = 0;
                IERC20Upgradeable(stablecoin).safeTransfer(accounts[i], _amount);
            }
        }
       
        emit Redeem(accounts);
    }
    function setSpread(uint _spread) external auth {
        if (_spread <= 0) revert IStabilityPool.ZeroSpread();
        // require(_spread > 0, "ColanderRewards/duration-non-zero");
        spread = _spread;
        emit Spread(_spread);
    }
    function setExitDelay(uint _exitDelay) external auth {
        exitDelay = _exitDelay;
        emit ExitDelay(_exitDelay);
    }
    function cage() external auth {
        live = 0;
    }
    uint256[36] private __gap;
}