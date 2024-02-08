package com.alvaroe.peliculas.common.validation.annotation;

import com.alvaroe.peliculas.common.validation.LongCountryCodeValidator;
import com.alvaroe.peliculas.common.validation.NationalDayValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LongCountryCodeValidator.class)
public @interface ValidLongCountryCode {
    String message() default "El código de país largo tiene que tener tres carácteres y estar en mayúscula";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}