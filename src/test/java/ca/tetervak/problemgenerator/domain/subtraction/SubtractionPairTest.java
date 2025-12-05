package ca.tetervak.problemgenerator.domain.subtraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubtractionPairTest {

    @Test
    void testValidSubtractionPair() {
        assertDoesNotThrow(
                () -> new SubtractionPair(50, 25)
        );
    }

    @Test
    void testMinuendTooLow() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new SubtractionPair(1, 1)
        );
    }

    @Test
    void testMinuendTooHigh() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new SubtractionPair(101, 1)
        );
    }

    @Test
    void testSubtrahendTooLow() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new SubtractionPair(50, 0)
        );
    }

    @Test
    void testSubtrahendTooHigh() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new SubtractionPair(50, 100)
        );
    }

    @Test
    void testDifferenceTooLow() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new SubtractionPair(50, 50)
        );
    }

    @Test
    void testGetters() {
        SubtractionPair pair = new SubtractionPair(75, 25);
        assertEquals(75, pair.minuend());
        assertEquals(25, pair.subtrahend());
    }
}
