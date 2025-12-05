package ca.tetervak.problemgenerator.domain.addition;

import ca.tetervak.problemgenerator.domain.DifficultyLevel;
import org.jspecify.annotations.NonNull;


public class AdditionDifficultyEstimator {

    private static boolean isOperandValid(int operand) {
        return operand > 0 && operand < 100;
    }

    private static void checkOperandValid(int operand) {
        if (!isOperandValid(operand)) {
            throw new IllegalArgumentException("Invalid addition operand: " + operand);
        }
    }

    private static boolean hasFirstCarry(int firstAddend, int secondAddend) {
        checkOperandValid(firstAddend);
        checkOperandValid(secondAddend);
        return firstAddend % 10 + secondAddend % 10 > 9;
    }

    private static boolean hasSecondCarry(int firstAddend, int secondAddend) {
        checkOperandValid(firstAddend);
        checkOperandValid(secondAddend);
        if (hasFirstCarry(firstAddend, secondAddend)) {
            return (firstAddend / 10 + secondAddend / 10) > 8;
        } else {
            return (firstAddend / 10 + secondAddend / 10) > 9;
        }
    }

    // digit + digit = number > 9
    private static boolean hasCarry(int firstAddend, int secondAddend) {
        checkOperandValid(firstAddend);
        checkOperandValid(secondAddend);
        return hasFirstCarry(firstAddend, secondAddend) ||
                hasSecondCarry(firstAddend, secondAddend);
    }

    private static boolean hasFirstBridgingCarry(int firstAddend, int secondAddend) {
        checkOperandValid(firstAddend);
        checkOperandValid(secondAddend);
        return firstAddend % 10 + secondAddend % 10 == 10;
    }

    private static boolean hasSecondBridgingCarry(int firstAddend, int secondAddend) {
        checkOperandValid(firstAddend);
        checkOperandValid(secondAddend);
        if (hasFirstBridgingCarry(firstAddend, secondAddend)) {
            return (firstAddend / 10 + secondAddend / 10) == 9;
        } else {
            return (firstAddend / 10 + secondAddend / 10) == 10;
        }
    }

    private static boolean hasBridgingCarry(int firstAddend, int secondAddend) {
        checkOperandValid(firstAddend);
        checkOperandValid(secondAddend);
        return hasFirstBridgingCarry(firstAddend, secondAddend) ||
                hasSecondBridgingCarry(firstAddend, secondAddend);
    }

    private static boolean isOperandInBeginnerRange(int operand) {
        checkOperandValid(operand);
        return operand <= 9;
    }

    private static void checkOperandBeginnerRange(int operand) {
        if (!isOperandInBeginnerRange(operand)) {
            throw new IllegalArgumentException("Operand is NOT in the Beginner addition range: " + operand);
        }
    }

    private static boolean isSumInBeginnerRange(int firstAddend, int secondAddend) {
        checkOperandBeginnerRange(firstAddend);
        checkOperandBeginnerRange(secondAddend);
        int sum = firstAddend + secondAddend;
        return sum <= 10;
    }

    public static boolean isBeginnerAdditionLevel(int firstAddend, int secondAddend) {
        return isOperandInBeginnerRange(firstAddend) &&
                isOperandInBeginnerRange(secondAddend) &&
                isSumInBeginnerRange(firstAddend, secondAddend) &&
                (!hasFirstCarry(firstAddend, secondAddend) ||
                        hasFirstBridgingCarry(firstAddend, secondAddend));
    }

    private static boolean isOperandInEasyRange(int operand) {
        checkOperandValid(operand);
        return operand <= 10;
    }

    private static void checkOperandEasyRange(int operand) {
        checkOperandValid(operand);
        if (!isOperandInEasyRange(operand)) {
            throw new IllegalArgumentException("Operand is NOT in the Easy addition range: " + operand);
        }
    }

    private static boolean isSumInEasyRange(int firstAddend, int secondAddend) {
        checkOperandEasyRange(firstAddend);
        checkOperandEasyRange(secondAddend);
        int sum = firstAddend + secondAddend;
        return sum > 10 && sum < 20;
    }

    public static boolean isEasyAdditionLevel(int firstAddend, int secondAddend) {
        return isOperandInEasyRange(firstAddend) &&
                isOperandInEasyRange(secondAddend) &&
                isSumInEasyRange(firstAddend, secondAddend) &&
                !hasFirstBridgingCarry(firstAddend, secondAddend);
    }

    private static boolean isLargerOperandInIntermediateRange(int operand) {
        checkOperandValid(operand);
        return operand > 10;
    }

    private static boolean areOperandsInIntermediateRange(int firstAddend, int secondAddend) {
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

    private static boolean isSumInIntermediateRange(int firstAddend, int secondAddend) {
        checkOperandValid(firstAddend);
        checkOperandValid(secondAddend);
        int sum = firstAddend + secondAddend;
        return sum >= 12 && sum <= 100;
    }

    public static boolean isIntermediateAdditionLevel(int firstAddend, int secondAddend) {
        return areOperandsInIntermediateRange(firstAddend, secondAddend) &&
                isSumInIntermediateRange(firstAddend, secondAddend) &&
                (!hasCarry(firstAddend, secondAddend) ||
                        hasBridgingCarry(firstAddend, secondAddend));
    }

    public static boolean isModerateAdditionLevel(int firstAddend, int secondAddend) {
        return areOperandsInIntermediateRange(firstAddend, secondAddend) &&
                isSumInIntermediateRange(firstAddend, secondAddend) &&
                hasCarry(firstAddend, secondAddend) &&
                !hasBridgingCarry(firstAddend, secondAddend);
    }

    private static boolean isOperandInAdvancedRange(int operand) {
        checkOperandValid(operand);
        return operand >= 10;
    }

    public static boolean isAdvancedAdditionLevel(int firstAddend, int secondAddend) {
        return isOperandInAdvancedRange(firstAddend) &&
                isOperandInAdvancedRange(secondAddend) &&
                isSumInIntermediateRange(firstAddend, secondAddend) &&
                (!hasCarry(firstAddend, secondAddend) ||
                        hasBridgingCarry(firstAddend, secondAddend));
    }

    public static boolean isChallengingAdditionLevel(int firstAddend, int secondAddend) {
        return isOperandInAdvancedRange(firstAddend) &&
                isOperandInAdvancedRange(secondAddend) &&
                isSumInIntermediateRange(firstAddend, secondAddend) &&
                hasCarry(firstAddend, secondAddend) &&
                !hasBridgingCarry(firstAddend, secondAddend);
    }

    @SuppressWarnings("Duplicates")
    @NonNull
    public static DifficultyLevel getAdditionDifficultyLevel(int firstAddend, int secondAddend) {
        if (isBeginnerAdditionLevel(firstAddend, secondAddend)) {
            return DifficultyLevel.BEGINNER;
        }
        if (isEasyAdditionLevel(firstAddend, secondAddend)) {
            return DifficultyLevel.EASY;
        }
        if (isIntermediateAdditionLevel(firstAddend, secondAddend)) {
            return DifficultyLevel.INTERMEDIATE;
        }
        if (isModerateAdditionLevel(firstAddend, secondAddend)) {
            return DifficultyLevel.MODERATE;
        }
        if (isAdvancedAdditionLevel(firstAddend, secondAddend)) {
            return DifficultyLevel.ADVANCED;
        }
        if (isChallengingAdditionLevel(firstAddend, secondAddend)) {
            return DifficultyLevel.CHALLENGING;
        }
        return DifficultyLevel.UNKNOWN;
    }
}
