package com.MTIT.microservice.movieservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long movieId;

    @Column(name = "title")
    private String movieTitle;

    @Column(name = "type")
    private String movieType;

    @Column(name = "year")
    private int year;


}
