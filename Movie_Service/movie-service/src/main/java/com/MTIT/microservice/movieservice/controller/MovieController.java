package com.MTIT.microservice.movieservice.controller;

import com.MTIT.microservice.movieservice.exception.ResourceNotFoundException;
import com.MTIT.microservice.movieservice.model.Movie;
import com.MTIT.microservice.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public List<Movie> getAllMovieDetails(){
        return movieRepository.findAll();
    }

    //create movie
    @PostMapping
    public Movie createMovie(@RequestBody Movie movie){
        return movieRepository.save(movie);
    }

    //get movie by id
    @GetMapping("{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable long id){
        Movie movie = movieRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Movie not found with id: " + id));

        return ResponseEntity.ok(movie);
    }
}
