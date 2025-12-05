package ca.tetervak.problemgenerator.domain.addition;

import ca.tetervak.problemgenerator.domain.DifficultyLevel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdditionDifficultyEstimatorTest {

    @Test
    void checkForGapsAndOverlaps() {
        for (int firstAddend = 1; firstAddend < 100; firstAddend++) {
            for (int secondAddend = 1; secondAddend < 100; secondAddend++) {
                if(firstAddend + secondAddend <= 100) {
                    DifficultyLevel level = DifficultyLevel.UNKNOWN;
                    if (AdditionDifficultyEstimator.isBeginnerAdditionLevel(firstAddend, secondAddend)) {
                        level = DifficultyLevel.BEGINNER;
                    }
                    if (AdditionDifficultyEstimator.isEasyAdditionLevel(firstAddend, secondAddend)) {
                        if (level == DifficultyLevel.UNKNOWN) {
                            level = DifficultyLevel.EASY;
                        } else {
                            System.out.println("Overlap: " + firstAddend + " + " + secondAddend);
                            System.out.println(
                                    "in difficulty levels: " +
                                            level +
                                            " and " +
                                            DifficultyLevel.EASY
                            );
                            assertEquals(DifficultyLevel.UNKNOWN, level);
                        }
                    }
                    if (AdditionDifficultyEstimator.isIntermediateAdditionLevel(firstAddend, secondAddend)) {
                        if (level == DifficultyLevel.UNKNOWN) {
                            level = DifficultyLevel.INTERMEDIATE;
                        } else {
                            System.out.println("Overlap: " + firstAddend + " + " + secondAddend);
                            System.out.println(
                                    "in difficulty levels: " +
                                            level +
                                            " and " +
                                            DifficultyLevel.INTERMEDIATE
                            );
                            assertEquals(DifficultyLevel.UNKNOWN, level);
                        }
                    }
                    if (AdditionDifficultyEstimator.isModerateAdditionLevel(firstAddend, secondAddend)) {
                        if (level == DifficultyLevel.UNKNOWN) {
                            level = DifficultyLevel.MODERATE;
                        } else {
                            System.out.println("Overlap: " + firstAddend + " + " + secondAddend);
                            System.out.println(
                                    "in difficulty levels: " +
                                            level +
                                            " and " +
                                            DifficultyLevel.MODERATE
                            );
                            assertEquals(DifficultyLevel.UNKNOWN, level);
                        }
                    }
                    if (AdditionDifficultyEstimator.isAdvancedAdditionLevel(firstAddend, secondAddend)) {
                        if (level == DifficultyLevel.UNKNOWN) {
                            level = DifficultyLevel.ADVANCED;
                        } else {
                            System.out.println("Overlap: " + firstAddend + " + " + secondAddend);
                            System.out.println(
                                    "in difficulty levels: " +
                                            level +
                                            " and " +
                                            DifficultyLevel.ADVANCED
                            );
                            assertEquals(DifficultyLevel.UNKNOWN, level);
                        }
                    }
                    if (AdditionDifficultyEstimator.isChallengingAdditionLevel(firstAddend, secondAddend)) {
                        if (level == DifficultyLevel.UNKNOWN) {
                            level = DifficultyLevel.CHALLENGING;
                        } else {
                            System.out.println("Overlap: " + firstAddend + " + " + secondAddend);
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
                        System.out.println("Unknown level: " + firstAddend + " + " + secondAddend);
                    }
                    assertNotSame(DifficultyLevel.UNKNOWN, level);
                }
            }
        }
    }

}