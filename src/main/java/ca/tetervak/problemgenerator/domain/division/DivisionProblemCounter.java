package ca.tetervak.problemgenerator.domain.division;

import ca.tetervak.problemgenerator.domain.DifficultyLevel;
import org.jspecify.annotations.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiPredicate;

public class DivisionProblemCounter {

    public static int countDivisionProblems() {
        int count = 0;
        for (int dividend = 4; dividend <= 100; dividend++) {
            for (int divisor = 2; divisor <= 50; divisor++) {
                if(dividend > divisor) {
                    if (dividend % divisor == 0) {
                        count++;
                    }
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public static Map<DifficultyLevel, Integer> getDivisionProblemCounts() {
        Map<DifficultyLevel, Integer> counts = new HashMap<>();
        for (int dividend = 4; dividend <= 100; dividend++) {
            for (int divisor = 2; divisor <= 50; divisor++) {
                if(dividend > divisor) {
                    if (dividend % divisor == 0) {
                        DifficultyLevel difficultyLevel =
                                DivisionDifficultyEstimator.getDivisionDifficultyLevel(dividend, divisor);
                        counts.merge(difficultyLevel, 1, Integer::sum);
                    }
                } else {
                    break;
                }
            }
        }
        return counts;
    }

    public static int countDivisionProblems(
            @NonNull BiPredicate<Integer, Integer> condition
    ) {
        int count = 0;
        for (int dividend = 4; dividend <= 100; dividend++) {
            for (int divisor = 2; divisor <= 50; divisor++) {
                if(dividend > divisor) {
                    if (dividend % divisor == 0) {
                        if (condition.test(dividend, divisor)) {
                            count++;
                        }
                    }
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public static int countBeginnerDivisionProblems() {
        return countDivisionProblems(DivisionDifficultyEstimator::isBeginnerDivisionLevel);
    }

    public static int countEasyDivisionProblems() {
        return countDivisionProblems(DivisionDifficultyEstimator::isEasyDivisionLevel);
    }

    public static int countIntermediateDivisionProblems() {
        return countDivisionProblems(DivisionDifficultyEstimator::isIntermediateDivisionLevel);
    }

    public static int countModerateDivisionProblems() {
        return countDivisionProblems(DivisionDifficultyEstimator::isModerateDivisionLevel);
    }

    public static int countAdvancedDivisionProblems() {
        return countDivisionProblems(DivisionDifficultyEstimator::isAdvancedDivisionLevel);
    }

    public static int countChallengingDivisionProblems() {
        return countDivisionProblems(DivisionDifficultyEstimator::isChallengingDivisionLevel);
    }
}
