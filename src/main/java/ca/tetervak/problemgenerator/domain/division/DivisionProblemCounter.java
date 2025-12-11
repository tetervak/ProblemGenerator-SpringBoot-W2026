package ca.tetervak.problemgenerator.domain.division;

import ca.tetervak.problemgenerator.domain.CountsByLevels;
import ca.tetervak.problemgenerator.domain.DifficultyLevel;
import org.jspecify.annotations.NonNull;

import java.util.HashMap;
import java.util.Map;

public class DivisionProblemCounter {

    private final CountsByLevels countsByLevels;

    public DivisionProblemCounter() {
        Map<DifficultyLevel, Integer> counts = getDivisionProblemCounts();
        int total = 0;
        for (DifficultyLevel level : DifficultyLevel.values()) {
            if (level != DifficultyLevel.UNKNOWN) {
                int count = counts.getOrDefault(level, 0);
                total += count;
            }
        }

        this.countsByLevels = new CountsByLevels(
                counts.getOrDefault(DifficultyLevel.BEGINNER, 0),
                counts.getOrDefault(DifficultyLevel.EASY, 0),
                counts.getOrDefault(DifficultyLevel.INTERMEDIATE, 0),
                counts.getOrDefault(DifficultyLevel.MODERATE, 0),
                counts.getOrDefault(DifficultyLevel.ADVANCED, 0),
                counts.getOrDefault(DifficultyLevel.CHALLENGING, 0),
                total
        );
    }

    @NonNull
    public CountsByLevels getCountsByLevels() {
        return countsByLevels;
    }

    private static Map<DifficultyLevel, Integer> getDivisionProblemCounts() {
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
}
