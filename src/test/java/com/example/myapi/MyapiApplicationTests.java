package com.example.myapi;

import com.example.myapi.domain.model.Movie;
import com.example.myapi.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
class MyapiApplicationTests {
	@Autowired
	private MovieRepository movieRepository;

	@Test
	@Transactional
	void contextLoads() {
		List<Movie> movies = movieRepository.findAll();
	}

}
