package com.nostratech.m_tok.persistence.repository;

import com.nostratech.m_tok.persistence.model.Booking;
import com.nostratech.m_tok.utils.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query(value = """
    SELECT b
    FROM Booking b
    WHERE b.studio.cinema.id = :cinemaId
    AND UPPER(b.user.name) LIKE UPPER(:search)
    AND b.status IN :status
    """)
    List<Booking> findAllBySearchAndCinemaAndStatusIn(String search,Long cinemaId,List<StatusEnum> status);
}
