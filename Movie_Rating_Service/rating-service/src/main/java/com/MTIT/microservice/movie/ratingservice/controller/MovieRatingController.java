package com.MTIT.microservice.movie.ratingservice.controller;

import com.MTIT.microservice.movie.ratingservice.model.MovieRating;
import com.MTIT.microservice.movie.ratingservice.model.MovieRatingClass;
import com.MTIT.microservice.movie.ratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for MovieRating
 */
@RestController
@RequestMapping("api/rating")
public class MovieRatingController {

  //inject the dependency
  @Autowired RatingService ratingService;

  /**
   * createMovieRating
   * @param movieRating
   * @return MovieRating
   */
  @PostMapping("/save")
  public MovieRating createMovieRating(@RequestBody MovieRating movieRating) {
    return ratingService.save(movieRating);
  }

  /**
   * getMovieRating by movieId
   * @param movieId
   * @return
   */
  @GetMapping("/movie/{movieId}")
  public ResponseEntity<List<MovieRatingClass>> getMovieRating(@PathVariable long movieId) {
    List<MovieRatingClass> ratings = ratingService.getMovieRatingForMovieId(movieId);

    return ResponseEntity.ok(ratings);
  }
}
