package com.nostratech.m_tok.dto.request;

import com.nostratech.m_tok.validation.annotation.BookingValid;

import java.math.BigDecimal;
import java.util.List;

@BookingValid
public class BookingRequestDto {
    private Long userId;
    private Long showtimeId;
    private List<Long> seatIds;
    private BigDecimal totalPrice;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(Long showtimeId) {
        this.showtimeId = showtimeId;
    }

    public List<Long> getSeatIds() {
        return seatIds;
    }

    public void setSeatIds(List<Long> seatIds) {
        this.seatIds = seatIds;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
