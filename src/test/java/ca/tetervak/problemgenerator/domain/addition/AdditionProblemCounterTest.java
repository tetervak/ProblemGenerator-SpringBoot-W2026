package ca.tetervak.problemgenerator.domain.addition;

import ca.tetervak.problemgenerator.domain.DifficultyLevel;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static java.lang.System.out;

class AdditionProblemCounterTest {

    @Test
    void countAdditionProblems() {
        int count = AdditionProblemCounter.countAdditionProblems();
        out.printf("Addition Problem count = %d%n", count);
        assertEquals(4950, count);
    }

    @Test
    void countBeginnerAdditionProblems() {
        int count = AdditionProblemCounter.countBeginnerAdditionProblems();
        out.printf("Beginner Addition Problem count = %d%n", count);
        assertEquals(45, count);
    }

    @Test
    void countEasyAdditionProblems() {
        int count = AdditionProblemCounter.countEasyAdditionProblems();
        out.printf("Easy Addition Problem count = %d%n", count);
        assertEquals(54, count);
    }

    @Test
    void countIntermediateAdditionProblems() {
        int count = AdditionProblemCounter.countIntermediateAdditionProblems();
        out.printf("Intermediate Addition Problem count = %d%n", count);
        assertEquals(954, count);
    }

    @Test
    void countModerateAdditionProblems() {
        int count = AdditionProblemCounter.countModerateAdditionProblems();
        out.printf("Moderate Addition Problem count = %d%n", count);
        assertEquals(576, count);
    }

    @Test
    void countAdvancedAdditionProblems() {
        int count = AdditionProblemCounter.countAdvancedAdditionProblems();
        out.printf("Advanced Addition Problem count = %d%n", count);
        assertEquals(2313, count);
    }

    @Test
    void countChallengingAdditionProblems() {
        int count = AdditionProblemCounter.countChallengingAdditionProblems();
        out.printf("Challenging Addition Problem count = %d%n", count);
        assertEquals(1008, count);
    }

    @Test
    void verifyTotalAdditionProblems() {
        int overallCount = AdditionProblemCounter.countAdditionProblems();
        out.printf("Total Addition Problem count = %d%n", overallCount);
        int separatedCount = 0;
        int beginnerCount = AdditionProblemCounter.countBeginnerAdditionProblems();
        separatedCount += beginnerCount;
        int easyCount = AdditionProblemCounter.countEasyAdditionProblems();
        separatedCount += easyCount;
        int intermediateCount = AdditionProblemCounter.countIntermediateAdditionProblems();
        separatedCount += intermediateCount;
        int moderateCount = AdditionProblemCounter.countModerateAdditionProblems();
        separatedCount += moderateCount;
        int advancedCount = AdditionProblemCounter.countAdvancedAdditionProblems();
        separatedCount += advancedCount;
        int challengingCount = AdditionProblemCounter.countChallengingAdditionProblems();
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
    void getAdditionProblemCounts() {
        Map<DifficultyLevel, Integer> counts =
                AdditionProblemCounter.getAdditionProblemCounts();
        int beginnerCount = AdditionProblemCounter.countBeginnerAdditionProblems();
        int easyCount = AdditionProblemCounter.countEasyAdditionProblems();
        int intermediateCount = AdditionProblemCounter.countIntermediateAdditionProblems();
        int moderateCount = AdditionProblemCounter.countModerateAdditionProblems();
        int advancedCount = AdditionProblemCounter.countAdvancedAdditionProblems();
        int challengingCount = AdditionProblemCounter.countChallengingAdditionProblems();
        assertEquals(beginnerCount, counts.get(DifficultyLevel.BEGINNER));
        assertEquals(easyCount, counts.get(DifficultyLevel.EASY));
        assertEquals(intermediateCount, counts.get(DifficultyLevel.INTERMEDIATE));
        assertEquals(moderateCount, counts.get(DifficultyLevel.MODERATE));
        assertEquals(advancedCount, counts.get(DifficultyLevel.ADVANCED));
        assertEquals(challengingCount, counts.get(DifficultyLevel.CHALLENGING));
    }

}