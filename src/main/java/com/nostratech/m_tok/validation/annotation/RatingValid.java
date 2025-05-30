package com.nostratech.m_tok.validation.annotation;

import com.nostratech.m_tok.validation.BookingValidation;
import com.nostratech.m_tok.validation.RatingValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = {RatingValidation.class})
public @interface RatingValid {
    String message() default "Rating Error";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
