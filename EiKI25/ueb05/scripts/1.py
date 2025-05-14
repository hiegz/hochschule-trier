import pandas as pd

df = pd.read_csv("data/1.csv")
X = df.drop("Cancelled", axis=1)
Y = df["Cancelled"]


def entropy(y):
    from scipy.stats import entropy as _entropy

    return _entropy(y.value_counts(normalize=True), base=2)


def information_gain(x, y, feature):
    total_entropy = entropy(y)
    values = x[feature].unique()
    weighted_entropy = 0
    for v in values:
        subset = y[x[feature] == v]
        weighted_entropy += (len(subset) / len(y)) * entropy(subset)
    return total_entropy - weighted_entropy


gain = {f: information_gain(X, Y, f) for f in ["TimeOfDay", "Device", "PaymentMethod"]}

for feat, score in gain.items():
    print(f"{feat}: {score:.4f}")
