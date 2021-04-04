package com.endava.superhero.exception.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateValidator.class)
@Documented
public @interface ValidDate {
    String message() default "Invalid date format!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
