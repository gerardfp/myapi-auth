package com.example.myapi.controller;

import com.example.myapi.domain.MapStructMapper;
import com.example.myapi.domain.dto.MovieCreateRequest;
import com.example.myapi.domain.dto.MovieDetails;
import com.example.myapi.domain.model.Movie;
import com.example.myapi.repository.MovieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieRepository movieRepository;
    private final MapStructMapper mapStructMapper;

    public MovieController(MovieRepository movieRepository, MapStructMapper mapStructMapper) {
        this.movieRepository = movieRepository;
        this.mapStructMapper = mapStructMapper;
    }

    @GetMapping("/")
    public List<MovieDetails> getAll() {
        return mapStructMapper.toListMovieDetails(movieRepository.findAll());
    }

    @GetMapping("/{id}")
    public MovieDetails getById(@PathVariable UUID id) {
        movieRepository.findAll();

        return mapStructMapper.toMovieDetails(movieRepository.findById(id).orElse(null));
    }

    @GetMapping("/findByTitle")
    public List<MovieDetails> findByTitle(@RequestParam String title) {
        return mapStructMapper.toListMovieDetails(movieRepository.findByTitle(title));
    }

    @GetMapping("/searchByTitle")
    public List<MovieDetails> searchByTitle(@RequestParam String title) {
        return mapStructMapper.toListMovieDetails(movieRepository.searchByTitle(title));
    }

    @PostMapping("/")
    public Movie create(@RequestBody MovieCreateRequest movieCreateRequest) {
        System.out.println(movieCreateRequest.title + "   !!!  " + movieCreateRequest.synopsis);
        return movieRepository.save(mapStructMapper.toMovie(movieCreateRequest));
    }
}
