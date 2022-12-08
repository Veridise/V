// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.4.22 <0.9.0;

contract MappingOfStructs {
    struct Point{
        uint x; uint y;
    }

    mapping (uint256 => Point) public ys;

    function f() public{
        Point memory p = Point(2,3);
        ys[3] = p;
    }

}
