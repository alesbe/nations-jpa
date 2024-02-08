package com.alvaroe.peliculas.common.validation.annotation;

import com.alvaroe.peliculas.common.validation.NationalDayValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NationalDayValidator.class)
public @interface ValidArea {
    String message() default "El área tiene que ser mayor a 0";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}