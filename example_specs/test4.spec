Vars: ERC20 token, TrustedLenderPool lender, Attacker attacker
Init: finished(token.ERC20(2000000), token = this) ;
finished(lender.TrustedLenderPool(token), lender = this) ;
finished(attacker.Attacker(lender), attacker = this) ;
finished(token.transfer(lender, 1000000))
Spec: finished(attacker.attack, token.balanceof(this) = 1000000 && token.balanceof(lender) = 0)
