# Temporal Specifications

Temporal specifications allow users to specify properties over arbitrary amounts of time. They are extremely useful for checking protocol behaviors amid unknown user interaction. A temporal specification is made up of several sections discussed below.

## Variables

The variables section is an optional section that declares specification variables. They can be declared using the following syntax:

```solidity
vars: type1 name1, type2 name2, ...
```

For more details, please see the page about [specification variables](vars_and_macros.md).

## Fairness

The fairness section is an optional section that defines a fairness property. Unlike a specification that *checks* if a particular temporal property holds, a fairness property *requires* that a temporal property holds. As such it is used to constrain the allowable behavior of the system and to enforce that specific behaviors occur. A fairness property can be declared as follows, where `tprop` is a [temporal property](temporal_property.md):

```solidity
fair: tprop
```

## Specification

The specification section is a required section that defines the temporal property to check. It can be declared as follows, where `tprop` is a [temporal property](temporal_property.md):

```solidity
spec: tprop
```

## Examples
### Example 1
Whenever some user deposits `X` funds they can eventually withdraw `Y` funds where `Y <= X`
```
vars: address u, uint X
spec: [](finished(wallet.deposit, sender = u && value = X) ==>
      <> finished(wallet.withdraw(amt), sender = u && amt <= X))
```

### Example 2
Note that the above specification has a trivial counterexample where the user does not ever attempt to perform a withdraw. We therefore need a fairness property that specifies that the user will always attempt to withdraw funds.
```
vars: address u, uint X
fair: []<> started(wallet.withdraw(amt), sender = u && amt <= X)
spec: [](finished(wallet.deposit, sender = u && value = X) ==>
      <> finished(wallet.withdraw(amt), sender = u && amt <= X))
```