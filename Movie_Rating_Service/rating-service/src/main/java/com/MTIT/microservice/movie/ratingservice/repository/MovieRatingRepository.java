package com.MTIT.microservice.movie.ratingservice.repository;

import com.MTIT.microservice.movie.ratingservice.model.MovieRating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRatingRepository extends JpaRepository<MovieRating, Long> {
    Optional<MovieRating> findByMovieId(long movieId);
    //all crud methods
}
