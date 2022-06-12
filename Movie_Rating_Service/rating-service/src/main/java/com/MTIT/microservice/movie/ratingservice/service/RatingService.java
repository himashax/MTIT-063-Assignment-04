package com.MTIT.microservice.movie.ratingservice.service;

import com.MTIT.microservice.movie.ratingservice.model.MovieRating;
import com.MTIT.microservice.movie.ratingservice.model.MovieRatingClass;

import java.util.List;

/**
 * Interface that declares the methods
 * getMovieRatingForMovieId
 * save movie rating
 */
public interface RatingService {
  List<MovieRatingClass> getMovieRatingForMovieId(long movieId);

  MovieRating save(MovieRating movieRating);
}
