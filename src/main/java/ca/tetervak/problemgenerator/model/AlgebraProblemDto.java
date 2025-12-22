package ca.tetervak.problemgenerator.model;

import ca.tetervak.problemgenerator.domain.AlgebraProblem;

public record AlgebraProblemDto(
        String text,
        int answer,
        String level
) {

    public AlgebraProblemDto(AlgebraProblem algebraProblem){
        this(
                algebraProblem.getText(),
                algebraProblem.getAnswer(),
                algebraProblem.getDifficultyLevel().toString().toLowerCase()
        );
    }
}
