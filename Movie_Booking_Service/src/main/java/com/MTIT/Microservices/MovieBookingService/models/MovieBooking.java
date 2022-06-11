package com.MTIT.Microservices.MovieBookingService.models;

import javax.persistence.*;

@Entity
public class MovieBooking {
    @Column
    private int bookingId;
    @Column
    private int customerId;
    @Column
    private int movieId;
    @Column
    private int movieHallId;

    public MovieBooking(){}

    public MovieBooking(int bookingId, int customerId, int movieId, int movieHallId) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.movieId = movieId;
        this.movieHallId = movieHallId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

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

    @Override
    public String toString() {
        return "MovieBooking{" +
                "bookingId=" + bookingId +
                ", customerId=" + customerId +
                ", movieId=" + movieId +
                ", movieHallId=" + movieHallId +
                '}';
    }
}
