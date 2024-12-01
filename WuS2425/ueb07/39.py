from scipy.stats import binom

inputs = [(0.5, 50), (0.6, 40), (0.7, 30)]

alpha = 0.05
h0 = 0.4


def left_tail(q, n, p):
    return n - binom.ppf(1 - q, n, 1 - p) - 1


def right_tail(q, n, p):
    return n - binom.ppf(1 - q, n, p) - 1


for h1, n in inputs:
    lh0 = left_tail(alpha, n, h0)
    rh0 = right_tail(alpha, n, h0)

    beta = binom.cdf(lh0, n, h1) + binom.cdf(rh0, n, 1 - h1)
    print(
        f"{h1}, {n} ({lh0}, {binom.cdf(lh0, n, h0)}) ({n - rh0}, {binom.cdf(rh0, n, 1 - h0)}) {binom.cdf(lh0, n, h1)} + {binom.cdf(rh0, n, 1 - h1)} = {beta}"
    )
