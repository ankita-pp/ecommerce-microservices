package com.example.demo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {NumericStringValidator.class})
@Documented
public @interface NumericString {
    String message() default "String should be numeric";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}