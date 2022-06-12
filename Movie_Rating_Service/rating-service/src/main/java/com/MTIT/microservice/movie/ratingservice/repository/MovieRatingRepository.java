package com.MTIT.microservice.movie.ratingservice.repository;

import com.MTIT.microservice.movie.ratingservice.model.MovieRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * to interact with the database
 * rating_service db
 * provide the mechanism for all create, read, update, delete methods
 */
@Repository
public interface MovieRatingRepository extends JpaRepository<MovieRating, Long> {
  /**
   * findByMovieId
   * @param movieId
   * @return
   */
  Optional<List<MovieRating>> findByMovieId(long movieId);
}
