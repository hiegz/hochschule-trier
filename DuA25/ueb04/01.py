calls = 0
comparisons = 0
additions = 0


def recursion(n):
    global calls
    global comparisons
    global additions

    calls += 1
    if n <= 0:
        comparisons += 1
        return 1
    else:
        additions += 1
        return recursion(n - 1) + recursion(n - 1)


# geometric series
# sum_i^n[2 ** i] = O(2^n)
def call_complexity(n):
    return (1 - (2 ** (n + 1))) / (1 - 2)


# O(2^n)
def comparison_complexity(n):
    return 2**n


# O(2^n)
def addition_complexity(n):
    return 2**n - 1


for n in range(10 + 1):
    recursion(n)
    print("n =", n)
    print(calls, "call(s)")
    assert calls == call_complexity(n)
    print(comparisons, "comparison(s)")
    assert comparisons == comparison_complexity(n)
    print(additions, "addition(s)")
    assert additions == addition_complexity(n)
    calls = 0
    comparisons = 0
    additions = 0
    if n != 10:
        print()
