vars: Wallet wallet
LTLProperty: [](started(wallet.deposit(), flag = -1) ==> <> finished(wallet.deposit(), flag = 5))