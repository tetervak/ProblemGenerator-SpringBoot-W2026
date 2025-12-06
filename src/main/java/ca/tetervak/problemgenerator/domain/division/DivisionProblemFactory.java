package ca.tetervak.problemgenerator.domain.division;

import ca.tetervak.problemgenerator.domain.AlgebraProblem;
import ca.tetervak.problemgenerator.domain.DifficultyLevel;
import ca.tetervak.problemgenerator.domain.multiplication.MultiplicationPair;
import ca.tetervak.problemgenerator.domain.multiplication.MultiplicationProblemFactory;
import org.jspecify.annotations.NonNull;

import java.util.Random;

public class DivisionProblemFactory {

    private final MultiplicationProblemFactory multiplicationProblemFactory;

    public DivisionProblemFactory(
            @NonNull Random random
    ) {
        this.multiplicationProblemFactory = new MultiplicationProblemFactory(random);
    }

    public DivisionProblemFactory() {
        this(new Random());
    }

    @NonNull
    public DivisionPair createRandomDivisionPair(
            @NonNull DifficultyLevel difficultyLevel
    ) {
        MultiplicationPair multiplicationPair =
                multiplicationProblemFactory.createRandomMultiplicationPair(difficultyLevel);
        return new DivisionPair(multiplicationPair.product(), multiplicationPair.multiplicand());
    }

    @NonNull
    public AlgebraProblem createRandomDivisionProblem(
            @NonNull DifficultyLevel difficultyLevel
    ) {
        DivisionPair divisionPair = createRandomDivisionPair(difficultyLevel);
        return new AlgebraProblem(divisionPair, difficultyLevel);
    }
}
