import glob
import numpy as np
import matplotlib.pyplot as plt

csv_files = glob.glob("data/*.csv")

means = []

for file in csv_files:
    with open(file, "r") as f:
        content = f.read().replace("\n", "")
        numbers = [float(x) for x in content.split(",") if x.strip() != ""]
        mean = np.mean(numbers)
        means.append(mean)

plt.figure(figsize=(10, 6))
plt.bar([f"{i+1}" for i in range(len(means))], means, color="skyblue")
plt.axhline(y=240, color='green', linestyle='--', linewidth=2, label="MHP (240 ms)")
plt.legend()

plt.xlabel("Teilnehmer")
plt.ylabel("Mittelwerte")
plt.savefig("plot.pdf", format="pdf")
