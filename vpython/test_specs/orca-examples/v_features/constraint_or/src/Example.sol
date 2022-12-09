// SPDX-License-Identifier: GPL-3.0
pragma solidity ^0.8.0;

contract Example {

    uint public x;
    int public y;
    uint[] public x_sets;
    int[] public y_sets;

    constructor () {
        x = 0;
        y = 0;
    }

    function set_x_one() public {
        require(x == 0);
        x = 1;
        x_sets.push(1);
    }

    function set_x_two() public {
        require(x == 1);
        x = 2;
        x_sets.push(2);
    }

    function set_x_three() public {
        require(x == 2);
        x = 3;
        x_sets.push(3);
    }

    function set_y(int v) public {
        y = v;
        y_sets.push(v);
    }

    function get_x() public returns (uint) {
        return x;
    }

    function get_y() public returns (int) {
        return y;
    }
}
