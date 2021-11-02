package com.example.myapi.controller;

import com.example.myapi.domain.MapStructMapper;
import com.example.myapi.domain.dto.GenreActors;
import com.example.myapi.domain.dto.GenreDetails;
import com.example.myapi.repository.GenreRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/genres")
public class GenreController {
    private final GenreRepository genreRepository;
    private final MapStructMapper mapStructMapper;

    public GenreController(GenreRepository genreRepository, MapStructMapper mapStructMapper) {
        this.genreRepository = genreRepository;
        this.mapStructMapper = mapStructMapper;
    }

    @GetMapping("/")
    public List<GenreDetails> getAll() {
        return mapStructMapper.toListGenreDetails(genreRepository.findAll());
    }

    @GetMapping("/{id}")
    public GenreDetails getById(@PathVariable UUID id) {
        return mapStructMapper.toGenreDetails(genreRepository.findById(id).orElse(null));
    }

    @GetMapping("/wa")
    public List<GenreActors> getGenreActors(){
        return mapStructMapper.toListGenreActors(genreRepository.listWithActors());
    }

    @GetMapping("/findByLabel")
    public List<GenreDetails> findByName(@RequestParam String label) {
        return mapStructMapper.toListGenreDetails(genreRepository.findByLabel(label));
    }

    @GetMapping("/searchByLabel")
    public List<GenreDetails> searchByName(@RequestParam String label) {
        return mapStructMapper.toListGenreDetails(genreRepository.searchByLabel(label));
    }
}
