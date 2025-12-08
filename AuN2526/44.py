import math
from tabulate import tabulate

x0 = 0.5
t0 = 0
h = 0.05


def schritt(x_n, t_n, h):
    t = t_n + h
    x = x_n

    def g(x, x_n, t, h):
        return (h - 1) * x + x_n + (1 - t**2) * h

    def dg(h):
        return h - 1

    for _ in range(20):
        x = x - g(x, x_n, t, h) / dg(h)

    return x, t


def exact(t):
    return (t + 1) ** 2 - 0.5 * math.exp(t)

table = []

for i in range(100):
    table.append([i, t0, x0, exact(t0), math.fabs(x0 - exact(t0))])
    x0, t0 = schritt(x0, t0, h)

print(tabulate(table))
