package com.example.resumeService.service;

import com.example.resumeService.dto.MovieInfo;
import com.example.resumeService.dto.TmbdSearchResultsResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class TmbdIntegrationService {
    public String getMovieDescription(String movieName) {

        final String url = "https://watchlater.cloud.technokratos.com/search/film?query=" + movieName;
        RestTemplate restTemplate = new RestTemplate();
        TmbdSearchResultsResponse searchMovieResult = restTemplate.getForObject(url, TmbdSearchResultsResponse.class);
        if (searchMovieResult == null) {
            return "Description not found";
        }
        List<MovieInfo> movies = searchMovieResult.getResults();
        if (movies.isEmpty()) {
            return "Description not found";
        }
        return movies.get(0).getOverview();
    }
}
