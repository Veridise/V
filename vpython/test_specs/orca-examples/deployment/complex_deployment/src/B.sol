// SPDX-License-Identifier: GPL-3.0

pragma solidity ^0.8.0;

import {C} from "./C.sol";

contract B {

    address c_addr;
    bool alert;

    constructor(address _c_addr) {
        c_addr = _c_addr;
    }

    function allow_alert() public returns (bool) {
        return C(c_addr).initialized();
    }
}
