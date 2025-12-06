package ca.tetervak.problemgenerator.domain.division;

import ca.tetervak.problemgenerator.domain.DifficultyLevel;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

class DivisionProblemCounterTest {

    @Test
    void countDivisionProblems() {
        int count = DivisionProblemCounter.countDivisionProblems();
        out.printf("Division Problem count = %d%n", count);
        assertEquals(283, count);
    }

    @Test
    void countBeginnerDivisionProblems() {
        int count = DivisionProblemCounter.countBeginnerDivisionProblems();
        out.printf("Beginner Division Problem count = %d%n", count);
        assertEquals(16, count);
    }

    @Test
    void countEasyDivisionProblems() {
        int count = DivisionProblemCounter.countEasyDivisionProblems();
        out.printf("Easy Division Problem count = %d%n", count);
        assertEquals(25, count);
    }

    @Test
    void countIntermediateDivisionProblems() {
        int count = DivisionProblemCounter.countIntermediateDivisionProblems();
        out.printf("Intermediate Division Problem count = %d%n", count);
        assertEquals(24, count);
    }

    @Test
    void countModerateDivisionProblems() {
        int count = DivisionProblemCounter.countModerateDivisionProblems();
        out.printf("Moderate Division Problem count = %d%n", count);
        assertEquals(16, count);
    }

    @Test
    void countAdvancedDivisionProblems() {
        int count = DivisionProblemCounter.countAdvancedDivisionProblems();
        out.printf("Advanced Division Problem count = %d%n", count);
        assertEquals(84, count);
    }

    @Test
    void countChallengingDivisionProblems() {
        int count = DivisionProblemCounter.countChallengingDivisionProblems();
        out.printf("Challenging Division Problem count = %d%n", count);
        assertEquals(118, count);
    }

    @Test
    void verifyTotalDivisionProblems() {
        int overallCount = DivisionProblemCounter.countDivisionProblems();
        out.printf("Total Division Problem count = %d%n", overallCount);
        int separatedCount = 0;
        int beginnerCount = DivisionProblemCounter.countBeginnerDivisionProblems();
        separatedCount += beginnerCount;
        int easyCount = DivisionProblemCounter.countEasyDivisionProblems();
        separatedCount += easyCount;
        int intermediateCount = DivisionProblemCounter.countIntermediateDivisionProblems();
        separatedCount += intermediateCount;
        int moderateCount = DivisionProblemCounter.countModerateDivisionProblems();
        separatedCount += moderateCount;
        int advancedCount = DivisionProblemCounter.countAdvancedDivisionProblems();
        separatedCount += advancedCount;
        int challengingCount = DivisionProblemCounter.countChallengingDivisionProblems();
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
    void getDivisionProblemCounts() {
        Map<DifficultyLevel, Integer> counts =
                DivisionProblemCounter.getDivisionProblemCounts();
        int beginnerCount = DivisionProblemCounter.countBeginnerDivisionProblems();
        int easyCount = DivisionProblemCounter.countEasyDivisionProblems();
        int intermediateCount = DivisionProblemCounter.countIntermediateDivisionProblems();
        int moderateCount = DivisionProblemCounter.countModerateDivisionProblems();
        int advancedCount = DivisionProblemCounter.countAdvancedDivisionProblems();
        int challengingCount = DivisionProblemCounter.countChallengingDivisionProblems();
        assertEquals(beginnerCount, counts.get(DifficultyLevel.BEGINNER));
        assertEquals(easyCount, counts.get(DifficultyLevel.EASY));
        assertEquals(intermediateCount, counts.get(DifficultyLevel.INTERMEDIATE));
        assertEquals(moderateCount, counts.get(DifficultyLevel.MODERATE));
        assertEquals(advancedCount, counts.get(DifficultyLevel.ADVANCED));
        assertEquals(challengingCount, counts.get(DifficultyLevel.CHALLENGING));
    }


}