package com.nostratech.m_tok.model;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Table(name = "studios")
@Entity
@Data
public class Studio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "total_row",nullable = false)
    private Integer totalRow;

    @Column(name = "total_col",nullable = false)
    private Integer totalCol;

    @ManyToOne
    @JoinColumn(name = "studio_type_id", nullable = false)
    private StudioType studioType;

    @ManyToOne
    @JoinColumn(name = "cinema_id", nullable = false)
    private Cinema cinema;

}
