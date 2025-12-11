package ca.tetervak.problemgenerator.repository;

import ca.tetervak.problemgenerator.domain.AlgebraProblem;
import ca.tetervak.problemgenerator.domain.AlgebraProblemCategory;
import ca.tetervak.problemgenerator.domain.DifficultyLevel;
import org.jspecify.annotations.NonNull;

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

    int getAlgebraProblemCountByCategory(AlgebraProblemCategory category);

    int getAlgebraProblemCountByCategoryAndDifficultyLevel(
            AlgebraProblemCategory category,
            DifficultyLevel difficultyLevel
    );

}
