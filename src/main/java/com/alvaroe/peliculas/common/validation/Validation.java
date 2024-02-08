package com.alvaroe.peliculas.common.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;

import java.util.Set;

import static jakarta.validation.Validation.buildDefaultValidatorFactory;

public class Validation {

    // Your IDE may complain that the ValidatorFactory needs to be closed, but if we do that here,
    // we break the contract of ValidatorFactory#close.
    private final static Validator validator = buildDefaultValidatorFactory().getValidator();

    public static <T> void validate (T subject) {
        Set<ConstraintViolation<T>> violations = validator.validate(subject);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

}