package com.nostratech.m_tok.model;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "seats")
@Data
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private boolean visible;
    private boolean available;

    @ManyToOne
    private Studio studio;
}
