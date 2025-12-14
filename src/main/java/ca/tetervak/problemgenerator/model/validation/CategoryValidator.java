package ca.tetervak.problemgenerator.model.validation;

import ca.tetervak.problemgenerator.domain.AlgebraProblemCategory;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CategoryValidator implements ConstraintValidator<ValidCategory, String> {
    @Override
    public void initialize(ValidCategory constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        // You can access parameters from the annotation here if needed
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        try{
            AlgebraProblemCategory.fromString(s);
            return true;
        } catch (IllegalArgumentException e){
            return false;
        }
    }
}
