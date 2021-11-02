package com.example.myapi.controller;

import com.example.myapi.domain.MapStructMapper;
import com.example.myapi.domain.dto.ActorDetails;
import com.example.myapi.repository.ActorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/actors")
public class ActorController {
    private final ActorRepository actorRepository;
    private final MapStructMapper mapStructMapper;

    public ActorController(ActorRepository actorRepository, MapStructMapper mapStructMapper) {
        this.actorRepository = actorRepository;
        this.mapStructMapper = mapStructMapper;
    }

    @GetMapping("/")
    public List<ActorDetails> getAll() {
        return mapStructMapper.toListActorDetails(actorRepository.findAll());
    }

    @GetMapping("/{id}")
    public ActorDetails getById(@PathVariable UUID id) {
        return mapStructMapper.toActorDetails(actorRepository.findById(id).orElse(null));
    }

    @GetMapping("/findByName")
    public List<ActorDetails> findByName(@RequestParam String name) {
        return mapStructMapper.toListActorDetails(actorRepository.findByName(name));
    }

    @GetMapping("/searchByName")
    public List<ActorDetails> searchByName(@RequestParam String name) {
        return mapStructMapper.toListActorDetails(actorRepository.searchByName(name));
    }
}
