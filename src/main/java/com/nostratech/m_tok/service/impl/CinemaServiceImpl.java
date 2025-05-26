package com.nostratech.m_tok.service.impl;

import com.nostratech.m_tok.dto.response.CinemaDto;
import com.nostratech.m_tok.persistence.model.Cinema;
import com.nostratech.m_tok.persistence.repository.CinemaRepository;
import com.nostratech.m_tok.service.CinemaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {

    private final CinemaRepository cinemaRepository;

    public CinemaServiceImpl(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @Override
    public List<CinemaDto> listCinema(String cityCode) {
        List<Cinema> cinemas = cinemaRepository.findByCityCode(cityCode);
        return cinemas.stream().map(c -> new CinemaDto(c.getId(),c.getName())).toList();
    }
}
