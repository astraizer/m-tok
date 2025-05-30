package com.nostratech.m_tok.persistence.repository;

import com.nostratech.m_tok.persistence.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating,String> {

    Rating findByCode(String code);
}
