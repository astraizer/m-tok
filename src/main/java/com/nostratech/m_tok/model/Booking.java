package com.nostratech.m_tok.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "booking")
@Data
public class Booking {

    @Id
    private Long id;

    @ManyToOne
    private Showtime showtime;

}
