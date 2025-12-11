package ca.tetervak.problemgenerator.domain.addition;

import ca.tetervak.problemgenerator.domain.DifficultyLevel;
import ca.tetervak.problemgenerator.domain.CountsByLevels;
import org.jspecify.annotations.NonNull;

import java.util.HashMap;
import java.util.Map;

public class AdditionProblemCounter {

    private final CountsByLevels countsByLevels;

    public AdditionProblemCounter() {

        Map<DifficultyLevel, Integer> counts = getAdditionProblemCounts();
        int total = 0;
        for (DifficultyLevel level : DifficultyLevel.values()) {
            if(level != DifficultyLevel.UNKNOWN){
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

    private static Map<DifficultyLevel, Integer> getAdditionProblemCounts() {
        Map<DifficultyLevel, Integer> counts = new HashMap<>();
        for(int firstAddend = 1; firstAddend < 100; firstAddend++){
            for(int secondAddend = 1; secondAddend < 100; secondAddend++){
                if(firstAddend + secondAddend <= 100){
                    DifficultyLevel difficultyLevel =
                            AdditionDifficultyEstimator.getAdditionDifficultyLevel(firstAddend, secondAddend);
                    counts.merge(difficultyLevel, 1, Integer::sum);
                } else {
                    break;
                }
            }
        }
        return counts;
    }
}
