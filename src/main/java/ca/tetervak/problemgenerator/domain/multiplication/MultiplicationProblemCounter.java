package ca.tetervak.problemgenerator.domain.multiplication;

import org.jspecify.annotations.NonNull;

import java.util.function.BiPredicate;

public class MultiplicationProblemCounter {

    public static int countMultiplicationProblems() {
        int count = 0;
        for (int multiplicand = 1; multiplicand <= 100; multiplicand++) {
            for (int multiplier = 1; multiplier <= 100; multiplier++) {
                if (multiplicand * multiplier <= 100) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public static int countMultiplicationProblems(
            @NonNull BiPredicate<Integer, Integer> condition
    ) {
        int count = 0;
        for (int multiplicand = 1; multiplicand <= 100; multiplicand++) {
            for (int multiplier = 1; multiplier <= 100; multiplier++) {
                if (multiplicand * multiplier <= 100) {
                    if (condition.test(multiplicand, multiplier)) {
                        count++;
                    }
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public static int countBeginnerMultiplicationProblems() {
        return countMultiplicationProblems(MultiplicationDifficultyEstimator::isBeginnerMultiplicationLevel);
    }

    public static int countEasyMultiplicationProblems() {
        return countMultiplicationProblems(MultiplicationDifficultyEstimator::isEasyMultiplicationLevel);
    }

    public static int countIntermediateMultiplicationProblems() {
        return countMultiplicationProblems(MultiplicationDifficultyEstimator::isIntermediateMultiplicationLevel);
    }

    public static int countModerateMultiplicationProblems() {
        return countMultiplicationProblems(MultiplicationDifficultyEstimator::isModerateMultiplicationLevel);
    }

    public static int countAdvancedMultiplicationProblems() {
        return countMultiplicationProblems(MultiplicationDifficultyEstimator::isAdvancedMultiplicationLevel);
    }

    public static int countChallengingMultiplicationProblems() {
        return countMultiplicationProblems(MultiplicationDifficultyEstimator::isChallengingMultiplicationLevel);
    }
}
