package com.example;

public interface Division {
    /**
     * Gibt den Quotienten der beiden Argumente zurück.
     *
     * Die Implementierung soll eine `ArithmeticException` werfen,
     * wenn das Ergebnis einen `int`-Überlauf verursacht oder der Divisor 0 ist.
     */
    public int divide(int a, int b) throws ArithmeticException;
}
