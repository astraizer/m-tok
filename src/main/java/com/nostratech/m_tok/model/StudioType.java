package com.nostratech.m_tok.model;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "studio_types")
@Data
public class StudioType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;
}
