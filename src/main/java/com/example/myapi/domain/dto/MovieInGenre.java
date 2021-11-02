package com.example.myapi.domain.dto;

import java.util.List;
import java.util.UUID;

public class MovieInGenre {
    public UUID movieid;
    public String title;

    public List<ActorInMovie> actors;
}
