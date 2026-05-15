package com.example;

public final class TaschenrechnerPercentageOfTest extends PercentageOfTest {
    @Override
    protected PercentageOf percentageOf() {
        return new Taschenrechner();
    }
}
