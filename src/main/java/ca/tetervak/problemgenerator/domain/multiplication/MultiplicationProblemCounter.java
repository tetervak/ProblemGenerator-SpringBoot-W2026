package ca.tetervak.problemgenerator.domain.multiplication;

import ca.tetervak.problemgenerator.domain.CountsByLevels;
import ca.tetervak.problemgenerator.domain.DifficultyLevel;
import org.jspecify.annotations.NonNull;

import java.util.HashMap;
import java.util.Map;

public class MultiplicationProblemCounter {

    private final CountsByLevels countsByLevels;

    public MultiplicationProblemCounter() {
        Map<DifficultyLevel, Integer> counts = getMultiplicationProblemCounts();
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

    private static Map<DifficultyLevel, Integer> getMultiplicationProblemCounts() {
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
}
