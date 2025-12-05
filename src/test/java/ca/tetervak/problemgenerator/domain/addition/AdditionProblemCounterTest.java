package ca.tetervak.problemgenerator.domain.addition;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static java.lang.System.out;

class AdditionProblemCounterTest {

    @Test
    void countAdditionProblems() {
        int count = AdditionProblemCounter.countAdditionProblems();
        out.printf("Addition Problem count = %d%n", count);
    }

    @Test
    void countBeginnerAdditionProblems() {
        int count = AdditionProblemCounter.countBeginnerAdditionProblems();
        out.printf("Beginner Addition Problem count = %d%n", count);
    }

    @Test
    void countEasyAdditionProblems() {
        int count = AdditionProblemCounter.countEasyAdditionProblems();
        out.printf("Easy Addition Problem count = %d%n", count);
    }

    @Test
    void countIntermediateAdditionProblems() {
        int count = AdditionProblemCounter.countIntermediateAdditionProblems();
        out.printf("Intermediate Addition Problem count = %d%n", count);
    }

    @Test
    void countModerateAdditionProblems() {
        int count = AdditionProblemCounter.countModerateAdditionProblems();
        out.printf("Moderate Addition Problem count = %d%n", count);
    }

    @Test
    void countAdvancedAdditionProblems() {
        int count = AdditionProblemCounter.countAdvancedAdditionProblems();
        out.printf("Advanced Addition Problem count = %d%n", count);
    }

    @Test
    void countChallengingAdditionProblems() {
        int count = AdditionProblemCounter.countChallengingAdditionProblems();
        out.printf("Challenging Addition Problem count = %d%n", count);
    }

    @Test
    void verifyTotalAdditionProblems() {
        int allCount = AdditionProblemCounter.countAdditionProblems();
        int beginnerCount = AdditionProblemCounter.countBeginnerAdditionProblems();
        int easyCount = AdditionProblemCounter.countEasyAdditionProblems();
        int intermediateCount = AdditionProblemCounter.countIntermediateAdditionProblems();
        int moderateCount = AdditionProblemCounter.countModerateAdditionProblems();
        int advancedCount = AdditionProblemCounter.countAdvancedAdditionProblems();
        int challengingCount = AdditionProblemCounter.countChallengingAdditionProblems();
        assertEquals(
                allCount,
                beginnerCount +
                        easyCount +
                        intermediateCount +
                        moderateCount +
                        advancedCount +
                        challengingCount
        );
    }

}