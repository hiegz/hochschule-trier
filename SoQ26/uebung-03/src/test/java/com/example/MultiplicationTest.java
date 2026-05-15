package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public abstract class MultiplicationTest {
    protected abstract Multiplication multiplication();

    @ParameterizedTest
    @CsvSource({
            "0, 1, 0",
            "1, 0, 0",
            "1, 1, 1",
            "2, 2, 4",
            "2, -2, -4",
            "-2, 2, -4",
            "-2, -2, 4",
            "2147483647, 1, 2147483647",
            "1, 2147483647, 2147483647",
            "2147483647, -1, -2147483647",
            "-1, 2147483647, -2147483647",
            "-2147483648, 1, -2147483648",
            "1, -2147483648, -2147483648",
    })
    void shouldReturnExpectedProduct(int a, int b, int expected) {
        assertEquals(multiplication().multiply(a, b), expected);
    }

    @ParameterizedTest
    @CsvSource({
            "2147483647, 2",
            "2, 2147483647",
            "-2147483648, 2",
            "2, -2147483648",
            "-2147483648, -1",
            "-1, -2147483648",
    })
    void shouldThrowArithmeticExceptionOnIntegerOverflow(int a, int b) {
        assertThrows(ArithmeticException.class, () -> multiplication().multiply(a, b));
    }
}
