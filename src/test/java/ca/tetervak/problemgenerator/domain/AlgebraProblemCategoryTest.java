package ca.tetervak.problemgenerator.domain;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class AlgebraProblemCategoryTest {

    @Test
    void fromAlgebraOperator() {
        assertEquals(
                AlgebraProblemCategory.ADDITION,
                AlgebraProblemCategory.fromAlgebraOperator(AlgebraOperator.ADD)
        );
        assertEquals(
                AlgebraProblemCategory.SUBTRACTION,
                AlgebraProblemCategory.fromAlgebraOperator(AlgebraOperator.SUBTRACT)
        );
        assertEquals(
                AlgebraProblemCategory.MULTIPLICATION,
                AlgebraProblemCategory.fromAlgebraOperator(AlgebraOperator.MULTIPLY)
        );
        assertEquals(
                AlgebraProblemCategory.DIVISION,
                AlgebraProblemCategory.fromAlgebraOperator(AlgebraOperator.DIVIDE)
        );
    }

    @Test
    void getRandomAlgebraProblemCategory() {
        assertNotNull(
                AlgebraProblemCategory.getRandomAlgebraProblemCategory(
                        new Random()
                )
        );
    }
}
