import numpy as np
import matplotlib.pyplot as plt

x = np.linspace(-4, 6, 1000)

fig = plt.figure()
ax = fig.add_subplot()

plt.plot(x, np.sin(x) + np.cos(x), label="$sin(x) + cos(x)$")
plt.plot(
    x,
    (1 + (1 / 2) * np.pi - (1 / 8) * np.pi**2 - (1 / 48) * np.pi**3)
    - (1 - (1 / 2) * np.pi - (1 / 8) * np.pi**2) * x
    - ((1 / 4) * np.pi + (1 / 2)) * x**2
    + (1 / 6) * x**3,
    label="$ln(3) - \dfrac{14}{27} + \dfrac{21}{27} x - \dfrac{1}{3} x^2 + \dfrac{2}{27} x^3$",
)

ax.spines["left"].set_position("zero")
ax.spines["bottom"].set_position("zero")
ax.spines["top"].set_color("none")
ax.spines["right"].set_color("none")

ax.set_xticks([tick for tick in np.arange(-5, 5, 1) if tick != 0])
ax.set_yticks([tick for tick in np.arange(-5, 5, 1) if tick != 0])
ax.set_ylim([-4, 4])

plt.legend(loc="best")
plt.show()
