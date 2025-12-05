package ca.tetervak.problemgenerator.domain.addition;

import ca.tetervak.problemgenerator.domain.AlgebraProblem;
import ca.tetervak.problemgenerator.domain.DifficultyLevel;
import org.jspecify.annotations.NonNull;

import java.util.Random;

import static ca.tetervak.problemgenerator.domain.addition.AdditionDifficultyEstimator.*;

@SuppressWarnings("ClassCanBeRecord")
public class AdditionProblemFactory {

    private final Random random;

    public AdditionProblemFactory(
            @NonNull Random random
    ) {
        this.random = random;
    }

    public AdditionProblemFactory() {
        this(new Random());
    }

    @NonNull
    private AdditionPair getRandomBeginnerAdditionPair(){

        int firstAddend;
        int secondAddend;
        do{
            firstAddend = random.nextInt(1, 10);
            secondAddend = random.nextInt(1, 10);
        } while(!isBeginnerLevel(firstAddend, secondAddend));

        return new AdditionPair(firstAddend, secondAddend);
    }

    @NonNull
    private AdditionPair getRandomEasyAdditionPair(){

        int firstAddend;
        int secondAddend;
        do{
            firstAddend = random.nextInt(1, 11);
            secondAddend = random.nextInt(1, 11);
        } while(!isEasyLevel(firstAddend, secondAddend));

        return new AdditionPair(firstAddend, secondAddend);
    }

    @NonNull
    private AdditionPair getRandomIntermediateAdditionPair() {

        int firstAddend;
        int secondAddend;
        do{
            firstAddend = random.nextInt(11, 100);
            secondAddend = random.nextInt(1, 10);
        } while(!isIntermediateLevel(firstAddend, secondAddend));

        if(random.nextBoolean()){
            int temp = firstAddend;
            firstAddend = secondAddend;
            secondAddend = temp;
        }

        return new AdditionPair(firstAddend, secondAddend);
    }

    @NonNull
    private AdditionPair getRandomModerateAdditionPair() {

        int firstAddend;
        int secondAddend;
        do{
            firstAddend = random.nextInt(11, 100);
            secondAddend = random.nextInt(1, 10);
        } while(!isModerateLevel(firstAddend, secondAddend));

        if(random.nextBoolean()){
            int temp = firstAddend;
            firstAddend = secondAddend;
            secondAddend = temp;
        }

        return new AdditionPair(firstAddend, secondAddend);
    }

    @NonNull
    private AdditionPair getRandomAdvancedAdditionPair() {

        int firstAddend;
        int secondAddend;
        do{
            firstAddend = random.nextInt(10, 100);
            secondAddend = random.nextInt(10, 100);
        } while(!isAdvancedLevel(firstAddend, secondAddend));

        return new AdditionPair(firstAddend, secondAddend);
    }

    @NonNull
    private AdditionPair createRandomChallengingAdditionPair(){

        int firstAddend;
        int secondAddend;
        do{
            firstAddend = random.nextInt(10, 100);
            secondAddend = random.nextInt(10, 100);
        } while(!isChallengingLevel(firstAddend, secondAddend));

        return new AdditionPair(firstAddend, secondAddend);
    }

    @NonNull
    public AdditionPair createRandomAdditionPair(
            @NonNull DifficultyLevel difficultyLevel
    ) {
        return switch (difficultyLevel){
            case BEGINNER -> getRandomBeginnerAdditionPair();
            case EASY -> getRandomEasyAdditionPair();
            case INTERMEDIATE -> getRandomIntermediateAdditionPair();
            case MODERATE -> getRandomModerateAdditionPair();
            case ADVANCED -> getRandomAdvancedAdditionPair();
            case CHALLENGING -> createRandomChallengingAdditionPair();
            default -> throw new IllegalArgumentException("Invalid difficulty level: " + difficultyLevel);
        };
    }

    @NonNull
    public AlgebraProblem createRandomAdditionProblem(
            @NonNull DifficultyLevel difficultyLevel
    ) {
        AdditionPair additionPair = createRandomAdditionPair(difficultyLevel);
        return new AlgebraProblem(additionPair, difficultyLevel);
    }
}
