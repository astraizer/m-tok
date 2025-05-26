package com.nostratech.m_tok.dto.response;

import java.math.BigDecimal;

public class ShowtimeDetailDto {
    private String movieName;
    private String movieImage;
    private String studioName;
    private String cinemaName;
    private Long showtimeDate;
    private BigDecimal price;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(String movieImage) {
        this.movieImage = movieImage;
    }

    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public Long getShowtimeDate() {
        return showtimeDate;
    }

    public void setShowtimeDate(Long showtimeDate) {
        this.showtimeDate = showtimeDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
