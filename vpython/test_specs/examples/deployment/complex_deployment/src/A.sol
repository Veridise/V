// SPDX-License-Identifier: GPL-3.0

pragma solidity ^0.8.0;

import {B} from "./B.sol";

contract A {

    address b_addr;
    bool alert;

    function set_b(address _b_addr) public {
        b_addr = _b_addr;
    }

    function trigger_alert() public {
        require(B(b_addr).allow_alert());
        alert = true;
    }
}
