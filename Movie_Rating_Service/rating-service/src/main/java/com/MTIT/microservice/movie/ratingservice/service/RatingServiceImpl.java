package com.MTIT.microservice.movie.ratingservice.service;

import com.MTIT.microservice.movie.ratingservice.model.MovieRating;
import com.MTIT.microservice.movie.ratingservice.repository.MovieRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    MovieRatingRepository movieRatingRepository;

    @Override
    public Optional<MovieRating> getMovieRatingForMovieId(long movieId) {

        return movieRatingRepository.findByMovieId(movieId);
    }

    @Override
    public MovieRating save(MovieRating movieRating) {
        return movieRatingRepository.save(movieRating);
    }
}
