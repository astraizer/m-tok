package com.nostratech.m_tok.controller;

import com.nostratech.m_tok.dto.response.StudioSeatDto;
import com.nostratech.m_tok.service.SeatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/seat")
public class SeatController {

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping
    public ResponseEntity<StudioSeatDto> getSeat(@RequestParam Long showtimeId) {
        StudioSeatDto studioSeatDto = seatService.listSeat(showtimeId);
        return ResponseEntity.ok(studioSeatDto);
    }
}
