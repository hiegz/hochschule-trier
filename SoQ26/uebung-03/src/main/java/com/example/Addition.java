package com.example;

public interface Addition {
    /**
     * Gibt die Summe der beiden Argumente zurück.
     *
     * Die Implementierung soll eine `ArithmeticException` werfen,
     * wenn das Ergebnis einen `int`-Überlauf verursacht.
     */
    public int add(int a, int b) throws ArithmeticException;
}
