package ca.tetervak.problemgenerator.domain.division;

import ca.tetervak.problemgenerator.domain.DifficultyLevel;
import org.junit.jupiter.api.Test;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

class DivisionDifficultyEstimatorTest {
    @Test
    void checkForGapsAndOverlaps() {
        for (int dividend = 4; dividend < 100; dividend++) {
            for (int divider = 2; divider < 50; divider++) {
                if(dividend > divider) {
                    if (dividend % divider != 0) continue;
                    DifficultyLevel level = DifficultyLevel.UNKNOWN;
                    if (DivisionDifficultyEstimator.isBeginnerDivisionLevel(dividend, divider)) {
                        level = DifficultyLevel.BEGINNER;
                    }
                    if (DivisionDifficultyEstimator.isEasyDivisionLevel(dividend, divider)) {
                        if (level == DifficultyLevel.UNKNOWN) {
                            level = DifficultyLevel.EASY;
                        } else {
                            out.printf("Overlap: %d / %d%n", dividend, divider);
                            out.printf("in difficulty levels: %s and %s%n", level, DifficultyLevel.EASY);
                            assertEquals(DifficultyLevel.UNKNOWN, level);
                        }
                    }
                    if (DivisionDifficultyEstimator.isIntermediateDivisionLevel(dividend, divider)) {
                        if (level == DifficultyLevel.UNKNOWN) {
                            level = DifficultyLevel.INTERMEDIATE;
                        } else {
                            out.printf("Overlap: %d / %d%n", dividend, divider);
                            out.printf("in difficulty levels: %s and %s%n", level, DifficultyLevel.INTERMEDIATE);
                            assertEquals(DifficultyLevel.UNKNOWN, level);
                        }
                    }
                    if (DivisionDifficultyEstimator.isModerateDivisionLevel(dividend, divider)) {
                        if (level == DifficultyLevel.UNKNOWN) {
                            level = DifficultyLevel.MODERATE;
                        } else {
                            out.printf("Overlap: %d / %d%n", dividend, divider);
                            out.printf("in difficulty levels: %s and %s%n", level, DifficultyLevel.MODERATE);
                            assertEquals(DifficultyLevel.UNKNOWN, level);
                        }
                    }
                    if (DivisionDifficultyEstimator.isAdvancedDivisionLevel(dividend, divider)) {
                        if (level == DifficultyLevel.UNKNOWN) {
                            level = DifficultyLevel.ADVANCED;
                        } else {
                            out.printf("Overlap: %d / %d%n", dividend, divider);
                            out.printf("in difficulty levels: %s and %s%n", level, DifficultyLevel.ADVANCED);
                            assertEquals(DifficultyLevel.UNKNOWN, level);
                        }
                    }
                    if (DivisionDifficultyEstimator.isChallengingDivisionLevel(dividend, divider)) {
                        if (level == DifficultyLevel.UNKNOWN) {
                            level = DifficultyLevel.CHALLENGING;
                        } else {
                            out.printf("Overlap: %d / %d%n", dividend, divider);
                            out.printf("in difficulty levels: %s and %s%n", level, DifficultyLevel.CHALLENGING);
                            assertEquals(DifficultyLevel.UNKNOWN, level);
                        }
                    }
                    if(level == DifficultyLevel.UNKNOWN){
                        out.printf("Unknown level: %d / %d%n", dividend, divider);
                    }
                    assertNotSame(DifficultyLevel.UNKNOWN, level);
                } else {
                    break;
                }
            }
        }
    }
}