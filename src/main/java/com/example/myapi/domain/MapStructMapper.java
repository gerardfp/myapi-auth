package com.example.myapi.domain;

import com.example.myapi.domain.dto.*;
import com.example.myapi.domain.model.Actor;
import com.example.myapi.domain.model.File;
import com.example.myapi.domain.model.Genre;
import com.example.myapi.domain.model.Movie;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
    ActorDetails toActorDetails(Actor actor);
    MovieDetails toMovieDetails(Movie movie);
    GenreDetails toGenreDetails(Genre genre);
    ActorInMovie toActorInMovie(Actor actor);
    MovieInActor toMovieInActor(Movie movie);
    List<GenreDetails> toListGenreDetails(List<Genre> genres);
    List<MovieDetails> toListMovieDetails(List<Movie> movies);
    List<ActorDetails> toListActorDetails(List<Actor> actors);
    Movie toMovie(MovieCreateRequest movieCreateRequest);
    FileDetails toFileDetails(File file);
    List<FileDetails> toListFileDetails(List<File> files);


    GenreActors toGenreActors(Genre genre);
    List<GenreActors> toListGenreActors(List<Genre> genre);

}
