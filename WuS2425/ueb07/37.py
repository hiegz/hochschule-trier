from scipy.stats import binom

nrange = list(range(10, 100 + 1))
alpha = 0.005
h0 = 0.8
h1 = 0.6


def left_tail(q, n, p):
    return n - binom.ppf(1 - q, n, 1 - p) - 1


def right_tail(q, n, p):
    return n - binom.ppf(1 - q, n, p) - 1


for n in nrange:
    lh0 = left_tail(alpha, n, h0)
    rh0 = right_tail(alpha, n, h0)

    beta = binom.cdf(lh0, n, h1) + binom.cdf(rh0, n, 1 - h1)
    print(
        f"{n} ({lh0}, {binom.cdf(lh0, n, h0)}) ({n - rh0}, {binom.cdf(rh0, n, 1 - h0)}) {binom.cdf(lh0, n, h1)} + {binom.cdf(rh0, n, 1 - h1)} = {beta}"
    )
    if beta >= 0.95:
        print(f"n = {n}")
        break
