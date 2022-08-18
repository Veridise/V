Variables: address a, ERC20 erc20
LTLFairness: [](<>(started(Auction.Withdraw, msg.sender = a))) && [](!started(Auction.Withdraw, msg.sender = a && a = this.highestBidder)) && [](!reverted(erc20.send(from, to, amt), to = a)) && [](!started(Auction.AuctionEnd, this.beneficiary = a))
LTLProperty: [](finished(Auction.Bid, msg.sender = a && msg.value != 0) ==> <>(finished(erc20.send(from, to, amt), to = a))) && [](!started(erc20.send(from, to, amt), to = a && amt != fsum(Auction.Bid, 2, msg.sender = a) - fsum(erc20.send(from, to, amt), 2, to = a)))
