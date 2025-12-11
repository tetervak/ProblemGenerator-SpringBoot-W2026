package ca.tetervak.problemgenerator.domain;

import org.jspecify.annotations.NonNull;

import java.util.Random;

public enum DifficultyLevel {
    BEGINNER,
    EASY,
    INTERMEDIATE,
    MODERATE,
    ADVANCED,
    CHALLENGING,
    UNKNOWN;

    @NonNull
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

    @NonNull
    public static DifficultyLevel getRandomDifficultyLevel(
            Random random
    ){
        return values()[random.nextInt(values().length - 1)];
    }
}
