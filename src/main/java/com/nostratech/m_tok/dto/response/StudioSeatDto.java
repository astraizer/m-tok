package com.nostratech.m_tok.dto.response;

import java.math.BigDecimal;
import java.util.List;

public class StudioSeatDto {

    private String cinemaName;
    private String studioName;
    private String movieName;
    private Long showTimeDate;
    private BigDecimal price;
    private List<SeatDto> seatDtos;

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Long getShowTimeDate() {
        return showTimeDate;
    }

    public void setShowTimeDate(Long showTimeDate) {
        this.showTimeDate = showTimeDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<SeatDto> getSeatDtos() {
        return seatDtos;
    }

    public void setSeatDtos(List<SeatDto> seatDtos) {
        this.seatDtos = seatDtos;
    }
}
