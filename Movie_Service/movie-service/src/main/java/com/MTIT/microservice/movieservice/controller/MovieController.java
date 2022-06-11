package com.MTIT.microservice.movieservice.controller;

import com.MTIT.microservice.movieservice.model.Movie;
import com.MTIT.microservice.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
