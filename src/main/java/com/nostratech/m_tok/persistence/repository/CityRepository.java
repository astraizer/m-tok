package com.nostratech.m_tok.persistence.repository;

import com.nostratech.m_tok.persistence.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, String> {

    List<City> findByNameLikeIgnoreCase(String name);
}
