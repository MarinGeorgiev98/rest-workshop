package com.javaschool.heroes.exception.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidator implements ConstraintValidator<DateValid, String> {
    @Override
    public boolean isValid(String dateString, ConstraintValidatorContext constraintValidatorContext) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-DD");
        try {
            LocalDate.parse(dateString, dateFormatter);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }
}
