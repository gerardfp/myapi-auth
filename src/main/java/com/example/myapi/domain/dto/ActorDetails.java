package com.example.myapi.domain.dto;

import java.util.List;
import java.util.UUID;

public class ActorDetails {
    public UUID actorid;
    public String name;
    public List<MovieInActor> movies;
}
