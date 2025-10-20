def fib(n):
    if n <= 1:
        return n

    return fib(n - 1) + fib(n - 2)


def sollwert(n):
    return (1 / (5 ** (1 / 2)) * (((1 + (5 ** (1 / 2))) / 2) ** n - ((1 - (5 ** (1 / 2))) / 2) ** n))

for i in range(30 + 1):
    from math import isclose

    found = fib(i)
    expected = sollwert(i)

    print(f"fib({i}) ...", end="")
    assert isclose(expected, found), f"expected {expected}, found {found}"
    print("ok")
