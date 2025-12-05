package ca.tetervak.problemgenerator.domain;

import ca.tetervak.problemgenerator.domain.addition.AdditionPair;
import ca.tetervak.problemgenerator.domain.multiplication.MultiplicationPair;
import ca.tetervak.problemgenerator.domain.subtraction.SubtractionPair;
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

    // explicit non-canonical constructor for addition
    public AlgebraProblem(
            @NonNull AdditionPair additionPair,
            @NonNull DifficultyLevel difficultyLevel
    ) {
        this(
                additionPair.firstAddend(),
                additionPair.secondAddend(),
                AlgebraOperator.ADD,
                difficultyLevel
        );
    }

    public AlgebraProblem(
            @NonNull SubtractionPair subtractionPair,
            @NonNull DifficultyLevel difficultyLevel
    ) {
        this(
                subtractionPair.minuend(),
                subtractionPair.subtrahend(),
                AlgebraOperator.SUBTRACT,
                difficultyLevel
        );
    }

    public AlgebraProblem(
            @NonNull MultiplicationPair multiplicationPair,
            @NonNull DifficultyLevel difficultyLevel
    ) {
        this(
                multiplicationPair.multiplicand(),
                multiplicationPair.multiplier(),
                AlgebraOperator.MULTIPLY,
                difficultyLevel
        );
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
        return "AlgebraProblem{" +
                "text=" + getText() +
                ", answer=" + getAnswer() +
                ", difficultyLevel=" + difficultyLevel +
                '}';
    }

    @NonNull
    public static AlgebraProblem createFromText(
            String text,
            DifficultyLevel difficultyLevel
    ) {
        String[] parts = text.split(" ");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid text format: expected 'firstOperand operator secondOperand'");
        }
        if (parts[1].length() != 1) {
            throw new IllegalArgumentException("Operator must be a single character");
        }
        int firstOperand = Integer.parseInt(parts[0]);
        char symbol = parts[1].charAt(0);
        AlgebraOperator algebraOperator = AlgebraOperator.fromSymbol(symbol);
        int secondOperand = Integer.parseInt(parts[2]);
        return new AlgebraProblem(firstOperand, secondOperand, algebraOperator, difficultyLevel);
    }
}