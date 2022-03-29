**************
[V] Statements
**************

[V] statements make up the core of the specification language as they efficiently represent interactions with the blockchain. In general, they have the following structure:

    action ( target, property )

Where an action refers to the state of a transaction, a target refers to the recipient of the transaction and a property refers to an assertion over the state of contract and blockchain. More details on each can be found below.

Action
======

An action describes the state of a transaction's execution on the blockchain which establishes when a property is checked. Below we describe each type of action and how it impacts the checking of a property.

======== =========================================================================
Action   Description
======== =========================================================================
started  Refers to the invokation of the target transaction. Properties query the 
         blockchain state immediately before the execution of the transaction.
finished Refers to a revert-free execution of the target transaction. Properties 
         query the blockchain state immediately after the modifications are 
         committed to the ledger.
reverted Refers to an execution of the target transaction that is reverted. 
         Properties query the blockchain state immediately after the revert 
         occurs.
executed Refers to a completed execution of the target transaction regardless 
         of whether it reverts or not. Properties query the blockchain state 
         after the execution of the transaction completes.
======== =========================================================================

Target
======

A target refers to the recipient entity as well as the transaction to execute. A target has the following form:

    entity . transaction

More information on each component can be found below.

entity
------

The recipient entity can either be a specific contract instance or, in cases where the specific entity does not matter such as when defining invariants, the name of a smart contract. Note that if the name of a smart contract is provided, it is assumed that the transaction could be executed on any smart contract of the appropriate type.

transaction
-----------

This is the transaction to execute on the given entity. A transaction consists of the name of a transaction that can be executed on the desired entity along with the arguments required to execute that transaction. In the event that the arguments are unnecessary for the intention of the statement and the transaction name is not overloaded, they can be excluded entirely and just a transaction name can be provided. If arguments are provided, all arguments must be defined in one of the following ways: (1) as an expression over global blockchain variables, contract variables, pure/view functions and any variables declared in the specification, or (2) as an argument alias, which is fresh variable that can be used in the property by giving the variable a unique name.

Example 1
---------

Instruct erc20 to transfer 10 tokens from erc20's owner to the null address.

    erc20.transfer(erc20.owner, address(0), 10)

Example 2
---------

Instruct any wallet contract to deposit funds into some address addr's account.

    Wallet.deposit(addr)

Example 3
---------

Instruct erc20 to perform a transfer.

    erc20.transfer

Property
========
A property is a boolean expression over blockchain variables, contract variables, pure/view functions, specification variables, argument aliases and [V] utility variables/functions. The [V] utility variables and functions are defined below:

================== ========================================================================================
Utility            Description
================== ========================================================================================
msg.selector       The selector for this transaction
old(expr)          Evaluates expr just before the transaction executes
fsum(target, expr) Accumulates the sum of expr across all transactions to target that successfully execute
sum(collection)    Accumulates the sum of all the values contained in collection
================== ========================================================================================

Examples
========

Example 1
---------
A transfer on erc20 such that from has a non-zero balance, to is not the null address and the amount is greater than zero executes successfully.

    finished(erc20.transfer(from, to, amt), old(balances[from]) > 0 && to != address(0) && amt > 0)
