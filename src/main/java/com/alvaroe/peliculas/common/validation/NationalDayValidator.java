package com.alvaroe.peliculas.common.validation;

import com.alvaroe.peliculas.common.validation.annotation.ValidNationalDay;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.util.Date;

public class NationalDayValidator implements ConstraintValidator<ValidNationalDay, LocalDate> {

    private static final LocalDate minDate = LocalDate.of(1500, 1, 1);

    @Override
    public void initialize(ValidNationalDay constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(LocalDate nationalDay, ConstraintValidatorContext constraintValidatorContext) {
        // Validate if national day is after year 1500
        return nationalDay.isAfter(minDate);
    }
}