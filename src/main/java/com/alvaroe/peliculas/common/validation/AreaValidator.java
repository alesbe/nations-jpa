package com.alvaroe.peliculas.common.validation;

import com.alvaroe.peliculas.common.validation.annotation.ValidArea;
import com.alvaroe.peliculas.common.validation.annotation.ValidShortCountryCode;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AreaValidator implements ConstraintValidator<ValidArea, Float> {
    @Override
    public void initialize(ValidArea constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Float area, ConstraintValidatorContext constraintValidatorContext) {
        // Validate if is uppercase and 2 chars
        return area > 0;
    }
}