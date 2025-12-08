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

    public static AlgebraProblemCategory fromString(String category) {
        return switch (category) {
            case "addition" -> ADDITION;
            case "subtraction" -> SUBTRACTION;
            case "multiplication" -> MULTIPLICATION;
            case "division" -> DIVISION;
            default -> throw new IllegalArgumentException("Invalid category: " + category);
        };
    }
}
