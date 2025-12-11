package ca.tetervak.problemgenerator.domain;

import ca.tetervak.problemgenerator.domain.addition.AdditionProblemCounter;
import ca.tetervak.problemgenerator.domain.division.DivisionProblemCounter;
import ca.tetervak.problemgenerator.domain.multiplication.MultiplicationProblemCounter;
import ca.tetervak.problemgenerator.domain.subtraction.SubtractionProblemCounter;

public class AlgebraProblemCounter {

    private final CountsByCategoriesAndLevels problemCounts;

    public AlgebraProblemCounter() {
        AdditionProblemCounter additionProblemCounter = new AdditionProblemCounter();
        SubtractionProblemCounter subtractionProblemCounter = new SubtractionProblemCounter();
        MultiplicationProblemCounter multiplicationProblemCounter = new MultiplicationProblemCounter();
        DivisionProblemCounter divisionProblemCounter = new DivisionProblemCounter();

        CountsByLevels additionCounts = additionProblemCounter.getCountsByLevels();
        CountsByLevels subtractionCounts = subtractionProblemCounter.getCountsByLevels();
        CountsByLevels multiplicationCounts = multiplicationProblemCounter.getCountsByLevels();
        CountsByLevels divisionCounts = divisionProblemCounter.getCountsByLevels();

        int total = additionCounts.total() + subtractionCounts.total() +
                multiplicationCounts.total() + divisionCounts.total();

        this.problemCounts = new CountsByCategoriesAndLevels(
                additionCounts,
                subtractionCounts,
                multiplicationCounts,
                divisionCounts,
                total
        );
    }

    public CountsByCategoriesAndLevels getProblemCounts() {
        return problemCounts;
    }

    public CountsByLevels getCountsByCategory(AlgebraProblemCategory category) {
        return switch (category) {
            case ADDITION -> problemCounts.addition();
            case SUBTRACTION -> problemCounts.subtraction();
            case MULTIPLICATION -> problemCounts.multiplication();
            case DIVISION -> problemCounts.division();
        };
    }

    public int getProblemCountByCategoryAndLevel(
            AlgebraProblemCategory category,
            DifficultyLevel level
    ) {
        return getCountsByCategory(category).getCountByLevel(level);
    }

}
