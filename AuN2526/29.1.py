import numpy as np
import matplotlib.pyplot as plt

x = np.linspace(-1, 3, 1000)
e = np.e

fig = plt.figure()
ax = fig.add_subplot()

plt.plot(x, e**x, label="$e^x$")
plt.plot(
    x,
    (1 / 3) * e + (1 / 2) * e * x + (1 / 6) * e * x ** 3,
    label="$\dfrac{1}{3}e + \dfrac{1}{2}ex + \dfrac{1}{6}ex^3$",
)

ax.spines["left"].set_position("zero")
ax.spines["bottom"].set_position("zero")
ax.spines["top"].set_color("none")
ax.spines["right"].set_color("none")

ax.set_xticks([tick for tick in ax.get_xticks() if tick != 0])
ax.set_yticks([tick for tick in ax.get_yticks() if tick != 0])

plt.legend(loc="best")
plt.show()
