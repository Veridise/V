# Execution Model

[V] allows users to specify relationships between state at specific moments in time. It relies on the observation that it is essential for certain properties to hold between transactions, however they can be violated within a transaction. To capture this intuition, [V] models interactions with the blockchain as a linear sequence of atomic transactions as discussed below.

## Transaction Model

![Execution Model](images/execution_model.png)

[V] models interactions with the blockchain over time as a linear series of atomic transactions. Information may only be queried either at the beginning or the end of a transaction but may not interrupt it. Further, since transactions are guaranteed to terminate, a transaction consists of two important events: `started` and `executed`. As the name implies, `started` indicates that some transaction is just about to start its execution. `executed` then indicates that a transaction has just terminated. The termination of a transaction may occur either because it has `reverted` or because it has `finished` without reverting. Note that these events correspond to the actions of [[V] statements](statements.md).

## [V] Statement Evaluation

A [V] statement is made up of two components, a location and a constraint. The location matches a particular point in time by identifying a transaction and one of the events discussed above. A constraint, on the other hand, identifies a set of states. For a [V] statement to hold, the transaction model must be in a position consistent with the specified location and the constraint must contain the current execution state.

### Assumptions

As can be seen, this execution model makes a few simplifying assumptions. First, it assumes that when a transaction is requested, it is immediately executed. [V] therefore does not allow users to reason about front-running. For example, let’s say some transaction `F` could front-run another transaction `T` for some harmful effect. From the perspective of the transaction model there is no difference between this scenario and one in which `F` is executed and then `T` is executed. This is because [V] does not differentiate the time of request from the time of execution. While we may eventually extend [V] to do so, we currently do this to improve the scalability since separating request from execution could require a symbolic stack to be maintained. 

In addition, [V] does not currently reason about internal transactions. So called internal transactions occur when a contract makes an external call (note our tools support external calls, [V] just cannot specify properties about them). As an example, consider a transaction `T` that initiates an internal transaction `I`. There is currently no way to explicitly specify that a statement should match executions of `T` in which `I` does not revert. Rather, the user must ensure all of the necessary constraints are placed on `T` to ensure `I` will not revert. We plan to extend [V] to include internal transactions (i.e. external calls) in the future by representing them as a finite series of nested transactions.