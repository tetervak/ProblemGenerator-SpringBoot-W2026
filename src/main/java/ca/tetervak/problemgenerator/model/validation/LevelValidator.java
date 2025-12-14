package ca.tetervak.problemgenerator.model.validation;

import ca.tetervak.problemgenerator.domain.DifficultyLevel;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LevelValidator implements ConstraintValidator<ValidLevel, String> {
    @Override
    public void initialize(ValidLevel constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        // You can access parameters from the annotation here if needed
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return DifficultyLevel.fromString(s) != DifficultyLevel.UNKNOWN;
    }
}
