package com.nostratech.m_tok.service.impl;

import com.nostratech.m_tok.dto.response.CityDto;
import com.nostratech.m_tok.persistence.model.City;
import com.nostratech.m_tok.persistence.repository.CityRepository;
import com.nostratech.m_tok.service.CityService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {


    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<CityDto> listCity(String search) {
        String searchBy = "%"+search+"%";
        List<City> cityList = cityRepository.findByNameLikeIgnoreCase(searchBy);
        List<CityDto> cityDtos = new ArrayList<>();
        cityList.forEach(city -> {
            CityDto cityDto = new CityDto(city.getName(),city.getCode());
            cityDtos.add(cityDto);
        });
        return cityDtos;
    }
}
