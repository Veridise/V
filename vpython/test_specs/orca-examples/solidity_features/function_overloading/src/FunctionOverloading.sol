// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.4.16 <0.9.0;

contract FunctionOverloading {
    uint out;
    function f(uint value) public returns (uint) {
        out = value;
        return out;
    }

    function f(uint value, bool really) public returns (uint) {
        require(false);
        if (really)
            out = value;
        return out;
    }
}


