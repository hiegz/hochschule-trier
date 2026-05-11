package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public abstract class AbstractSubtractionTest {
    protected abstract Subtraction subtraction();

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "2, 3, 5",
            "-2, 10, 8",
            "100, 200, 300",
            "0, 0, 0",
            "1, 0, 1",
            "0, 1, 1",
            "2147483647, 0, 2147483647",
            "0, 2147483647, 2147483647",
    })
    void shouldReturnExpectedDifference(int a, int b, int expected) {
        assertEquals(subtraction().subtract(a, b), expected);
    }

    @ParameterizedTest
    @CsvSource({
            "2147483647, 1",
            "1, 2147483647",
            "-2147483648, -1",
            "-1, -2147483648",
    })
    void shouldThrowArithmeticExceptionOnIntegerOverflow(int a, int b) {
        assertThrows(ArithmeticException.class, () -> addition().add(a, b));
    }
}
