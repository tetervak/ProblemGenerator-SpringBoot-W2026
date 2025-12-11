package ca.tetervak.problemgenerator.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlgebraProblemFactoryTest {

    @Test
    void createRandomAlgebraProblem() {
        AlgebraProblemFactory factory = new AlgebraProblemFactory();
        for (DifficultyLevel difficultyLevel : DifficultyLevel.values()) {
            if (difficultyLevel != DifficultyLevel.UNKNOWN) {
                for (AlgebraProblemCategory category : AlgebraProblemCategory.values()) {
                    AlgebraProblem problem = factory.createRandomAlgebraProblem(category, difficultyLevel);
                    assertNotNull(problem);
                    assertEquals(category, problem.getCategory());
                    assertEquals(difficultyLevel, problem.getDifficultyLevel());
                }
            }
        }
    }
}