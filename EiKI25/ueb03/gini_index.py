import pandas as pd
from pandas import DataFrame
from typing import Set


class Attribute:
    label: str
    values: Set

    def __repr__(self) -> str:
        return str(vars(self))


data = pd.read_excel("play_tennis_data_small.xlsx")
X = data.drop(columns=["PlayTennis"])
Y = data["PlayTennis"]
attributes = set()
for label in X.columns.values:
    attribute = Attribute()
    attribute.label = label
    attribute.values = set(data[label].unique())
    attributes.add(attribute)


def gini(data: DataFrame):
    acc = 0
    for count in data.value_counts(normalize=True):
        acc += count**2
    return 1 - acc


def gini_index(y: DataFrame, x: DataFrame, attribute: Attribute):
    acc = 0
    for value in attribute.values:
        y_v = y[x[attribute.label] == value]
        acc += (len(y_v) / len(y)) * gini(y_v)
    return acc


for attribute in attributes:
    print("Gini-Index(%s) = %f" % (attribute.label, gini_index(Y, X, attribute)))
