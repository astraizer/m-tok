package com.nostratech.m_tok.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name = "city")
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;


    @OneToMany
    @JoinColumn(name = "cinema_id")
    private List<Cinema> cinemas;


}
