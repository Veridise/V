Vars: address alice, address bob, address charlie, address david, TheRewarderPool rewarder, FlashLoanerPool loaner, RewardToken rewardTok, AccountingToken accountTok, DamnValuableToken token, address[] users
Init: finished(token.DamnValuableToken(2000000), token = this) ;
finished(loaner.FlashLoanerPool(token), loaner = this) ;
finished(rewarder.TheRewarderPool(token), rewarder = this && accountTok = accToken && rewardTok = rewardToken) ;
let(users := [alice, bob, charlie, david]) ;
foreach(user : users, finished(token.transfer(user, 100)));
finished(token.transfer(loaner, 1000000)) ;
foreach(user : users, finished(token.approve(loaner, 100), msg.sender = user));
foreach(user : users, finished(loaner.deposit(100), msg.sender = user));
foreach(user : users, finished(loaner.distributeRewards, msg.sender = user))
Spec: finished(attacker.attack) ;
foreach(user : users, finished(loaner.distributeRewards, msg.sender = user && rewardTok.balanceof(user) - old(rewardTok.balanceof(user)) <= 1) );
finished(loaner.distributeRewards, msg.sender = attacker && rewardToken.balanceof(attacker) > 90)
