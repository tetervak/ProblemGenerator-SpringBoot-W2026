package ca.tetervak.problemgenerator.domain.addition;

import ca.tetervak.problemgenerator.domain.DifficultyLevel;
import org.jspecify.annotations.NonNull;


public class AdditionDifficultyEstimator {

    public static boolean isOperandValid(int operand) {
        return operand > 0 && operand < 100;
    }

    public static void checkOperandValid(int operand) {
        if (!isOperandValid(operand)) {
            throw new IllegalArgumentException("Invalid addition operand: " + operand);
        }
    }

    public static boolean hasFirstCarry(int firstAddend, int secondAddend) {
        checkOperandValid(firstAddend);
        checkOperandValid(secondAddend);
        return firstAddend % 10 + secondAddend % 10 > 9;
    }

    public static boolean hasSecondCarry(int firstAddend, int secondAddend) {
        checkOperandValid(firstAddend);
        checkOperandValid(secondAddend);
        if (hasFirstCarry(firstAddend, secondAddend)) {
            return (firstAddend / 10 + secondAddend / 10) > 8;
        } else {
            return (firstAddend / 10 + secondAddend / 10) > 9;
        }
    }

    // digit + digit = number > 9
    public static boolean hasCarry(int firstAddend, int secondAddend) {
        checkOperandValid(firstAddend);
        checkOperandValid(secondAddend);
        return hasFirstCarry(firstAddend, secondAddend) ||
                hasSecondCarry(firstAddend, secondAddend);
    }

    public static boolean hasFirstBridgingCarry(int firstAddend, int secondAddend) {
        checkOperandValid(firstAddend);
        checkOperandValid(secondAddend);
        return firstAddend % 10 + secondAddend % 10 == 10;
    }

    public static boolean hasSecondBridgingCarry(int firstAddend, int secondAddend) {
        checkOperandValid(firstAddend);
        checkOperandValid(secondAddend);
        if (hasFirstBridgingCarry(firstAddend, secondAddend)) {
            return (firstAddend / 10 + secondAddend / 10) == 9;
        } else {
            return (firstAddend / 10 + secondAddend / 10) == 10;
        }
    }

    public static boolean hasBridgingCarry(int firstAddend, int secondAddend) {
        checkOperandValid(firstAddend);
        checkOperandValid(secondAddend);
        return hasFirstBridgingCarry(firstAddend, secondAddend) ||
                hasSecondBridgingCarry(firstAddend, secondAddend);
    }

    public static boolean isOperandInBeginnerRange(int operand) {
        checkOperandValid(operand);
        return operand <= 9;
    }

    public static void checkOperandBeginnerRange(int operand) {
        if (!isOperandInBeginnerRange(operand)) {
            throw new IllegalArgumentException("Operand is NOT in the Beginner addition range: " + operand);
        }
    }

    public static boolean isSumInBeginnerRange(int firstAddend, int secondAddend) {
        checkOperandBeginnerRange(firstAddend);
        checkOperandBeginnerRange(secondAddend);
        int sum = firstAddend + secondAddend;
        return sum <= 10;
    }

    public static boolean isBeginnerLevel(int firstAddend, int secondAddend) {
        return isOperandInBeginnerRange(firstAddend) &&
                isOperandInBeginnerRange(secondAddend) &&
                isSumInBeginnerRange(firstAddend, secondAddend) &&
                (!hasFirstCarry(firstAddend, secondAddend) ||
                        hasFirstBridgingCarry(firstAddend, secondAddend));
    }

    public static boolean isOperandInEasyRange(int operand) {
        checkOperandValid(operand);
        return operand <= 10;
    }

    public static void checkOperandEasyRange(int operand) {
        checkOperandValid(operand);
        if (!isOperandInEasyRange(operand)) {
            throw new IllegalArgumentException("Operand is NOT in the Easy addition range: " + operand);
        }
    }

