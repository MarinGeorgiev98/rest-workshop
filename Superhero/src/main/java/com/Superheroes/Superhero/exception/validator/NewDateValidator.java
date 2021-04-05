package com.Superheroes.Superhero.exception.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class NewDateValidator  implements ConstraintValidator<NewDate, LocalDate> {

    String validDate;

    @Override
    public void initialize(NewDate constraintAnnotation) {
        validDate = constraintAnnotation.current();
    }

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        String[] splitdate = validDate.split("-");
        return localDate.isAfter(LocalDate.of(Integer.valueOf(splitdate[0]),Integer.valueOf(splitdate[1]),Integer.valueOf(splitdate[2])));
    }
}
