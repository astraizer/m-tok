package com.nostratech.m_tok.model;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Table(name = "studio")
@Data
public class Studio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "total_row")
    private Integer totalRow;

    @Column(name = "total_col")
    private Integer totalCol;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne
    private StudioType studioType;

    @OneToMany
    private Cinema cinemas;

}
