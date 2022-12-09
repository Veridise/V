// SPDX-License-Identifier: GPL-3.0
pragma solidity ^0.8.0;

contract StructEnum {
    struct  Voter { // Struct
        uint weight;
        bool voted;
        address delegate;
        uint vote;
    }

        Voter public voter;

    enum State { Created, Locked, Inactive }

    State public state;

    function setVoterAndState() public{
        voter.weight = 0;
        voter.voted = false;
        voter.delegate = address(0);
        voter.vote = 0;
        state = State.Created;
    }

}
