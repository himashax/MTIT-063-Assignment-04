package com.MTIT.microservice.movieservice.repository;

import com.MTIT.microservice.movieservice.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * get all crud methods
 * interact with the database
 */
public interface MovieRepository extends JpaRepository<Movie, Long> {

  /**
   * findByMovieTitleLike
   * @param title
   * @return
   */
  @Query("SELECT m FROM Movie m WHERE m.movieTitle LIKE %:title%")
  Optional<List<Movie>> findByMovieTitleLike(@Param("title") String title);
}
