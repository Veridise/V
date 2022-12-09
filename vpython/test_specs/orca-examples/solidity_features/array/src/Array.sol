// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.5.0 <0.9.0;

contract Array{
    uint256 public foo;
    uint[4] arrFixed;
    uint[] arrDynamic;
    uint[][3] twoDim;

    function init() public{
        arrFixed[1]=2;
        arrDynamic.push(3);
        arrFixed[2] = 4;
        twoDim[0][1] = 2;
    }
}
