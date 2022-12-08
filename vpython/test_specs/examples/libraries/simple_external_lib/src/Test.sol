// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.8.5 <0.9.0;

import {SafeMath} from "./SafeMath.sol";

contract Test {
    uint public x;
    uint public y;

    function foo() public {
        x = SafeMath.add(x,y);
    }
}
