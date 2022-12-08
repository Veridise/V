// SPDX-License-Identifier: GPL-3.0
pragma solidity ^0.8.8;

contract Operators{
    uint public foo;
    function f() public{
        uint16 a = 2;
        a+=3;
        a--;
        uint b = a**(++a);
        bool c = true;
        b = c ? a : b;
    }
}
