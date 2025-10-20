import sys

sys.setrecursionlimit(10001)


def g(n):
    assert n >= 1

    if n == 1:
        return 1

    return g(n - 1) + n**3


def sollwert(n):
    return ((n * (n + 1)) / 2) ** 2


for i in range(1, 10000 + 1):
    found = g(i)
    expected = sollwert(i)
    print(f"g({i}) ... ", end="")
    assert found == expected, f"expected {expected}, found {found}"
    print("ok")
