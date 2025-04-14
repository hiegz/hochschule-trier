def fakultaet(n):
    if n == 0:
        return 1
    return n * fakultaet(n - 1)

print(fakultaet(0))
print(fakultaet(1))
print(fakultaet(2))
print(fakultaet(3))
