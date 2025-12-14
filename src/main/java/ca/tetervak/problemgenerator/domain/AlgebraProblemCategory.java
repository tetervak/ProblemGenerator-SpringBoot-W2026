package ca.tetervak.problemgenerator.domain;

import org.jspecify.annotations.NonNull;

import java.util.Random;

public enum AlgebraProblemCategory {
    ADDITION,
    SUBTRACTION,
    MULTIPLICATION,
    DIVISION;

    @NonNull
    public static AlgebraProblemCategory fromAlgebraOperator(AlgebraOperator operator) {
        return switch (operator) {
            case ADD -> ADDITION;
            case SUBTRACT -> SUBTRACTION;
            case MULTIPLY -> MULTIPLICATION;
            case DIVIDE -> DIVISION;
        };
    }

    @NonNull
    public static AlgebraProblemCategory fromString(String category) {
        return switch (category) {
            case "addition" -> ADDITION;
            case "subtraction" -> SUBTRACTION;
            case "multiplication" -> MULTIPLICATION;
            case "division" -> DIVISION;
            default -> throw new IllegalArgumentException("Invalid category: " + category);
        };
    }

    @NonNull
    public static String[] getStringArray() {
        return new String[]{"addition", "subtraction", "multiplication", "division"};
    }

    @NonNull
    public static AlgebraProblemCategory getRandomAlgebraProblemCategory(
            Random random
    ){
        return values()[random.nextInt(values().length)];
    }
}
