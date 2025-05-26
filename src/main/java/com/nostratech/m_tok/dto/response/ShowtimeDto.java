package com.nostratech.m_tok.dto.response;

public class ShowtimeDto{
    private Long id;
    private Long time;
    private Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
