def schleife1(n):
    count = 0
    for _ in range(n):
        for _ in range(n):
            count += 1
    return count


def schleife2(n):
    count = 0
    for i in range(n, 0, -1):
        for _ in range(i, n):
            count += 1
    return count


def schleife3(n):
    count = 0
    for _ in range(1, n // 2 + 1):
        for _ in range(1, n * n):
            count += 1
    return count


def schleife4(n):
    i = n
    count = 0
    while True:
        count += 1
        i = i // 3
        if i <= 0:
            break
    return count


N = 10

print("Schleife 1")
print()
for n in range(N + 1):
    count = schleife1(n)
    print("n = " + str(n) + "; count = " + str(count))
print()
print("Komplexitätsklasse : O(n^2)")

print()
print("---")
print()

print("Schleife 2")
print()
for n in range(N + 1):
    count = schleife2(n)
    print("n = " + str(n) + "; count = " + str(count))
print()
print("Komplexitätsklasse : O(n * (n - 1) / 2) = O(n^2)")

print()
print("---")
print()

print("Schleife 3")
print()
for n in range(N + 1):
    count = schleife3(n)
    print("n = " + str(n) + "; count = " + str(count))
print()
print("Komplexitätsklasse : O(n // 2 * (n^2 - 1)) = O(n^3)")

print()
print("---")
print()

print("Schleife 4")
print()
for n in range(N + 1):
    count = schleife4(n)
    print("n = " + str(n) + "; count = " + str(count))
print()
print("Komplexitätsklasse : O(floor(log_3(n)) + 1) = O(log(n))")
