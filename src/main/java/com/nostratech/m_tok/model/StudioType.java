package com.nostratech.m_tok.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "studio_types")
@Data
public class StudioType {
    @Id
    private int id;

    @Column(name = "name")
    private String name;
}
