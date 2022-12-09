// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.4.22 <0.9.0;

contract OmittedName {
    // omitted name for parameter
    uint public dummy;
    function func(uint k, uint) public returns(uint) {
        dummy = 1;
        return k;
    }
}
