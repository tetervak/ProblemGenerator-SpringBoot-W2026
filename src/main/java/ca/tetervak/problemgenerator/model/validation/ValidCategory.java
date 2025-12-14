package ca.tetervak.problemgenerator.model.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CategoryValidator.class)  // Link to the validator class
@Target({ ElementType.FIELD, ElementType.PARAMETER })  // Where it can be used
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCategory {
    String message() default "Invalid problem category";  // Default error message
    Class<?>[] groups() default {};  // For validation groups
    Class<? extends Payload>[] payload() default {};  // For severity/metadata
}