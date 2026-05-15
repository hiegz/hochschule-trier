package com.example;

public final class TaschenrechnerMwstTest extends MwstTest {
    @Override
    protected Mwst mwst() {
        return new Taschenrechner();
    }
}
