package com.example;

public final class TaschenrechnerDivisionTest extends DivisionTest {
    @Override
    protected Division division() {
        return new Taschenrechner();
    }
}
