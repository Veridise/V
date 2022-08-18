Vars: SideEntranceLenderPool lender, Attacker attacker
Init: finished(lender.SideEntranceLenderPool, lender = this && msg.value = 1000) ;
finished(attacker.Attacker(lender), attacker = this)
Spec: finished(attacker.attack, address(this).balance = 1000 && address(lender).balance = 0)
