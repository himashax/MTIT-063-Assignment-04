package com.MTIT.microservice.movie.ratingservice.service;

import com.MTIT.microservice.movie.ratingservice.model.MovieRating;
import com.MTIT.microservice.movie.ratingservice.model.MovieRatingDto;

import java.util.Optional;

public interface RatingService {
    MovieRatingDto getMovieRatingForMovieId(long movieId);

    MovieRating save(MovieRating movieRating);
}
