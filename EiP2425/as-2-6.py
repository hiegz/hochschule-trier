def pqsolve(p, q):
    return (-(p/2) + ((p/2)**2 - q)**(1/2), -(p/2) - ((p/2)**2 - q)**(1/2))

print(f'1. {pqsolve(-3, -10)}')
print(f'2. {pqsolve(-1, -1)}')
print(f'3. {pqsolve(-(2/3), 0)}')
print(f'4. {pqsolve(-5, 6)}')
