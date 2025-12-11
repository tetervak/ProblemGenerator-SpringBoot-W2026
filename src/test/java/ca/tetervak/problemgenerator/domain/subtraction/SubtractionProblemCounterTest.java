package ca.tetervak.problemgenerator.domain.subtraction;

import ca.tetervak.problemgenerator.domain.CountsByLevels;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static java.lang.System.out;

class SubtractionProblemCounterTest {

    @Test
    void getSubtractionProblemCounts() {
        SubtractionProblemCounter counter = new SubtractionProblemCounter();
        CountsByLevels counts =
                counter.getCountsByLevels();
        out.println(counts);
        assertEquals(36, counts.beginner());
        assertEquals(90, counts.easy());
        assertEquals(360, counts.intermediate());
        assertEquals(369, counts.moderate());
        assertEquals(2385, counts.advanced());
        assertEquals(1710, counts.challenging());
        assertEquals(4950, counts.total());
    }
}