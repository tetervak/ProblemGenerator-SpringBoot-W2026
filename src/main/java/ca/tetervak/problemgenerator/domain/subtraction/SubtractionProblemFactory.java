package ca.tetervak.problemgenerator.domain.subtraction;

import ca.tetervak.problemgenerator.domain.AlgebraProblem;
import ca.tetervak.problemgenerator.domain.DifficultyLevel;
import org.jspecify.annotations.NonNull;

import java.util.Random;

import static ca.tetervak.problemgenerator.domain.subtraction.SubtractionDifficultyEstimator.*;

@SuppressWarnings("ClassCanBeRecord")
public class SubtractionProblemFactory {

    private final Random random;

    public SubtractionProblemFactory(
            @NonNull Random random
    ) {
        this.random = random;
    }

    public SubtractionProblemFactory() {
        this(new Random());
    }

    @NonNull
    private SubtractionPair getRandomBeginnerSubtractionPair(){

        int minuend;
        int subtrahend;
        do{
            minuend = random.nextInt(2, 10);
            subtrahend = random.nextInt(1, 9);
        } while(!isBeginnerLevel(minuend, subtrahend));

        return new SubtractionPair(minuend, subtrahend);
    }

    @NonNull
    private SubtractionPair getRandomEasySubtractionPair(){

        int minuend;
        int subtrahend;
        do{
            minuend = random.nextInt(10, 20);
            subtrahend = random.nextInt(1, 10);
        } while(!isEasyLevel(minuend, subtrahend));

        return new SubtractionPair(minuend, subtrahend);
    }

    @NonNull
    private SubtractionPair getRandomIntermediateSubtractionPair() {

        int minuend;
        int subtrahend;
        do {
            minuend = random.nextInt(20, 101);
            subtrahend = random.nextInt(1, 10);
        } while(!isIntermediateLevel(minuend, subtrahend));

        return new SubtractionPair(minuend, subtrahend);
    }

    @NonNull
    private SubtractionPair getRandomModerateSubtractionPair() {

        int minuend;
        int subtrahend;
        do {
            minuend = random.nextInt(20, 101);
            subtrahend = random.nextInt(1, 10);
        } while(!isModerateLevel(minuend, subtrahend));

        return new SubtractionPair(minuend, subtrahend);
    }

    @NonNull
    private SubtractionPair getRandomAdvancedSubtractionPair() {

        int minuend;
        int subtrahend;
        do {
            minuend = random.nextInt(11, 101);
            subtrahend = random.nextInt(10, 100);
        } while(!isAdvancedLevel(minuend, subtrahend));

        return new SubtractionPair(minuend, subtrahend);
    }

    @NonNull
    private SubtractionPair getRandomChallengingSubtractionPair() {

        int minuend;
        int subtrahend;
        do {
            minuend = random.nextInt(20, 101);
            subtrahend = random.nextInt(10, 100);
        } while(!isChallengingLevel(minuend, subtrahend));

        return new SubtractionPair(minuend, subtrahend);
    }

    @NonNull
    public SubtractionPair createRandomSubtractionPair(
            @NonNull DifficultyLevel difficultyLevel
    ) {
        return switch (difficultyLevel){
            case BEGINNER -> getRandomBeginnerSubtractionPair();
            case EASY -> getRandomEasySubtractionPair();
            case INTERMEDIATE -> getRandomIntermediateSubtractionPair();
            case MODERATE -> getRandomModerateSubtractionPair();
            case ADVANCED -> getRandomAdvancedSubtractionPair();
            case CHALLENGING -> getRandomChallengingSubtractionPair();
            default -> throw new IllegalArgumentException("Invalid difficulty level: " + difficultyLevel);
        };
    }

    @NonNull
    public AlgebraProblem createRandomSubtractionProblem(
            @NonNull DifficultyLevel difficultyLevel
    ) {
        SubtractionPair subtractionPair = createRandomSubtractionPair(difficultyLevel);
        return new AlgebraProblem(subtractionPair, difficultyLevel);
    }

}
