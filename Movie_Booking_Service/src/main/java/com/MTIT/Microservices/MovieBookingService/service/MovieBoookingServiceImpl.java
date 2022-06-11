package com.MTIT.Microservices.MovieBookingService.service;

import com.MTIT.Microservices.MovieBookingService.models.Movie;
import com.MTIT.Microservices.MovieBookingService.models.MovieBooking;
import com.MTIT.Microservices.MovieBookingService.repository.MovieBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieBoookingServiceImpl implements MovieBookingService {
    @Autowired
    private MovieBookingRepository movieBookingRepository;


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
    public MovieBooking getBookedMovieDetails(Integer movieBookingId) {
        // Returns booking details by the booking id
        return movieBookingRepository.findById(movieBookingId).get();
    }

    public String updateBooking(MovieBooking booking, Integer bookingId){
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
    public void deleteBooking(Integer movieBookingId) {
        // Delete the booking details by giving the booking id
        movieBookingRepository.deleteById(movieBookingId);
    }

    @Override
    public boolean bookingAvailability() {

        // Defining a boolean variable for availability of the hall
        boolean available = true;

//        int totalBookedSeats = 0;
//        for(MovieBooking booking : movieBookingRepository.findAll()){
//            totalBookedSeats += booking.getNoOfSeats();
//        }
//        System.out.println(totalBookedSeats);

//        // Get entering hall id from the user
//        int hallId;
//        //get booked seats
//        int noofseats;
//        int capacity = template + hallIdid.getcapacity();

        int capacity = 100;
        int totalBookedSeats = 20;
        int noofseats = 10;

        // Get the hall id requested by the user
        // Get total capacity of the hall
        // Sum total number of booked seats to date
        // Check for availability of seats according to the user request

        if(capacity-totalBookedSeats >= noofseats){
            return available;
        }else{
            return !available;
        }
    }
}
