vars: IERC20 erc20
LTLProperty: []!finished(erc20.*, erc20.totalSupply() != fsum(erc20._mint(a,x), x, true) - fsum(erc20._burn(a2,y), y, true))
