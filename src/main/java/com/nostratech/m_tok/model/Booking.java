package com.nostratech.m_tok.model;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "booking")
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Showtime showtime;

}
