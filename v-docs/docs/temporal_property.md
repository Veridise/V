# Temporal Properties

Temporal properties allow users to specify a property over arbitrary amounts of time. They are extremely useful for checking protocol behaviors amid unknown user interaction. These properties are specified by composing one or more [[V] Statements](statements.md) using the logical and temporal operators described below.

## Temporal Operators

Unlike logical operators, temporal operators specifically specify properties over time. All but the sequence operator are inherited from [Linear Temporal Logic (LTL)](https://en.wikipedia.org/wiki/Linear_temporal_logic) and have the same semantics. In addition, the sequence operator has the same semantics that it does in [Sequential Properties](sequential_property.md).

|  Operator  |   Use   |  Description  |
| :--------- | :-----: | :------------ |
| Always     | `[] a`  | `a` holds from now on |
| Eventually | `<> a`  | `a` either holds now or at some point in the future |
| Next       | `X a`   | `a` holds in the next state |
| Until      | `a U b` | `a` holds at least until `b` holds and `b` eventually holds |
| Sequence   | `a ; b` | `a` holds followed by `b` in the appropriate slot of the next transaction |

## Logical Operators

In addition to temporal operators, statements can be composed with the following logical operators.

|   Operator   |    Use    |  Description  |
| :----------- | :-------: | :------------ |
| Logical AND  | `a && b`  | Checks if both `a` and `b` hold |
| Logical OR   | `a || b`  | Checks if either `a`, `b` or both hold |
| Logical NOT  | `!a`      | Checks if `a` does not hold |
| Implication  | `a ==> b` | Checks that `b` holds if `a` holds |

## Common Mistakes

As it can be difficult to reason about the implications of temporal operators at time, here we discuss a few common mistakes we’ve seen. 

### [V] Statements Refer to Specific Moments in Time

While conventional LTL operates over program states, [V] operates over specific moments in the lifecycle of a contract as described by the [execution model](execution_model.md). As such, there are certain temporal expressions that are useful in LTL but have trivial counterexamples in [V] since they require a violation of the execution model to hold. Such temporal expressions typically imply that time has either stopped or that it is not linear. 

As an example, consider the temporal expression `[] action(txn, ...)`. This statement has a trivial counterexample since it is impossible to stay in a state consistent with `action` and `txn`. More specifically, consider `[] started(token.transfer)` . For this to hold, a `transfer` transaction must always be starting its execution on `token`. Note that this implies that time halts since the transaction never completes.

As another example, consider the temporal expression `action1(t1, ...) && action2(t2, ...)`.  This statement also has a trivial counterexample since it is impossible to be in a state consistent with `action1` and `t1` at the same time as `action2` and `t2` unless `action1 = action2` and `t1 = t2`. If this were to occur time could not be linear as it would have to be in two states at once. More specifically, consider `started(c.foo) && started(c.bar)`. For this to hold two transactions must have been started on contract `c` at the same time.

## Example

### Example 1

Whenever `usr` deposits `X` funds in the wallet, they can eventually withdraw them.

```solidity
[](finished(wallet.deposit, sender = usr && value = X) ==> 
  <>finished(wallet.withdraw(amt), sender = usr && amt = X))
```

### Example 2

`usr` cannot `withdraw` their funds until `close`  has been called in a state where `failed` holds.