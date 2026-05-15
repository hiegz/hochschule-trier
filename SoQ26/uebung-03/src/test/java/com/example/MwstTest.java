package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public abstract class MwstTest {
    protected abstract Mwst mwst();

    @ParameterizedTest
    @CsvSource({
            "1, 100, 1",
            "1, 200, 2",
            "2147483647, 100, 2147483647",
    })
    void shouldReturnExpectedMwst(int a, int b, int expected) {
        assertEquals(expected, mwst().mwst(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "2147483647, 110",
    })
    void shouldThrowArithmeticExceptionOnIntegerOverflow(int a, int b) {
        assertThrows(ArithmeticException.class, () -> mwst().mwst(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "-1, 20",
            "20, -2",
            "-3, -2",
    })
    void shouldThrowIllegalArgumentExceptionOnInvalidArguments(int a, int b) {
        assertThrows(IllegalArgumentException.class, () -> mwst().mwst(a, b));
    }
}
