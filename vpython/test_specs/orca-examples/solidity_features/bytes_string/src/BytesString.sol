// SPDX-License-Identifier: GPL-3.0
pragma solidity ^0.8.12;

contract BytesString {
    string public s = "Storage";
    function f(bytes calldata bc, string memory sm, bytes calldata b) public {
        string memory concatString = string.concat(s, string(bc), "Literal", sm);
        assert((bytes(s).length + bc.length + 7 + bytes(sm).length) == bytes(concatString).length);

        bytes memory concatBytes = bytes.concat(bytes(s), bc, bc[:2], "Literal", bytes(sm), b);
        assert((bytes(s).length + bc.length + 2 + 7 + bytes(sm).length + b.length) == concatBytes.length);
    }
}
