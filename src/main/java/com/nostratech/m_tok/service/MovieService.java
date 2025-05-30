package com.nostratech.m_tok.service;

import com.nostratech.m_tok.dto.request.MovieRequestDto;
import com.nostratech.m_tok.dto.response.MovieDto;

import java.util.List;

public interface MovieService {

    Boolean addMovie(MovieRequestDto dto);
    List<MovieDto> listMovie(String search);
}
