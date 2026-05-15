package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public abstract class DivisionTest {
    protected abstract Division division();

    @ParameterizedTest
    @CsvSource({
            "1, 1, 1",
            "2, 1, 2",
            "2, 2, 1",
            "4, 2, 2",
            "10, 2, 5",
            "1, 2, 0",
            "2, 4, 0",
    })
    void shouldReturnExpectedQuotient(int a, int b, int expected) {
        assertEquals(expected, division().divide(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 0",
            "2, 0",
    })
    void shouldThrowArithmeticExceptionOnDivisionByZero(int a, int b) {
        assertThrows(ArithmeticException.class, () -> division().divide(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "-2147483648, -1",
    })
    void shouldThrowArithmeticExceptionOnIntegerOverflow(int a, int b) {
        assertThrows(ArithmeticException.class, () -> division().divide(a, b));
    }
}
