// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.6.2 <0.9.0;

import "./InfoFeed.sol";

contract ExternalFuncCall {
    InfoFeed feed;
    function setFeed(InfoFeed addr) public {
        feed = addr;
    }
    function callFeed() public payable {
        require(address(feed) != address(0));
        feed.info{value: 10, gas: 800}();
    }
}
