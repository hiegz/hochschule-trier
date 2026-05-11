package com.example;

public class Taschenrechner implements Addition, Subtraction, Multiplication, Division {
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
}
