package com.nostratech.m_tok.service;

import com.nostratech.m_tok.dto.response.StudioSeatDto;

public interface SeatService {

    StudioSeatDto listSeat(Long showTimeId);
}
