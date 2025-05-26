package com.nostratech.m_tok.persistence.model;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "seats")
@Entity
@Data
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number",nullable = false)
    private String number;

    @Column(nullable = false)
    private Integer x;

    @Column(nullable = false)
    private Integer y;

    @Column(nullable = false, columnDefinition = "boolean default true")
    private Boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "studio_id", nullable = false)
    private Studio studio;
}
