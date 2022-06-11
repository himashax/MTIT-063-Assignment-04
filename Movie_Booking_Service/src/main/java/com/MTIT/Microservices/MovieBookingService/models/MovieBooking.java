package com.MTIT.Microservices.MovieBookingService.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MovieBooking {

    private int bookingId;
    private int customerId;
    private int movieId;
    private int movieHallId;

    private int age;
    public MovieBooking(){}

    public MovieBooking(int bookingId, int customerId, int movieId, int movieHallId) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.movieId = movieId;
        this.movieHallId = movieHallId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getMovieHallId() {
        return movieHallId;
    }

    public void setMovieHallId(int movieHallId) {
        this.movieHallId = movieHallId;
    }
}
