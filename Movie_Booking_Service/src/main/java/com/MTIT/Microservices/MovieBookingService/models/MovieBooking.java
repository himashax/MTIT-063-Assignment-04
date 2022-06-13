package com.MTIT.Microservices.MovieBookingService.models;

import javax.persistence.*;
import java.util.List;

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

    @Column
    private long noOfSeats;

    public MovieBooking(){}

    public MovieBooking(int bookingId, int customerId, int movieId, int movieHallId, long noOfSeats) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.movieId = movieId;
        this.movieHallId = movieHallId;
        this.noOfSeats = noOfSeats;
    }

    /**
     *
     * @return bookingId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getBookingId() {
        return bookingId;
    }

    /**
     *
     * @param bookingId
     */
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    /**
     *
     * @return customerId
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     *
     * @param customerId
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     *
     * @return movieId
     */
    public int getMovieId() {
        return movieId;
    }

    /**
     *
     * @param movieId
     */
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    /**
     *
     * @return movieHallId
     */
    public int getMovieHallId() {
        return movieHallId;
    }

    /**
     *
     * @param movieHallId
     */
    public void setMovieHallId(int movieHallId) {
        this.movieHallId = movieHallId;
    }

    /**
     *
     * @return noOfSeats
     */
    public long getNoOfSeats() {
        return noOfSeats;
    }

    /**
     *
     * @param noOfSeats
     */
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
