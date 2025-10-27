import numpy as np
import matplotlib.pyplot as plt

x = np.linspace(-1, 3, 1000)

fig = plt.figure()
ax = fig.add_subplot()

plt.plot(x, np.log(x + 2), label="$ln(x + 2)$")
plt.plot(
    x,
    (np.log(3) - (14 / 27)) + (21 / 27) * x - (1 / 3) * x**2 + (2 / 27) * x**3,
    label="$ln(3) - \dfrac{14}{27} + \dfrac{21}{27} x - \dfrac{1}{3} x^2 + \dfrac{2}{27} x^3$",
)

ax.spines["left"].set_position("zero")
ax.spines["bottom"].set_position("zero")
ax.spines["top"].set_color("none")
ax.spines["right"].set_color("none")

ax.set_xticks([tick for tick in ax.get_xticks() if tick != 0])
ax.set_yticks([tick for tick in ax.get_yticks() if tick != 0])

plt.legend(loc="best")
plt.show()
