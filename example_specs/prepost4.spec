Pre: started(ERC20.totalSupply(), this.totalSupply >= 0)
Post: finished(ERC20.totalSupply(), return = this.totalSupply && this.totalSupply = old(this.totalSupply) && this.balances = old(this.balances) && this.allowances = old(this.allowances)) || reverted(ERC20.totalSupply, this.totalSupply >= 2e256)
