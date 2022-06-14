package com.demo.moviecatalogservice.service;

import com.demo.moviecatalogservice.models.Movie;
import com.demo.moviecatalogservice.models.MovieRatingClass;

import java.util.List;

public interface MovieCatalogService {

    // Get all the movie details
    public List<Movie> getAllTheMovies();

    // Get the most watched movie details
    public Movie getMostWatchedMovie();

    // Get details of a particular movie
    public Movie getMovieDetails(int movieId);

    // Get movie ratings
    public List<MovieRatingClass> getRatings(long movieId);


}
