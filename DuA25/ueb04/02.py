def f_recursive(x, y):
    if y == 0:
        return x
    else:
        return 1 + f_recursive(x, y - 1)


def f_tail_recursive(x, y):
    if y == 0:
        return x
    else:
        return f_tail_recursive(x + 1, y - 1)


def g_recursive(x, y):
    if y == 0:
        return 0
    elif y == 1:
        return x
    else:
        return x + g_recursive(x, y - 1)


def g_tail_recursive(x, y, acc=0):
    if y == 0:
        return acc
    else:
        return g_tail_recursive(x, y - 1, acc + x)


assert f_recursive(1, 2) == 3
assert f_recursive(0, 0) == 0
assert f_recursive(0, 1) == 1

assert f_tail_recursive(1, 2) == 3
assert f_tail_recursive(0, 0) == 0
assert f_tail_recursive(0, 1) == 1

assert g_recursive(1, 2) == 2
assert g_recursive(0, 0) == 0
assert g_recursive(0, 1) == 0
assert g_recursive(1, 0) == 0
assert g_recursive(9, 9) == 81
assert g_recursive(6, 7) == 42

assert g_tail_recursive(1, 2) == 2
assert g_tail_recursive(0, 0) == 0
assert g_tail_recursive(0, 1) == 0
assert g_tail_recursive(1, 0) == 0
assert g_tail_recursive(9, 9) == 81
assert g_tail_recursive(6, 7) == 42


print("[+] OK")
