package com.alvaroe.peliculas.common.validation;

import com.alvaroe.peliculas.common.validation.annotation.ValidLongCountryCode;
import com.alvaroe.peliculas.common.validation.annotation.ValidShortCountryCode;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LongCountryCodeValidator implements ConstraintValidator<ValidLongCountryCode, String> {
    @Override
    public void initialize(ValidLongCountryCode constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String longCountryCode, ConstraintValidatorContext constraintValidatorContext) {
        // Validate if is uppercase and 2 chars
        return longCountryCode.length() == 3 && longCountryCode.toUpperCase().equals(longCountryCode);
    }
}