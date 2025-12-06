package ca.tetervak.problemgenerator.domain.multiplication;

import ca.tetervak.problemgenerator.domain.DifficultyLevel;
import org.jspecify.annotations.NonNull;

public class MultiplicationDifficultyEstimator {

    private static boolean isFactorValid(int factor) {
        return factor >= 1 && factor <= 100;
    }

    private static void checkFactorValid(int factor) {
        if (!isFactorValid(factor)) {
            throw new IllegalArgumentException(
                    "The multiplication factor must be between 1 and 100: %d".formatted(factor));
        }
    }

    private static boolean isProductValid(int multiplicand, int multiplier) {
        checkFactorValid(multiplicand);
        checkFactorValid(multiplier);
        int product = multiplicand * multiplier;
        return product >= 1 && product <= 100;
    }

    private static void checkProductValid(int multiplicand, int multiplier) {
        if (!isProductValid(multiplicand, multiplier)) {
            throw new IllegalArgumentException(
                    "The product must be between 1 and 100: %d * %d = %d"
                            .formatted(multiplicand, multiplier, multiplicand * multiplier)
            );
        }
    }

    public static boolean isBeginnerMultiplicationLevel(int multiplicand, int multiplier) {
        checkFactorValid(multiplicand);
        checkFactorValid(multiplier);
        return multiplicand <= 5 && multiplier <= 5;
    }

    public static boolean isEasyMultiplicationLevel(int multiplicand, int multiplier) {
        checkFactorValid(multiplicand);
        checkFactorValid(multiplier);
        return switch (multiplicand) {
            case 1, 5 -> (multiplier >= 6 && multiplier <= 10);
            case 10 -> (multiplier >= 1 && multiplier <= 10);
            default -> switch (multiplier) {
                case 1, 5 -> (multiplicand >= 6 && multiplicand <= 10);
                case 10 -> (multiplicand >= 1 && multiplicand <= 10);
                default -> false;
            };
        };
    }

    public static boolean isIntermediateMultiplicationLevel(int multiplicand, int multiplier) {
        checkFactorValid(multiplicand);
        checkFactorValid(multiplier);
        return multiplicand >=2 && multiplicand <= 4 && multiplier >= 6 && multiplier <= 9 ||
                        multiplicand >= 6 && multiplicand <= 9 && multiplier >= 2 && multiplier <= 4;
    }

    public static boolean isModerateMultiplicationLevel(int multiplicand, int multiplier) {
        checkFactorValid(multiplicand);
        checkFactorValid(multiplier);
        return multiplicand >= 6 && multiplicand <= 9 && multiplier >= 6 && multiplier <= 9;
    }

    private static boolean hasCarry(int multiplicand, int multiplier) {
        checkFactorValid(multiplicand);
        checkFactorValid(multiplier);
        return (multiplicand % 10) * (multiplier % 10) > 9;
    }

    public static boolean isAdvancedMultiplicationLevel(int multiplicand, int multiplier) {
        checkFactorValid(multiplicand);
        checkFactorValid(multiplier);
        return isProductValid(multiplicand, multiplier) &&
                (multiplicand >= 11 && multiplier < 10 || multiplicand < 10 && multiplier >= 11)  &&
                !hasCarry(multiplicand, multiplier);
    }

    public static boolean isChallengingMultiplicationLevel(int multiplicand, int multiplier) {
        checkFactorValid(multiplicand);
        checkFactorValid(multiplier);
        return isProductValid(multiplicand, multiplier) &&
                (multiplicand >= 11 && multiplier < 10 || multiplicand < 10 && multiplier >= 11) &&
                hasCarry(multiplicand, multiplier);
    }

    @NonNull
    public static DifficultyLevel getMultiplicationDifficultyLevel(int multiplicand, int multiplier) {
        if (isBeginnerMultiplicationLevel(multiplicand, multiplier)) {
            return DifficultyLevel.BEGINNER;
        }
        if (isEasyMultiplicationLevel(multiplicand, multiplier)) {
            return DifficultyLevel.EASY;
        }
        if (isIntermediateMultiplicationLevel(multiplicand, multiplier)) {
            return DifficultyLevel.INTERMEDIATE;
        }
        if (isModerateMultiplicationLevel(multiplicand, multiplier)) {
            return DifficultyLevel.MODERATE;
        }
        if (isAdvancedMultiplicationLevel(multiplicand, multiplier)) {
            return DifficultyLevel.ADVANCED;
        }
        if (isChallengingMultiplicationLevel(multiplicand, multiplier)) {
            return DifficultyLevel.CHALLENGING;
        }
        return DifficultyLevel.UNKNOWN;
    }
}
