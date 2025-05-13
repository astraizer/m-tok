package com.nostratech.m_tok.model;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Table(name = "showtimes")
@Data
public class Showtime {

    @Id
    private Long id;

    private Date startTime;

    private Date endTime;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Studio studio;
}
