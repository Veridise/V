// SPDX-License-Identifier: GPL-3.0
pragma solidity ^0.8.0;

contract AddressPayable{
    address payable z;
    uint256 public foo;
    function simpleFunc() public payable {
        address payable x = payable(address(0x123));
        address myAddress = address(this);
        if (x.balance < 10 && myAddress.balance >= 10) x.transfer(10);
        bytes memory payload = abi.encodeWithSignature("register(string)", "MyName");
        (bool success, bytes memory returnData) = x.call{gas: 1000000, value: 1 ether}(abi.encodeWithSignature("register(string)", "MyName"));
        // require(success);
    }
}
