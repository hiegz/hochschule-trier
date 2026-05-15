package com.example;

public final class TaschenrechnerSubtractionTest extends SubtractionTest {
    @Override
    protected Subtraction subtraction() {
        return new Taschenrechner();
    }
}
