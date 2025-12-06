package ca.tetervak.problemgenerator.domain.division;

import ca.tetervak.problemgenerator.domain.DifficultyLevel;

import static ca.tetervak.problemgenerator.domain.multiplication.MultiplicationDifficultyEstimator.*;

public class DivisionDifficultyEstimator {

    private static boolean isDividendValid(int dividend) {
        return dividend >= 4 && dividend <= 100;
    }

    private static void checkDividendValid(int dividend) {
        if (!isDividendValid(dividend)) {
            throw new IllegalArgumentException(
                    "The dividend must be between 4 and 100: %d".formatted(dividend));
        }
    }

    private static boolean isDivisorValid(int divisor) {
        return divisor >= 2 && divisor <= 50;
    }

    private static void checkDivisorValid(int divisor) {
        if (!isDivisorValid(divisor)) {
            throw new IllegalArgumentException(
                    "The divisor must be between 2 and 50: %d".formatted(divisor));
        }
    }

    private static boolean isQuotientValid(int dividend, int divisor) {
        checkDividendValid(dividend);
        checkDivisorValid(divisor);
        return dividend > divisor && dividend % divisor == 0;
    }

    private static void checkQuotient(int dividend, int divisor) {
        if (!isQuotientValid(dividend, divisor)) {
            throw new IllegalArgumentException(
                    "The dividend must be divisible by the divisor: %d / %d"
                            .formatted(dividend, divisor)
            );
        }
    }

    public static boolean isBeginnerDivisionLevel(int dividend, int divisor) {
        checkDividendValid(dividend);
        checkDivisorValid(divisor);
        checkQuotient(dividend, divisor);
        return isBeginnerMultiplicationLevel(dividend/divisor, divisor);
    }

    public static boolean isEasyDivisionLevel(int dividend, int divisor) {
        checkDividendValid(dividend);
        checkDivisorValid(divisor);
        checkQuotient(dividend, divisor);
        return isEasyMultiplicationLevel(dividend/divisor, divisor);
    }

    public static boolean isIntermediateDivisionLevel(int dividend, int divisor) {
        checkDividendValid(dividend);
        checkDivisorValid(divisor);
        checkQuotient(dividend, divisor);
        return isIntermediateMultiplicationLevel(dividend/divisor, divisor);
    }

    public static boolean isModerateDivisionLevel(int dividend, int divisor) {
        checkDividendValid(dividend);
        checkDivisorValid(divisor);
        checkQuotient(dividend, divisor);
        return isModerateMultiplicationLevel(dividend/divisor, divisor);
    }

    public static boolean isAdvancedDivisionLevel(int dividend, int divisor) {
        checkDividendValid(dividend);
        checkDivisorValid(divisor);
        checkQuotient(dividend, divisor);
        return isAdvancedMultiplicationLevel(dividend/divisor, divisor);
    }

    public static boolean isChallengingDivisionLevel(int dividend, int divisor) {
        checkDividendValid(dividend);
        checkDivisorValid(divisor);
        checkQuotient(dividend, divisor);
        return isChallengingMultiplicationLevel(dividend/divisor, divisor);
    }

    public static DifficultyLevel getDivisionDifficultyLevel(int dividend, int divisor) {
        if (isBeginnerDivisionLevel(dividend, divisor)) {
            return DifficultyLevel.BEGINNER;
        }
        if (isEasyDivisionLevel(dividend, divisor)) {
            return DifficultyLevel.EASY;
        }
        if (isIntermediateDivisionLevel(dividend, divisor)) {
            return DifficultyLevel.INTERMEDIATE;
        }
        if (isModerateDivisionLevel(dividend, divisor)) {
            return DifficultyLevel.MODERATE;
        }
        if (isAdvancedDivisionLevel(dividend, divisor)) {
            return DifficultyLevel.ADVANCED;
        }
        if (isChallengingDivisionLevel(dividend, divisor)) {
            return DifficultyLevel.CHALLENGING;
        }
        return DifficultyLevel.UNKNOWN;
    }
}
