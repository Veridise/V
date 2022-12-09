// SPDX-License-Identifier: GPL-3.0
pragma solidity ^0.8.0;
contract Unchecked {
    uint dummy;
    function f(uint a, uint b)  public returns (uint) {
        // This subtraction will wrap on underflow.
        dummy = 1;
        unchecked { return a - b; }
    }
    function g(uint a, uint b) pure public returns (uint) {
        // This subtraction will revert on underflow.
        return a - b;
    }
}
