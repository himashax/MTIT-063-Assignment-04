package com.MTIT.microservice.movie.ratingservice.service;

import com.MTIT.microservice.movie.ratingservice.model.MovieRating;
import com.MTIT.microservice.movie.ratingservice.model.MovieRatingDto;

import java.util.List;
import java.util.Optional;

public interface RatingService {
  List<MovieRatingDto> getMovieRatingForMovieId(long movieId);

  MovieRating save(MovieRating movieRating);
}
