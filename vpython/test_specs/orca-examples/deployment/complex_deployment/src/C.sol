// SPDX-License-Identifier: GPL-3.0

pragma solidity ^0.8.0;

import {D} from "./D.sol";

contract C {

    D d;

    constructor(address _d_addr) {
        d = D(_d_addr);
    }

    function initialized() public returns (bool) {
        return d.exists();
    }
}
