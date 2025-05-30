package com.nostratech.m_tok.persistence.repository;

import com.nostratech.m_tok.persistence.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Long> {

    List<Movie> findByNameLikeIgnoreCase(String name);
}
