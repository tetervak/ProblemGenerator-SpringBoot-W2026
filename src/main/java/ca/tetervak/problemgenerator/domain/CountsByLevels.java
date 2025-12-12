package ca.tetervak.problemgenerator.domain;


public record CountsByLevels(
        int beginner,
        int easy,
        int intermediate,
        int moderate,
        int advanced,
        int challenging,
        int total
) {
    public CountsByLevels {
        if (beginner < 0 || easy < 0 || intermediate < 0 ||
                moderate < 0 || advanced < 0 || challenging < 0 ||
                total < 0) {
            throw new IllegalArgumentException("Counts cannot be negative");
        }
    }

    public int getCountByLevel(DifficultyLevel level) {
        return switch (level) {
            case BEGINNER -> beginner();
            case EASY -> easy();
            case INTERMEDIATE -> intermediate();
            case MODERATE -> moderate();
            case ADVANCED -> advanced();
            case CHALLENGING -> challenging();
            default -> throw new IllegalArgumentException("Invalid difficulty level");
        };
    }

    public int getCountByLevel(String level) {
        return getCountByLevel(DifficultyLevel.fromString(level));
    }

}
