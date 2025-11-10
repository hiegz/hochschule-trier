import numpy as np
import matplotlib.pyplot as plt

n = 30


def factorial(x):
    if x == 0:
        return 1
    return x * factorial(x - 1)


def f(x):
    return np.exp(-(x**2) / 2)


def f_approximated(x):
    acc = 0
    for v in range(n):
        acc += ((-1) ** v) * (x ** (2 * v)) / ((2**v) * factorial(v))
    return acc


x = np.linspace(-5, 5, 1000)
y1 = f(x)
y2 = f_approximated(x)

fig = plt.figure()
ax = fig.add_subplot()

plt.plot(x, y1, label="f")
plt.plot(x, y2, label="f_approx")

ax.spines["left"].set_position("zero")
ax.spines["bottom"].set_position("zero")
ax.spines["top"].set_color("none")
ax.spines["right"].set_color("none")

ax.set_xticks([tick for tick in ax.get_xticks() if tick != 0])
ax.set_yticks([tick for tick in ax.get_yticks() if tick != 0])

plt.legend(loc="best")
plt.show()
