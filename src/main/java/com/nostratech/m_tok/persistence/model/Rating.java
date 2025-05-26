package com.nostratech.m_tok.persistence.model;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "rating")
@Entity
@Data
public class Rating {

    @Id
    private String code;

    @Column(nullable = false)
    private String name;
}
