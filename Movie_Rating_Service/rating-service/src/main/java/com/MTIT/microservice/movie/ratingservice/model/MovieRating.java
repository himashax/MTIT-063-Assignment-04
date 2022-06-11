package com.MTIT.microservice.movie.ratingservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "movie_rating")
public class MovieRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long movieRatingId;

    @Column(name = "movieId")
    private long movieId;

    @Column(name = "movieRating")
    private int movieRating;

    @Column(name = "description")
    private String description;

}
