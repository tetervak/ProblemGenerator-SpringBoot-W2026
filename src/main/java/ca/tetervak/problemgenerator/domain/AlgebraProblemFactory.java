package ca.tetervak.problemgenerator.domain;

import ca.tetervak.problemgenerator.domain.addition.AdditionPair;
import ca.tetervak.problemgenerator.domain.addition.AdditionProblemFactory;
import ca.tetervak.problemgenerator.domain.division.DivisionPair;
import ca.tetervak.problemgenerator.domain.division.DivisionProblemFactory;
import ca.tetervak.problemgenerator.domain.multiplication.MultiplicationPair;
import ca.tetervak.problemgenerator.domain.multiplication.MultiplicationProblemFactory;
import ca.tetervak.problemgenerator.domain.subtraction.SubtractionPair;
import ca.tetervak.problemgenerator.domain.subtraction.SubtractionProblemFactory;
import org.jspecify.annotations.NonNull;

import java.util.Random;

public class AlgebraProblemFactory {

    private final AdditionProblemFactory additionFactory;
    private final SubtractionProblemFactory subtractionFactory;
    private final MultiplicationProblemFactory multiplicationFactory;
    private final DivisionProblemFactory divisionFactory;

    public AlgebraProblemFactory(Random random) {
        this.additionFactory = new AdditionProblemFactory(random);
        this.subtractionFactory = new SubtractionProblemFactory(random);
        this.multiplicationFactory = new MultiplicationProblemFactory(random);
        this.divisionFactory = new DivisionProblemFactory(random);
    }

    public AlgebraProblemFactory() {
        this(new Random());
    }

    @NonNull
    public AlgebraProblem createRandomAlgebraProblem(
            @NonNull AlgebraProblemCategory category,
            @NonNull DifficultyLevel difficultyLevel
    ) {
        return switch (category) {
            case ADDITION -> additionFactory.createRandomAdditionProblem(difficultyLevel);
            case SUBTRACTION -> subtractionFactory.createRandomSubtractionProblem(difficultyLevel);
            case MULTIPLICATION -> multiplicationFactory.createRandomMultiplicationProblem(difficultyLevel);
            case DIVISION -> divisionFactory.createRandomDivisionProblem(difficultyLevel);
        };
    }

    @NonNull
    public static AlgebraProblem getInstance(
            @NonNull AdditionPair additionPair,
            @NonNull DifficultyLevel difficultyLevel
    ) {
        return new AlgebraProblem(
                additionPair.firstAddend(),
                additionPair.secondAddend(),
                AlgebraOperator.ADD,
                difficultyLevel
        );
    }

    @NonNull
    public static AlgebraProblem getInstance(
            @NonNull SubtractionPair subtractionPair,
            @NonNull DifficultyLevel difficultyLevel
    ) {
        return new AlgebraProblem(
                subtractionPair.minuend(),
                subtractionPair.subtrahend(),
                AlgebraOperator.SUBTRACT,
                difficultyLevel
        );
    }

    @NonNull
    public static AlgebraProblem getInstance(
            @NonNull MultiplicationPair multiplicationPair,
            @NonNull DifficultyLevel difficultyLevel
    ) {
        return new AlgebraProblem(
                multiplicationPair.multiplicand(),
                multiplicationPair.multiplier(),
                AlgebraOperator.MULTIPLY,
                difficultyLevel
        );
    }

    @NonNull
    public static AlgebraProblem getInstance(
            @NonNull DivisionPair divisionPair,
            @NonNull DifficultyLevel difficultyLevel
    ) {
        return new AlgebraProblem(
                divisionPair.dividend(),
                divisionPair.divisor(),
                AlgebraOperator.DIVIDE,
                difficultyLevel
        );
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