// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.5.0 <0.9.0;

contract Calldata{
    uint public foo;

    function f(uint[] calldata arr) public returns(uint){
        return arr[0];
    }
}
