vars: IERC20 erc20
LTLProperty: []!finished(erc20._mint(acc, amt), erc20.balanceOf(acc) < old(erc20.balanceOf(acc)))
