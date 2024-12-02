import math


def estimate_pi():
    result = 0
    c = (2 * math.sqrt(2)) / 9801
    k = 0
    while True:
        term = (
            math.factorial(4 * k)
            * (1103 + 26390 * k)
            / ((math.factorial(k) ** 4) * (396) ** (4 * k))
        )
        result += term
        if term < 1e-15:
            break
        k += 1
    return c * result


print(estimate_pi() ** (-1))
