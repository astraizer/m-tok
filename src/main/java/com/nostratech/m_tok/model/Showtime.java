package com.nostratech.m_tok.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Table(name = "showtimes")
@Data
public class Showtime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date startTime;

    private Date endTime;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Studio studio;
}
