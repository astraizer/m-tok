package com.nostratech.m_tok.persistence.repository;

import com.nostratech.m_tok.persistence.model.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
    @Query(value = """
            select s
            from Showtime s
            where s.studio.cinema.id = :cinemaId and s.studio.studioType.id = :studioType
                and DATE(s.startTime) = :date
            """)
    List<Showtime> findByCinemaIdAndStudioType(Long cinemaId,Integer studioType, LocalDate date);

    @Query(value = """
            SELECT m.id,
                m.name,
                m.image,
                s.price,
                c.name,
                array_agg(s.id)
            from movies m 
            join showtimes s on s.movie_id = m.id
            join studios s2 on s.studio_id =s2.id
            join cinemas c on c.id = s2.cinema_id
            where s2.studio_type_id = :studioType and s2.cinema_id = :cinemaId
                and DATE(s.start_time) = :date
            group by m.id,m.name,m.image,s.price,c.name
    """,nativeQuery = true)
    List<Object []> findMovieByCinemaIdAndStudioType(Long cinemaId, Integer studioType, LocalDate date);
}
