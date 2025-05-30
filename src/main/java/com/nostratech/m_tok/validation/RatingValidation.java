package com.nostratech.m_tok.validation;

import com.nostratech.m_tok.dto.request.BookingRequestDto;
import com.nostratech.m_tok.persistence.model.Rating;
import com.nostratech.m_tok.persistence.repository.RatingRepository;
import com.nostratech.m_tok.validation.annotation.BookingValid;
import com.nostratech.m_tok.validation.annotation.RatingValid;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RatingValidation implements ConstraintValidator<RatingValid, String> {

    private final RatingRepository ratingRepository;

    public RatingValidation(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public void initialize(RatingValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Rating rating = ratingRepository.findByCode(value);
        return rating != null;
    }
}
