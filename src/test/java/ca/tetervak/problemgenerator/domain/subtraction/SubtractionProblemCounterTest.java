package ca.tetervak.problemgenerator.domain.subtraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubtractionProblemCounterTest {

    @Test
    void countSubtractionProblems() {
        int count = SubtractionProblemCounter.countSubtractionProblems();
        System.out.println("Subtraction Problem count = " + count);
    }

    @Test
    void countBeginnerSubtractionProblems() {
        int count = SubtractionProblemCounter.countBeginnerSubtractionProblems();
        System.out.println("Beginner Subtraction Problem count = " + count);
    }

    @Test
    void countEasySubtractionProblems() {
        int count = SubtractionProblemCounter.countEasySubtractionProblems();
        System.out.println("Easy Subtraction Problem count = " + count);
    }

    @Test
    void countIntermediateSubtractionProblems() {
        int count = SubtractionProblemCounter.countIntermediateSubtractionProblems();
        System.out.println("Intermediate Subtraction Problem count = " + count);
    }

    @Test
    void countModerateSubtractionProblems() {
        int count = SubtractionProblemCounter.countModerateSubtractionProblems();
        System.out.println("Moderate Subtraction Problem count = " + count);
    }

    @Test
    void countAdvancedSubtractionProblems() {
        int count = SubtractionProblemCounter.countAdvancedSubtractionProblems();
        System.out.println("Advanced Subtraction Problem count = " + count);
    }

    @Test
    void countChallengingSubtractionProblems() {
        int count = SubtractionProblemCounter.countChallengingSubtractionProblems();
        System.out.println("Challenging Subtraction Problem count = " + count);
    }

    @Test
    void verifyTotalSubtractionProblems() {
        int allCount = SubtractionProblemCounter.countSubtractionProblems();
        int beginnerCount = SubtractionProblemCounter.countBeginnerSubtractionProblems();
        int easyCount = SubtractionProblemCounter.countEasySubtractionProblems();
        int intermediateCount = SubtractionProblemCounter.countIntermediateSubtractionProblems();
        int moderateCount = SubtractionProblemCounter.countModerateSubtractionProblems();
        int advancedCount = SubtractionProblemCounter.countAdvancedSubtractionProblems();
        int challengingCount = SubtractionProblemCounter.countChallengingSubtractionProblems();

        assertEquals(allCount,
                beginnerCount +
                        easyCount +
                        intermediateCount +
                        moderateCount +
                        advancedCount +
                        challengingCount
        );
    }

}