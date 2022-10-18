# Behavioral Specifications

Behavioral specifications allow to specify properties over a specific sequence of transactions. These are useful for determining the correctness of a specific sequence of behaviors.

## Variables

The variables section is an optional section that declares specification variables. They can be declared using the following syntax:

```solidity
vars: type1 name1, type2 name2, ...
```

For more details, please see the page about [specification variables](statements.md).

## Initialization

The initialization section is an optional section that specifies how to initialize the state of the blockchain for the given specification. Whereas the specification section is checked to determine if it holds, the initialization section is required to hold. The initialization is declared as follows, where `sprop` is a [sequential property](sequential_property.md):

```solidity
init: sprop
```

## Specification

The specification section is a required section that defines the property to check. It can be declared as follows, where `sprop` is a [sequential property](sequential_property.md):

```solidity
spec: sprop
```

## Examples
Some user can deposit `X` funds and then withdraw `Y` funds as long as `Y <= X`
```
vars: address u, uint X
spec: finished(wallet.deposit, sender = u && value = X |=> true) ;
      finished(wallet.withdraw(amt), sender = u |=> amt <= X)
```