package com.MTIT.microservice.movie.ratingservice.model;

import lombok.*;

import javax.persistence.Column;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieRatingDto {
    private String movieName;

    private int movieRating;

    private String description;
}
