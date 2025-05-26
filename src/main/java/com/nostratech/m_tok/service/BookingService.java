package com.nostratech.m_tok.service;

import com.nostratech.m_tok.dto.request.BookingRequestDto;
import com.nostratech.m_tok.dto.response.BookingDetailDto;
import com.nostratech.m_tok.dto.response.BookingDto;

import java.util.List;

public interface BookingService {

    Boolean booking(BookingRequestDto dto);
    List<BookingDto> bookingList(String search,Long cinemaId);
    BookingDetailDto bookingDetail(Long id);
    Boolean updateStatus(Long id);
}
