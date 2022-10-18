# Specification Variables and Macros
Specification variables and macros are an essential part of the [V] specification language. They can be used to reduce redundancy of a specification and to correlate values across time.

## Specification Variables

In [V], specification variables allow relationships across transactions to be expressed. Similar to free variables in SMT solvers, such variables range over the domain corresponding to their type, allowing them to take on any possible value. As such, they can be used to reason about many possible values at once as they are allowed to take on any values that meets the constraints placed on the variables.

Variables are declared in a special section and are scoped for the entire specification. Similar to declaring a variable in other programming languages, a variable simply needs a type and a name. As an example, `uint256 a` declares a variable called `a` with a type of `uint256`. All variables are declared similarly in a variables section as a comma separated list, like so:

```solidity
vars: uint256 a, boolean b, mathInt c
```

### Types

Currently, most types in [V] are inherited from the smart contract language right now. That is, the types that are available are defined by the language the specification is checking. For example, in Solidity types such as `u256`, `string`, `address` and `mapping(address => uint256)` may be used while in a rust-like language, such as Near, `u64`, `AccountId` and `String` may be used. While we might eventually try to unify the available types across languages, at the moment we believe this reduces the specification effort on users as they don’t have to determine how to map a type in the language they’re using to [V]. 

In addition to the types inherited from the programming language, [V] does provide additional types that do not exist in most other programming languages. Currently, the following types are provided:

### Variable Use

Unlike variables in a conventional programming language, variables in [V] are unbound or free by default. This means that the variable may have any possible value, allowing specifications to reason about more than a single concrete input. Uses of the variable then place constraints upon value of the given variable. The specification then holds if at least one value can be found such that all of the constraints placed upon the variable are satisfied.

As an example, consider a variable `uint256 a` and say the specification places the following constraints upon `a`: `a > 0` and `a < 10`. Since a satisfying assignment exists for `a` (such as `a=5`) the specification will hold as long as the rest of it holds. Now consider a new specification that places the following constraints upon `a`: `a > 0` and `a = 0`. In such a case, the specification does not hold since no satisfying assignment exists for `a`.

## Let Statements

Let statements allow users to define specification variables and create macros. They are used to reduce the amount of duplication in a specification. As such, while they may appear to be similar to assignments, they cannot overwrite anything other than specification variables.

### Defining Variables

Specification variables may be used as free variables, as discussed above or they can be assigned to a particular value using let statements. This is a statement of the form `let a := b` where `a` is a specification variable and `b` is an arbitrary [expression](expressions.md) that evaluates to the same type as `a`. The statement will evaluate `b` and assign the result to `a`. Further uses of `a` will not result in the reevaluation of `b` unlike macros but instead will have a constant value that is determined at the point of assignment. In addition, even though `a` is assigned to a concrete *expression*, it may not have a concrete *value*. That is, since `b` may contain other specification variables, it may not evaluate to a single concrete value and therefore `a` won’t either.

As an example, let’s say we want to assign a specification variable to some value stored in contract `c`'s variable `mapping(address ⇒ uint256) bal`. To do so we will create two specification variables: `uint256 a, address b`. We can then use the following let statement to set `a` to an arbitrary value in the mapping:

```solidity
let a := c.bal[b]
```

### Macros

Macros look similar to variable definitions but their behavior is quite different. Where a variable definition will only evaluate an expression at the time of definition, a macro will evaluate the expression every time it is invoked. This occurs because [V] performs a macro expansion step in which invocations of a macro are replaced with its body.

A macro is also declared with a let statement of the form `let name(params) := body` where `name` is the name of the macro, `params` is a comma separated list of parameters and `body` is an arbitrary [expression](expressions.md) to be evaluated when the macro is invoked. The only restriction that is placed on a macro is that it must not be recursive (or mutually recursive). A macro is then invoked by simply calling the macro by name with the appropriate arguments.

As an example, let’s say that we want to define a macro `inc` to ensures a variable increases by some value. We would therefore create the following macro:

```solidity
let inc(a, b) := a = old(a) + b
```

In the specification, we can then invoke this macro to ensure the contract `c`'s variable `total` increases by `amt`: `inc(c.total, amt)`. Before evaluating the specification, this will be expanded to `c.total = old(c.total) + amt`.