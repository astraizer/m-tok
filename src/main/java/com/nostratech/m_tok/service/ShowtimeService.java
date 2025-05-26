package com.nostratech.m_tok.service;

import com.nostratech.m_tok.dto.response.CinemaShowtimeDto;
import com.nostratech.m_tok.dto.response.ShowtimeDetailDto;

import java.util.List;

public interface ShowtimeService {

    List<CinemaShowtimeDto> listShowtime(Long cinemaId, Integer studioType);
    ShowtimeDetailDto getDetailShowTime(Long showtimeId);
}
