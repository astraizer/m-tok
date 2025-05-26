package com.nostratech.m_tok.controller;

import com.nostratech.m_tok.dto.response.CityDto;
import com.nostratech.m_tok.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/city")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public ResponseEntity<List<CityDto>> getCity(@RequestParam(defaultValue = "") String search) {
        List<CityDto> cityDtos = cityService.listCity(search);
        return ResponseEntity.ok(cityDtos);
    }
}
