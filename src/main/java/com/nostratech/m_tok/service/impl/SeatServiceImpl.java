package com.nostratech.m_tok.service.impl;

import com.nostratech.m_tok.dto.response.SeatDto;
import com.nostratech.m_tok.dto.response.StudioSeatDto;
import com.nostratech.m_tok.persistence.model.Cinema;
import com.nostratech.m_tok.persistence.model.Movie;
import com.nostratech.m_tok.persistence.model.Showtime;
import com.nostratech.m_tok.persistence.model.Studio;
import com.nostratech.m_tok.persistence.repository.SeatRepository;
import com.nostratech.m_tok.persistence.repository.ShowtimeRepository;
import com.nostratech.m_tok.service.SeatService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;
    private final ShowtimeRepository showtimeRepository;

    public SeatServiceImpl(SeatRepository seatRepository, ShowtimeRepository showtimeRepository) {
        this.seatRepository = seatRepository;
        this.showtimeRepository = showtimeRepository;
    }

    @Override
    public StudioSeatDto listSeat(Long showTimeId) {

        StudioSeatDto studioSeatDto = new StudioSeatDto();
        Showtime showtime = showtimeRepository.findById(showTimeId)
                .orElseThrow(() -> new RuntimeException("Showtime not found"));
        Studio studio = showtime.getStudio();
        Movie movie = showtime.getMovie();
        Cinema cinema = studio.getCinema();

        studioSeatDto.setStudioName(studio.getName());
        studioSeatDto.setCinemaName(cinema.getName());
        studioSeatDto.setMovieName(movie.getName());
        studioSeatDto.setShowTimeDate(showtime.getStartTime().getTime());
        studioSeatDto.setPrice(showtime.getPrice());

        List<Object[]> seatList = seatRepository.findSeatByShowTimeId(showTimeId);
        List<SeatDto> seatDtos = new ArrayList<>();
        for (Object[] seat : seatList) {
            SeatDto seatDto = new SeatDto();
            seatDto.setId((Long) seat[0]);
            seatDto.setSeatNumber((String) seat[1]);
            seatDto.setX((Integer) seat[2]);
            seatDto.setY((Integer) seat[3]);
            seatDto.setBooked((Boolean) seat[4]);
            seatDtos.add(seatDto);
        }
        studioSeatDto.setSeatDtos(seatDtos);
        return studioSeatDto;
    }
}
