package com.example.myapi.repository;

import com.example.myapi.domain.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface GenreRepository extends JpaRepository<Genre, UUID> {

    @Override
    @Query("SELECT g FROM Genre g JOIN FETCH g.movies m JOIN FETCH m.actors")
    List<Genre> findAll();

    List<Genre> findByLabel(String label);

    @Query("SELECT g FROM Genre g WHERE g.label LIKE '%' || :label || '%'")
    List<Genre> searchByLabel(@Param("label") String label);

//    @Query(nativeQuery = true, value="SELECT CAST(g.genre_id AS varchar(50)) as genre_id, g.label, a.name FROM genre g JOIN movie_genre mg ON g.genre_id=mg.genre_id JOIN movie_actor ma ON mg.movie_id = ma.movie_id JOIN FETCH actor a ON ma.actor_id = a.actor_id")
//    @Query("SELECT g, m, a FROM Genre g JOIN FETCH g.movies m JOIN FETCH m.actors a")
    @Query("SELECT g FROM Genre g JOIN FETCH g.movies m JOIN FETCH m.actors")
//    @Query(nativeQuery = true, value="SELECT * FROM genre JOIN movie_genre USING(genreid) JOIN movie USING (movieid) JOIN movie_actor USING(movieid) JOIN actor USING (actorid)")
    List<Genre> listWithActors();
}
