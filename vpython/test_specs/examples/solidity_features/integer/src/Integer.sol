// SPDX-License-Identifier: GPL-3.0
pragma solidity ^0.8.0;

contract Integer{
    struct Ints {
        int i;
        int8 i8;
        int24 i24;
        int256 i256;
        uint ui;
        uint8 ui8;
        uint24 ui24;
        uint256 ui256;
    }

    Ints public ints;

    function set() public{
        ints.i8 = 2**4;
        ints.i = ints.i8 << 2;
        ints.i24 = type(int24).min;
        ints.i256 = type(int256).max;
        ints.ui8 = 2**4;
        ints.ui = ints.ui8 << 2;
        ints.ui24 = type(uint24).min;
        ints.ui256 = type(uint256).max;
    }
}
