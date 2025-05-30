package com.nostratech.m_tok.service.impl;

import com.nostratech.m_tok.dto.request.BookingRequestDto;
import com.nostratech.m_tok.dto.response.BookingDetailDto;
import com.nostratech.m_tok.dto.response.BookingDto;
import com.nostratech.m_tok.persistence.model.*;
import com.nostratech.m_tok.persistence.repository.*;
import com.nostratech.m_tok.service.BookingService;
import com.nostratech.m_tok.utils.StatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;
    private final ShowtimeRepository showtimeRepository;
    private final SeatRepository seatRepository;

    public BookingServiceImpl(UserRepository userRepository,
                              BookingRepository bookingRepository,
                              ShowtimeRepository showtimeRepository,
                              SeatRepository seatRepository) {
        this.userRepository = userRepository;
        this.bookingRepository = bookingRepository;
        this.showtimeRepository = showtimeRepository;
        this.seatRepository = seatRepository;
    }

    @Transactional
    @Override
    public Boolean booking(BookingRequestDto dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Showtime showtime = showtimeRepository.findById(dto.getShowtimeId())
                .orElseThrow(() -> new RuntimeException("Showtime not found"));

        Studio studio = showtime.getStudio();

        List<Seat> seats = seatRepository.findAllByIdIn(dto.getSeatIds());

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setTotalPrice(dto.getTotalPrice());
        booking.setStatus(StatusEnum.PENDING);
        booking.setStudio(studio);
        booking.setSeats(seats);
        booking.setShowtime(showtime);

        booking = bookingRepository.save(booking);
        return true;
    }

    @Override
    public Map<String, Object> bookingList(String search, Long cinemaId, Pageable pageable) {

        List<StatusEnum> status = new ArrayList<>(List.of(StatusEnum.PENDING));
        Page<Booking> bookingPage = bookingRepository.findAllBySearchAndCinemaAndStatusIn("%"+search+"%",cinemaId,status,pageable);
        List<Booking> bookings = bookingPage.getContent();
        List<BookingDto> dtos = new ArrayList<>();
        for(Booking booking : bookings) {
            User user = booking.getUser();
            Studio studio = booking.getStudio();
            Showtime showtime = booking.getShowtime();
            BookingDto dto = new BookingDto();
            dto.setId(booking.getId());
            dto.setUsername(user.getName());
            dto.setStudioName(studio.getName());
            dto.setTime(showtime.getStartTime().getTime());
            dto.setMovieName(showtime.getMovie().getName());
            dto.setStatus(booking.getStatus().name());
            dtos.add(dto);
        }
        Map<String, Object> map = new HashMap<>();

        map.put("content",dtos);
        map.put("totalElements",bookingPage.getTotalElements());
        map.put("totalPages",bookingPage.getTotalPages());
        return map;
    }

    @Override
    public BookingDetailDto bookingDetail(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        BookingDetailDto dto = new BookingDetailDto();
        dto.setId(booking.getId());
        dto.setUsername(booking.getUser().getName());
        dto.setStudioName(booking.getStudio().getName());
        dto.setStudioType(booking.getStudio().getStudioType().getName());
        dto.setTime(booking.getShowtime().getStartTime().getTime());
        dto.setMovieName(booking.getShowtime().getMovie().getName());
        dto.setStatus(booking.getStatus().name());
        dto.setSeatNumber(booking.getSeats().stream()
                .map(Seat::getNumber)
                .collect(Collectors.joining(",")));
        dto.setPrice(booking.getTotalPrice());
        return dto;
    }

    @Override
    public Boolean updateStatus(Long id) {

        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        booking.setStatus(StatusEnum.PAID);
        bookingRepository.save(booking);

        return true;
    }
}
