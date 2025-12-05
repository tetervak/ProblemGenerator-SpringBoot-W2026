package ca.tetervak.problemgenerator.domain.addition;

import ca.tetervak.problemgenerator.domain.AlgebraProblem;
import ca.tetervak.problemgenerator.domain.DifficultyLevel;
import static java.lang.System.out;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static ca.tetervak.problemgenerator.domain.addition.AdditionDifficultyEstimator.*;
import static org.junit.jupiter.api.Assertions.*;

class AdditionProblemFactoryTest {

    private AdditionProblemFactory factory;

    @BeforeEach
    void setUp() {
        factory = new AdditionProblemFactory(new Random(4));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createRandomBeginnerAdditionProblem() {
        for(int i = 0; i < 100; i++){
            AlgebraProblem problem = factory.createRandomAdditionProblem(DifficultyLevel.BEGINNER);
            out.println(problem);
            assertTrue(isBeginnerAdditionLevel(problem.getFirstOperand(), problem.getSecondOperand()));
        }
    }


    @Test
    void createRandomEasyAdditionProblem() {
        for(int i = 0; i < 100; i++){
            AlgebraProblem problem =
                    factory.createRandomAdditionProblem(DifficultyLevel.EASY);
            out.println(problem);
            assertTrue(isEasyAdditionLevel(problem.getFirstOperand(), problem.getSecondOperand()));
        }
    }

    @Test
    void createRandomIntermediateAdditionProblem() {
        for(int i = 0; i < 100; i++){
            AlgebraProblem problem =
                    factory.createRandomAdditionProblem(DifficultyLevel.INTERMEDIATE);
            out.println(problem);
            assertTrue(isIntermediateAdditionLevel(problem.getFirstOperand(), problem.getSecondOperand()));
        }
    }

    @Test
    void createRandomModerateAdditionProblem() {
        for(int i = 0; i < 100; i++){
            AlgebraProblem problem =
                    factory.createRandomAdditionProblem(DifficultyLevel.MODERATE);
            out.println(problem);
            assertTrue(isModerateAdditionLevel(problem.getFirstOperand(), problem.getSecondOperand()));
        }
    }

    @Test
    void createRandomAdvancedAdditionProblem() {
        for(int i = 0; i < 100; i++){
            AlgebraProblem problem =
                    factory.createRandomAdditionProblem(DifficultyLevel.ADVANCED);
            out.println(problem);
            assertTrue(isAdvancedAdditionLevel(problem.getFirstOperand(), problem.getSecondOperand()));
        }
    }

    @Test
    void createRandomChallengingAdditionProblem() {
        for(int i = 0; i < 100; i++){
            AlgebraProblem problem =
                    factory.createRandomAdditionProblem(DifficultyLevel.CHALLENGING);
            out.println(problem);
            assertTrue(isChallengingAdditionLevel(problem.getFirstOperand(), problem.getSecondOperand()));
        }
    }

}