package com.nostratech.m_tok.service;

import com.nostratech.m_tok.dto.request.BookingRequestDto;
import com.nostratech.m_tok.dto.response.BookingDetailDto;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface BookingService {

    Boolean booking(BookingRequestDto dto);
    Map<String, Object> bookingList(String search, Long cinemaId, Pageable pageable);
    BookingDetailDto bookingDetail(Long id);
    Boolean updateStatus(Long id);
}
