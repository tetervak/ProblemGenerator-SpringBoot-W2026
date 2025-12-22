package ca.tetervak.problemgenerator.repository;

import ca.tetervak.problemgenerator.domain.*;
import org.jspecify.annotations.NonNull;

import java.util.List;

public interface AlgebraProblemRepository {

    @NonNull
    CountsByCategoriesAndLevels getAlgebraProblemCounts();

    @NonNull
    CountsByLevels getAlgebraProblemCountsForCategory(
            @NonNull AlgebraProblemCategory category
    );

    @NonNull List<AlgebraProblem> getRandomAlgebraProblemList(
            @NonNull AlgebraProblemCategory category,
            @NonNull DifficultyLevel difficultyLevel,
            int numberOfProblems
    );
}
