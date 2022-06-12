package com.MTIT.Microservices.MovieBookingService.service;

import com.MTIT.Microservices.MovieBookingService.models.Hall;
import com.MTIT.Microservices.MovieBookingService.models.Movie;
import com.MTIT.Microservices.MovieBookingService.models.MovieBooking;
import com.MTIT.Microservices.MovieBookingService.repository.MovieBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieBookingServiceImpl implements MovieBookingService {
    @Autowired
    private MovieBookingRepository movieBookingRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<MovieBooking> listBookedMovies() {
        // Returns a list of all the bookings details
        return movieBookingRepository.findAll();
    }

    @Override
    public void bookMovie(MovieBooking movieBooking) {
        // Book a movie using the entered booking details
        movieBookingRepository.save(movieBooking);
    }

    @Override
    public MovieBooking getBookedMovieDetails(int movieBookingId) {
        // Returns booking details by the booking id
        return movieBookingRepository.findById(movieBookingId).get();
    }

    @Override
    public String updateBooking(MovieBooking booking, int bookingId){
        // Get if there is an existing booking details for the requested booking id
        MovieBooking getExistingBooking = getBookedMovieDetails(bookingId);

        // Check if the booking id of the updated details is corresponding to the requested booking id
        if(getExistingBooking.getBookingId() == booking.getBookingId()){
            // Allow user to update if the ids are matching
            bookMovie(booking);

            // Returns the updated movie details
            return booking.toString() + "Updated Successfully";
        }
        else{
            return "Selected Booking does not exist";
        }
    }

    @Override
    public void deleteBooking(int movieBookingId) {
        // Delete the booking details by giving the booking id
        movieBookingRepository.deleteById(movieBookingId);
    }

    @Override
    public boolean bookingAvailability(int hallId, long noOfSeats) {

        // Defining a boolean variable for availability of the hall
        boolean available = true;

        // Get total booked capacity of the hall
        int totalBookedSeats = 0;
        for(MovieBooking booking : movieBookingRepository.findAll()){
            if(booking.getMovieHallId() == hallId){
                // Sum total number of booked seats to date
                totalBookedSeats += booking.getNoOfSeats();
            }
        }
        System.out.println(totalBookedSeats);

        // Get the hall id requested by the user
        //Hall hall = restTemplate.getForObject("http://localhost:8082/api/movie/"+hallId, Hall.class);

        // Check for availability of seats according to the user request
        //int hallCapacity = hall.getSeatCapacity();

        int hallCapacity = 200;

        if(hallCapacity - totalBookedSeats >= noOfSeats){
            return available;
        }else{
            return !available;
        }
    }

    @Override
    public Movie getMovieDetails(int bookingId) {
        // Get the id of the booked movie
        int movieId = getBookedMovieDetails(bookingId).getMovieId();

        // API call to get the particular movie details by the movie id
        Movie movie = restTemplate.getForObject("http://localhost:8082/api/movie/"+movieId, Movie.class);
        return movie;
    }

    @Override
    public String test(){
        long cap=0;
        List<Long> caps = new ArrayList<>();
        for(int i=0;i< listBookedMovies().size();i++){
            int mid = listBookedMovies().get(i).getMovieId();
            for(MovieBooking movieBooking:listBookedMovies()){
                if(mid == movieBooking.getMovieId()){
                    cap += movieBooking.getNoOfSeats();
                }else{
                    break;
                }
            }
            caps.add(cap);
        }
        return ""+caps;
    }


}
