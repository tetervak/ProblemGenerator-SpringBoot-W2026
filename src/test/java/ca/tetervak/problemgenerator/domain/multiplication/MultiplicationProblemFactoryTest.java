package ca.tetervak.problemgenerator.domain.multiplication;

import ca.tetervak.problemgenerator.domain.AlgebraProblem;
import ca.tetervak.problemgenerator.domain.DifficultyLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static ca.tetervak.problemgenerator.domain.multiplication.MultiplicationDifficultyEstimator.*;
import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

class MultiplicationProblemFactoryTest {

    private MultiplicationProblemFactory factory;

    @BeforeEach
    void setUp() {
        factory = new MultiplicationProblemFactory(new Random(4));
    }

    @Test
    void createRandomBeginnerMultiplicationProblem() {
        for(int i = 0; i < 100; i++){
            AlgebraProblem problem =
                    factory.createRandomMultiplicationProblem(DifficultyLevel.BEGINNER);
            out.println(problem);
            assertTrue(isBeginnerMultiplicationLevel(problem.getFirstOperand(), problem.getSecondOperand()));
        }
    }

    @Test
    void createRandomEasyMultiplicationProblem() {
        for(int i = 0; i < 100; i++){
            AlgebraProblem problem =
                    factory.createRandomMultiplicationProblem(DifficultyLevel.EASY);
            out.println(problem);
            assertTrue(isEasyMultiplicationLevel(problem.getFirstOperand(), problem.getSecondOperand()));
        }
    }

    @Test
    void createRandomIntermediateMultiplicationProblem() {
        for(int i = 0; i < 100; i++){
            AlgebraProblem problem =
                    factory.createRandomMultiplicationProblem(DifficultyLevel.INTERMEDIATE);
            out.println(problem);
            assertTrue(isIntermediateMultiplicationLevel(problem.getFirstOperand(), problem.getSecondOperand()));
        }
    }

    @Test
    void createRandomModerateMultiplicationProblem() {
        for(int i = 0; i < 100; i++){
            AlgebraProblem problem =
                    factory.createRandomMultiplicationProblem(DifficultyLevel.MODERATE);
            out.println(problem);
            assertTrue(isModerateMultiplicationLevel(problem.getFirstOperand(), problem.getSecondOperand()));
        }
    }

    @Test
    void createRandomAdvancedMultiplicationProblem() {
        for(int i = 0; i < 100; i++){
            AlgebraProblem problem =
                    factory.createRandomMultiplicationProblem(DifficultyLevel.ADVANCED);
            out.println(problem);
            assertTrue(isAdvancedMultiplicationLevel(problem.getFirstOperand(), problem.getSecondOperand()));
        }
    }

    @Test
    void createRandomChallengingMultiplicationProblem() {
        for(int i = 0; i < 100; i++){
            AlgebraProblem problem =
                    factory.createRandomMultiplicationProblem(DifficultyLevel.CHALLENGING);
            out.println(problem);
            assertTrue(isChallengingMultiplicationLevel(problem.getFirstOperand(), problem.getSecondOperand()));
        }
    }

}