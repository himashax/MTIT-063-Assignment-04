package com.demo.moviecatalogservice.service;

import com.demo.moviecatalogservice.models.Movie;

import java.util.List;

public interface MovieCatalogService {

    // Get all the movie details
    public List<Movie> getAllTheMovies();

    // Get the most watched movie details
    public Movie getMostWatchedMovie();

    // Get details of a particular movie
    public Movie getMovieDetails(int movieId);


}
