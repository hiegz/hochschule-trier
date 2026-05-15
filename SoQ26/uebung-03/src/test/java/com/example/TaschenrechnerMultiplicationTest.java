package com.example;

public final class TaschenrechnerMultiplicationTest extends MultiplicationTest {
    @Override
    protected Multiplication multiplication() {
        return new Taschenrechner();
    }
}
