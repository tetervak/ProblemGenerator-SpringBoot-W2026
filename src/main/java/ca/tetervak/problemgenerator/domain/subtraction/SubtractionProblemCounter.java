package ca.tetervak.problemgenerator.domain.subtraction;

import org.jspecify.annotations.NonNull;

import java.util.function.BiPredicate;

public class SubtractionProblemCounter {

    public static int countSubtractionProblems() {
        int count = 0;
        for (int minuend = 2; minuend <= 100; minuend++) {
            for (int subtrahend = 1; subtrahend <= 99; subtrahend++) {
                if (minuend > subtrahend) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public static int countSubtractionProblems(
            @NonNull BiPredicate<Integer, Integer> condition
    ){
        int count = 0;
        for (int minuend = 2; minuend <= 100; minuend++) {
            for (int subtrahend = 1; subtrahend <= 99; subtrahend++) {
                if (minuend > subtrahend) {
                    if (condition.test(minuend, subtrahend)) {
                        count++;
                    }
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public static int countBeginnerSubtractionProblems() {
        return countSubtractionProblems(SubtractionDifficultyEstimator::isBeginnerSubtractionLevel);
    }

    public static int countEasySubtractionProblems() {
        return countSubtractionProblems(SubtractionDifficultyEstimator::isEasySubtractionLevel);
    }

    public static int countIntermediateSubtractionProblems() {
        return countSubtractionProblems(SubtractionDifficultyEstimator::isIntermediateSubtractionLevel);
    }

    public static int countModerateSubtractionProblems() {
        return countSubtractionProblems(SubtractionDifficultyEstimator::isModerateSubtractionLevel);
    }

    public static int countAdvancedSubtractionProblems() {
        return countSubtractionProblems(SubtractionDifficultyEstimator::isAdvancedSubtractionLevel);
    }

    public static int countChallengingSubtractionProblems() {
        return countSubtractionProblems(SubtractionDifficultyEstimator::isChallengingSubtractionLevel);
    }

}
