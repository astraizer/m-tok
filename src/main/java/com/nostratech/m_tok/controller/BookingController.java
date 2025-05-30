package com.nostratech.m_tok.controller;

import com.nostratech.m_tok.dto.request.BookingRequestDto;
import com.nostratech.m_tok.dto.response.BookingDetailDto;
import com.nostratech.m_tok.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

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
    public ResponseEntity<Map<String,Object>> bookingList(@RequestParam(defaultValue = "") String search,
                                                 @RequestParam(defaultValue = "0") Integer page,
                                                 @RequestParam(defaultValue = "10") Integer limit,
                                                 @RequestParam(defaultValue = "asc") String direction,
                                                 @RequestParam(defaultValue = "id") String sortBy,
                                                  @RequestParam Long cinemaId) {

        Pageable pageable = PageRequest.of(page, limit, Sort.by(direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy));
        Map<String, Object> bookingDtos = bookingService.bookingList(search, cinemaId,pageable);
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
