package com.example;

public interface Mwst {
    /**
     * Berechnet die Mehrwertsteuer (Steueranteil) eines gegebenen Betrags.
     *
     * Die Implementierung soll eine `IllegalArgumentException` werfen,
     * falls wert oder steuersatz negativ sind.
     *
     * Die Implementierung soll eine `ArithmeticException` werfen, wenn das
     * Ergebnis einen `int`-Überlauf verursacht.
     */
    public int mwst(int wert, int steuersatz) throws IllegalArgumentException, ArithmeticException;
}
