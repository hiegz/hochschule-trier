package com.example;

public final class AdditionTest extends AbstractAdditionTest {
    @Override
    protected Addition addition() {
        return new Taschenrechner();
    }
}
