package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public abstract class SubtractionTest {
    protected abstract Subtraction subtraction();

    @ParameterizedTest
    @CsvSource({
            "1, 2, -1",
            "2, 3, -1",
            "-2, 10, -12",
            "100, 200, -100",
            "0, 0, 0",
            "1, 0, 1",
            "0, 1, -1",
            "2147483647, 0, 2147483647",
            "0, 2147483647, -2147483647",
    })
    void shouldReturnExpectedDifference(int a, int b, int expected) {
        assertEquals(expected, subtraction().subtract(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "2147483647, -1",
            "-2147483648, 1",
            "1, -2147483648",
            "0, -2147483648",
    })
    void shouldThrowArithmeticExceptionOnIntegerOverflow(int a, int b) {
        assertThrows(ArithmeticException.class, () -> subtraction().subtract(a, b));
    }
}
