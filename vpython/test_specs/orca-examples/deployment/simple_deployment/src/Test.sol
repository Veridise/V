// SPDX-License-Identifier: GPL-3.0

pragma solidity ^0.8.0;

contract Test {

    uint256 public num;

    constructor(uint256 _num) {
        num = _num;
    }

    function foo(uint256 _num) public {
        require(num == 1);
        num = _num;
    }

    function bar(uint256 _num) public {
        require(num == 2);
        num = _num;
    }

    function baz(uint256 _num) public {
        require(num == 3);
        num = _num;
    }
}
