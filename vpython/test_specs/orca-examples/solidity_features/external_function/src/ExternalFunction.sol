// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.4.22 <0.9.0;

import {Oracle} from "./Oracle.sol";

contract ExternalFunction {
    Oracle private oracle;
    uint private exchangeRate;

    constructor (address addr) {
        oracle = Oracle(addr);
    }

    function buySomething() public {
        oracle.query("USD", this.oracleResponse);
    }

    function oracleResponse(uint response) public {
        require(
                msg.sender == address(oracle),
                "Only oracle can call this."
                );
        exchangeRate = response;
    }

}
