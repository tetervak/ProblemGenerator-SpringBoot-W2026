package ca.tetervak.problemgenerator.model;

import ca.tetervak.problemgenerator.domain.AlgebraProblem;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "AlgebraProblem", description = "Generated Algebra Problem")
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
