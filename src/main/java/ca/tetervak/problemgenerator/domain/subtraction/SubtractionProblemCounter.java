package ca.tetervak.problemgenerator.domain.subtraction;

import ca.tetervak.problemgenerator.domain.CountsByLevels;
import ca.tetervak.problemgenerator.domain.DifficultyLevel;
import org.jspecify.annotations.NonNull;

import java.util.HashMap;
import java.util.Map;

public class SubtractionProblemCounter {

    private final CountsByLevels countsByLevels;

    public SubtractionProblemCounter() {

        Map<DifficultyLevel, Integer> counts = getSubtractionProblemCounts();
        int total = 0;
        for (DifficultyLevel level : DifficultyLevel.values()) {
            if(level != DifficultyLevel.UNKNOWN){
                int count = counts.getOrDefault(level, 0);
                total += count;
            }
        }
        countsByLevels = new CountsByLevels(
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

    private static Map<DifficultyLevel, Integer> getSubtractionProblemCounts() {
        Map<DifficultyLevel, Integer> counts = new HashMap<>();
        for (int minuend = 2; minuend <= 100; minuend++) {
            for (int subtrahend = 1; subtrahend <= 99; subtrahend++) {
                if (minuend > subtrahend) {
                    DifficultyLevel difficultyLevel =
                            SubtractionDifficultyEstimator.getSubtractionDifficultyLevel(minuend, subtrahend);
                    counts.merge(difficultyLevel, 1, Integer::sum);
                } else {
                    break;
                }
            }
        }
        return counts;
    }
}
