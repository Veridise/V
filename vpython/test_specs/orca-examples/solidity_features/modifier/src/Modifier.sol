// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.8.1;

contract Modifier {
    bool public locked;
    modifier noReentrancy() {
        require(
                !locked,
                "Reentrant call."
                );
        locked = true;
        _;
        locked = false;
    }

    /// This function is protected by a mutex, which means that
    /// reentrant calls from within `msg.sender.call` cannot call `f` again.
    /// The `return 7` statement assigns 7 to the return value but still
    /// executes the statement `locked = false` in the modifier.
    function f() public noReentrancy returns (uint) {
        (bool success,) = msg.sender.call("");
        require(success);
        return 7;
    }
}
