import numpy as np


def A(a1, a4):
    return np.array([[a1, 1], [1, a4]])


def B(b4):
    return np.array([[0, -1], [1, b4]])


def verify(a1, a4, b4):
    a = A(a1, a4)
    b = B(b4)

    print(np.matmul(a, b))
    print()
    print("!=")
    print()
    print(np.matmul(b, a))
