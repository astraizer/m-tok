package com.nostratech.m_tok.validation;

import com.nostratech.m_tok.dto.request.BookingRequestDto;
import com.nostratech.m_tok.persistence.model.Booking;
import com.nostratech.m_tok.persistence.repository.BookingRepository;
import com.nostratech.m_tok.utils.StatusEnum;
import com.nostratech.m_tok.validation.annotation.BookingValid;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class BookingValidation implements ConstraintValidator<BookingValid, BookingRequestDto>  {

    private final BookingRepository bookingRepository;

    public BookingValidation(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void initialize(BookingValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(BookingRequestDto dto, ConstraintValidatorContext context) {
        List<Booking> bookings = bookingRepository.findBySeatsNumberInAndShowtimeIdAndStatusNotIn(dto.getSeatIds(), dto.getShowtimeId(), List.of(StatusEnum.EXPIRED,StatusEnum.CANCELLED));
        return bookings.isEmpty();
    }
}