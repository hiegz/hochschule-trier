package com.example;

public interface PercentageOf {
    /**
     * Berechnet den prozentualen Anteil von part am Gesamtwert whole.
     *
     * Die Implementierung soll eine `IllegalArgumentException` werfen,
     * falls {@code whole == 0}.
     */
    public int percentageOf(int part, int whole) throws IllegalArgumentException;
}
