def schleife(n):
    zaehler = 0
    for i in range(1, n + 1):
        for _ in range(1, i + 1, 2):
            zaehler += 1
    return zaehler


schleife(8)

for i in range(1, 8 + 1):
    if i % 2 == 0:
        print(i, (i / 2) * ((i / 2) + 1), schleife(i))
    else:
        print(i, ((i + 1) ** 2) / 4, schleife(i))


# even numbers
#
# [n/2] * ([n/2] + 1)

# odd numbers
#
# (n + 1)^2 / 4
