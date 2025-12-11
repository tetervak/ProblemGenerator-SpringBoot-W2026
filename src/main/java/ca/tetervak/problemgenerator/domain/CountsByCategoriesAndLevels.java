package ca.tetervak.problemgenerator.domain;

import org.jspecify.annotations.NonNull;

public record CountsByCategoriesAndLevels(
        @NonNull CountsByLevels addition,
        @NonNull CountsByLevels subtraction,
        @NonNull CountsByLevels multiplication,
        @NonNull CountsByLevels division,
        int total
) {

    public CountsByCategoriesAndLevels {
        if (addition.total() < 0 ||
                subtraction.total() < 0 ||
                multiplication.total() < 0 ||
                division.total() < 0 ||
                total < 0) {
            throw new IllegalArgumentException("Counts cannot be negative");
        }
    }

    @NonNull
    public CountsByLevels getCountsByCategory(AlgebraProblemCategory category) {
        return switch (category) {
            case ADDITION -> addition();
            case SUBTRACTION -> subtraction();
            case MULTIPLICATION -> multiplication();
            case DIVISION -> division();
        };
    }

    public int getCountByCategoryAndLevel(
            AlgebraProblemCategory category,
            DifficultyLevel level
    ) {
        return getCountsByCategory(category).getCountByLevel(level);
    }
}
