Vars: address alice, address bob, address charlie, address david, TheRewarderPool rewarder, FlashLoanerPool loaner, RewardToken rewardTok, AccountingToken accountTok, DamnValuableToken token
Init: finished(token.DamnValuableToken(2000000), token = this) ;
finished(loaner.FlashLoanerPool(token), loaner = this) ;
finished(rewarder.TheRewarderPool(token), rewarder = this && accountTok = accToken && rewardTok = rewardToken) ;
finished(token.transfer(alice, 100)) ;
finished(token.transfer(bob, 100)) ;
finished(token.transfer(charlie, 100)) ;
finished(token.transfer(david, 100)) ;
finished(token.transfer(loaner, 1000000)) ;
finished(token.approve(loaner, 100), msg.sender = alice) ;
finished(token.approve(loaner, 100), msg.sender = bob) ;
finished(token.approve(loaner, 100), msg.sender = charlie) ;
finished(token.approve(loaner, 100), msg.sender = david) ;
finished(loaner.deposit(100), msg.sender = alice) ;
finished(loaner.deposit(100), msg.sender = bob) ;
finished(loaner.deposit(100), msg.sender = charlie) ;
finished(loaner.deposit(100), msg.sender = david) ;
finished(loaner.distributeRewards, msg.sender = alice) ;
finished(loaner.distributeRewards, msg.sender = bob) ;
finished(loaner.distributeRewards, msg.sender = charlie) ;
finished(loaner.distributeRewards, msg.sender = david)
Spec: finished(attacker.attack) ;
finished(loaner.distributeRewards, msg.sender = alice && rewardTok.balanceof(alice) - old(rewardTok.balanceof(alice)) <= 1) ;
finished(loaner.distributeRewards, msg.sender = bob && rewardTok.balanceof(bob) - old(rewardTok.balanceof(bob)) <= 1) ;
finished(loaner.distributeRewards, msg.sender = charlie && rewardTok.balanceof(charlie) - old(rewardTok.balanceof(charlie)) <= 1) ;
finished(loaner.distributeRewards, msg.sender = david && rewardTok.balanceof(david) - old(rewardTok.balanceof(david)) <= 1)  ;
finished(loaner.distributeRewards, msg.sender = attacker && rewardToken.balanceof(attacker) > 90)
