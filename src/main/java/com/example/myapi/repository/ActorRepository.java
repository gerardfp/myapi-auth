package com.example.myapi.repository;

import com.example.myapi.domain.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ActorRepository extends JpaRepository<Actor, UUID> {
    List<Actor> findByName(String name);

    @Query("SELECT m FROM Actor m WHERE m.name LIKE '%' || :name || '%'")
    List<Actor> searchByName(@Param("name") String name);
}
