package com.example.myapi.domain.dto;

import java.util.List;
import java.util.UUID;

public class GenreDetails {
    public UUID genreid;
    public String label;
    public List<MovieInGenre> movies;
}
