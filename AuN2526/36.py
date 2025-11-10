from random import random

N = 1024 * 1024  # Reiheglieder
I = 10  # Newton-Iterationen
n = 30  # Grad Taylor-Polynom
L = 4  # Integrationsgrenz
m = 1000  # Teile

# ------------------ #
#  pi approximation  #
# ------------------ #

pi = 0

for k in range(N):
    pi += ((-1) ** k) / (2 * k + 1)

pi *= 4

print(f"1. pi ≈ {pi}")


# ------------------------- #
#  sqrt(2pi) approximation  #
# ------------------------- #


def g(x):
    return x**2 - 2 * pi


def g_prime(x):
    return 2 * x


sqrt_2pi = random()
for _ in range(I):
    sqrt_2pi = sqrt_2pi - g(sqrt_2pi) / g_prime(sqrt_2pi)

print(f"2. sqrt(2pi) ≈ {sqrt_2pi}")

# ---------------- #
#  Taylor-Polynom  #
# ---------------- #


def factorial(x):
    if x == 0:
        return 1
    return x * factorial(x - 1)


def f(x):
    acc = 0
    for v in range(n):
        acc += ((-1) ** v) * (x ** (2 * v)) / ((2**v) * factorial(v))
    return acc


# --------- #
#  Simpson  #
# --------- #

delta = (2 * L) / m


def x(j):
    return -L + j * delta


integral = f(x(0)) + f(x(m))

for j in range(1, m + 1):
    if j % 2 == 0:
        integral += 2 * f(x(j))
    else:
        integral += 4 * f(x(j))

integral *= delta / 3
integral /= sqrt_2pi

print(f"3. ∫ ≈ {integral}")