    public static boolean isSumInEasyRange(int firstAddend, int secondAddend) {
        checkOperandEasyRange(firstAddend);
        checkOperandEasyRange(secondAddend);
        int sum = firstAddend + secondAddend;
        return sum > 10 && sum < 20;
    }

    public static boolean isEasyLevel(int firstAddend, int secondAddend) {
        return isOperandInEasyRange(firstAddend) &&
                isOperandInEasyRange(secondAddend) &&
                isSumInEasyRange(firstAddend, secondAddend) &&
                !hasFirstBridgingCarry(firstAddend, secondAddend);
    }

    public static boolean isLargerOperandInIntermediateRange(int operand) {
        checkOperandValid(operand);
        return operand > 10;
    }

    public static boolean areOperandsInIntermediateRange(int firstAddend, int secondAddend) {
        checkOperandValid(firstAddend);
        checkOperandValid(secondAddend);
        if(firstAddend > secondAddend) {
            return isLargerOperandInIntermediateRange(firstAddend) &&
                    isOperandInBeginnerRange(secondAddend);
        } else {
            return isOperandInBeginnerRange(firstAddend) &&
                    isLargerOperandInIntermediateRange(secondAddend);
        }
    }

    public static boolean isSumInIntermediateRange(int firstAddend, int secondAddend) {
        checkOperandValid(firstAddend);
        checkOperandValid(secondAddend);
        int sum = firstAddend + secondAddend;
        return sum >= 12 && sum <= 100;
    }

    public static boolean isIntermediateLevel(int firstAddend, int secondAddend) {
        return areOperandsInIntermediateRange(firstAddend, secondAddend) &&
                isSumInIntermediateRange(firstAddend, secondAddend) &&
                (!hasCarry(firstAddend, secondAddend) ||
                        hasBridgingCarry(firstAddend, secondAddend));
    }

    public static boolean isModerateLevel(int firstAddend, int secondAddend) {
        return areOperandsInIntermediateRange(firstAddend, secondAddend) &&
                isSumInIntermediateRange(firstAddend, secondAddend) &&
                hasCarry(firstAddend, secondAddend) &&
                !hasBridgingCarry(firstAddend, secondAddend);
    }

    public static boolean isOperandInAdvancedRange(int operand) {
        checkOperandValid(operand);
        return operand >= 10;
    }

    public static boolean isAdvancedLevel(int firstAddend, int secondAddend) {
        return isOperandInAdvancedRange(firstAddend) &&
                isOperandInAdvancedRange(secondAddend) &&
                isSumInIntermediateRange(firstAddend, secondAddend) &&
                (!hasCarry(firstAddend, secondAddend) ||
                        hasBridgingCarry(firstAddend, secondAddend));
    }

    public static boolean isChallengingLevel(int firstAddend, int secondAddend) {
        return isOperandInAdvancedRange(firstAddend) &&
                isOperandInAdvancedRange(secondAddend) &&
                isSumInIntermediateRange(firstAddend, secondAddend) &&
                hasCarry(firstAddend, secondAddend) &&
                !hasBridgingCarry(firstAddend, secondAddend);
    }

    @SuppressWarnings("Duplicates")
    @NonNull
    public static DifficultyLevel getDifficultyLevel(int firstAddend, int secondAddend) {
        if (isBeginnerLevel(firstAddend, secondAddend)) {
            return DifficultyLevel.BEGINNER;
        }
        if (isEasyLevel(firstAddend, secondAddend)) {
            return DifficultyLevel.EASY;
        }
        if (isIntermediateLevel(firstAddend, secondAddend)) {
            return DifficultyLevel.INTERMEDIATE;
        }
        if (isModerateLevel(firstAddend, secondAddend)) {
            return DifficultyLevel.MODERATE;
        }
        if (isAdvancedLevel(firstAddend, secondAddend)) {
            return DifficultyLevel.ADVANCED;
        }
        if (isChallengingLevel(firstAddend, secondAddend)) {
            return DifficultyLevel.CHALLENGING;
        }
        return DifficultyLevel.UNKNOWN;
    }
}
