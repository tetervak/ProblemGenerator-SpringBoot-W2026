package ca.tetervak.problemgenerator.domain.addition;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdditionProblemCounterTest {

    @Test
    void countAdditionProblems() {
        int count = AdditionProblemCounter.countAdditionProblems();
        System.out.println("Addition Problem count = " + count);
    }

    @Test
    void countBeginnerAdditionProblems() {
        int count = AdditionProblemCounter.countBeginnerAdditionProblems();
        System.out.println("Beginner Addition Problem count = " + count);
    }

    @Test
    void countEasyAdditionProblems() {
        int count = AdditionProblemCounter.countEasyAdditionProblems();
        System.out.println("Easy Addition Problem count = " + count);
    }

    @Test
    void countIntermediateAdditionProblems() {
        int count = AdditionProblemCounter.countIntermediateAdditionProblems();
        System.out.println("Intermediate Addition Problem count = " + count);
    }

    @Test
    void countModerateAdditionProblems() {
        int count = AdditionProblemCounter.countModerateAdditionProblems();
        System.out.println("Moderate Addition Problem count = " + count);
    }

    @Test
    void countAdvancedAdditionProblems() {
        int count = AdditionProblemCounter.countAdvancedAdditionProblems();
        System.out.println("Advanced Addition Problem count = " + count);
    }

    @Test
    void countChallengingAdditionProblems() {
        int count = AdditionProblemCounter.countChallengingAdditionProblems();
        System.out.println("Challenging Addition Problem count = " + count);
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