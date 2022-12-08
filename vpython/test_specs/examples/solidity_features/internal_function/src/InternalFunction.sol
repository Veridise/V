// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.4.16 <0.9.0;

import "./ArrayUtils.sol";

contract InternalFunction {
    using ArrayUtils for *;
    uint public dummy;
    function pyramid(uint l) public returns (uint) {
        dummy = 1;
        return ArrayUtils.range(l).map(square).reduce(sum);
    }

    function square(uint x) internal pure returns (uint) {
        return x * x;
    }

    function sum(uint x, uint y) internal pure returns (uint) {
        return x + y;
    }
}
