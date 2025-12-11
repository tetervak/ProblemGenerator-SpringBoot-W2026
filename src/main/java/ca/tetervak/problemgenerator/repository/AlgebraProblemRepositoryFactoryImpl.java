package ca.tetervak.problemgenerator.repository;

import ca.tetervak.problemgenerator.domain.*;
import org.jspecify.annotations.NonNull;

import java.util.Random;

public class AlgebraProblemRepositoryFactoryImpl
        implements AlgebraProblemRepository {

    private final AlgebraProblemFactory algebraProblemFactory;
    private final  Random random;
    private final CountsByCategoriesAndLevels problemCounts;

    AlgebraProblemRepositoryFactoryImpl(
        @NonNull Random random
    ){
        this.random = random;
        this.algebraProblemFactory = new AlgebraProblemFactory(random);
        this.problemCounts = (new AlgebraProblemCounter()).getProblemCounts();
    }

    AlgebraProblemRepositoryFactoryImpl(){
        this(new Random());
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
    public int getAlgebraProblemCountByCategory(AlgebraProblemCategory category) {
        return problemCounts.getCountsByCategory(category).total();
    }

    @Override
    public int getAlgebraProblemCountByCategoryAndDifficultyLevel(
            AlgebraProblemCategory category,
            DifficultyLevel difficultyLevel
    ) {
        return problemCounts.getCountByCategoryAndLevel(category, difficultyLevel);
    }

}
