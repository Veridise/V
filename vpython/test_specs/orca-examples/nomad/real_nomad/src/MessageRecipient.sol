// SPDX-License-Identifier: MIT OR Apache-2.0
pragma solidity ^0.8.0;

interface IMessageRecipient {
    function handle(
                    uint32 _origin,
                    uint32 _nonce,
                    bytes32 _sender,
                    bytes memory _message
                    ) external ;
}

contract MessageRecipient is IMessageRecipient {
    event Handle(uint32 _origin,
                 uint32 _nonce,
                 bytes32 _sender,
                 bytes _message
                 );

    constructor() {}

    function handle(uint32 _origin,
                    uint32 _nonce,
                    bytes32 _sender,
                    bytes memory _message) external {
        emit Handle(_origin, _nonce, _sender, _message);
    }
}
