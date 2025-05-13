package com.nostratech.m_tok.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "rating")
@Data
public class Rating {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;
}
