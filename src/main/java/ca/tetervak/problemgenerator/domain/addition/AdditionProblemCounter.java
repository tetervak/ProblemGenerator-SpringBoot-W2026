package ca.tetervak.problemgenerator.domain.addition;

import org.jspecify.annotations.NonNull;

import java.util.function.BiPredicate;

public class AdditionProblemCounter {

    public static int countAdditionProblems(){
        int count = 0;
        for(int firstAddend = 1; firstAddend < 100; firstAddend++){
            for(int secondAddend = 1; secondAddend < 100; secondAddend++){
                if(firstAddend + secondAddend <= 100){
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public static int countAdditionProblems(
            @NonNull BiPredicate<Integer, Integer> condition
    ) {
        int count = 0;
        for(int firstAddend = 1; firstAddend < 100; firstAddend++){
            for(int secondAddend = 1; secondAddend < 100; secondAddend++){
                if(firstAddend + secondAddend <= 100) {
                    if (condition.test(firstAddend, secondAddend)) {
                        count++;
                    }
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public static int countBeginnerAdditionProblems(){
        return countAdditionProblems(AdditionDifficultyEstimator::isBeginnerAdditionLevel);
    }

    public static int countEasyAdditionProblems(){
        return countAdditionProblems(AdditionDifficultyEstimator::isEasyAdditionLevel);
    }

    public static int countIntermediateAdditionProblems(){
        return countAdditionProblems(AdditionDifficultyEstimator::isIntermediateAdditionLevel);
    }

    public static int countModerateAdditionProblems(){
        return countAdditionProblems(AdditionDifficultyEstimator::isModerateAdditionLevel);
    }

    public static int countAdvancedAdditionProblems(){
        return countAdditionProblems(AdditionDifficultyEstimator::isAdvancedAdditionLevel);
    }

    public static int countChallengingAdditionProblems(){
        return countAdditionProblems(AdditionDifficultyEstimator::isChallengingAdditionLevel);
    }
}
