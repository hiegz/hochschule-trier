import math


def sphere_volume(r):
    return (4 / 3) * math.pi * math.pow(r, 3)


def wholesale(n):
    if n == 0:
        return 0
    book_cost = 24.95 * 0.6
    return (book_cost + 3) + ((book_cost + 0.75) * (n - 1))


def run_time():
    t = (6 * 60 * 60) + (52 * 60)
    t += (8 * 60) + 15
    t += 3 * (7 * 60) + 12
    t += (8 * 60) + 15

    t_seconds = t % 60
    t //= 60
    t_minutes = t % 60
    t //= 60

    print(f"{t}:{t_minutes}:{t_seconds}")
