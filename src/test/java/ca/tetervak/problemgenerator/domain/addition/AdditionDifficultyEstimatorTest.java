package ca.tetervak.problemgenerator.domain.addition;

import ca.tetervak.problemgenerator.domain.DifficultyLevel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static java.lang.System.out;

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
                            out.printf("Overlap: %d + %d%n", firstAddend, secondAddend);
                            out.printf("in difficulty levels: %s and %s%n", level, DifficultyLevel.EASY);
                            assertEquals(DifficultyLevel.UNKNOWN, level);
                        }
                    }
                    if (AdditionDifficultyEstimator.isIntermediateAdditionLevel(firstAddend, secondAddend)) {
                        if (level == DifficultyLevel.UNKNOWN) {
                            level = DifficultyLevel.INTERMEDIATE;
                        } else {
                            out.printf("Overlap: %d + %d%n", firstAddend, secondAddend);
                            out.printf("in difficulty levels: %s and %s%n", level, DifficultyLevel.INTERMEDIATE);
                            assertEquals(DifficultyLevel.UNKNOWN, level);
                        }
                    }
                    if (AdditionDifficultyEstimator.isModerateAdditionLevel(firstAddend, secondAddend)) {
                        if (level == DifficultyLevel.UNKNOWN) {
                            level = DifficultyLevel.MODERATE;
                        } else {
                            out.printf("Overlap: %d + %d%n", firstAddend, secondAddend);
                            out.printf("in difficulty levels: %s and %s%n", level, DifficultyLevel.MODERATE);
                            assertEquals(DifficultyLevel.UNKNOWN, level);
                        }
                    }
                    if (AdditionDifficultyEstimator.isAdvancedAdditionLevel(firstAddend, secondAddend)) {
                        if (level == DifficultyLevel.UNKNOWN) {
                            level = DifficultyLevel.ADVANCED;
                        } else {
                            out.printf("Overlap: %d + %d%n", firstAddend, secondAddend);
                            out.printf("in difficulty levels: %s and %s%n", level, DifficultyLevel.ADVANCED);
                            assertEquals(DifficultyLevel.UNKNOWN, level);
                        }
                    }
                    if (AdditionDifficultyEstimator.isChallengingAdditionLevel(firstAddend, secondAddend)) {
                        if (level == DifficultyLevel.UNKNOWN) {
                            level = DifficultyLevel.CHALLENGING;
                        } else {
                            out.printf("Overlap: %d + %d%n", firstAddend, secondAddend);
                            out.printf("in difficulty levels: %s and %s%n", level, DifficultyLevel.CHALLENGING);
                            assertEquals(DifficultyLevel.UNKNOWN, level);
                        }
                    }
                    if(level == DifficultyLevel.UNKNOWN){
                        out.printf("Unknown level: %d + %d%n", firstAddend, secondAddend);
                    }
                    assertNotSame(DifficultyLevel.UNKNOWN, level);
                }
            }
        }
    }

}