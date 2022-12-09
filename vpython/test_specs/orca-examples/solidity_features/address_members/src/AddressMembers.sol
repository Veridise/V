// SPDX-License-Identifier: GPL-3.0
pragma solidity ^0.8.8;

contract AddressMembers{
    uint256 public foo;
    
    function f() public{
        address ad = msg.sender;
        uint bl = ad.balance;
        bytes memory code = ad.code;
    }
}
