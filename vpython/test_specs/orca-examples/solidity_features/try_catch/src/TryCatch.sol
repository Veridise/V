// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.8.1;

import "./DataFeed.sol";

contract TryCatch {
    DataFeed feed;

    constructor (address _feed) {
        feed = DataFeed(_feed);
    }

    uint public errorCount;
    function rate(address token) public returns (uint value, bool success) {
        require(errorCount < 10);
        try feed.getData(token) returns (uint v) {
            return (v, true);
        } catch Error(string memory /*reason*/) {
            errorCount++;
            return (0, false);
        } catch Panic(uint /*errorCode*/) {
            errorCount++;
            return (0, false);
        } catch (bytes memory /*lowLevelData*/) {
            errorCount++;
            return (0, false);
        }
    }
}
