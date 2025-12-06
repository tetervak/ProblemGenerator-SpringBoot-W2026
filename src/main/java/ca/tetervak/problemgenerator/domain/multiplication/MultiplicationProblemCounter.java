package ca.tetervak.problemgenerator.domain.multiplication;

import ca.tetervak.problemgenerator.domain.DifficultyLevel;
import org.jspecify.annotations.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiPredicate;

public class MultiplicationProblemCounter {

    public static int countMultiplicationProblems() {
        int count = 0;
        for (int multiplicand = 2; multiplicand <= 100; multiplicand++) {
            for (int multiplier = 2; multiplier <= 100; multiplier++) {
                if (multiplicand * multiplier <= 100) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public static Map<DifficultyLevel, Integer> getMultiplicationProblemCounts() {
        Map<DifficultyLevel, Integer> counts = new HashMap<>();
        for (int multiplicand = 2; multiplicand <= 100; multiplicand++) {
            for (int multiplier = 2; multiplier <= 100; multiplier++) {
                if (multiplicand * multiplier <= 100) {
                    DifficultyLevel difficultyLevel =
                            MultiplicationDifficultyEstimator.getMultiplicationDifficultyLevel(multiplicand, multiplier);
                    counts.merge(difficultyLevel, 1, Integer::sum);
                } else {
                    break;
                }
            }
        }
        return counts;
    }

    public static int countMultiplicationProblems(
            @NonNull BiPredicate<Integer, Integer> condition
    ) {
        int count = 0;
        for (int multiplicand = 2; multiplicand <= 100; multiplicand++) {
            for (int multiplier = 2; multiplier <= 100; multiplier++) {
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
