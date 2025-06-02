package com.nostratech.m_tok.service.impl;

import com.nostratech.m_tok.dto.request.MovieRequestDto;
import com.nostratech.m_tok.dto.response.MovieDto;
import com.nostratech.m_tok.persistence.model.Movie;
import com.nostratech.m_tok.persistence.model.Rating;
import com.nostratech.m_tok.persistence.repository.MovieRepository;
import com.nostratech.m_tok.persistence.repository.RatingRepository;
import com.nostratech.m_tok.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final RatingRepository ratingRepository;

    public MovieServiceImpl(MovieRepository movieRepository, RatingRepository ratingRepository) {
        this.movieRepository = movieRepository;
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Boolean addMovie(MovieRequestDto dto) {
        Movie movie = new Movie();
        movie.setName(dto.getName());
        movie.setImage(dto.getImage());
        movie.setSynopsis(dto.getSynopsis());
        Rating rating = ratingRepository.findByCode(dto.getRating());
        movie.setRating(rating);
        movieRepository.save(movie);
        return true;
    }

    @Override
    public List<MovieDto> listMovie(String search) {
        String searchBy = "%"+search+"%";
        List<Movie> movieList = movieRepository.findByNameLikeIgnoreCase(searchBy);
        List<MovieDto> movieDtos = new ArrayList<>();
        movieList.forEach(movie -> {
            MovieDto movieDto = new MovieDto();
            movieDto.setId(movie.getId());
            movieDto.setName(movie.getName());
            movieDto.setImage(movie.getImage());
            movieDto.setDuration(movie.getDuration());
            movieDto.setGenre(movie.getGenre());
            movieDto.setRating(movie.getRating().getCode());
            movieDtos.add(movieDto);
        });
        return movieDtos;
    }
}
