package com.nostratech.m_tok.persistence.model;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "studio_types")
@Entity
@Data
public class StudioType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;
}
