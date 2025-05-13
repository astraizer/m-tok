package com.nostratech.m_tok.model;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "seats")
@Data
public class Seat {
    @Id
    private Long id;
    private String number;
    private boolean visible;
    private boolean available;

    @ManyToOne
    private Studio studio;
}
