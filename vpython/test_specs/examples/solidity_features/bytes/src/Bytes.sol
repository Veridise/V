// SPDX-License-Identifier: GPL-3.0
pragma solidity ^0.8.12;

contract Bytes {
    bytes2 public d = 0x1234;
    bytes2 public e = 0x0012;
    bytes4 public f = 0;
    bytes4 public g = 0x0;
    uint dummy;

    function bytesConcat() public returns(bytes memory) {
        bytes memory bc = bytes.concat(f,g);
        dummy = 1;
        return bc;
    }
}
