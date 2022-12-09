// SPDX-License-Identifier: GPL-3.0
pragma solidity ^0.8.0;

uint constant X = 32**22 + 8;

contract Constant {
    string constant TEXT = "abc";
    bytes32 constant MY_HASH = keccak256("abc");
    uint immutable decimals;
    uint immutable maxBalance;
    address immutable owner = msg.sender;
    uint public dummy;

    constructor(uint decimals_, address ref) {
        decimals = decimals_;
        // Assignments to immutables can even access the environment.
        maxBalance = ref.balance;
    }

    function isBalanceTooHigh(address other) public returns (bool) {
        dummy = 20;
        return other.balance > maxBalance;
    }

}
