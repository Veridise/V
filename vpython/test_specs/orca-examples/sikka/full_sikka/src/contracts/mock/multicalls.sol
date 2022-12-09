// SPDX-License-Identifier: GPL-3.0

pragma solidity ^0.8.10;

interface multicalls {
     function multicall(bytes[] calldata data) external payable returns (bytes[] memory results);
}