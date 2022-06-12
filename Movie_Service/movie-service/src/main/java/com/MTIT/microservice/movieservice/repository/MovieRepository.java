package com.MTIT.microservice.movieservice.repository;

import com.MTIT.microservice.movieservice.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
  Optional<Movie> findByMovieTitle(String name);
  // all create, read, update, delete methods
}
