Pre: started(ERC20.transfer(to, value), msg.sender != to && (value > this.balances[msg.sender] || this.balances[to] + value >= 2e256) && value >= 0 && value < 2e256 && this.balances[to] >= 0 && this.balances[to] < 2e256 && this.balances[msg.sender] >= 0 && this.balances[msg.sender] < 2e256)
Post: reverted(ERC20.transfer(to, value))
