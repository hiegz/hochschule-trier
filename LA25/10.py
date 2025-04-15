import numpy as np
import matplotlib.pyplot as plt


def rotation_matrix(alpha):
    alpha = np.radians(alpha)
    c = np.cos(alpha)
    s = np.sin(alpha)
    return np.array([[c, -s], [s, c]])


# Computes the matrix-vector product, rotation_matrix(alpha) * v
def rotate(v, alpha):
    return np.matmul(rotation_matrix(alpha), v)


v1 = np.array([1, 0])
v2 = np.array([1, 1])
v3 = np.array([0, 1])
v4 = v1 + v3
v5 = v2 - 2 * v3


def visualize(vecs):
    plt.figure()
    for vec in vecs:
        plt.quiver(
            *np.array([[0, 0], [0, 0]]),
            vec[0],
            vec[1],
            color="blue",
            units="xy",
            scale=1,
        )
    plt.xlim(-2, 2)
    plt.ylim(-2, 2)
    plt.show()
