package com.MTIT.microservice.movieservice.repository;

import com.MTIT.microservice.movieservice.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

  @Query("SELECT m FROM movie m WHERE m.movieTitle LIKE %:title%")
  Optional<List<Movie>> findByMovieTitleLike(@Param("title") String title);
  // all create, read, update, delete methods
}
