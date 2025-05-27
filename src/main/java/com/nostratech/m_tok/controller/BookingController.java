package com.nostratech.m_tok.controller;

import com.nostratech.m_tok.dto.request.BookingRequestDto;
import com.nostratech.m_tok.dto.response.BookingDetailDto;
import com.nostratech.m_tok.dto.response.BookingDto;
import com.nostratech.m_tok.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/booking")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<Boolean> booking(@Valid @RequestBody BookingRequestDto dto) {
        Boolean result = bookingService.booking(dto);
        return ResponseEntity.created(URI.create("/v1/booking")).body(result);
    }

    @GetMapping
    public ResponseEntity<List<BookingDto>> bookingList(@RequestParam(defaultValue = "") String search,
                                                  @RequestParam Long cinemaId) {
        List<BookingDto> bookingDtos = bookingService.bookingList(search, cinemaId);
        return ResponseEntity.ok(bookingDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDetailDto> bookingDetail(@PathVariable Long id) {
        BookingDetailDto bookingDto = bookingService.bookingDetail(id);
        return ResponseEntity.ok(bookingDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateStatus(@PathVariable Long id) {
        Boolean result = bookingService.updateStatus(id);
        return ResponseEntity.ok(result);
    }
}
