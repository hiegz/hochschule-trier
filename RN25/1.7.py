n = int(input("n = "))
num = 2 ** (2 * n + 1) * n - 2 ** (2 * n + 2) - 2 ** (n + 1) * n + 2 ** (n + 3) - 4
den = (2**n - 1) ** 2
print("d = %f" % (num / den))
