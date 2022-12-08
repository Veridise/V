vars: Example e, address a, int i, uint j
LTLProperty: []!(finished(e.set_y, sender = a) && X <>finished(e.set_y(v), sender = a && v > i && x < j))
