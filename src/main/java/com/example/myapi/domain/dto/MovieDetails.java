package com.example.myapi.domain.dto;

import java.util.List;
import java.util.UUID;

public class MovieDetails {
    public UUID movieid;
    public String title;
    public String synopsis;
    public List<ActorInMovie> actors;
    public List<GenreInMovie> genres;
}
