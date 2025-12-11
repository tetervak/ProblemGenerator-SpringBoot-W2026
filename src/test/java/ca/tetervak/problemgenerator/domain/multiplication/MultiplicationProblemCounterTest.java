package ca.tetervak.problemgenerator.domain.multiplication;

import ca.tetervak.problemgenerator.domain.CountsByLevels;
import org.junit.jupiter.api.Test;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

class MultiplicationProblemCounterTest {

    @Test
    void getMultiplicationProblemCounts() {
        MultiplicationProblemCounter counter = new MultiplicationProblemCounter();
        CountsByLevels counts = counter.getCountsByLevels();
        out.println(counts);
        assertEquals(16, counts.beginner());
        assertEquals(25, counts.easy());
        assertEquals(24, counts.intermediate());
        assertEquals(16, counts.moderate());
        assertEquals(84, counts.advanced());
        assertEquals(118, counts.challenging());
        assertEquals(283, counts.total());
    }
}