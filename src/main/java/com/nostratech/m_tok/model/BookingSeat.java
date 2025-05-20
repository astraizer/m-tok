package com.nostratech.m_tok.model;

import jakarta.persistence.*;
import lombok.Data;

@Table(
        name = "booking_seats",
        uniqueConstraints = @UniqueConstraint(columnNames = {"booking_id", "seat_id"})
)
@Entity
@Data
public class BookingSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "showtime_id", nullable = false)
    private Showtime showtime;

    @ManyToOne
    @JoinColumn(name = "seat_id", nullable = false)
    private Seat seat;




}
