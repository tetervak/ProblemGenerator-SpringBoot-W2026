package ca.tetervak.problemgenerator.domain.division;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisionPairTest {

    @Test
    void testValidDivisionPair() {
        assertDoesNotThrow(
                () -> new DivisionPair(10, 5)
        );
    }

    @Test
    void testDividendTooLow() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new DivisionPair(0, 5)
        );
    }

    @Test
    void testDividendTooHigh() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new DivisionPair(101, 5)
        );
    }

    @Test
    void testDivisorTooLow() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new DivisionPair(10, 0)
        );
    }

    @Test
    void testDivisorTooHigh() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new DivisionPair(10, 101)
        );
    }

    @Test
    void testNotDivisible() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new DivisionPair(10, 3)
        );
    }

    @Test
    void testDividendLessThanDivisor() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new DivisionPair(5, 10)
        );
    }

    @Test
    void testDividendEqualToDivisor() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new DivisionPair(5, 5)
        );
    }

    @Test
    void testGetters() {
        DivisionPair pair = new DivisionPair(10, 2);
        assertEquals(10, pair.dividend());
        assertEquals(2, pair.divisor());
    }

    @Test
    void testQuotient() {
        DivisionPair pair = new DivisionPair(10, 2);
        assertEquals(5, pair.quotient());
    }

    @Test
    void testText() {
        DivisionPair pair = new DivisionPair(10, 2);
        assertEquals("10 / 2 = 5", pair.text());
    }
}
