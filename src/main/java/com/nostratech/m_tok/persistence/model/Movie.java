package com.nostratech.m_tok.persistence.model;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "movies")
@Entity
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String synopsis;

    @Column(nullable = false)
    private String image;

    @ManyToOne
    @JoinColumn(name = "rating", nullable = false)
    private Rating rating;

}
