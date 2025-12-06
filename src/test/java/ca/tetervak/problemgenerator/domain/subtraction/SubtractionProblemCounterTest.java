package ca.tetervak.problemgenerator.domain.subtraction;

import ca.tetervak.problemgenerator.domain.DifficultyLevel;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static java.lang.System.out;

class SubtractionProblemCounterTest {

    @Test
    void countSubtractionProblems() {
        int count = SubtractionProblemCounter.countSubtractionProblems();
        out.printf("Subtraction Problem count = %d%n", count);
        assertEquals(4950, count);
    }

    @Test
    void countBeginnerSubtractionProblems() {
        int count = SubtractionProblemCounter.countBeginnerSubtractionProblems();
        out.printf("Beginner Subtraction Problem count = %d%n", count);
        assertEquals(36, count);
    }

    @Test
    void countEasySubtractionProblems() {
        int count = SubtractionProblemCounter.countEasySubtractionProblems();
        out.printf("Easy Subtraction Problem count = %d%n", count);
        assertEquals(90, count);
    }

    @Test
    void countIntermediateSubtractionProblems() {
        int count = SubtractionProblemCounter.countIntermediateSubtractionProblems();
        out.printf("Intermediate Subtraction Problem count = %d%n", count);
        assertEquals(360, count);
    }

    @Test
    void countModerateSubtractionProblems() {
        int count = SubtractionProblemCounter.countModerateSubtractionProblems();
        out.printf("Moderate Subtraction Problem count = %d%n", count);
        assertEquals(369, count);
    }

    @Test
    void countAdvancedSubtractionProblems() {
        int count = SubtractionProblemCounter.countAdvancedSubtractionProblems();
        out.printf("Advanced Subtraction Problem count = %d%n", count);
        assertEquals(2385, count);
    }

    @Test
    void countChallengingSubtractionProblems() {
        int count = SubtractionProblemCounter.countChallengingSubtractionProblems();
        out.printf("Challenging Subtraction Problem count = %d%n", count);
        assertEquals(1710, count);
    }

    @Test
    void verifyTotalSubtractionProblems() {
        int overallCount = SubtractionProblemCounter.countSubtractionProblems();
        out.printf("Total Subtraction Problem count = %d%n", overallCount);
        int separatedCount = 0;
        int beginnerCount = SubtractionProblemCounter.countBeginnerSubtractionProblems();
        separatedCount += beginnerCount;
        int easyCount = SubtractionProblemCounter.countEasySubtractionProblems();
        separatedCount += easyCount;
        int intermediateCount = SubtractionProblemCounter.countIntermediateSubtractionProblems();
        separatedCount += intermediateCount;
        int moderateCount = SubtractionProblemCounter.countModerateSubtractionProblems();
        separatedCount += moderateCount;
        int advancedCount = SubtractionProblemCounter.countAdvancedSubtractionProblems();
        separatedCount += advancedCount;
        int challengingCount = SubtractionProblemCounter.countChallengingSubtractionProblems();
        separatedCount += challengingCount;
        out.printf(
                "%d + %d + %d + %d + %d + %d = %d%n",
                beginnerCount,
                easyCount,
                intermediateCount,
                moderateCount,
                advancedCount,
                challengingCount,
                separatedCount);
        assertEquals(overallCount, separatedCount);
    }

    @Test
    void getSubtractionProblemCounts() {
        Map<DifficultyLevel, Integer> counts =
                SubtractionProblemCounter.getSubtractionProblemCounts();
        int beginnerCount = SubtractionProblemCounter.countBeginnerSubtractionProblems();
        int easyCount = SubtractionProblemCounter.countEasySubtractionProblems();
        int intermediateCount = SubtractionProblemCounter.countIntermediateSubtractionProblems();
        int moderateCount = SubtractionProblemCounter.countModerateSubtractionProblems();
        int advancedCount = SubtractionProblemCounter.countAdvancedSubtractionProblems();
        int challengingCount = SubtractionProblemCounter.countChallengingSubtractionProblems();
        assertEquals(beginnerCount, counts.get(DifficultyLevel.BEGINNER));
        assertEquals(easyCount, counts.get(DifficultyLevel.EASY));
        assertEquals(intermediateCount, counts.get(DifficultyLevel.INTERMEDIATE));
        assertEquals(moderateCount, counts.get(DifficultyLevel.MODERATE));
        assertEquals(advancedCount, counts.get(DifficultyLevel.ADVANCED));
        assertEquals(challengingCount, counts.get(DifficultyLevel.CHALLENGING));
    }
}