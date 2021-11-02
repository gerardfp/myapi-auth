package com.example.myapi.domain.dto;

import java.util.List;
import java.util.UUID;

public class MovieInActor {
    public UUID movieid;
    public String title;

    public List<GenreInMovie> genres;
}
