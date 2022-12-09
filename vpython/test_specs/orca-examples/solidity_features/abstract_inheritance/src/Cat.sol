// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.6.0 <0.9.0;

import {Feline} from "./Feline.sol";

contract Cat is Feline {
    uint public dummy;
    function utterance() public override returns (bytes32) {
        dummy = 1;
        return "miaow";
    }
}
