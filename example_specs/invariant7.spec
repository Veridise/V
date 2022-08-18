vars: ERC20 erc20
inv: finished(erc20.transfer(to, amt), old(balances[to] >= amt) && old(balanceOf(to)) >= amt)
