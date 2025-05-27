package com.nostratech.m_tok.persistence.model;


import jakarta.persistence.*;

@Table(name = "studios")
@Entity
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(Integer totalRow) {
        this.totalRow = totalRow;
    }

    public Integer getTotalCol() {
        return totalCol;
    }

    public void setTotalCol(Integer totalCol) {
        this.totalCol = totalCol;
    }

    public StudioType getStudioType() {
        return studioType;
    }

    public void setStudioType(StudioType studioType) {
        this.studioType = studioType;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }
}
