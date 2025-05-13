package com.nostratech.m_tok.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name = "studio")
@Data
public class Studio {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "total_row")
    private Integer totalRow;

    @Column(name = "total_col")
    private Integer totalCol;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    private StudioType studioType;

    @OneToMany
    private Cinema cinemas;

}
