package ca.tetervak.problemgenerator.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CompareForm {
    private String firstLevel = "beginner";
    private String secondLevel = "easy";
    private int number = 0;
}
