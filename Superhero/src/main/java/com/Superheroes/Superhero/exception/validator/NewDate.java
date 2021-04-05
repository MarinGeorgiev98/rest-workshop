package com.Superheroes.Superhero.exception.validator;


import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Target({FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = com.Superheroes.Superhero.exception.validator.NewDateValidator.class)
@Documented
public @interface NewDate {
    String message() default "Date is not allowed!";
    String current();
}
