package com.nostratech.m_tok.model;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "movies")
@Data
public class Movie {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "synopsis")
    private String synopsis;

    @OneToMany
    @JoinColumn(name = "rating_id")
    private Rating rating;

}
