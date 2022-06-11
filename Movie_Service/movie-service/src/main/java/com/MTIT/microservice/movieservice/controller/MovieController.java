package com.MTIT.microservice.movieservice.controller;

import com.MTIT.microservice.movieservice.exception.ResourceNotFoundException;
import com.MTIT.microservice.movieservice.model.Movie;
import com.MTIT.microservice.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;


    /**
     * getAllMovieDetails
     *
     * @return Movie
     */
    @GetMapping
    public List<Movie> getAllMovieDetails() {
        return movieRepository.findAll();
    }

    /**
     * createMovie
     *
     * @param movie
     * @return Movie
     */
    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    /**
     * getMovieById
     *
     * @param id
     * @return Movie
     */
    @GetMapping("{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + id));

        return ResponseEntity.ok(movie);
    }

    /**
     * updateMovie
     *
     * @param id
     * @param movieDetails
     * @return Movie
     */
    @PutMapping("{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable long id, @RequestBody Movie movieDetails) {
        Movie updateMovie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No movie with the id: " + id));

        updateMovie.setMovieTitle(movieDetails.getMovieTitle());
        updateMovie.setMovieType(movieDetails.getMovieType());
        updateMovie.setYear(movieDetails.getYear());

        movieRepository.save(updateMovie);

        return ResponseEntity.ok(updateMovie);
    }

    /**
     * deleteMovie
     *
     * @param id
     * @return ResponseEntity<HttpStatus>
     */
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteMovie(@PathVariable long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with the id: " + id));

        movieRepository.delete(movie);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * getMovieByName
     *
     * @param name
     * @return Movie
     */
    @GetMapping("/name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name) {
        Movie movie = movieRepository.findByMovieTitle(name)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with name: " + name));

        return ResponseEntity.ok(movie);
    }
}
