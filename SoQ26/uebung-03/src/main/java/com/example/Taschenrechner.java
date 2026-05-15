package com.example;

public final class Taschenrechner implements Addition, Subtraction, Multiplication, Division, PercentageOf, Mwst {
    @Override
    public int add(int a, int b) throws ArithmeticException {
        return Math.addExact(a, b);
    }

    @Override
    public int subtract(int a, int b) throws ArithmeticException {
        return Math.subtractExact(a, b);
    }

    @Override
    public int multiply(int a, int b) throws ArithmeticException {
        return Math.multiplyExact(a, b);
    }

    @Override
    public int divide(int a, int b) throws ArithmeticException {
        return Math.divideExact(a, b);
    }

    @Override
    public int percentageOf(int part, int whole) throws IllegalArgumentException {
        if (whole == 0) {
            throw new IllegalArgumentException();
        }

        double d = (part * 1.0 / whole) * 100;

        return (int) d;
    }

    @Override
    public int mwst(int wert, int steuersatz) throws IllegalArgumentException, ArithmeticException {
        if (wert < 0 || steuersatz < 0) {
            throw new IllegalArgumentException();
        }

        double s = (double) steuersatz / 100.0;
        double r = (double) wert * s;

        if (r > Integer.MAX_VALUE) {
            throw new ArithmeticException();
        }

        return (int) r;
    }
}
