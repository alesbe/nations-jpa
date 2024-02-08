package com.alvaroe.peliculas.common.validation.annotation;

import com.alvaroe.peliculas.common.validation.NationalDayValidator;
import com.alvaroe.peliculas.common.validation.ShortCountryCodeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ShortCountryCodeValidator.class)
public @interface ValidShortCountryCode {
    String message() default "El código de país corto tiene que tener dos carácteres y estar en mayúscula";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}