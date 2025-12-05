package ca.tetervak.problemgenerator.domain.subtraction;

import ca.tetervak.problemgenerator.domain.AlgebraProblem;
import ca.tetervak.problemgenerator.domain.DifficultyLevel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static ca.tetervak.problemgenerator.domain.subtraction.SubtractionDifficultyEstimator.*;
import static org.junit.jupiter.api.Assertions.*;

class SubtractionProblemFactoryTest {

    private SubtractionProblemFactory factory;

    @BeforeEach
    void setUp() {
        factory = new SubtractionProblemFactory(new Random(4));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createRandomBeginnerProblem() {
        for (int i = 0; i < 100; i++) {
            AlgebraProblem problem =
                    factory.createRandomSubtractionProblem(DifficultyLevel.BEGINNER);
            System.out.println(problem);
            assertTrue(isBeginnerLevel(problem.getFirstOperand(), problem.getSecondOperand()));
        }
    }

    @Test
    void createRandomEasyProblem() {
        for (int i = 0; i < 100; i++) {
            AlgebraProblem problem =
                    factory.createRandomSubtractionProblem(DifficultyLevel.EASY);
            System.out.println(problem);
            assertTrue(isEasyLevel(problem.getFirstOperand(), problem.getSecondOperand()));
        }
    }

    @Test
    void createRandomIntermediateProblem() {
        for (int i = 0; i < 100; i++) {
            AlgebraProblem problem =
                    factory.createRandomSubtractionProblem(DifficultyLevel.INTERMEDIATE);
            System.out.println(problem);
            assertTrue(isIntermediateLevel(problem.getFirstOperand(), problem.getSecondOperand()));
        }
    }

    @Test
    void createRandomModerateProblem() {
        for (int i = 0; i < 100; i++) {
            AlgebraProblem problem =
                    factory.createRandomSubtractionProblem(DifficultyLevel.MODERATE);
            System.out.println(problem);
            assertTrue(isModerateLevel(problem.getFirstOperand(), problem.getSecondOperand()));
        }
    }

    @Test
    void createRandomAdvancedProblem() {
        for (int i = 0; i < 100; i++) {
            AlgebraProblem problem =
                    factory.createRandomSubtractionProblem(DifficultyLevel.ADVANCED);
            System.out.println(problem);
            assertTrue(isAdvancedLevel(problem.getFirstOperand(), problem.getSecondOperand()));
        }
    }

    @Test
    void createRandomChallengingProblem() {
        for (int i = 0; i < 100; i++) {
            AlgebraProblem problem =
                    factory.createRandomSubtractionProblem(DifficultyLevel.CHALLENGING);
            System.out.println(problem);
            assertTrue(isChallengingLevel(problem.getFirstOperand(), problem.getSecondOperand()));
        }

    }

}