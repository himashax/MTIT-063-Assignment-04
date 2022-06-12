package com.MTIT.microservice.movie.ratingservice.service;

import com.MTIT.microservice.movie.ratingservice.model.Movie;
import com.MTIT.microservice.movie.ratingservice.model.MovieRating;
import com.MTIT.microservice.movie.ratingservice.model.MovieRatingDto;
import com.MTIT.microservice.movie.ratingservice.repository.MovieRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService {
  @Autowired MovieRatingRepository movieRatingRepository;

  @Autowired RestTemplate restTemplate;

  @Override
  public List<MovieRatingDto> getMovieRatingForMovieId(long movieId) {

    Optional<List<MovieRating>> ratings = movieRatingRepository.findByMovieId(movieId);

    Movie movie =
        restTemplate.getForObject("http://localhost:8082/api/movie/" + movieId, Movie.class);

    List<MovieRatingDto> ratingDtos = new ArrayList<>();

    for (MovieRating rating : ratings.get()) {
      MovieRatingDto ratingDto =
          MovieRatingDto.builder()
              .description(rating.getDescription())
              .movieName(movie.getMovieTitle())
              .movieRating(rating.getMovieRating())
              .build();
      ratingDtos.add(ratingDto);
    }

    return ratingDtos;
  }

  @Override
  public MovieRating save(MovieRating movieRating) {
    return movieRatingRepository.save(movieRating);
  }
}
