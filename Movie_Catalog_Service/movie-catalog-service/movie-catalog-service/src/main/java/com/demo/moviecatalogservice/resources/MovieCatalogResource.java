package com.demo.moviecatalogservice.resources;

import com.demo.moviecatalogservice.models.Movie;
import com.demo.moviecatalogservice.models.MovieRatingClass;
import com.demo.moviecatalogservice.service.MovieCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/moviecatalog")
public class MovieCatalogResource {

    @Autowired
    MovieCatalogService movieCatalogService;

    @RequestMapping("")
    public List<Movie> getAllMovie(){
        return movieCatalogService.getAllTheMovies();
    }

    // get the most watched movie
    @RequestMapping("/mostwatched")
    public Movie mostViewedMovies(){
        return movieCatalogService.getMostWatchedMovie();
    }

    // get the movie ratings
    @RequestMapping("/ratings/{movieId}")
    public List<MovieRatingClass> getMovieRatings(long movieId){
        return movieCatalogService.getRatings(movieId);
    }
}
