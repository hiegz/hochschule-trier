import matplotlib.pyplot as plt

import numpy as np
import pandas as pd
import math
import random
import copy

df = pd.read_csv("data/set.csv")
X = [np.array([row.x, row.y]) for row in df.itertuples(index=False)]
Z = [None] * len(X)


def info(z, c):
    for i in range(len(z)):
        print("z%d = %s" % (i, z[i]), end="; ")
    print()
    for j in range(len(c)):
        print("c%d = %s" % (j, c[j]), end="; ")
    print()


def iterate(x, z, c):
    n = len(x)
    k = len(c)

    for i in range(n):
        minimum = math.inf
        centre = 0
        for j in range(k):
            distance = np.linalg.norm(x[i] - c[j]) ** 2
            if distance < minimum:
                minimum = distance
                centre = j
        z[i] = centre

    for j in range(k):
        Sj = [x[i] for i in range(n) if z[i] == j]
        c[j] = (1 / len(Sj)) * sum(Sj)


def run(x, z, c):
    import copy

    it = 1
    pc = None
    while True:
        if pc != None and np.array_equal(c, pc):
            break
        pc = copy.deepcopy(c)
        iterate(x, z, c)
        it += 1


def sse(x, z, c):
    n = len(x)
    ret = 0
    for i in range(n):
        ret += np.linalg.norm(x[i] - c[z[i]]) ** 2
    return ret


def plot(x, z):
    colors = {
        0: "red",
        1: "blue",
        2: "green",
        3: "purple",
        4: "orange",
        5: "cyan",
        6: "magenta",
        7: "brown",
    }

    n = len(x)

    plt.figure()
    plt.xlabel("X-axis")
    plt.ylabel("Y-axis")

    for i in range(n):
        plt.scatter(x[i][0], x[i][1], color=colors[z[i]], marker="o")

    plt.show()


def elbow():
    ks = []
    sses = []

    for k in range(2, 7 + 1):
        x = copy.deepcopy(X)
        z = copy.deepcopy(Z)
        c = random.sample(x, k)

        print("k=%d" % k)
        run(x, z, c)
        val = sse(x, z, c)
        print("SSE:", val)
        ks.append(k)
        sses.append(val)

    plt.figure()
    plt.xlabel("k")
    plt.ylabel("SSE")
    plt.plot(ks, sses, marker="o")
    plt.show()


def final(k):
    x = copy.deepcopy(X)
    z = copy.deepcopy(Z)
    c = random.sample(x, k)

    print("k=%d" % k)
    run(x, z, c)
    print("SSE:", sse(x, z, c))
    plot(x, z)
