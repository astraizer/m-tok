package com.nostratech.m_tok.service;

import com.nostratech.m_tok.dto.response.CityDto;

import java.util.List;

public interface CityService {

    List<CityDto> listCity(String search);
}
