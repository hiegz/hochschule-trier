package com.example;

public final class TaschenrechnerAdditionTest extends AdditionTest {
    @Override
    protected Addition addition() {
        return new Taschenrechner();
    }
}
