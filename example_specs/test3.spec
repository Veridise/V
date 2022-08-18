Vars: FlashLoanReceiver user, NaiveReceiverLenderPool lender, Attacker attacker
Init:
finished(lender.NaiveReceiverLenderPool(), lender = this && msg.value = 1000) ;
finished(user.FlashLoanReceiver(lender), user = this && msg.value = 10) ;
finished(attacker.Attacker(user), attacker = this)
Spec: finished(attacker.attack, address(user).balance = 0)
