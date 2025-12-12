package ca.tetervak.problemgenerator.repository;

import ca.tetervak.problemgenerator.domain.*;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

@Repository
public class AlgebraProblemRepositoryFactories
        implements AlgebraProblemRepository {

    private final Random random;
    private final AlgebraProblemFactory algebraProblemFactory;
    private final AlgebraProblemListFactory algebraProblemListFactory;
    private final CountsByCategoriesAndLevels problemCounts;

    AlgebraProblemRepositoryFactories(
            @NonNull Random random,
            @NonNull AlgebraProblemFactory algebraProblemFactory,
            @NonNull AlgebraProblemListFactory algebraProblemListFactory
    ){
        this.random = random;
        this.algebraProblemFactory = algebraProblemFactory;
        this.algebraProblemListFactory = algebraProblemListFactory;
        this.problemCounts = (new AlgebraProblemCounter()).getProblemCounts();
    }

    @Override
    @NonNull
    public AlgebraProblem getRandomAlgebraProblem(
            @NonNull AlgebraProblemCategory category,
            @NonNull DifficultyLevel difficultyLevel
    ) {
        return algebraProblemFactory
                .createRandomAlgebraProblem(category, difficultyLevel);
    }

    @Override
    @NonNull
    public AlgebraProblem getRandomAlgebraProblem(
            @NonNull AlgebraProblemCategory category
    ) {
        return algebraProblemFactory
                .createRandomAlgebraProblem(
                        category,
                        DifficultyLevel.getRandomDifficultyLevel(random));
    }

    @Override
    @NonNull
    public AlgebraProblem getRandomAlgebraProblem() {
        return algebraProblemFactory
                .createRandomAlgebraProblem(
                        AlgebraProblemCategory.getRandomAlgebraProblemCategory(random),
                        DifficultyLevel.getRandomDifficultyLevel(random)
                );
    }

    @Override
    public int getAlgebraProblemTotalCount() {
        return problemCounts.total();
    }

    @Override
    public int getAlgebraProblemCountByCategory(@NonNull AlgebraProblemCategory category) {
        return problemCounts.getCountsByCategory(category).total();
    }

    @Override
    public @NonNull CountsByLevels getAlgebraProblemCountsByLevels(
            @NonNull AlgebraProblemCategory category
    ) {
        return problemCounts.getCountsByCategory(category);
    }

    @Override
    public int getAlgebraProblemCountByCategoryAndDifficultyLevel(
            @NonNull AlgebraProblemCategory category,
            @NonNull DifficultyLevel difficultyLevel
    ) {
        return problemCounts.getCountByCategoryAndLevel(category, difficultyLevel);
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
