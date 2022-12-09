// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.5.0 <0.9.0;

contract Scoping {
    uint public foo;

    function minimalScoping() public{
        uint same = 1;
        {
            same = 2;
        }

        {
            uint same;
            same = 3;
        }
        require(same == 2, "same is not 1");
    }
}
