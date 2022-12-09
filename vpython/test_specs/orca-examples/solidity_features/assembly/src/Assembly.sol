// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.4.16 <0.9.0;

contract Assembly {
    uint public u;
    function at() public  {
        u  = 1;
        assembly {
            let size := 0
        }
    }
}
