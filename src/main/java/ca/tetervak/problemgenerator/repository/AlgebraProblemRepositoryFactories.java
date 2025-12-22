package ca.tetervak.problemgenerator.repository;

import ca.tetervak.problemgenerator.domain.*;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

@Repository
public class AlgebraProblemRepositoryFactories
        implements AlgebraProblemRepository {

    private final AlgebraProblemListFactory algebraProblemListFactory;
    private final CountsByCategoriesAndLevels problemCounts;

    AlgebraProblemRepositoryFactories(
            @NonNull AlgebraProblemListFactory algebraProblemListFactory
    ){
        this.algebraProblemListFactory = algebraProblemListFactory;
        this.problemCounts = (new AlgebraProblemCounter()).getProblemCounts();
    }

    @Override
    public @NonNull CountsByCategoriesAndLevels getAlgebraProblemCounts() {
        return problemCounts;
    }

    @Override
    public @NonNull CountsByLevels getAlgebraProblemCountsForCategory(
            @NonNull AlgebraProblemCategory category
    ) {
        return problemCounts.getCountsByCategory(category);
    }

    @Override
    public @NonNull List<AlgebraProblem> getRandomAlgebraProblemList(
            @NonNull AlgebraProblemCategory category,
            @NonNull DifficultyLevel difficultyLevel,
            int numberOfProblems
    ) {
        return algebraProblemListFactory
                .createRandomAlgebraProblemList(category, difficultyLevel, numberOfProblems);
    }

}
