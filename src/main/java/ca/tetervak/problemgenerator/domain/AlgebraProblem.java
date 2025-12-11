package ca.tetervak.problemgenerator.domain;

import org.jspecify.annotations.NonNull;


public record AlgebraProblem(
        int firstOperand,
        int secondOperand,
        @NonNull AlgebraOperator algebraOperator,
        @NonNull DifficultyLevel difficultyLevel
) {

    // explicit canonical constructor with validation
    public AlgebraProblem {
        if (firstOperand < 1 || firstOperand > 100) {
            throw new IllegalArgumentException("First operand must be between 1 and 100");
        }
        if (secondOperand < 1 || secondOperand > 100) {
            throw new IllegalArgumentException("Second operand must be between 1 and 100");
        }
    }

    // Shim getters for backward compatibility
    public int getFirstOperand() {
        return firstOperand;
    }

    public int getSecondOperand() {
        return secondOperand;
    }

    public int getAnswer() {
        return algebraOperator.calculate(firstOperand, secondOperand);
    }

    @NonNull
    public AlgebraOperator getOperator() {
        return algebraOperator;
    }

    @NonNull
    public AlgebraProblemCategory getCategory() {
        return AlgebraProblemCategory.fromAlgebraOperator(algebraOperator);
    }

    @NonNull
    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    @NonNull
    public String getText() {
        return firstOperand + " " + algebraOperator.getSymbol() + " " + secondOperand;
    }

    @Override
    public @NonNull String toString() {
        return "AlgebraProblem{text=%s, answer=%d, difficultyLevel=%s}"
                .formatted(getText(), getAnswer(), difficultyLevel);
    }
}