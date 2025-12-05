package ca.tetervak.problemgenerator.domain.subtraction;

import ca.tetervak.problemgenerator.domain.DifficultyLevel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static java.lang.System.out;

class SubtractionDifficultyEstimatorTest {

    @Test
    void checkForGapsAndOverlaps() {
        for (int minuend = 2; minuend <= 100; minuend++) {
            for (int subtrahend = 1; subtrahend <= 99; subtrahend++) {
                if(minuend > subtrahend) {
                    DifficultyLevel level = DifficultyLevel.UNKNOWN;
                    if (SubtractionDifficultyEstimator.isBeginnerSubtractionLevel(minuend, subtrahend)) {
                        level = DifficultyLevel.BEGINNER;
                    }
                    if (SubtractionDifficultyEstimator.isEasySubtractionLevel(minuend, subtrahend)) {
                        if (level == DifficultyLevel.UNKNOWN) {
                            level = DifficultyLevel.EASY;
                        } else {
                            out.printf("Overlap: %d - %d%n", minuend, subtrahend);
                            out.printf("in difficulty levels: %s and %s%n", level, DifficultyLevel.EASY);
                            assertEquals(DifficultyLevel.UNKNOWN, level);
                        }
                    }
                    if (SubtractionDifficultyEstimator.isIntermediateSubtractionLevel(minuend, subtrahend)) {
                        if (level == DifficultyLevel.UNKNOWN) {
                            level = DifficultyLevel.INTERMEDIATE;
                        } else {
                            out.printf("Overlap: %d - %d%n", minuend, subtrahend);
                            out.printf("in difficulty levels: %s and %s%n", level, DifficultyLevel.INTERMEDIATE);
                            assertEquals(DifficultyLevel.UNKNOWN, level);
                        }
                    }
                    if (SubtractionDifficultyEstimator.isModerateSubtractionLevel(minuend, subtrahend)) {
                        if (level == DifficultyLevel.UNKNOWN) {
                            level = DifficultyLevel.MODERATE;
                        } else {
                            out.printf("Overlap: %d - %d%n", minuend, subtrahend);
                            out.printf("in difficulty levels: %s and %s%n", level, DifficultyLevel.MODERATE);
                            assertEquals(DifficultyLevel.UNKNOWN, level);
                        }
                    }
                    if (SubtractionDifficultyEstimator.isAdvancedSubtractionLevel(minuend, subtrahend)) {
                        if (level == DifficultyLevel.UNKNOWN) {
                            level = DifficultyLevel.ADVANCED;
                        } else {
                            out.printf("Overlap: %d - %d%n", minuend, subtrahend);
                            out.printf("in difficulty levels: %s and %s%n", level, DifficultyLevel.ADVANCED);
                            assertEquals(DifficultyLevel.UNKNOWN, level);
                        }
                    }
                    if (SubtractionDifficultyEstimator.isChallengingSubtractionLevel(minuend, subtrahend)) {
                        if (level == DifficultyLevel.UNKNOWN) {
                            level = DifficultyLevel.CHALLENGING;
                        } else {
                            out.printf("Overlap: %d - %d%n", minuend, subtrahend);
                            out.printf("in difficulty levels: %s and %s%n", level, DifficultyLevel.CHALLENGING);
                            assertEquals(DifficultyLevel.UNKNOWN, level);
                        }
                    }
                    if(level == DifficultyLevel.UNKNOWN){
                        out.printf("Unknown level: %d - %d%n", minuend, subtrahend);
                    }
                    assertNotSame(DifficultyLevel.UNKNOWN, level);
                }
            }
        }
    }

}