package com.example.resumeService.Controller;

import lombok.Data;

import java.util.List;


@Data
public class TmbdSearchResultsResponse {

    private int page;

    private int totalResults;

    private int totalPages;

    private List<MovieInfo> results;

    private int resultsOnPage;

}
