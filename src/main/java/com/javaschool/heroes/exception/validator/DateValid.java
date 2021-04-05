package com.javaschool.heroes.exception.validator;

import javax.validation.Constraint;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = com.javaschool.heroes.exception.validator.DateValidator.class)
public @interface DateValid {
    String message() default "The date is not valid";

}
