# Code basiert auf dem Buch "Metin Karatas: Eigene KI-Anwendungen programmieren", Rheinwerk Computing, 2024"
import numpy as np
import random
import tensorflow as tf
import pandas as pd
import matplotlib.pyplot as plt

from sklearn.model_selection import train_test_split
from sklearn.preprocessing import MinMaxScaler


def plot_training(history):
    plt.figure(figsize=(8, 5))

    # Loss
    plt.plot(history.history["loss"], label="Train Loss", linestyle="--")
    plt.plot(history.history["val_loss"], label="Validation Loss", linestyle="--")

    # Accuracy
    plt.plot(history.history["accuracy"], label="Train Accuracy")
    plt.plot(history.history["val_accuracy"], label="Validation Accuracy")

    # Gestaltung
    plt.title("Verlauf von Verlust und Genauigkeit")
    plt.xlabel("Epoche")
    plt.ylabel("Wert")
    plt.legend()
    plt.grid(True)
    plt.tight_layout()
    plt.show()

    # plt.plot(history.history['accuracy'], label='Train Accuracy')
    # plt.plot(history.history['val_accuracy'], label='Val Accuracy')
    # plt.xlabel('Epoch')
    # plt.ylabel('Accuracy')
    # plt.legend()
    # plt.title('Trainingsverlauf')
    # plt.grid(True)

    # Verlust (Loss)
    # plt.subplot(1, 2, 2)
    # plt.plot(history.history['loss'], label='Train Loss', linestyle='--')
    # plt.plot(history.history['val_loss'], label='Validation Loss', linestyle='--')
    # plt.title('Verlust im Training')
    # plt.xlabel('Epoche')
    # plt.ylabel('Loss')
    # plt.legend()
    # plt.grid(True)

    # plt.tight_layout()
    # plt.show()


# Zufall fixieren
random.seed(42)
np.random.seed(42)
tf.random.set_seed(42)

path = "dataset.csv"
data = pd.read_csv(path, delimiter=";")
# Gib die ersten 5 Zeilen aus
print(data.head())

# Was soll vorhergesagt werden? Spaltenname in Variable speichern.
col_name = "species"

# Wandele die Zeichenkette der species in Zahlen um (z.B. Adelie -> 0, ....)
data[col_name] = data[col_name].astype("category")
data[col_name] = data[col_name].cat.codes

data["island"] = data["island"].astype("category")
data["island"] = data["island"].cat.codes

data["sex"] = data["sex"].astype("category")
data["sex"] = data["sex"].cat.codes

col = data[col_name]
# entfernte die Klassenangabe aus den Daten
data = data.drop([col_name], axis=1)


# Aus den Tabellen 6 Tabellen erzeugen
# 80% temp, 20% test
temp_data, test_data, temp_labels, test_labels = train_test_split(
    data, col, test_size=0.2, random_state=42
)

# temp weiter unterteilen: 80% train, 20% val
train_data, val_data, train_labels, val_labels = train_test_split(
    temp_data, temp_labels, test_size=0.2, random_state=42
)

scaler = MinMaxScaler()

train_data = scaler.fit_transform(train_data)
test_data = scaler.transform(test_data)
val_data = scaler.transform(val_data)

# Aufbau neuronales Netzes: Eingabeschicht mit 4 Features, verborgene Schichten
# mit 32 bzw. 64 Neuronen, Ausgabeschicht mit 3 Neuronen (da 3 Klassen)
# (Softmax (klassische Klassifikation))
model = tf.keras.Sequential(
    [
        tf.keras.Input(shape=(6,)),
        tf.keras.layers.Dense(10, activation=tf.nn.sigmoid),
        tf.keras.layers.Dense(3, activation=tf.nn.softmax),
    ]
)
# Konfiguration des Lernprozesses: adam (schneller, adaptiver Gradientenabstieg),
# - sparce_categorical_crossentropy: bei Klassifikation mit mehreren Klassen, wenn Klassenlabels als ganze Zahlen und nicht als one-hot-Vektoren vorliegen)
model.compile(
    optimizer="adam", loss="sparse_categorical_crossentropy", metrics=["accuracy"]
)

# Wenn sich der überwachte Wert (val_loss – also der Validierungsfehler) über mehrere Epochen hinweg nicht verbessert, wird das Training automatisch gestoppt
callback = tf.keras.callbacks.EarlyStopping(
    monitor="val_loss", patience=50, restore_best_weights=True
)
history = model.fit(
    train_data,
    train_labels,
    validation_data=(val_data, val_labels),
    epochs=500,
    callbacks=[callback],
)


# testen
test_loss, test_acc = model.evaluate(test_data, test_labels)
print("Test accuracy:", test_acc)

# History des Trainings ausgeben
plot_training(history)
