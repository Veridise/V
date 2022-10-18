# Expressions

[V] expressions are operations composed of blockchain variables, contract variables, pure/view functions, specification variables, macros, argument aliases and [V] utility variables/functions. More information is provided below about the supported operators, variables and functions.

## Blockchain Variables

To allow the specification of properties across different blockchains and languages, [V] provides language-agnostic access to information commonly provided by blockchains. Specifically, the following information is provided:

|   Utility   | Description |
| :---------- | :---------- |
| `null`      | Evaluates to the null account |
| `sender`    | Specifies the account that invoked the transaction |
| `value`     | Specifies the amount of native tokens attached by the sender to the transaction’s message |
| `timestamp` | Provides the current timestamp |
| `selector`  | The selector for this transaction |

## Utility Variables and Functions

The [V] utility variables and functions are defined below:

| <div style="width:220px">Utility</div> | Description |
| :-------------------------- | :---------- |
| `this`                      | Evaluates to the recipient contract of the statement’s transaction |
| `ret`                       | The return value of the given transaction |
| `balance(account)`          | Returns `account`’s balance in native tokens |
| `id(contract)`              | Returns the account identifier for the contract |
| `old(expr)`                 | Evaluates `expr` just before the transaction executes |
| `fsum(target, cond, expr)`  | Accumulates the sum of `expr` across all transactions to `target` that successfully execute where `cond` holds. Note that this creates a nested scope where the blockchain variables, utility variables and utility functions refer to the specified target transaction |
| `last(target, cond, expr)`  | Returns the evaluation of `expr` from the last transaction to `target` that successfully executed where `cond` held. Note that this creates a nested scope where the blockchain variables, utility variables and utility functions refer to the specified target transaction |
| `sum(collection)`           | Accumulates the sum of all the values contained in `collection` |
| `type(val)`                 | Casts `val` to `type` |

## Arithmetic Operators

[V] allows the use of typical arithmetic operators to perform mathematical operations. Specifically it supports the operators below:

|    Operator    |   Use   |  Description  |
| :------------- | :-----: | :------------ |
| Addition       | `a + b` | Adds the values of `a` and `b` |
| Subtraction    | `a - b` | Subtracts the value of `b` from `a` |
| Multiplication | `a * b` | Multiplies the values of `a` and `b` |
| Division       | `a / b` | Divides `a` by `b` |
| Modulus        | `a % b` | Provides the remainder of `a`’s division by `b` |
| Unary Minus    | `-a`    | Changes the sign of `a` |

## Relational Operators

[V] provides various relational operators to perform comparisons between values. In addition to common relational operators, [V] provides a few specialty operators for common use cases. It should be noted that since [V] is a declarative language and does not allow assignment (usually), that equality comparison is `=` rather than assignment.

|     Operator     |        Use        |  Description  |
| :--------------- | :---------------: | :------------ |
| Equal            | `a = b`           | Checks if the value of `a` is equal to the value of `b` |
| Not Equal        | `a != b`          | Checks if the value of `a` is not equal to the value of `b` |
| Greater Than     | `a > b`           | Checks if the value of `a` is greater than the value of `b` |
| Greater or Equal | `a >= b`          | Checks if the value of `a` is greater than or equal to the value of `b` |
| Less Than        | `a < b`           | Checks if the value of `a` is less than the value of `b` |
| Less or Equal    | `a <= b`          | Checks if the value of a is less than or equal to the value of b |
| Equal Except     | `a = b except c`  | Checks if two collections, structures or contracts `a` and `b` are equal except at the locations specified by `c` (separated by commas) |

## Logical Operators

[V] supports the following logical operators:

|   Operator   |    Use    |  Description  |
| :----------- | :-------: | :------------ |
| Logical AND  | `a && b`  | Checks if both `a` and `b` hold |
| Logical OR   | `a || b`  | Checks if either `a`, `b` or both hold |
| Logical NOT  | `!a`      | Checks if `a` does not hold |
| Implication  | `a ==> b` | Checks that `b` holds if `a` holds |


## Access Operators

[V] provides operators for accessing collections and members of contracts and structs. With respect to contracts, both contract variables and pure or view functions are accessible regardless of visibility. To make an access into a contract, though, [V] must know which contract is being accessed. The following operators are provided to access collections, member variables and member functions:

|     Operator     |      Use      |  Description  |
| :--------------- | :-----------: | :------------ |
| Index            | `c[i]`        | Accesses collection `c` at index `i` |
| Member Variable  | `c.v`         | Accesses the member variable `v` contained in `c` |
| Member Function  | `c.fn(args)`  | Calls function `fn` with the arguments `args` provided by `c` |