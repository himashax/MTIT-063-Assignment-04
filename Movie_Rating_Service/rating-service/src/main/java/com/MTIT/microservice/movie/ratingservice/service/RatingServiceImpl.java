package com.MTIT.microservice.movie.ratingservice.service;

import com.MTIT.microservice.movie.ratingservice.model.MovieRating;
import com.MTIT.microservice.movie.ratingservice.repository.MovieRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class RatingServiceImpl implements RatingService {
    @Autowired
    MovieRatingRepository movieRatingRepository;

    @Override
    public Optional<MovieRating> getMovieRatingForMovieId(long movieId) {

        return movieRatingRepository.findByMovieId(movieId);
    }
}
