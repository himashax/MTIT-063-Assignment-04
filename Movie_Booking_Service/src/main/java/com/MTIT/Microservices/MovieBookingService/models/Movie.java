package com.MTIT.Microservices.MovieBookingService.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor

public class Movie {

    private long movieId;

    private String movieTitle;

    private String movieType;

    private int year;

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieTitle='" + movieTitle + '\'' +
                ", movieType='" + movieType + '\'' +
                ", year=" + year +
                '}';
    }
}
