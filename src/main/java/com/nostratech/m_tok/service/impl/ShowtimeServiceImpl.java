package com.nostratech.m_tok.service.impl;

import com.nostratech.m_tok.dto.response.CinemaShowtimeDto;
import com.nostratech.m_tok.dto.response.ShowtimeDetailDto;
import com.nostratech.m_tok.dto.response.ShowtimeDto;
import com.nostratech.m_tok.persistence.model.Showtime;
import com.nostratech.m_tok.persistence.repository.ShowtimeRepository;
import com.nostratech.m_tok.service.ShowtimeService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class ShowtimeServiceImpl implements ShowtimeService {

    private final ShowtimeRepository showtimeRepository;

    public ShowtimeServiceImpl(ShowtimeRepository showtimeRepository) {
        this.showtimeRepository = showtimeRepository;
    }

    @Override
    public List<CinemaShowtimeDto> listShowtime(Long cinemaId, Integer studioType) {

        List<Showtime> showtimes = showtimeRepository.findByCinemaIdAndStudioType(cinemaId,studioType);
        Map<Long, ShowtimeDto> showtimeDtos = new HashMap<>();
        for (Showtime showtime : showtimes) {
            ShowtimeDto showtimeDto = new ShowtimeDto();
            showtimeDto.setId(showtime.getId());
            showtimeDto.setTime(showtime.getStartTime().getTime());
            showtimeDto.setPrice(showtime.getPrice().doubleValue());
            showtimeDtos.put(showtime.getId(), showtimeDto);
        }

        List<CinemaShowtimeDto> dtos = new ArrayList<>();
        List<Object[]> moviesShowTime = showtimeRepository.findMovieByCinemaIdAndStudioType(cinemaId,studioType);
        for (Object[] showtime : moviesShowTime) {
            CinemaShowtimeDto cinemaShowtimeDto = new CinemaShowtimeDto();
            cinemaShowtimeDto.setMovieName((String) showtime[1]);
            cinemaShowtimeDto.setMovieImage((String) showtime[2]);
            BigDecimal priceDecimal = (BigDecimal) showtime[3];
            cinemaShowtimeDto.setPrice(priceDecimal);
            cinemaShowtimeDto.setCinemaName((String) showtime[4]);
            Long[] ids = (Long[]) showtime[5];
            List<ShowtimeDto> showtimeDto = new ArrayList<>();
            for (Long id : ids) {
                ShowtimeDto dto = showtimeDtos.get(id);
                showtimeDto.add(dto);
            }
            cinemaShowtimeDto.setShowtimeDtos(showtimeDto);
            dtos.add(cinemaShowtimeDto);

        }
        return dtos;
    }

    @Override
    public ShowtimeDetailDto getDetailShowTime(Long showtimeId) {
        Showtime showtime = showtimeRepository.findById(showtimeId)
                .orElseThrow(() -> new RuntimeException("Showtime not found"));
        ShowtimeDetailDto showtimeDetailDto = new ShowtimeDetailDto();
        showtimeDetailDto.setMovieName(showtime.getMovie().getName());
        showtimeDetailDto.setMovieImage(showtime.getMovie().getImage());
        showtimeDetailDto.setPrice(showtime.getPrice());
        showtimeDetailDto.setCinemaName(showtime.getStudio().getCinema().getName());
        showtimeDetailDto.setStudioName(showtime.getStudio().getName());
        showtimeDetailDto.setShowtimeDate(showtime.getStartTime().getTime());

        return showtimeDetailDto;
    }
}
