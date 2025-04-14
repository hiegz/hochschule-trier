while True:
    try:
        N = M = int(input("N = M = "))
    except:
        exit(0)

    additions = 0
    multiplications = 0

    for k in range(1, N + 1):
        # ... [k - 1, k, k + 1] ...
        n_items = min(k + 1, M) - max(k - 1, 1) + 1

        additions += n_items - 1
        multiplications += n_items

    print("Additions:", additions)
    print("Multiplications:", multiplications)
