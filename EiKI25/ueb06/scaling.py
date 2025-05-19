bill_length_mm = [39.1, 38.8, 36.3, 38.2, 39.0, 43.3]
bill_depth_mm = [18.7, 17.2, 19.5, 20.0, 17.1, 14.0]
flipper_length_mm = [181, 180, 190, 190, 191, 208]
body_mass_g = [3750, 3800, 3800, 3900, 3050, 4575]


def min_max_scaler(dataset):
    ret = []
    xmin = min(dataset)
    xmax = max(dataset)
    for feature in dataset:
        ret.append((feature - xmin) / (xmax - xmin))
    return ret


print("Min-Max Scaler")

# fmt: off
print("Bill length (mm)    : {} -> {}".format(bill_length_mm,    min_max_scaler(bill_length_mm)))
print("Bill depth (mm)     : {} -> {}".format(bill_depth_mm,     min_max_scaler(bill_depth_mm)))
print("Flipper length (mm) : {} -> {}".format(flipper_length_mm, min_max_scaler(flipper_length_mm)))
print("Body mass (g)       : {} -> {}".format(body_mass_g,       min_max_scaler(body_mass_g)))
# fmt: on


def standard_scaler(dataset):
    import math

    n = len(dataset)
    mu = (1 / n) * sum(dataset)
    sigma = math.sqrt((1 / (n - 1)) * sum((i - mu) ** 2 for i in dataset))

    ret = []

    for feature in dataset:
        ret.append((feature - mu) / sigma)

    return ret


print("Standard Scaler")

# fmt: off
print("Bill length (mm)    : {} -> {}".format(bill_length_mm,    standard_scaler(bill_length_mm)))
print("Bill depth (mm)     : {} -> {}".format(bill_depth_mm,     standard_scaler(bill_depth_mm)))
print("Flipper length (mm) : {} -> {}".format(flipper_length_mm, standard_scaler(flipper_length_mm)))
print("Body mass (g)       : {} -> {}".format(body_mass_g,       standard_scaler(body_mass_g)))
# fmt: on
