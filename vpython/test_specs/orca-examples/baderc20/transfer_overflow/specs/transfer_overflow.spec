vars: IERC20 erc20
LTLProperty: []!finished(erc20.transfer(to, amt), erc20.balanceOf(sender) > old(erc20.balanceOf(sender)) || erc20.balanceOf(to) < old(erc20.balanceOf(to)))
