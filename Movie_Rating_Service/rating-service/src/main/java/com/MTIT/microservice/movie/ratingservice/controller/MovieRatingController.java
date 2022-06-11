package com.MTIT.microservice.movie.ratingservice.controller;

import com.MTIT.microservice.movie.ratingservice.exception.ResourceNotFoundException;
import com.MTIT.microservice.movie.ratingservice.model.MovieRating;
import com.MTIT.microservice.movie.ratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/rating")
public class MovieRatingController {
    @Autowired
    RatingService ratingService;

    @PostMapping("/save")
    public MovieRating createMovie(@RequestBody MovieRating movieRating) {
        return ratingService.save(movieRating);
    }
    @GetMapping("/movie/{movieId}")
    public ResponseEntity<MovieRating> getMovieRating(@PathVariable long movieId) {
        MovieRating movie = ratingService.getMovieRatingForMovieId(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("MovieRating not found for movie with id : " + movieId));

        return ResponseEntity.ok(movie);
    }
}
