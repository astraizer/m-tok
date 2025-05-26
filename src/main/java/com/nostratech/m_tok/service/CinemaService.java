package com.nostratech.m_tok.service;

import com.nostratech.m_tok.dto.response.CinemaDto;

import java.util.List;

public interface CinemaService {

    List<CinemaDto> listCinema(String cityCode);

}
