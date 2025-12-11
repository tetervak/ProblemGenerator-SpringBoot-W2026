package ca.tetervak.problemgenerator.domain.addition;

import ca.tetervak.problemgenerator.domain.CountsByLevels;
import org.junit.jupiter.api.Test;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AdditionProblemCounterTest {

    @Test
    void getAdditionProblemCounts() {
        AdditionProblemCounter counter = new AdditionProblemCounter();
        CountsByLevels counts = counter.getCountsByLevels();
        out.println(counts);
        assertEquals(45, counts.beginner());
        assertEquals(54, counts.easy());
        assertEquals(954, counts.intermediate());
        assertEquals(576, counts.moderate());
        assertEquals(2313, counts.advanced());
        assertEquals(1008, counts.challenging());
        assertEquals(4950, counts.total());
    }

}