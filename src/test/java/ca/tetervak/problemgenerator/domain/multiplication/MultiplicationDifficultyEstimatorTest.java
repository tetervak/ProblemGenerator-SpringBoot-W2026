package ca.tetervak.problemgenerator.domain.multiplication;

import ca.tetervak.problemgenerator.domain.DifficultyLevel;
import org.junit.jupiter.api.Test;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

class MultiplicationDifficultyEstimatorTest {

    @Test
    void checkForGapsAndOverlaps() {
        for (int multiplicand = 1; multiplicand < 100; multiplicand++) {
            for (int multiplier = 1; multiplier < 100; multiplier++) {
                if(multiplicand * multiplier <= 100) {
                    DifficultyLevel level = DifficultyLevel.UNKNOWN;
                    if (MultiplicationDifficultyEstimator.isBeginnerMultiplicationLevel(multiplicand, multiplier)) {
                        level = DifficultyLevel.BEGINNER;
                    }
                    if (MultiplicationDifficultyEstimator.isEasyMultiplicationLevel(multiplicand, multiplier)) {
                        if (level == DifficultyLevel.UNKNOWN) {
                            level = DifficultyLevel.EASY;
                        } else {
                            out.printf("Overlap: %d + %d%n", multiplicand, multiplier);
                            out.printf("in difficulty levels: %s and %s%n", level, DifficultyLevel.EASY);
                            assertEquals(DifficultyLevel.UNKNOWN, level);
                        }
                    }
                    if (MultiplicationDifficultyEstimator.isIntermediateMultiplicationLevel(multiplicand, multiplier)) {
                        if (level == DifficultyLevel.UNKNOWN) {
                            level = DifficultyLevel.INTERMEDIATE;
                        } else {
                            out.printf("Overlap: %d + %d%n", multiplicand, multiplier);
                            out.printf("in difficulty levels: %s and %s%n", level, DifficultyLevel.INTERMEDIATE);
                            assertEquals(DifficultyLevel.UNKNOWN, level);
                        }
                    }
                    if (MultiplicationDifficultyEstimator.isModerateMultiplicationLevel(multiplicand, multiplier)) {
                        if (level == DifficultyLevel.UNKNOWN) {
                            level = DifficultyLevel.MODERATE;
                        } else {
                            out.printf("Overlap: %d + %d%n", multiplicand, multiplier);
                            out.printf("in difficulty levels: %s and %s%n", level, DifficultyLevel.MODERATE);
                            assertEquals(DifficultyLevel.UNKNOWN, level);
                        }
                    }
                    if (MultiplicationDifficultyEstimator.isAdvancedMultiplicationLevel(multiplicand, multiplier)) {
                        if (level == DifficultyLevel.UNKNOWN) {
                            level = DifficultyLevel.ADVANCED;
                        } else {
                            out.printf("Overlap: %d + %d%n", multiplicand, multiplier);
                            out.printf("in difficulty levels: %s and %s%n", level, DifficultyLevel.ADVANCED);
                            assertEquals(DifficultyLevel.UNKNOWN, level);
                        }
                    }
                    if (MultiplicationDifficultyEstimator.isChallengingMultiplicationLevel(multiplicand, multiplier)) {
                        if (level == DifficultyLevel.UNKNOWN) {
                            level = DifficultyLevel.CHALLENGING;
                        } else {
                            out.printf("Overlap: %d + %d%n", multiplicand, multiplier);
                            out.printf("in difficulty levels: %s and %s%n", level, DifficultyLevel.CHALLENGING);
                            assertEquals(DifficultyLevel.UNKNOWN, level);
                        }
                    }
                    if(level == DifficultyLevel.UNKNOWN){
                        out.printf("Unknown level: %d + %d%n", multiplicand, multiplier);
                    }
                    assertNotSame(DifficultyLevel.UNKNOWN, level);
                } else {
                    break;
                }
            }
        }
    }

}