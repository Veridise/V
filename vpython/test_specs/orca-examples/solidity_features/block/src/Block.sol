// SPDX-License-Identifier: GPL-3.0
pragma solidity ^0.8.8;

contract Block{
    uint256 public foo;
    
    function f() public {
        bytes32 bh = blockhash(block.number);
        uint gl = block.gaslimit;
        address ad = tx.origin;
        address msgsender = msg.sender;
    }
}
