def a1(n):
    return 1000 * n


def a2(n):
    import math

    return 100 * n * math.log2(n)


def a3(n):
    return 2**n


from tabulate import tabulate

table = []

for i in range(50):
    n = i + 1
    table.append([n, a1(n), a2(n), a3(n)])

print(tabulate(table, headers=["n", "1000 * n", "100 * n * math.log2(n)", "2 ** n"]))
