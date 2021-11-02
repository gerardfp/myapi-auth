package com.example.myapi.domain.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID actorid;

    public String name;

    @ManyToMany
    @JoinTable(
            name = "movie_actor",
            joinColumns = @JoinColumn(name = "actorid"),
            inverseJoinColumns = @JoinColumn(name = "movieid")
    )
    public Set<Movie> movies = new HashSet<>();
}
