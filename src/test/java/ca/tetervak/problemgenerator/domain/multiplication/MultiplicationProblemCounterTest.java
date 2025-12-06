package ca.tetervak.problemgenerator.domain.multiplication;

import ca.tetervak.problemgenerator.domain.DifficultyLevel;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

class MultiplicationProblemCounterTest {

    @Test
    void countMultiplicationProblems() {
        int count = MultiplicationProblemCounter.countMultiplicationProblems();
        out.printf("Multiplication Problem count = %d%n", count);
        assertEquals(283, count);
    }

    @Test
    void countBeginnerMultiplicationProblems() {
        int count = MultiplicationProblemCounter.countBeginnerMultiplicationProblems();
        out.printf("Beginner Multiplication Problem count = %d%n", count);
        assertEquals(16, count);
    }

    @Test
    void countEasyMultiplicationProblems() {
        int count = MultiplicationProblemCounter.countEasyMultiplicationProblems();
        out.printf("Easy Multiplication Problem count = %d%n", count);
        assertEquals(25, count);
    }

    @Test
    void countIntermediateMultiplicationProblems() {
        int count = MultiplicationProblemCounter.countIntermediateMultiplicationProblems();
        out.printf("Intermediate Multiplication Problem count = %d%n", count);
        assertEquals(24, count);
    }

    @Test
    void countModerateMultiplicationProblems() {
        int count = MultiplicationProblemCounter.countModerateMultiplicationProblems();
        out.printf("Moderate Multiplication Problem count = %d%n", count);
        assertEquals(16, count);
    }

    @Test
    void countAdvancedMultiplicationProblems() {
        int count = MultiplicationProblemCounter.countAdvancedMultiplicationProblems();
        out.printf("Advanced Multiplication Problem count = %d%n", count);
        assertEquals(84, count);
    }

    @Test
    void countChallengingMultiplicationProblems() {
        int count = MultiplicationProblemCounter.countChallengingMultiplicationProblems();
        out.printf("Challenging Multiplication Problem count = %d%n", count);
        assertEquals(118, count);
    }

    @Test
    void verifyTotalMultiplicationProblems() {
        int overallCount = MultiplicationProblemCounter.countMultiplicationProblems();
        out.printf("Total Multiplication Problem count = %d%n", overallCount);
        int separatedCount = 0;
        int beginnerCount = MultiplicationProblemCounter.countBeginnerMultiplicationProblems();
        separatedCount += beginnerCount;
        int easyCount = MultiplicationProblemCounter.countEasyMultiplicationProblems();
        separatedCount += easyCount;
        int intermediateCount = MultiplicationProblemCounter.countIntermediateMultiplicationProblems();
        separatedCount += intermediateCount;
        int moderateCount = MultiplicationProblemCounter.countModerateMultiplicationProblems();
        separatedCount += moderateCount;
        int advancedCount = MultiplicationProblemCounter.countAdvancedMultiplicationProblems();
        separatedCount += advancedCount;
        int challengingCount = MultiplicationProblemCounter.countChallengingMultiplicationProblems();
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
    void getMultiplicationProblemCounts() {
        Map<DifficultyLevel, Integer> counts =
                MultiplicationProblemCounter.getMultiplicationProblemCounts();
        int beginnerCount = MultiplicationProblemCounter.countBeginnerMultiplicationProblems();
        int easyCount = MultiplicationProblemCounter.countEasyMultiplicationProblems();
        int intermediateCount = MultiplicationProblemCounter.countIntermediateMultiplicationProblems();
        int moderateCount = MultiplicationProblemCounter.countModerateMultiplicationProblems();
        int advancedCount = MultiplicationProblemCounter.countAdvancedMultiplicationProblems();
        int challengingCount = MultiplicationProblemCounter.countChallengingMultiplicationProblems();
        assertEquals(beginnerCount, counts.get(DifficultyLevel.BEGINNER));
        assertEquals(easyCount, counts.get(DifficultyLevel.EASY));
        assertEquals(intermediateCount, counts.get(DifficultyLevel.INTERMEDIATE));
        assertEquals(moderateCount, counts.get(DifficultyLevel.MODERATE));
        assertEquals(advancedCount, counts.get(DifficultyLevel.ADVANCED));
        assertEquals(challengingCount, counts.get(DifficultyLevel.CHALLENGING));
    }
}