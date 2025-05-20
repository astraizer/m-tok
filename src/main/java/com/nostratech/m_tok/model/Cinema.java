package com.nostratech.m_tok.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name = "cinemas")
@Entity
@Data
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "city", nullable = false)
    private City city;


}
