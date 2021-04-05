package com.endava.superhero.exception.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidator implements ConstraintValidator<ValidDate, String> {
    private static final String DATE_PATTERN = "yyyy-MM-dd";
    @Override
    public boolean isValid(String date, ConstraintValidatorContext constraintValidatorContext) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
        try {
            LocalDate.parse(date, formatter);
        } catch (DateTimeParseException exception){
            return false;
        }

        return true;
    }
}
