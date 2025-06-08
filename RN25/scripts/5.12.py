from matplotlib import pyplot as plt
from tabulate import tabulate

plt.rcParams.update({"text.usetex": True, "font.family": "Helvetica"})

sample = [
    200,
    190,
    180,
    210,
    200,
    190,
    210,
    190,
    210,
    100,
    90,
    80,
    90,
    110,
    100,
    100,
    90,
    110,
    100,
    90,
]

alpha = 0.75
mu = 1
phi = 4
estimated_rtt = 200
timeout_original = 400
abweichung = 10
timeout_jacobsen = 240

data = []

for i in range(len(sample)):
    rtt = sample[i]
    estimated_rtt = alpha * estimated_rtt + (1 - alpha) * rtt
    timeout_original = 2 * estimated_rtt
    abweichung = alpha * abweichung + (1 - alpha) * abs(rtt - estimated_rtt)
    timeout_jacobsen = mu * estimated_rtt + phi * abweichung
    data.append(
        (i + 1, rtt, estimated_rtt, timeout_original, abweichung, timeout_jacobsen)
    )

table = open("assets/5.12.tex", "w")
table.write(
    tabulate(
        data,
        headers=[
            "Zeit",
            "SampleRTT",
            "EstimatedRTT",
            "Timeout (Original)",
            "Abweichung",
            "Timeout (Jacobsen)",
        ],
        stralign="center",
        numalign="center",
        tablefmt="latex",
    )
)
table.flush()
table.close()

# Zeit-SampleRTT
plt.figure()
for i in range(len(data)):
    x = data[i][0]
    y = data[i][1]
    plt.plot(x, y, "bo")
    plt.xlabel("Zeit")
    plt.ylabel("SampleRTT")
plt.savefig("assets/5.12.c.Zeit-SampleRTT.eps", format="eps")

# Zeit-EstimatedRTT
plt.figure()
for i in range(len(data)):
    x = data[i][0]
    y = data[i][2]
    plt.plot(x, y, "bo")
    plt.xlabel("Zeit")
    plt.ylabel("EstimatedRTT")
plt.savefig("assets/5.12.c.Zeit-EstimatedRTT.eps", format="eps")

# Zeit-Timeout-Original
plt.figure()
for i in range(len(data)):
    x = data[i][0]
    y = data[i][3]
    plt.plot(x, y, "bo")
    plt.xlabel("Zeit")
    plt.ylabel("Timeout (Original)")
plt.savefig("assets/5.12.c.Zeit-Timeout-Original.eps", format="eps")

# Zeit-Timeout-Jacobsen
plt.figure()
for i in range(len(data)):
    x = data[i][0]
    y = data[i][5]
    plt.plot(x, y, "bo")
    plt.xlabel("Zeit")
    plt.ylabel("Timeout (Jacobsen)")
plt.savefig("assets/5.12.c.Zeit-Timeout-Jacobsen.eps", format="eps")
