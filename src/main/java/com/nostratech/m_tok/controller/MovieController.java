package com.nostratech.m_tok.controller;

import com.nostratech.m_tok.dto.request.MovieRequestDto;
import com.nostratech.m_tok.dto.response.MovieDto;
import com.nostratech.m_tok.service.FileService;
import com.nostratech.m_tok.service.MovieService;
import com.nostratech.m_tok.service.impl.FileServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/v1/movie")
public class MovieController {

    private final FileService fileService;
    private final MovieService movieService;

    public MovieController(FileService fileService, MovieService movieService) {
        this.fileService = fileService;
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> getMovie(@RequestParam(defaultValue = "") String search) {
        List<MovieDto> result = movieService.listMovie(search);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Boolean> testing(@Valid @RequestBody MovieRequestDto dto) {
        Boolean result = movieService.addMovie(dto);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/upload-image")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file,@RequestParam() String filename) throws Exception {
        String result = fileService.uploadFile(file,filename);
        return ResponseEntity.ok(result);
    }
}
