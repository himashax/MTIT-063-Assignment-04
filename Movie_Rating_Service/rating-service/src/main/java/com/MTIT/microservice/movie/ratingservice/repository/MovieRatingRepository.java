package com.MTIT.microservice.movie.ratingservice.repository;

import com.MTIT.microservice.movie.ratingservice.model.MovieRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRatingRepository extends JpaRepository<MovieRating, Long> {
  Optional<List<MovieRating>> findByMovieId(long movieId);
  // all crud methods
}
