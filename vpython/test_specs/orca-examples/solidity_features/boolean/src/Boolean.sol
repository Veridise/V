// SPDX-License-Identifier: GPL-3.0
pragma solidity ^0.8.0;

contract Boolean {
    bool public a;
    bool public b;
    function methods() public returns (bool){
        bool c = !a || b && (a==b) || (a!=b) && true;
        a = true;
        return c;
    }
}
