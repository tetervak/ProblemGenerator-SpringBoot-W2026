package ca.tetervak.problemgenerator.model.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = LevelValidator.class)  // Link to the validator class
@Target({ ElementType.FIELD, ElementType.PARAMETER })  // Where it can be used
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidLevel {
    String message() default "Invalid difficulty level";  // Default error message
    Class<?>[] groups() default {};  // For validation groups
    Class<? extends Payload>[] payload() default {};  // For severity/metadata
}

