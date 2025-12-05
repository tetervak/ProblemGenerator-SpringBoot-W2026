package ca.tetervak.problemgenerator.domain.subtraction;

import ca.tetervak.problemgenerator.domain.DifficultyLevel;
import org.jspecify.annotations.NonNull;


public class SubtractionDifficultyEstimator {

    private static boolean isMinuendValid(int minuend) {
        return minuend >= 2 && minuend <= 100;
    }

    private static void checkMinuendValid(int minuend) {
        if (!isMinuendValid(minuend)) {
            throw new IllegalArgumentException("Invalid minuend: " + minuend);
        }
    }

    private static boolean isSubtrahendValid(int subtrahend) {
        return subtrahend >= 1 && subtrahend < 100;
    }

    private static void checkSubtrahendValid(int minuend) {
        if (!isSubtrahendValid(minuend)) {
            throw new IllegalArgumentException("Invalid subtrahend: " + minuend);
        }
    }

    private static boolean isDifferenceValid(int minuend, int subtrahend) {
        checkMinuendValid(minuend);
        checkSubtrahendValid(subtrahend);
        int difference = minuend - subtrahend;
        return difference >= 1 && difference < 100;
    }

    private static void checkDifferenceValid(int minuend, int subtrahend) {
        if (!isDifferenceValid(minuend, subtrahend)) {
            throw new IllegalArgumentException("Invalid difference: " + minuend + " - " + subtrahend);
        }
    }

    private static boolean hasFirstBorrow(int minuend, int subtrahend) {
        checkMinuendValid(minuend);
        checkSubtrahendValid(subtrahend);
        checkDifferenceValid(minuend, subtrahend);
        return minuend % 10 < subtrahend % 10;
    }

    private static boolean hasSecondBorrow(int minuend, int subtrahend) {
        checkMinuendValid(minuend);
        checkSubtrahendValid(subtrahend);
        checkDifferenceValid(minuend, subtrahend);
        if (hasFirstBorrow(minuend, subtrahend)) {
            return (minuend / 10 % 10 + 1 < subtrahend / 10 % 10);
        } else  {
            return (minuend / 10 % 10 < subtrahend / 10 % 10);
        }
    }

    private static boolean hasBorrow(int minuend, int subtrahend) {
        checkMinuendValid(minuend);
        checkSubtrahendValid(subtrahend);
        checkDifferenceValid(minuend, subtrahend);
        return hasFirstBorrow(minuend, subtrahend) ||
                hasSecondBorrow(minuend, subtrahend);
    }

    private static boolean isMinuendInBeginnerRange(int minuend) {
        checkMinuendValid(minuend);
        return minuend >= 2 && minuend <= 9;
    }

    private static boolean isSubtrahendInBeginnerRange(int subtrahend) {
        checkSubtrahendValid(subtrahend);
        return subtrahend >= 1 && subtrahend <= 8;
    }

    private static boolean isDifferenceInBeginnerRange(int minuend, int subtrahend) {
        checkMinuendValid(minuend);
        checkSubtrahendValid(subtrahend);
        int difference = minuend - subtrahend;
        return difference >= 1 && difference <= 8;
    }

    public static boolean isBeginnerSubtractionLevel(int minuend, int subtrahend) {
        checkMinuendValid(minuend);
        checkSubtrahendValid(subtrahend);
        return isMinuendInBeginnerRange(minuend) &&
                isSubtrahendInBeginnerRange(subtrahend) &&
                isDifferenceInBeginnerRange(minuend, subtrahend);
    }

    private static boolean isMinuendInEasyRange(int minuend) {
        checkMinuendValid(minuend);
        return minuend >= 10 && minuend <= 19;
    }

    private static boolean isSubtrahendInEasyRange(int subtrahend) {
        checkSubtrahendValid(subtrahend);
        return subtrahend >= 1 && subtrahend <= 9;
    }

    private static boolean isDifferenceInEasyRange(int minuend, int subtrahend) {
        checkMinuendValid(minuend);
        checkSubtrahendValid(subtrahend);
        int difference = minuend - subtrahend;
        return difference >= 1 && difference <= 18;
    }

    public static boolean isEasySubtractionLevel(int minuend, int subtrahend) {
        checkMinuendValid(minuend);
        checkSubtrahendValid(subtrahend);
        return isMinuendInEasyRange(minuend) &&
                isSubtrahendInEasyRange(subtrahend) &&
                isDifferenceInEasyRange(minuend, subtrahend);
    }

    private static boolean isMinuendInIntermediateRange(int minuend) {
        checkMinuendValid(minuend);
        return minuend >= 20 && minuend <= 100;
    }

    public static boolean isIntermediateSubtractionLevel(int minuend, int subtrahend) {
        checkMinuendValid(minuend);
        checkSubtrahendValid(subtrahend);
        return isMinuendInIntermediateRange(minuend) &&
                isSubtrahendInEasyRange(subtrahend) &&
                isDifferenceValid(minuend, subtrahend) &&
                !hasBorrow(minuend, subtrahend);
    }

    public static boolean isModerateSubtractionLevel(int minuend, int subtrahend) {
        checkMinuendValid(minuend);
        checkSubtrahendValid(subtrahend);
        return isMinuendInIntermediateRange(minuend) &&
                isSubtrahendInEasyRange(subtrahend) &&
                isDifferenceValid(minuend, subtrahend) &&
                hasBorrow(minuend, subtrahend);
    }

    private static boolean isMinuendInAdvancedRange(int minuend) {
        checkMinuendValid(minuend);
        return minuend >= 11 && minuend <= 100;
    }

    private static boolean isSubtrahendInAdvancedRange(int subtrahend) {
        checkSubtrahendValid(subtrahend);
        return subtrahend >= 10 && subtrahend <= 99;
    }

    public static boolean isAdvancedSubtractionLevel(int minuend, int subtrahend) {
        checkMinuendValid(minuend);
        checkSubtrahendValid(subtrahend);
        return isMinuendInAdvancedRange(minuend) &&
                isSubtrahendInAdvancedRange(subtrahend) &&
                isDifferenceValid(minuend, subtrahend) &&
                !hasBorrow(minuend, subtrahend);
    }

    public static boolean isChallengingSubtractionLevel(int minuend, int subtrahend) {
        checkMinuendValid(minuend);
        checkSubtrahendValid(subtrahend);
        return isMinuendInAdvancedRange(minuend) &&
                isSubtrahendInAdvancedRange(subtrahend) &&
                isDifferenceValid(minuend, subtrahend) &&
                hasBorrow(minuend, subtrahend);
    }

    @SuppressWarnings("Duplicates")
    @NonNull
    public static DifficultyLevel getSubtractionDifficultyLevel(int minuend, int subtrahend) {
        if (isBeginnerSubtractionLevel(minuend, subtrahend)) {
            return DifficultyLevel.BEGINNER;
        }
        if (isEasySubtractionLevel(minuend, subtrahend)) {
            return DifficultyLevel.EASY;
        }
        if (isIntermediateSubtractionLevel(minuend, subtrahend)) {
            return DifficultyLevel.INTERMEDIATE;
        }
        if (isModerateSubtractionLevel(minuend, subtrahend)) {
            return DifficultyLevel.MODERATE;
        }
        if (isAdvancedSubtractionLevel(minuend, subtrahend)) {
            return DifficultyLevel.ADVANCED;
        }
        if (isChallengingSubtractionLevel(minuend, subtrahend)) {
            return DifficultyLevel.CHALLENGING;
        }
        return DifficultyLevel.UNKNOWN;
    }

}
