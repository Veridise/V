// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.4.16 <0.9.0;

contract StructOfStructs {
    struct twod{
        uint x; uint y;
    }

    struct threed{
        twod td;
        uint z;
    }

    uint public foo;

    function f() public{
        twod memory td = twod(1,2);
        threed memory thd = threed(td,2);
    }
}
