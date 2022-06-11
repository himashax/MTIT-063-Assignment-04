package com.MTIT.microservice.movie.ratingservice.service;

import com.MTIT.microservice.movie.ratingservice.model.MovieRating;

import java.util.Optional;

public interface RatingService {
    Optional<MovieRating> getMovieRatingForMovieId(long movieId);

    MovieRating save(MovieRating movieRating);
}
