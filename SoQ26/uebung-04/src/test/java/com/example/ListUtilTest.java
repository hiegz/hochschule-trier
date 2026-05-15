package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ListUtilTest {
    // -------------------------
    // isEmpty Tests
    // -------------------------

    @Test
    void testIsEmpty_true() {
        assertTrue(ListUtil.isEmpty(new int[]{}));
    }

    @Test
    void testIsEmpty_false_singleElement() {
        assertFalse(ListUtil.isEmpty(new int[]{1}));
    }

    @Test
    void testIsEmpty_false_multipleElements() {
        assertFalse(ListUtil.isEmpty(new int[]{1, 2, 3}));
    }

    // -------------------------
    // getLength Tests
    // -------------------------

    @Test
    void testGetLength_empty() {
        assertEquals(0, ListUtil.getLength(new int[]{}));
    }

    @Test
    void testGetLength_normalArray() {
        assertEquals(4, ListUtil.getLength(new int[]{10, 20, 30, 40}));
    }

    // -------------------------
    // getLargest Tests
    // -------------------------

    @Test
    void testGetLargest_normal() {
        assertEquals(9, ListUtil.getLargest(new int[]{3, 9, 1, 7}));
    }

    @Test
    void testGetLargest_negativeNumbers() {
        assertEquals(-2, ListUtil.getLargest(new int[]{-10, -2, -5}));
    }

    @Test
    void testGetLargest_singleElement() {
        assertEquals(5, ListUtil.getLargest(new int[]{5}));
    }

    @Test
    void testGetLargest_emptyArray_throwsException() {
        assertThrows(RuntimeException.class, () -> {
            ListUtil.getLargest(new int[]{});
        });
    }

    // -------------------------
    // getSmallest Tests
    // -------------------------

    @Test
    void testGetSmallest_normal() {
        assertEquals(1, ListUtil.getSmallest(new int[]{3, 1, 9, 7}));
    }

    @Test
    void testGetSmallest_negativeNumbers() {
        assertEquals(-10, ListUtil.getSmallest(new int[]{-10, -2, -5}));
    }

    @Test
    void testGetSmallest_singleElement() {
        assertEquals(8, ListUtil.getSmallest(new int[]{8}));
    }

    @Test
    void testGetSmallest_emptyArray_throwsException() {
        assertThrows(RuntimeException.class, () -> {
            ListUtil.getSmallest(new int[]{});
        });
    }

    @Test
    void testNullInput_getLength() {
        assertThrows(NullPointerException.class, () -> {
            ListUtil.getLength(null);
        });
    }

    @Test
    void testNullInput_isEmpty() {
        assertThrows(NullPointerException.class, () -> {
            ListUtil.isEmpty(null);
        });
    }

    @Test
    void testNullInput_getLargest() {
        assertThrows(NullPointerException.class, () -> {
            ListUtil.getLargest(null);
        });
    }

    @Test
    void testNullInput_getSmallest() {
        assertThrows(NullPointerException.class, () -> {
            ListUtil.getSmallest(null);
        });
    }
}
