package com.demo.moviecatalogservice.service;

import com.demo.moviecatalogservice.models.Movie;
import com.demo.moviecatalogservice.models.MovieBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MovieCatalogServiceImpl implements MovieCatalogService{

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Movie getMostWatchedMovie(){

        // API call to Movie Booking Service to get all the movie bookings
        ResponseEntity<MovieBooking[]> responseEntity = restTemplate.getForEntity("http://localhost:8081/bookings", MovieBooking[].class);
        MovieBooking[] bookings = responseEntity.getBody();
        List<MovieBooking> movieBookings = Arrays.stream(bookings).collect(Collectors.toList());

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int movieId = 0;

        // Get the total number of booked seats for each
        for(int j=0;j<movieBookings.size();j++) {
            // Get the movie Id
            movieId = movieBookings.get(j).getMovieId();
            long total =0;

            // Check the movie Ids
            for(int i=0;i<movieBookings.size();i++) {
                // Get the bookings for the same movie id
                if(movieId == movieBookings.get(i).getMovieId()) {
                    // Total number of bookings for a movie
                    total += movieBookings.get(i).getNoOfSeats();
                }
            }

            // Store movie id and booked seats
            hashMap.put(movieId, (int) total);
        }

        int id=0;
        int maxValue = Collections.max(hashMap.values());

        // Get the movie id with maximum no of booked seats
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue()==maxValue) {
                id = entry.getKey();
            }
        }

        // Returns the movie id
        return getMovieDetails(id);
    }

    @Override
    public List<Movie> getAllTheMovies() {
        // API call to Movie Service to get the movies
        ResponseEntity<Movie[]> responseEntity = restTemplate.getForEntity("http://localhost:8082/api/movie", Movie[].class);
        Movie[] movie = responseEntity.getBody();
        List<Movie> movies = Arrays.stream(movie).collect(Collectors.toList());
        return movies;
    }

    @Override
    public Movie getMovieDetails(int movieId) {
        // API call Movie Service to get the particular movie details by the movie id
        Movie movie = restTemplate.getForObject("http://localhost:8082/api/movie/"+movieId, Movie.class);
        return movie;
    }




}
