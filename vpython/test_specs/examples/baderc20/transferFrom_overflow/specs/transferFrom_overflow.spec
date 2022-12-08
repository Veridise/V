vars: IERC20 erc20
LTLProperty: []!finished(erc20.transferFrom(from, to, amt), erc20.balanceOf(from) > old(erc20.balanceOf(from)) || erc20.balanceOf(to) < old(erc20.balanceOf(to)))
