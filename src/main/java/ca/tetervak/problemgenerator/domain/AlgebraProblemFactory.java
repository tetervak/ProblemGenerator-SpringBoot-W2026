package ca.tetervak.problemgenerator.domain;

import ca.tetervak.problemgenerator.domain.addition.AdditionProblemFactory;
import ca.tetervak.problemgenerator.domain.division.DivisionProblemFactory;
import ca.tetervak.problemgenerator.domain.multiplication.MultiplicationProblemFactory;
import ca.tetervak.problemgenerator.domain.subtraction.SubtractionProblemFactory;
import org.jspecify.annotations.NonNull;

import java.util.Random;

public class AlgebraProblemFactory {

    private final AdditionProblemFactory additionProblemFactory;
    private final SubtractionProblemFactory subtractionProblemFactory;
    private final MultiplicationProblemFactory multiplicationProblemFactory;
    private final DivisionProblemFactory divisionProblemFactory;

    public AlgebraProblemFactory(@NonNull Random random) {
        this.additionProblemFactory = new AdditionProblemFactory(random);
        this.subtractionProblemFactory = new SubtractionProblemFactory(random);
        this.multiplicationProblemFactory = new MultiplicationProblemFactory(random);
        this.divisionProblemFactory = new DivisionProblemFactory(random);
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
            case ADDITION -> additionProblemFactory.createRandomAdditionProblem(difficultyLevel);
            case SUBTRACTION -> subtractionProblemFactory.createRandomSubtractionProblem(difficultyLevel);
            case MULTIPLICATION -> multiplicationProblemFactory.createRandomMultiplicationProblem(difficultyLevel);
            case DIVISION -> divisionProblemFactory.createRandomDivisionProblem(difficultyLevel);
        };
    }
}
