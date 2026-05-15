package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public abstract class AdditionTest {
    protected abstract Addition addition();

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
            "-2147483648, 0, -2147483648",
            "0, -2147483648, -2147483648",
    })
    void shouldReturnExpectedSum(int a, int b, int expected) {
        assertEquals(expected, addition().add(a, b));
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
