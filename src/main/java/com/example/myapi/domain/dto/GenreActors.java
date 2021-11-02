package com.example.myapi.domain.dto;

import java.util.List;
import java.util.UUID;

public class GenreActors {
    public UUID genreid;
    public String label;
    public List<ActorInGenre> actors;
}
