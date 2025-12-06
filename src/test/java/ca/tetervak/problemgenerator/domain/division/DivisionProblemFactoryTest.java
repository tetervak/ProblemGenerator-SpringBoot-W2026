package ca.tetervak.problemgenerator.domain.division;

import ca.tetervak.problemgenerator.domain.AlgebraProblem;
import ca.tetervak.problemgenerator.domain.DifficultyLevel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static ca.tetervak.problemgenerator.domain.division.DivisionDifficultyEstimator.*;
import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

class DivisionProblemFactoryTest {

    private DivisionProblemFactory factory;

    @BeforeEach
    void setUp() {
        factory = new DivisionProblemFactory(new Random(4));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createRandomBeginnerDivisionProblem() {
        for(int i = 0; i < 100; i++){
            AlgebraProblem problem =
                    factory.createRandomDivisionProblem(DifficultyLevel.BEGINNER);
            out.println(problem);
            assertTrue(isBeginnerDivisionLevel(problem.getFirstOperand(), problem.getSecondOperand()));
        }
    }

    @Test
    void createRandomEasyDivisionProblem() {
        for(int i = 0; i < 100; i++){
            AlgebraProblem problem =
                    factory.createRandomDivisionProblem(DifficultyLevel.EASY);
            out.println(problem);
            assertTrue(isEasyDivisionLevel(problem.getFirstOperand(), problem.getSecondOperand()));
        }
    }

    @Test
    void createRandomIntermediateDivisionProblem() {
        for(int i = 0; i < 100; i++){
            AlgebraProblem problem =
                    factory.createRandomDivisionProblem(DifficultyLevel.INTERMEDIATE);
            out.println(problem);
            assertTrue(isIntermediateDivisionLevel(problem.getFirstOperand(), problem.getSecondOperand()));
        }
    }

    @Test
    void createRandomModerateDivisionProblem() {
        for(int i = 0; i < 100; i++){
            AlgebraProblem problem =
                    factory.createRandomDivisionProblem(DifficultyLevel.MODERATE);
            out.println(problem);
            assertTrue(isModerateDivisionLevel(problem.getFirstOperand(), problem.getSecondOperand()));
        }
    }

    @Test
    void createRandomAdvancedDivisionProblem() {
        for(int i = 0; i < 100; i++){
            AlgebraProblem problem =
                    factory.createRandomDivisionProblem(DifficultyLevel.ADVANCED);
            out.println(problem);
            assertTrue(isAdvancedDivisionLevel(problem.getFirstOperand(), problem.getSecondOperand()));
        }
    }

    @Test
    void createRandomChallengingDivisionProblem() {
        for(int i = 0; i < 100; i++){
            AlgebraProblem problem =
                    factory.createRandomDivisionProblem(DifficultyLevel.CHALLENGING);
            out.println(problem);
            assertTrue(isChallengingDivisionLevel(problem.getFirstOperand(), problem.getSecondOperand()));
        }
    }

}