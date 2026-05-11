package com.example;

public interface Multiplication {
    /// Gibt das Produkt der beiden Argumente zurück.
    ///
    /// Die Implementierung soll eine `ArithmeticException` werfen,
    /// wenn das Ergebnis einen Überlauf des Typs `int` verursacht.
    public int multiply(int a, int b);
}
