package com.MTIT.microservice.movie.ratingservice.service;

import com.MTIT.microservice.movie.ratingservice.model.Movie;
import com.MTIT.microservice.movie.ratingservice.model.MovieRating;
import com.MTIT.microservice.movie.ratingservice.model.MovieRatingClass;
import com.MTIT.microservice.movie.ratingservice.repository.MovieRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Rating Service Implementation class
 */
@Service
public class RatingServiceImpl implements RatingService {
  //inject dependency
  @Autowired MovieRatingRepository movieRatingRepository;

  //inject dependency
  @Autowired RestTemplate restTemplate;

  /**
   * getMovieRatingForMovieId
   * @param movieId
   * @return
   */
  @Override
  public List<MovieRatingClass> getMovieRatingForMovieId(long movieId) {

    //convey there may not be a value without using null - optional
    Optional<List<MovieRating>> ratings = movieRatingRepository.findByMovieId(movieId);

    //retrieve a response
    Movie movie =
        restTemplate.getForObject("http://localhost:8082/api/movie/" + movieId, Movie.class);

    //list of arrays
    List<MovieRatingClass> ratingMovies = new ArrayList<>();

    //get movie and rating details
    for (MovieRating rating : ratings.get()) {
      MovieRatingClass movieRating =
          MovieRatingClass.builder()
              .description(rating.getDescription())
              .movieName(movie.getMovieTitle())
              .movieRating(rating.getMovieRating())
              .build();
      ratingMovies.add(movieRating);
    }

    return ratingMovies;
  }

  /**
   * save movie ratings
   * @param movieRating
   * @return MovieRating
   */
  @Override
  public MovieRating save(MovieRating movieRating) {
    return movieRatingRepository.save(movieRating);
  }
}
