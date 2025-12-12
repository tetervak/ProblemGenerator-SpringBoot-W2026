package ca.tetervak.problemgenerator.domain.subtraction;

import ca.tetervak.problemgenerator.domain.AlgebraProblem;
import ca.tetervak.problemgenerator.domain.DifficultyLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Random;
import static java.lang.System.out;
import static ca.tetervak.problemgenerator.domain.subtraction.SubtractionDifficultyEstimator.*;
import static org.junit.jupiter.api.Assertions.*;

class SubtractionProblemFactoryTest {

    private SubtractionProblemFactory factory;

    @BeforeEach
    void setUp() {
        factory = new SubtractionProblemFactory(new Random(4));
    }

    @Test
    void createRandomBeginnerProblem() {
        for (int i = 0; i < 100; i++) {
            AlgebraProblem problem =
                    factory.createRandomSubtractionProblem(DifficultyLevel.BEGINNER);
            out.println(problem);
            assertTrue(isBeginnerSubtractionLevel(problem.getFirstOperand(), problem.getSecondOperand()));
        }
    }

    @Test
    void createRandomEasyProblem() {
        for (int i = 0; i < 100; i++) {
            AlgebraProblem problem =
                    factory.createRandomSubtractionProblem(DifficultyLevel.EASY);
            out.println(problem);
            assertTrue(isEasySubtractionLevel(problem.getFirstOperand(), problem.getSecondOperand()));
        }
    }

    @Test
    void createRandomIntermediateProblem() {
        for (int i = 0; i < 100; i++) {
            AlgebraProblem problem =
                    factory.createRandomSubtractionProblem(DifficultyLevel.INTERMEDIATE);
            out.println(problem);
            assertTrue(isIntermediateSubtractionLevel(problem.getFirstOperand(), problem.getSecondOperand()));
        }
    }

    @Test
    void createRandomModerateProblem() {
        for (int i = 0; i < 100; i++) {
            AlgebraProblem problem =
                    factory.createRandomSubtractionProblem(DifficultyLevel.MODERATE);
            out.println(problem);
            assertTrue(isModerateSubtractionLevel(problem.getFirstOperand(), problem.getSecondOperand()));
        }
    }

    @Test
    void createRandomAdvancedProblem() {
        for (int i = 0; i < 100; i++) {
            AlgebraProblem problem =
                    factory.createRandomSubtractionProblem(DifficultyLevel.ADVANCED);
            out.println(problem);
            assertTrue(isAdvancedSubtractionLevel(problem.getFirstOperand(), problem.getSecondOperand()));
        }
    }

    @Test
    void createRandomChallengingProblem() {
        for (int i = 0; i < 100; i++) {
            AlgebraProblem problem =
                    factory.createRandomSubtractionProblem(DifficultyLevel.CHALLENGING);
            out.println(problem);
            assertTrue(isChallengingSubtractionLevel(problem.getFirstOperand(), problem.getSecondOperand()));
        }
    }

}