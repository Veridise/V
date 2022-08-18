Variables: address a, ERC20 erc20
LTLProperty: [](!finished(erc20.*, this.pendingReturns[a] != fsum(Auction.Bid, 2, msg.sender = a) - fsum(erc20.send(from, to, amt), 2, to = a)))
