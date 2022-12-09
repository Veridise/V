vars: IERC20 erc20
LTLProperty: []!finished(erc20._burn(acc, amt), old(erc20.balanceOf(acc)) < erc20.balanceOf(acc))
