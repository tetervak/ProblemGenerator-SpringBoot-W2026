package ca.tetervak.problemgenerator.domain;

public enum DifficultyLevel {
    BEGINNER,
    EASY,
    INTERMEDIATE,
    MODERATE,
    ADVANCED,
    CHALLENGING,
    UNKNOWN;

    public static DifficultyLevel fromString(String level) {
        return switch (level) {
            case "beginner" -> BEGINNER;
            case "easy" -> EASY;
            case "intermediate" -> INTERMEDIATE;
            case "moderate" -> MODERATE;
            case "advanced" -> ADVANCED;
            case "challenging" -> CHALLENGING;
            default -> UNKNOWN;
        };
    }
}
