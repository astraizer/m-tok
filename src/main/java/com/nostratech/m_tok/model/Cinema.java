package com.nostratech.m_tok.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name = "cinemas")
@Data
public class Cinema {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany
    @JoinColumn(name = "studio_id")
    private List<Studio> studio;


}
