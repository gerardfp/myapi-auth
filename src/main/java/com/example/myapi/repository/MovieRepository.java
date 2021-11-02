package com.example.myapi.repository;

import com.example.myapi.domain.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface MovieRepository extends JpaRepository<Movie, UUID> {

    <T> T findByTitle(String title, Class<T> clazz);

    List<Movie> findByTitle(String title);

    @Query("SELECT m FROM Movie m WHERE m.title LIKE '%' || :title || '%'")
    List<Movie> searchByTitle(@Param("title") String title);
}
