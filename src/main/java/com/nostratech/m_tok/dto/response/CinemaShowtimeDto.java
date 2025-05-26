package com.nostratech.m_tok.dto.response;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class CinemaShowtimeDto{
    private String movieName;
    private String movieImage;
    private String studioName;
    private String cinemaName;
    private BigDecimal price;
    private List<ShowtimeDto> showtimeDtos;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<ShowtimeDto> getShowtimeDtos() {
        return showtimeDtos;
    }

    public void setShowtimeDtos(List<ShowtimeDto> showtimeDtos) {
        this.showtimeDtos = showtimeDtos;
    }
}
