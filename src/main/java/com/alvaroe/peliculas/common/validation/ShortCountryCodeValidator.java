package com.alvaroe.peliculas.common.validation;

import com.alvaroe.peliculas.common.validation.annotation.ValidNationalDay;
import com.alvaroe.peliculas.common.validation.annotation.ValidShortCountryCode;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class ShortCountryCodeValidator implements ConstraintValidator<ValidShortCountryCode, String> {
    @Override
    public void initialize(ValidShortCountryCode constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String shortCountryCode, ConstraintValidatorContext constraintValidatorContext) {
        // Validate if is uppercase and 2 chars
        return shortCountryCode.length() == 2 && shortCountryCode.toUpperCase().equals(shortCountryCode);
    }
}
