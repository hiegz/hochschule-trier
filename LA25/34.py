import matplotlib.pyplot as plt
import numpy as np
import random

v = [np.array([1, 1]), np.array([-1, 2])]
b = [1, 0, -0.5]


def f(sx, ex, n, b):
    assert len(n) == 2 and n[1] != 0
    return (b - n[0] * sx) / n[1], (b - n[0] * ex) / n[1]


def on_f(p, n, b):
    return abs(b - np.dot(n, p)) <= 0.01


def above_f(p, n, b):
    return np.dot(n, p) > b


def below_f(p, n, b):
    return np.dot(n, p) < b


def plot(n, b):
    sx, ex = -2, 2
    sy, ey = f(sx, ex, n, b)

    x = np.linspace(sx, ex, 100)
    y = np.interp(x, [sx, ex], [sy, ey])

    for _ in range(500):
        rx, ry = (
            np.random.uniform(low=x.min(), high=x.max()),
            np.random.uniform(low=y.min(), high=y.max()),
        )

        if on_f([rx, ry], n, b):
            continue
        elif above_f([rx, ry], n, b):
            plt.plot(rx, ry, marker="o", color="navy")
        elif below_f([rx, ry], n, b):
            plt.plot(rx, ry, marker="o", color="blue")
        else:
            assert False

    plt.plot([sx, ex], [sy, ey])
    plt.fill_between(x, y, y2=y.max(), color="#f0eee4")
    plt.fill_between(x, y, y2=y.min(), color="#d7d2cb")
    plt.axhline(0, color="black", linewidth=0.5)
    plt.axvline(0, color="black", linewidth=0.5)
    plt.xlabel("x")
    plt.ylabel("y")
    plt.grid(True)
    plt.axis("equal")

    rx, ry = random.choice(list(zip(x, y)))
    assert on_f((rx, ry), n, b)
    plt.quiver(rx, ry, n[0], n[1], color="r")

    plt.show()
