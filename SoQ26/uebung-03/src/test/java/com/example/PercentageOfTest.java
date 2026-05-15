package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public abstract class PercentageOfTest {
    protected abstract PercentageOf percentageOf();

    @ParameterizedTest
    @CsvSource({
            "1, 2, 50",
            "1, 1, 100",
            "1, 3, 33",
            "2, 1, 200",
    })
    void shouldReturnExpectedPercentage(int part, int whole, int expected) {
        assertEquals(expected, percentageOf().percentageOf(part, whole));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "10, 0",
    })
    void shouldThrowIllegalArgumentExceptionOnWholeEqualsZero(int part, int whole) {
        assertThrows(IllegalArgumentException.class, () -> percentageOf().percentageOf(part, whole));
    }
}
