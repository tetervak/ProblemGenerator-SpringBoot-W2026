package ca.tetervak.problemgenerator.domain;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class DifficultyLevelTest {

    @Test
    void fromString() {
        assertEquals(DifficultyLevel.BEGINNER, DifficultyLevel.fromString("beginner"));
        assertEquals(DifficultyLevel.EASY, DifficultyLevel.fromString("easy"));
        assertEquals(DifficultyLevel.INTERMEDIATE, DifficultyLevel.fromString("intermediate"));
        assertEquals(DifficultyLevel.MODERATE, DifficultyLevel.fromString("moderate"));
        assertEquals(DifficultyLevel.ADVANCED, DifficultyLevel.fromString("advanced"));
        assertEquals(DifficultyLevel.CHALLENGING, DifficultyLevel.fromString("challenging"));
        assertEquals(DifficultyLevel.UNKNOWN, DifficultyLevel.fromString("whatever"));
    }

    @Test
    void getRandomDifficultyLevel() {
        Random random = new Random(4);
        DifficultyLevel level;
        for (int i = 0; i < 100; i++) {
            level = DifficultyLevel.getRandomDifficultyLevel(random);
            assertNotNull(level);
            assertNotSame(DifficultyLevel.UNKNOWN, level);
        }
    }
}