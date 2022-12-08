vars: Replica replica
LTLFairness: []!finished(replica.setConfirmation) && []!finished(replica.update)
LTLProperty: []!finished(replica.process, sender != replica.owner())
