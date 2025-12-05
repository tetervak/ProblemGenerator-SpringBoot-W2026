package ca.tetervak.problemgenerator.domain.subtraction;

import ca.tetervak.problemgenerator.domain.DifficultyLevel;
import org.jspecify.annotations.NonNull;


public class SubtractionDifficultyEstimator {

    public static boolean isMinuendValid(int minuend) {
        return minuend >= 2 && minuend <= 100;
    }

    public static void checkMinuendValid(int minuend) {
        if (!isMinuendValid(minuend)) {
            throw new IllegalArgumentException("Invalid minuend: " + minuend);
        }
    }

    public static boolean isSubtrahendValid(int subtrahend) {
        return subtrahend >= 1 && subtrahend < 100;
    }

    public static void checkSubtrahendValid(int minuend) {
        if (!isSubtrahendValid(minuend)) {
            throw new IllegalArgumentException("Invalid subtrahend: " + minuend);
        }
    }

    public static boolean isDifferenceValid(int minuend, int subtrahend) {
        checkMinuendValid(minuend);
        checkSubtrahendValid(subtrahend);
        int difference = minuend - subtrahend;
        return difference >= 1 && difference < 100;
    }

    public static void checkDifferenceValid(int minuend, int subtrahend) {
        if (!isDifferenceValid(minuend, subtrahend)) {
            throw new IllegalArgumentException("Invalid difference: " + minuend + " - " + subtrahend);
        }
    }

    public static boolean hasFirstBorrow(int minuend, int subtrahend) {
        checkMinuendValid(minuend);
        checkSubtrahendValid(subtrahend);
        checkDifferenceValid(minuend, subtrahend);
        return minuend % 10 < subtrahend % 10;
    }

    public static boolean hasSecondBorrow(int minuend, int subtrahend) {
        checkMinuendValid(minuend);
        checkSubtrahendValid(subtrahend);
        checkDifferenceValid(minuend, subtrahend);
        if (hasFirstBorrow(minuend, subtrahend)) {
            return (minuend / 10 % 10 + 1 < subtrahend / 10 % 10);
        } else  {
            return (minuend / 10 % 10 < subtrahend / 10 % 10);
        }
    }

    public static boolean hasBorrow(int minuend, int subtrahend) {
        checkMinuendValid(minuend);
        checkSubtrahendValid(subtrahend);
        checkDifferenceValid(minuend, subtrahend);
        return hasFirstBorrow(minuend, subtrahend) ||
                hasSecondBorrow(minuend, subtrahend);
    }

    public static boolean isMinuendInBeginnerRange(int minuend) {
        checkMinuendValid(minuend);
        return minuend >= 2 && minuend <= 9;
    }

    public static boolean isSubtrahendInBeginnerRange(int subtrahend) {
        checkSubtrahendValid(subtrahend);
        return subtrahend >= 1 && subtrahend <= 8;
    }

    public static boolean isDifferenceInBeginnerRange(int minuend, int subtrahend) {
        checkMinuendValid(minuend);
        checkSubtrahendValid(subtrahend);
        int difference = minuend - subtrahend;
        return difference >= 1 && difference <= 8;
    }

    public static boolean isBeginnerLevel(int minuend, int subtrahend) {
        checkMinuendValid(minuend);
        checkSubtrahendValid(subtrahend);
        return isMinuendInBeginnerRange(minuend) &&
                isSubtrahendInBeginnerRange(subtrahend) &&
                isDifferenceInBeginnerRange(minuend, subtrahend);
    }

    public static boolean isMinuendInEasyRange(int minuend) {
        checkMinuendValid(minuend);
        return minuend >= 10 && minuend <= 19;
    }

    public static boolean isSubtrahendInEasyRange(int subtrahend) {
        checkSubtrahendValid(subtrahend);
        return subtrahend >= 1 && subtrahend <= 9;
    }

    public static boolean isDifferenceInEasyRange(int minuend, int subtrahend) {
        checkMinuendValid(minuend);
        checkSubtrahendValid(subtrahend);
        int difference = minuend - subtrahend;
        return difference >= 1 && difference <= 18;
    }

    public static boolean isEasyLevel(int minuend, int subtrahend) {
        checkMinuendValid(minuend);
        checkSubtrahendValid(subtrahend);
        return isMinuendInEasyRange(minuend) &&
                isSubtrahendInEasyRange(subtrahend) &&
                isDifferenceInEasyRange(minuend, subtrahend);
    }

    public static boolean isMinuendInIntermediateRange(int minuend) {
        checkMinuendValid(minuend);
        return minuend >= 20 && minuend <= 100;
    }

    public static boolean isIntermediateLevel(int minuend, int subtrahend) {
        checkMinuendValid(minuend);
        checkSubtrahendValid(subtrahend);
        return isMinuendInIntermediateRange(minuend) &&
                isSubtrahendInEasyRange(subtrahend) &&
                isDifferenceValid(minuend, subtrahend) &&
                !hasBorrow(minuend, subtrahend);
    }

    public static boolean isModerateLevel(int minuend, int subtrahend) {
        checkMinuendValid(minuend);
        checkSubtrahendValid(subtrahend);
        return isMinuendInIntermediateRange(minuend) &&
                isSubtrahendInEasyRange(subtrahend) &&
                isDifferenceValid(minuend, subtrahend) &&
                hasBorrow(minuend, subtrahend);
    }

    public static boolean isMinuendInAdvancedRange(int minuend) {
        checkMinuendValid(minuend);
        return minuend >= 11 && minuend <= 100;
    }

    public static boolean isSubtrahendInAdvancedRange(int subtrahend) {
        checkSubtrahendValid(subtrahend);
        return subtrahend >= 10 && subtrahend <= 99;
    }

    public static boolean isAdvancedLevel(int minuend, int subtrahend) {
        checkMinuendValid(minuend);
        checkSubtrahendValid(subtrahend);
        return isMinuendInAdvancedRange(minuend) &&
                isSubtrahendInAdvancedRange(subtrahend) &&
                isDifferenceValid(minuend, subtrahend) &&
                !hasBorrow(minuend, subtrahend);
    }

    public static boolean isChallengingLevel(int minuend, int subtrahend) {
        checkMinuendValid(minuend);
        checkSubtrahendValid(subtrahend);
        return isMinuendInAdvancedRange(minuend) &&
                isSubtrahendInAdvancedRange(subtrahend) &&
                isDifferenceValid(minuend, subtrahend) &&
                hasBorrow(minuend, subtrahend);
    }

    @SuppressWarnings("Duplicates")
    @NonNull
    public static DifficultyLevel getDifficultyLevel(int minuend, int subtrahend) {
        if (isBeginnerLevel(minuend, subtrahend)) {
            return DifficultyLevel.BEGINNER;
        }
        if (isEasyLevel(minuend, subtrahend)) {
            return DifficultyLevel.EASY;
        }
        if (isIntermediateLevel(minuend, subtrahend)) {
            return DifficultyLevel.INTERMEDIATE;
        }
        if (isModerateLevel(minuend, subtrahend)) {
            return DifficultyLevel.MODERATE;
        }
        if (isAdvancedLevel(minuend, subtrahend)) {
            return DifficultyLevel.ADVANCED;
        }
        if (isChallengingLevel(minuend, subtrahend)) {
            return DifficultyLevel.CHALLENGING;
        }
        return DifficultyLevel.UNKNOWN;
    }

}
