package ca.tetervak.problemgenerator.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlgebraProblemListFactoryTest {

    @Test
    void createRandomAlgebraProblemList() {
        AlgebraProblemListFactory factory = new AlgebraProblemListFactory();
        for (DifficultyLevel difficultyLevel : DifficultyLevel.values()) {
            if (difficultyLevel != DifficultyLevel.UNKNOWN) {
                for (AlgebraProblemCategory category : AlgebraProblemCategory.values()) {
                    List<AlgebraProblem> problems = factory.createRandomAlgebraProblemList(category, difficultyLevel, 10);
                    assertNotNull(problems);
                    assertEquals(10, problems.size());
                    for (AlgebraProblem problem : problems) {
                        assertNotNull(problem);
                        assertEquals(category, problem.getCategory());
                        assertEquals(difficultyLevel, problem.getDifficultyLevel());
                    }
                }
            }
        }
    }
}