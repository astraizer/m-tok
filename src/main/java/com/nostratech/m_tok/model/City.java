package com.nostratech.m_tok.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name = "city")
@Entity
@Data
public class City {
    @Id
    private String code;

    @Column(nullable = false)
    private String name;


}
