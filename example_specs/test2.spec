Vars: ERC20 erc20, UnstoppableLender lender, ReceiverUnstoppable user, Attacker attacker
Init: finished(erc20.ERC20(2000000), erc20=this && balances[lender] = 1000000 && balances[attacker] = 100) ;
finished(lender.UnstoppableLender(erc20), lender = this && poolBalance = 1000000) ;
finished(user.ReceiverUnstoppable(lender), user = this) ;
finished(attacker.Attacker(lender, user), attacker = this)
Spec: finished(attacker.attack) ; reverted(user.executeFlashLoan(10))
