// SPDX-License-Identifier: GPL-3.0
pragma solidity ^0.8.0;

contract Example {

    uint256 public x;

    function do_arithmetic(uint256 i) public returns (uint256) {
        x = (i * (i+1) / 2);
        return x;
    }
}
