// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.8.1;

contract ThisContract {
    uint public b = 2;
    mapping(uint => uint) public intMap;

    function f() public{
        uint bal = this.c();
        b = this.intMap(2);
        require(bal == 3, "bal is not 3");
        require(b == 0, "b is not 0");
    }

    function c() public view returns (uint){
        return 3;
    }
}
