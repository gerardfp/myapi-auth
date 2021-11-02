package com.example.myapi.domain.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID genreid;

    public String label;

    @ManyToMany
    @JoinTable(
            name = "movie_genre",
            joinColumns = @JoinColumn(name = "genreid"),
            inverseJoinColumns = @JoinColumn(name = "movieid")
    )
    public Set<Movie> movies = new HashSet<>();
}
