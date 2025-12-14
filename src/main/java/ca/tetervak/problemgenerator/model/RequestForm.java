package ca.tetervak.problemgenerator.model;

import ca.tetervak.problemgenerator.model.validation.ValidCategory;
import ca.tetervak.problemgenerator.model.validation.ValidLevel;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RequestForm {

    @Min(value = 1, message = "Number must be at least 1")
    @Max(value = 10, message = "Number must be at most 10")
    private int number = 5;

    @ValidCategory
    private String category = "select";

    @ValidLevel
    private String level = "select";
}
