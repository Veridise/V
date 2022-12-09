vars: Example e
LTLProperty: []!started(e.set_x_one, fsum(e.set_y(v), 2*v, v%2 = 0) != fsum(e.set_y(v), 2*v, v%2 = 1))
