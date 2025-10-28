from random import random

Z = 10000
T = 1080
G = 50


# f(r)
def f(r):
    return G / (1 + r) + sum(T / (1 + r) ** k for k in range(1, 10 + 1)) - Z


# f'(r)
def f_prime(r):
    # fmt: off
    return -(G / (1 + r) ** 2) + sum(-k * T / (1 + r) ** (k + 1) for k in range(1, 10 + 1)) - Z


eps = 1e-10
r = random()

while True:
    r_old = r
    r = r - f(r) / f_prime(r)
    if abs(r - r_old) < eps:
        break

print(f"f(r) = {f(r):.4}")
print(f"  r  = {r * 100:.4}%")
