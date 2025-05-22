import numpy as np
import math

x0 = np.array([1, 1])
x1 = np.array([2, 1])
x2 = np.array([2, 3])
x3 = np.array([2, 4])
x4 = np.array([1.5, 2])
x5 = np.array([2.5, 2.5])

c0 = x2
c1 = x3


def iterate(x, z, c):
    n = len(x)
    k = len(c)

    for i in range(n):
        minimum = math.inf
        centre = 0
        print("x{}: ".format(i), end="")
        for j in range(k):
            distance = np.linalg.norm(x[i] - c[j]) ** 2
            if distance < minimum:
                minimum = distance
                centre = j
            print("||x%d - c%d||^2 = %.2f" % (i, j, distance), end="; ")
        z[i] = centre
        print()

    for j in range(k):
        Sj = [x[i] for i in range(n) if z[i] == j]
        c[j] = (1 / len(Sj)) * sum(Sj)


def sse(x, z, c):
    n = len(x)
    ret = 0
    for i in range(n):
        ret += np.linalg.norm(x[i] - c[z[i]]) ** 2
    return ret


def info(z, c):
    for i in range(len(z)):
        print("z%d = %s" % (i, z[i]), end="; ")
    print()
    for j in range(len(c)):
        print("c%d = %s" % (j, c[j]), end="; ")
    print()


x = [x0, x1, x2, x3, x4, x5]
z = [None, None, None, None, None, None]
c = [c0, c1]

print("Initial State:")
info(z, c)

print("Iteration 1:")
iterate(x, z, c)
info(z, c)

print("Iteration 2:")
iterate(x, z, c)
info(z, c)

print("Iteration 3:")
iterate(x, z, c)
info(z, c)

print("Iteration 4:")
iterate(x, z, c)
info(z, c)
print("SSE: %.2f" % (sse(x, z, c)))
