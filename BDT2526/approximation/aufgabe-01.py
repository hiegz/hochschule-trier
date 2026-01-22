import random
from datasketch import HyperLogLog, HyperLogLogPlusPlus
from tabulate import tabulate

NUM_DAYS = 30
VISITS_PER_DAY = 10000
UNIQUE_DAILY_VISITORS = 1000
POSSIBLE_VISITORS = 100000

results = []
total_hll_error = 0
total_hllp_error = 0

for day in range(1, NUM_DAYS + 1):
    unique_daily_visitors = random.sample(range(POSSIBLE_VISITORS), UNIQUE_DAILY_VISITORS)
    hll = HyperLogLog()
    hllp = HyperLogLogPlusPlus()
    exact = set()

    for _ in range(VISITS_PER_DAY):
        v = random.choice(unique_daily_visitors)
        b = str(v).encode("utf-8")

        exact.add(v)
        hll.update(b)
        hllp.update(b)

    exact_len = len(exact)
    hll_len = hll.count()
    hllp_len = hllp.count()
    hll_err = abs(hll_len-exact_len)/exact_len*100
    hllp_err = abs(hllp_len-exact_len)/exact_len*100
    total_hll_error += hll_err
    total_hllp_error += hllp_err

    results.append((day, exact_len, hll_len, hllp_len, f"{hll_err:.1f}%", f"{hllp_err:.1f}%"))

print(tabulate(results, headers=["Day", "Exact", "HLL", "HLL++", "HLL error", "HLL+ error"]))
print()
print("average HLL error:", f"{total_hll_error/NUM_DAYS:.1f}%");
print("average HLL++ error:", f"{total_hllp_error/NUM_DAYS:.1f}%");
