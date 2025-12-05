package ca.tetervak.problemgenerator.domain.subtraction;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static java.lang.System.out;

class SubtractionProblemCounterTest {

    @Test
    void countSubtractionProblems() {
        int count = SubtractionProblemCounter.countSubtractionProblems();
        out.printf("Subtraction Problem count = %d%n", count);
    }

    @Test
    void countBeginnerSubtractionProblems() {
        int count = SubtractionProblemCounter.countBeginnerSubtractionProblems();
        out.printf("Beginner Subtraction Problem count = %d%n", count);
    }

    @Test
    void countEasySubtractionProblems() {
        int count = SubtractionProblemCounter.countEasySubtractionProblems();
        out.printf("Easy Subtraction Problem count = %d%n", count);
    }

    @Test
    void countIntermediateSubtractionProblems() {
        int count = SubtractionProblemCounter.countIntermediateSubtractionProblems();
        out.printf("Intermediate Subtraction Problem count = %d%n", count);
    }

    @Test
    void countModerateSubtractionProblems() {
        int count = SubtractionProblemCounter.countModerateSubtractionProblems();
        out.printf("Moderate Subtraction Problem count = %d%n", count);
    }

    @Test
    void countAdvancedSubtractionProblems() {
        int count = SubtractionProblemCounter.countAdvancedSubtractionProblems();
        out.printf("Advanced Subtraction Problem count = %d%n", count);
    }

    @Test
    void countChallengingSubtractionProblems() {
        int count = SubtractionProblemCounter.countChallengingSubtractionProblems();
        out.printf("Challenging Subtraction Problem count = %d%n", count);
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