# [V] Statements

[V] statements make up the core of the specification language as they efficiently represent interactions with the blockchain. In general, they have the following structure:

> action ( target, property )

Where an action refers to the state of a transaction, a target refers to the recipient of the transaction and a property refers to an assertion over the state of contract and blockchain. More details on each can be found below.

## Action

An action describes the state of a transaction's execution on the blockchain which establishes when a property is checked. Below we describe each type of action and how it impacts the checking of a property.

|  Action  | Description |
| :------- | :---------- |
| started  | Refers to the invocation of the target transaction. Properties query the blockchain state immediately before the execution of the transaction |
| finished | Refers to a revert-free execution of the target transaction. Properties query the blockchain state immediately after the modifications are committed to the ledger |
| reverted | Refers to an execution of the target transaction that is reverted. Properties query the blockchain state immediately after the revert occurs |
| executed | Refers to a completed execution of the target transaction regardless of whether it reverts or not. Properties query the blockchain state after the execution of the transaction completes |

## Target

A target refers to the recipient entity as well as the transaction to execute. A target has the following form:

> entity . transaction

More information on each component can be found below.

### entity

The recipient entity can either be a specific contract instance or, in cases where the specific entity does not matter such as when defining invariants, the name of a smart contract. Note that if the name of a smart contract is provided, it is assumed that the transaction could be executed on any contract of the appropriate type.

### transaction

This is the transaction to execute on the given entity. A transaction consists of the name of a transaction that can be executed on the desired entity along with the arguments required to execute that transaction. In the event that the arguments are unnecessary for the intention of the statement and the transaction name is not overloaded, they can be excluded entirely and just a transaction name can be provided. If arguments are provided, all arguments must be defined in one of the following ways: (1) as an expression over global blockchain variables, contract variables, pure/view functions and any variables declared in the specification, or (2) as an argument alias, which is fresh variable that can be used in the property by giving the variable a unique name.

*Example*

Instruct erc20 to transfer 10 tokens from erc20's owner to the null address.

```solidity
erc20.transfer(erc20.owner, address(0), 10)
```

*Example*

Instruct any wallet contract to deposit funds into some address addr's account.

```solidity
Wallet.deposit(addr)
```

*Example*

Instruct erc20 to perform a transfer.

```solidity
erc20.transfer
```

## Property

At a high level, a property is simply a boolean [expression](expressions.md). However, a property has access to a few specialty operators that are useful for specifying relationships over a transaction as described below.

### Specialty Operators

In addition to more conventional operators, [V] provides a few specialty operators that are useful when writing specifications. We will provide a more in-depth description of them here.

**Pre/Post Condition Operator**

It is often useful when writing a specification over a transaction to provide assumptions about the invocation of the transaction (pre-condition) as well as queries about the state after its execution (post-condition). [V] allows users to write such specification succinctly using a custom pre/post condition operator `|=>` as defined below.

|      Operator      |      Use      |  Description  |
| :----------------- | :-----------: | :------------ |
| Pre/Post Condition | `a |=> b`     | Assuming the pre-condition `a` holds before a transaction, ensure that the post-condition `b` holds after the transaction |

There are a few additional things to note about this operator. First is that it cannot be combined with any of the operators above. That is, `a` and `b` are arbitrary predicates that use all of the resources discussed in the property section (except another Pre/Post condition operator), but the `|=>` operation itself must be the top-most operation and can only occur once. As an example, the following is not allowed: `!(a |=> b)`. Second, we currently only allow this operator to be used in finished, reverted and executed statements. This is because the pre/post condition operator is intended to query information across a transaction. As such it is not appropriate to use this operator in started statements because the transaction indicated by this statement has not executed yet. 

*Example*

An ERC20 transfer transaction will succeed if a user has sufficient balance and does not transfer to the null address. In that case the user’s balance will be reduced by the specified amount and the other user’s balance should increase by the specified amount.

```solidity
finished(ERC20.transfer(from, to, amt), 
  this.balanceOf(from) >= amt && to != null 
 |=>
  this.balanceOf(from) = old(this.balanceOf(from) - amt &&
  this.balanceOf(to) = old(this.balanceOf(to) + amt)
)
```

## Examples
### Example 1
The total supply should be the equal to the sum of all user balances (assuming the balances are stored in a map called balances) and the state of the contract should be unchanged.
```
finished(ERC20.totalSupply(), ret = sum(this.balances) && this = old(this))
```

### Example 2
A transfer should revert if a user does not have sufficient balance.
```
reverted(ERC20.transfer(to, amt), this.balanceOf(sender) < amt)
```