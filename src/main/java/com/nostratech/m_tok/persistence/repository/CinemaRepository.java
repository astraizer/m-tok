package com.nostratech.m_tok.persistence.repository;

import com.nostratech.m_tok.persistence.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    @Query("SELECT c FROM Cinema c WHERE c.city.code = :code")
    List<Cinema> findByCityCode(String code);
}
