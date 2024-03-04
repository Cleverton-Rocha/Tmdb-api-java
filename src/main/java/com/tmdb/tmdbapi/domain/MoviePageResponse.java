package com.tmdb.tmdbapi.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class MoviePageResponse {
  @JsonProperty("page")
  private int page;

  @JsonProperty("results")
  private List<Movie> results;

  @JsonProperty("total_pages")
  private int totalPages;

  @JsonProperty("total_results")
  private int totalResults;
}