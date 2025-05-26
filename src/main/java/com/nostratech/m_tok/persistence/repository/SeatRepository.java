package com.nostratech.m_tok.persistence.repository;

import com.nostratech.m_tok.persistence.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Long> {

    @Query(value = """
          select s.id,number,x,y,
          case
            WHEN bs.seat_id IS NOT NULL THEN true
              ELSE false
          END AS booked
          from seats s
          join studios s2 on s2.id = s.studio_id
          join showtimes s3 on s3.studio_id = s2.id
          left join booking_seat bs on bs.seat_id = s.id
          left join bookings b on bs.booking_id = b.id
          where s3.id = :showTimeId
          ORDER BY
            LEFT(number, 1),
            CAST(SUBSTRING(number FROM 2) AS INTEGER);
        """,nativeQuery = true)
    List<Object[]> findSeatByShowTimeId(Long showTimeId);

    List<Seat> findAllByIdIn(List<Long> ids);
}
