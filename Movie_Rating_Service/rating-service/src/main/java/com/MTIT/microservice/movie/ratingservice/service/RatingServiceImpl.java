package com.MTIT.microservice.movie.ratingservice.service;

import com.MTIT.microservice.movie.ratingservice.model.Movie;
import com.MTIT.microservice.movie.ratingservice.model.MovieRating;
import com.MTIT.microservice.movie.ratingservice.model.MovieRatingDto;
import com.MTIT.microservice.movie.ratingservice.repository.MovieRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    MovieRatingRepository movieRatingRepository;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public MovieRatingDto getMovieRatingForMovieId(long movieId) {

        Optional<MovieRating> sRating = movieRatingRepository.findByMovieId(movieId);

        Movie movie = restTemplate.getForObject("http://localhost:8082/api/movie/" + movieId, Movie.class);

        return MovieRatingDto.builder()
                .description(sRating.get().getDescription())
                .movieName(movie.getMovieTitle())
                .movieRating(sRating.get().getMovieRating())
                .build();
    }

    @Override
    public MovieRating save(MovieRating movieRating) {
        return movieRatingRepository.save(movieRating);
    }

}
