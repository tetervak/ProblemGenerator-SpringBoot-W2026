package ca.tetervak.problemgenerator.service;

import ca.tetervak.problemgenerator.domain.AlgebraProblem;
import ca.tetervak.problemgenerator.domain.AlgebraProblemCategory;
import ca.tetervak.problemgenerator.domain.AlgebraProblemListFactory;
import ca.tetervak.problemgenerator.domain.DifficultyLevel;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ClassCanBeRecord")
@Service
public class ProblemListGeneratorService {

    private final AlgebraProblemListFactory problemListFactory;

    public ProblemListGeneratorService(@NonNull AlgebraProblemListFactory problemListFactory) {
        this.problemListFactory = problemListFactory;
    }

    @NonNull
    public List<AlgebraProblem> createRandomAlgebraProblemList(
            @NonNull AlgebraProblemCategory category,
            @NonNull DifficultyLevel difficultyLevel,
            int number
    ) {
        return problemListFactory.createRandomAlgebraProblemList(category, difficultyLevel, number);
    }

}
