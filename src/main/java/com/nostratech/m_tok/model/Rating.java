package com.nostratech.m_tok.model;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "rating")
@Data
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
}
