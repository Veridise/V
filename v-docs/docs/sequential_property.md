# Sequential Properties

Sequential properties are a special case of temporal properties. Rather than reasoning about arbitrary transactions like temporal properties, sequential properties reason about specific sequences of transactions defined by the user. While they are less general than their temporal counterparts, they are often easier to write and verify. Such properties are specified by composing [V] statements and let statements using the sequence operator defined below.

## Behavioral Operators

In [V]’s [execution model](execution_model.md), time is modeled as a sequential series of transactions which are further decomposed into specific points of interest. To help navigate these divisions and to make specifying multiple transactions easy without requiring users to reason about the execution of a transaction explicitly, we provide the sequence operator as described below.

|  Operator  |   Use   |  Description  |
| :--------- | :-----: | :------------ |
| Sequence   | `a ; b`  | `a` holds followed by `b` in the appropriate slot of the next transaction |

This operator allows users to specify sequences of transactions without having to directly reason about the number of steps between them in the execution model. For example, from a temporal perspective `finished(c.foo) ; started(c.bar) = finished(c.foo) && X started(c.bar)` while `finished(c.foo) ; finished(c.bar) = finished(c.foo) && X X finished(c.bar)`. The sequence operator allows the number of explicit time-steps to remain hidden from view by advancing time to the appropriate location in the next transaction. Note that this means the semantics of the `a ; b` is determined by the identify of `a` and `b`. In addition, note that `started(c.foo) ; finished(c.foo)` implies that two `c.foo` transactions will be executed.

## Example

*Example 1*

Two sequential token transfers from `usr1` to `usr2` of amounts `a` and `b` are equal to a single transfer of `a + b`.
```
finished(t1.transfer(to, amt), t1 = t2 && id(t1) != id(t2) && sender = usr1 && amt = a && to = user2 |=> true) ;
finished(t1.transfer(to, amt), sender = usr1 && amt = b && to = usr2 |=> true) ; 
finished(t2.transfer(to, amt), sender = usr1 && amt = a + b && to = usr2 |=> t1 = t2)
```