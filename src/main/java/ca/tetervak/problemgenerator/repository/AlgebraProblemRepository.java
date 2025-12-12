package ca.tetervak.problemgenerator.repository;

import ca.tetervak.problemgenerator.domain.*;
import org.jspecify.annotations.NonNull;

import java.util.List;

public interface AlgebraProblemRepository {

    @NonNull
    AlgebraProblem getRandomAlgebraProblem(
            @NonNull AlgebraProblemCategory category,
            @NonNull DifficultyLevel difficultyLevel
    );

    @NonNull
    AlgebraProblem getRandomAlgebraProblem(
            @NonNull AlgebraProblemCategory category
    );

    @NonNull
    AlgebraProblem getRandomAlgebraProblem();

    int getAlgebraProblemTotalCount();

    int getAlgebraProblemCountByCategory(
            @NonNull AlgebraProblemCategory category
    );

    @NonNull
    CountsByLevels getAlgebraProblemCountsByLevels(
            @NonNull AlgebraProblemCategory category
    );

    int getAlgebraProblemCountByCategoryAndDifficultyLevel(
            @NonNull AlgebraProblemCategory category,
            @NonNull DifficultyLevel difficultyLevel
    );

    @NonNull List<AlgebraProblem> getRandomAlgebraProblemList(
            @NonNull AlgebraProblemCategory category,
            @NonNull DifficultyLevel difficultyLevel,
            int numberOfProblems
    );
}
