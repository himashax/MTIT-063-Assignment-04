package com.demo.moviecatalogservice.models;

public class MovieBooking {
    private int bookingId;
    private int customerId;
    private int movieId;
    private int movieHallId;

    private long noOfSeats;

    public MovieBooking(){}

    public MovieBooking(int bookingId, int customerId, int movieId, int movieHallId, long noOfSeats) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.movieId = movieId;
        this.movieHallId = movieHallId;
        this.noOfSeats = noOfSeats;
    }

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

    public long getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(long noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    @Override
    public String toString() {
        return "MovieBooking{" +
                "bookingId=" + bookingId +
                ", customerId=" + customerId +
                ", movieId=" + movieId +
                ", movieHallId=" + movieHallId +
                ", noOfSeats=" + noOfSeats +
                '}';
    }
}
