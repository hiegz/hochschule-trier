import os
import numpy as np

from collections import Counter
from sklearn.feature_extraction import FeatureHasher
from sklearn.metrics.pairwise import cosine_similarity

DATA_PATH = "/data/0/shakespeare"

docs = []
names = []

for filename in sorted(os.listdir(DATA_PATH)):
    print(filename)
    with open(os.path.join(DATA_PATH, filename), encoding="utf-8") as f:
        docs.append(f.read())
        names.append(filename)

print(f"loaded {len(docs)} documents")

hashed_input = [Counter(doc.split()) for doc in docs]
hasher = FeatureHasher(n_features=100)
x_hash = hasher.transform(hashed_input)
cos_hash = cosine_similarity(x_hash)

for i in range(len(docs)):
    for j in range(i+1, len(docs)):
        print(f"{names[i]} vs {names[j]}: {cos_hash[i,j]:.3f}")
