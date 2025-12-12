package ca.tetervak.problemgenerator.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RequestForm {
    private int number = 5;
    private String category = "addition";
    private String level = "beginner";
}
