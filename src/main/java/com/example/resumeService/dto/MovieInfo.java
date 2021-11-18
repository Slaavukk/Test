package com.example.resumeService.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MovieInfo {

    private String posterPath;

    private String overview;

    private Date releaseDate;

    private String originalTitle;

    private String originalLanguage;

    private String title;

    private String backdropPath;

    private long id; //

    private int voteCount;

    private List<Integer> genreIds;

    private double popularity;

    private double voteAverage;

    private boolean video;

    private boolean adult;
}
