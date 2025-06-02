package com.nostratech.m_tok.controller;

import com.nostratech.m_tok.dto.response.CinemaShowtimeDto;
import com.nostratech.m_tok.dto.response.ShowtimeDetailDto;
import com.nostratech.m_tok.service.ShowtimeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/showtime")
public class ShowtimeController {

    private final ShowtimeService showtimeService;

    public ShowtimeController(ShowtimeService showtimeService) {
        this.showtimeService = showtimeService;
    }

    @GetMapping
    public ResponseEntity<Object> getShowtime(@RequestParam Long cinemaId,
                                              @RequestParam Integer studioType,
                                              @RequestParam Long date) {
        List<CinemaShowtimeDto> dtos = showtimeService.listShowtime(cinemaId,studioType,date);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getShowtime(@PathVariable Long id) {
        ShowtimeDetailDto dto = showtimeService.getDetailShowTime(id);
        return ResponseEntity.ok(dto);
    }
}
