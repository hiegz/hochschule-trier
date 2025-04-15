import numpy as np


def d1(alpha):
    alpha = np.radians(alpha)
    c = np.cos(alpha)
    s = np.sin(alpha)
    return np.array([[1, 0, 0], [0, c, -s], [0, s, c]])


def d2(alpha):
    alpha = np.radians(alpha)
    c = np.cos(alpha)
    s = np.sin(alpha)
    return np.array([[c, 0, s], [0, 1, 0], [-s, 0, c]])


def d3(alpha):
    alpha = np.radians(alpha)
    c = np.cos(alpha)
    s = np.sin(alpha)
    return np.array([[c, -s, 0], [s, c, 0], [0, 0, 1]])
