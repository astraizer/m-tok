package com.nostratech.m_tok.controller;

import com.nostratech.m_tok.dto.response.CinemaDto;
import com.nostratech.m_tok.service.CinemaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/cinema")
public class CinemaController {

    private final CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping
    public ResponseEntity<List<CinemaDto>> getCinema(@RequestParam String cityCode) {
        List<CinemaDto> cinemaDtos = cinemaService.listCinema(cityCode);
        return ResponseEntity.ok(cinemaDtos);
    }
}
