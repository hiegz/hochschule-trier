import pandas as pd
from pandas import DataFrame
from typing import Set


class Attribute:
    label: str
    values: Set

    def __repr__(self) -> str:
        return str(vars(self))


data = pd.read_excel("play_tennis_data_small.xlsx")


def gini(data: DataFrame):
    acc = 0
    for count in data.value_counts(normalize=True):
        acc += count**2
    return 1 - acc


value_counts = data["PlayTennis"].value_counts()

print("p = %d, n = %d" % (value_counts.get("Yes"), value_counts.get("No")))
print("Gini(S) = %f" % (gini(data["PlayTennis"])))
