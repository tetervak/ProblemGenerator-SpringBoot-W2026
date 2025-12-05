package ca.tetervak.problemgenerator.domain.addition;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdditionPairTest {

    @Test
    void testValidAdditionPair() {
        assertDoesNotThrow(() -> new AdditionPair(50, 50));
    }

    @Test
    void testFirstAddendTooLow() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new AdditionPair(0, 50)
        );
    }

    @Test
    void testFirstAddendTooHigh() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new AdditionPair(100, 1)
        );
    }

    @Test
    void testSecondAddendTooLow() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new AdditionPair(50, 0)
        );
    }

    @Test
    void testSecondAddendTooHigh() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new AdditionPair(1, 100)
        );
    }

    @Test
    void testSumTooHigh() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new AdditionPair(51, 50)
        );
    }

    @Test
    void testGetters() {
        AdditionPair pair = new AdditionPair(40, 30);
        assertEquals(40, pair.firstAddend());
        assertEquals(30, pair.secondAddend());
    }

    @Test
    void testSum() {
        AdditionPair pair = new AdditionPair(40, 30);
        assertEquals(70, pair.sum());
    }

    @Test
    void testText() {
        AdditionPair pair = new AdditionPair(6, 7);
        assertEquals("6 + 7 = 13", pair.text());
    }
}
