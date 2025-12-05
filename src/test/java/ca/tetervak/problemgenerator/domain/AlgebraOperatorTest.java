package ca.tetervak.problemgenerator.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AlgebraOperatorTest {

    @Test
    void fromSymbol() {
        assertEquals(AlgebraOperator.ADD, AlgebraOperator.fromSymbol('+'));
        assertEquals(AlgebraOperator.SUBTRACT, AlgebraOperator.fromSymbol('-'));
        assertEquals(AlgebraOperator.MULTIPLY, AlgebraOperator.fromSymbol('*'));
        assertEquals(AlgebraOperator.DIVIDE, AlgebraOperator.fromSymbol('/'));
    }

    @Test
    void fromSymbol_invalid() {
        assertThrows(
                IllegalArgumentException.class,
                () -> AlgebraOperator.fromSymbol('x')
        );
    }

    @Test
    void calculate() {
        assertEquals(8, AlgebraOperator.ADD.calculate(5, 3));
        assertEquals(2, AlgebraOperator.SUBTRACT.calculate(5, 3));
        assertEquals(15, AlgebraOperator.MULTIPLY.calculate(5, 3));
        assertEquals(1, AlgebraOperator.DIVIDE.calculate(5, 3));
    }

    @Test
    void getSymbol() {
        assertEquals('+', AlgebraOperator.ADD.getSymbol());
        assertEquals('-', AlgebraOperator.SUBTRACT.getSymbol());
        assertEquals('*', AlgebraOperator.MULTIPLY.getSymbol());
        assertEquals('/', AlgebraOperator.DIVIDE.getSymbol());
    }
}
