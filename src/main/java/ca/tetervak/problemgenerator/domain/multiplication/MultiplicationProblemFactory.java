package ca.tetervak.problemgenerator.domain.multiplication;

import ca.tetervak.problemgenerator.domain.AlgebraProblem;
import ca.tetervak.problemgenerator.domain.AlgebraProblemFactory;
import ca.tetervak.problemgenerator.domain.DifficultyLevel;
import org.jspecify.annotations.NonNull;

import java.util.Random;

@SuppressWarnings("ClassCanBeRecord")
public class MultiplicationProblemFactory {

    private final Random random;

    public MultiplicationProblemFactory(
            @NonNull Random random
    ) {
        this.random = random;
    }

    public MultiplicationProblemFactory() {
        this(new Random());
    }

    @NonNull
    private MultiplicationPair getRandomBeginnerMultiplicationPair() {
        int multiplicand = random.nextInt(2, 6);
        int multiplier = random.nextInt(2, 6);
        return new MultiplicationPair(multiplicand, multiplier);
    }

    @NonNull
    private MultiplicationPair getRandomEasyMultiplicationPair() {
        int factor1, factor2;
        if(random.nextBoolean()){
            factor1 = 5;
            factor2 = random.nextInt(6, 11);
        } else {
            factor1 = 10;
            factor2 = random.nextInt(2, 11);
        }
        if (random.nextBoolean()) {
            return new MultiplicationPair(factor1, factor2);
        } else {
            return new MultiplicationPair(factor2, factor1);
        }
    }

    @NonNull
    private MultiplicationPair getRandomIntermediateMultiplicationPair() {
        int factor1 = random.nextInt(2, 5);
        int factor2 = random.nextInt(6, 10);
        if (random.nextBoolean()) {
            return new MultiplicationPair(factor1, factor2);
        } else {
            return new MultiplicationPair(factor2, factor1);
        }
    }

    @NonNull
    private MultiplicationPair getRandomModerateMultiplicationPair() {
        int multiplicand = random.nextInt(6, 10);
        int multiplier = random.nextInt(6, 10);
        return new MultiplicationPair(multiplicand, multiplier);
    }

    @NonNull
    private MultiplicationPair getRandomAdvancedMultiplicationPair() {
        int factor1;
        int factor2;
        do {
            factor1 = random.nextInt(11, 100);
            factor2 = random.nextInt( 2, 9);
        } while (factor1 * factor2 > 100 || factor1 % 10 * factor2 > 9);

        if (random.nextBoolean()) {
            return new MultiplicationPair(factor1, factor2);
        } else {
            return new MultiplicationPair(factor2, factor1);
        }
    }

    @NonNull
    private MultiplicationPair getRandomChallengingMultiplicationPair() {
        int factor1;
        int factor2;
        do {
            factor1 = random.nextInt(11, 100);
            factor2 = random.nextInt(2, 9);
        } while (factor1 * factor2 > 100 || factor1 % 10 * factor2 <= 9);

        if (random.nextBoolean()) {
            return new MultiplicationPair(factor1, factor2);
        } else {
            return new MultiplicationPair(factor2, factor1);
        }
    }

    @NonNull
    public MultiplicationPair createRandomMultiplicationPair(
            @NonNull DifficultyLevel difficultyLevel
    ) {
        return switch (difficultyLevel) {
            case BEGINNER -> getRandomBeginnerMultiplicationPair();
            case EASY -> getRandomEasyMultiplicationPair();
            case INTERMEDIATE -> getRandomIntermediateMultiplicationPair();
            case MODERATE -> getRandomModerateMultiplicationPair();
            case ADVANCED -> getRandomAdvancedMultiplicationPair();
            case CHALLENGING -> getRandomChallengingMultiplicationPair();
            default -> throw new IllegalArgumentException(
                    "Invalid difficulty level: %s".formatted(difficultyLevel)
            );
        };
    }

    @NonNull
    public AlgebraProblem createRandomMultiplicationProblem(
            @NonNull DifficultyLevel difficultyLevel
    ) {
        MultiplicationPair multiplicationPair =
                createRandomMultiplicationPair(difficultyLevel);
        return AlgebraProblemFactory.getInstance(multiplicationPair, difficultyLevel);
    }
}