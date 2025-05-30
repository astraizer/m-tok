package com.nostratech.m_tok.validation.annotation;

import com.nostratech.m_tok.validation.BookingValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(TYPE)
@Constraint(validatedBy = {BookingValidation.class})
public @interface BookingValid {


    String message() default "Booking not valid";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
