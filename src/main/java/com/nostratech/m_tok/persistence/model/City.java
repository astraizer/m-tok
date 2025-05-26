package com.nostratech.m_tok.persistence.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name = "city")
@Entity
public class City {
    @Id
    private String code;

    @Column(nullable = false)
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
