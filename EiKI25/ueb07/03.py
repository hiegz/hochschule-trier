import numpy as np
import math

x0 = np.array([1, 1])
x1 = np.array([2, 1])
x2 = np.array([2, 3])
x3 = np.array([2, 4])
x4 = np.array([1.5, 2])
x5 = np.array([2.5, 2.5])
x6 = np.array([4.5, 4.5])


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


def run(x, z, c):
    import copy

    it = 1
    pc = None
    while True:
        if pc != None and np.array_equal(c, pc):
            break
        pc = copy.deepcopy(c)
        print("Iteration %d:" % it)
        iterate(x, z, c)
        info(z, c)
        it += 1


def sse(x, z, c):
    n = len(x)
    ret = 0
    for i in range(n):
        ret += np.linalg.norm(x[i] - c[z[i]]) ** 2
    return ret


def plot(x, z):
    import matplotlib.pyplot as plt

    n = len(x)
    k = len(np.unique(z))
    assert k == 2

    plt.figure()
    plt.xlabel("X-axis")
    plt.ylabel("Y-axis")

    for i in range(n):
        if z[i] == 0:
            plt.scatter(x[i][0], x[i][1], color="red", marker="o")
        elif z[i] == 1:
            plt.scatter(x[i][0], x[i][1], color="blue", marker="x")
        else:
            assert False

    plt.show()


def A():
    x = [x0, x1, x2, x3, x4, x5, x6]
    z = [None, None, None, None, None, None, None]
    c = [x1, x6]

    print("Variante A")
    print("Initial State:")
    info(z, c)

    run(x, z, c)
    print("SSE: %.2f" % (sse(x, z, c)))

    plot(x, z)


def B():
    x = [x0, x1, x2, x3, x4, x5, x6]
    z = [None, None, None, None, None, None, None]
    c = [x2, x5]

    print("Variante B")
    print("Initial State:")
    info(z, c)

    run(x, z, c)
    print("SSE: %.2f" % (sse(x, z, c)))

    plot(x, z)


def C():
    x = [x0, x1, x2, x3, x4, x5, x6]
    cs = []
    n = len(x)
    for i in range(n):
        for j in range(i + 1, n):
            cs.append([i, j])

    while True:
        for i in range(len(cs)):
            print("%02d. [x%d, x%d]" % (i, cs[i][0], cs[i][1]))

        which = input("> ")
        if which == "q":
            break
        which = int(which)
        assert 0 <= which <= len(cs)

        z = [None, None, None, None, None, None, None]
        c = [x[cs[which][0]], x[cs[which][1]]]

        print("Initial State:")
        info(z, c)

        run(x, z, c)
        print("SSE: %.2f" % (sse(x, z, c)))

        plot(x, z)
