package ca.tetervak.problemgenerator.domain.multiplication;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplicationPairTest {

    @Test
    void testValidMultiplicationPair() {
        assertDoesNotThrow(
                () -> new MultiplicationPair(10, 5)
        );
    }

    @Test
    void testMultiplicandTooLow() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new MultiplicationPair(0, 5)
        );
    }

    @Test
    void testMultiplicandTooHigh() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new MultiplicationPair(101, 5)
        );
    }

    @Test
    void testMultiplierTooLow() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new MultiplicationPair(10, 0)
        );
    }

    @Test
    void testMultiplierTooHigh() {
        assertThrows(IllegalArgumentException.class,
                () -> new MultiplicationPair(10, 101)
        );
    }

    @Test
    void testProductTooHigh() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new MultiplicationPair(11, 10)
        );
    }

    @Test
    void testGetters() {
        MultiplicationPair pair = new MultiplicationPair(8, 9);
        assertEquals(8, pair.multiplicand());
        assertEquals(9, pair.multiplier());
    }
}
