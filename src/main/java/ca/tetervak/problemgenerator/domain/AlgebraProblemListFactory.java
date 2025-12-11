package ca.tetervak.problemgenerator.domain;

import org.jspecify.annotations.NonNull;

import java.util.*;

public class AlgebraProblemListFactory {

    private final AlgebraProblemFactory problemFactory;

    public AlgebraProblemListFactory(@NonNull Random random) {
        this.problemFactory = new AlgebraProblemFactory(random);
    }

    public AlgebraProblemListFactory() {
        this(new Random());
    }

    @NonNull
    public List<AlgebraProblem> createRandomAlgebraProblemList(
            @NonNull AlgebraProblemCategory category,
            @NonNull DifficultyLevel difficultyLevel,
            int number
    ) {
        List<AlgebraProblem> list = new ArrayList<>(number);
        Set<String> textSet = new HashSet<>();
        for (int i = 0; i < number; i++) {
            AlgebraProblem problem = problemFactory
                    .createRandomAlgebraProblem(category, difficultyLevel);
            int iterCount = 0;
            while (textSet.contains(problem.getText()) && iterCount < 10) {
                problem = problemFactory
                        .createRandomAlgebraProblem(category, difficultyLevel);
                iterCount++;
            }

            list.add(problem);
            textSet.add(problem.getText());
        }
        return list;
    }
}