package com.example;

public interface Subtraction {
    /// Gibt die Differenz der beiden Argumente zurück.
    ///
    /// Die Implementierung soll eine `ArithmeticException` werfen,
    /// wenn das Ergebnis einen Überlauf des Typs `int` verursacht.
    public int subtract(int a, int b) throws ArithmeticException;
}
