package ca.tetervak.problemgenerator.domain.subtraction;

import ca.tetervak.problemgenerator.domain.DifficultyLevel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
                            System.out.println("Overlap: " + minuend + " - " + subtrahend);
                            System.out.println(
                                    "in difficulty levels: " +
                                            level +
                                            " and " +
                                            DifficultyLevel.EASY
                            );
                            assertEquals(DifficultyLevel.UNKNOWN, level);
                        }
                    }
                    if (SubtractionDifficultyEstimator.isIntermediateSubtractionLevel(minuend, subtrahend)) {
                        if (level == DifficultyLevel.UNKNOWN) {
                            level = DifficultyLevel.INTERMEDIATE;
                        } else {
                            System.out.println("Overlap: " + minuend + " - " + subtrahend);
                            System.out.println(
                                    "in difficulty levels: " +
                                            level +
                                            " and " +
                                            DifficultyLevel.INTERMEDIATE
                            );
                            assertEquals(DifficultyLevel.UNKNOWN, level);
                        }
                    }
                    if (SubtractionDifficultyEstimator.isModerateSubtractionLevel(minuend, subtrahend)) {
                        if (level == DifficultyLevel.UNKNOWN) {
                            level = DifficultyLevel.MODERATE;
                        } else {
                            System.out.println("Overlap: " + minuend + " - " + subtrahend);
                            System.out.println(
                                    "in difficulty levels: " +
                                            level +
                                            " and " +
                                            DifficultyLevel.MODERATE
                            );
                            assertEquals(DifficultyLevel.UNKNOWN, level);
                        }
                    }
                    if (SubtractionDifficultyEstimator.isAdvancedSubtractionLevel(minuend, subtrahend)) {
                        if (level == DifficultyLevel.UNKNOWN) {
                            level = DifficultyLevel.ADVANCED;
                        } else {
                            System.out.println("Overlap: " + minuend + " - " + subtrahend);
                            System.out.println(
                                    "in difficulty levels: " +
                                            level +
                                            " and " +
                                            DifficultyLevel.ADVANCED
                            );
                            assertEquals(DifficultyLevel.UNKNOWN, level);
                        }
                    }
                    if (SubtractionDifficultyEstimator.isChallengingSubtractionLevel(minuend, subtrahend)) {
                        if (level == DifficultyLevel.UNKNOWN) {
                            level = DifficultyLevel.CHALLENGING;
                        } else {
                            System.out.println("Overlap: " + minuend + " - " + subtrahend);
                            System.out.println(
                                    "in difficulty levels: " +
                                            level +
                                            " and " +
                                            DifficultyLevel.CHALLENGING
                            );
                            assertEquals(DifficultyLevel.UNKNOWN, level);
                        }
                    }
                    if(level == DifficultyLevel.UNKNOWN){
                        System.out.println("Unknown level: " + minuend + " - " + subtrahend);
                    }
                    assertNotSame(DifficultyLevel.UNKNOWN, level);
                }
            }
        }
    }

}