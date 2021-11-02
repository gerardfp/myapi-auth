package com.example.myapi.domain.dto;

import java.util.List;

public interface GenreSlim {
    String getGenreid();
    String getLabel();
    List<NameSlim> getMovies();
    interface NameSlim {
        String getTitle();

        List<NameSlim2> getActors();
    }

    interface NameSlim2 {
        String getName();
    }

    interface MovieSlim {
        String getTitle();
    }

    interface ActorSlim {
        String getName();
    }
}

