package ca.tetervak.problemgenerator.domain;

public enum AlgebraProblemCategory {
    ADDITION,
    SUBTRACTION,
    MULTIPLICATION,
    DIVISION;

    public static AlgebraProblemCategory fromAlgebraOperator(AlgebraOperator operator) {
        return switch (operator) {
            case ADD -> ADDITION;
            case SUBTRACT -> SUBTRACTION;
            case MULTIPLY -> MULTIPLICATION;
            case DIVIDE -> DIVISION;
        };
    }
}
