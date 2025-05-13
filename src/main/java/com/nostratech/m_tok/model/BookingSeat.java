package com.nostratech.m_tok.model;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "booking_seats")
@Data
public class BookingSeat {

    @Id
    private Long id;

    @ManyToOne
    private Booking booking;

    @ManyToOne
    private Seat seat;




}
