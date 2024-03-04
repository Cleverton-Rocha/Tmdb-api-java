package com.tmdb.tmdbapi.util;

import java.util.HashMap;
import java.util.Map;

public class GenreMapping {
  private static final Map<String, Integer> genreMap = new HashMap<>();

  static {
    genreMap.put("ação", 28);
    genreMap.put("aventura", 12);
    genreMap.put("animação", 16);
    genreMap.put("comédia", 35);
    genreMap.put("crime", 80);
    genreMap.put("documentário", 99);
    genreMap.put("drama", 18);
    genreMap.put("família", 10751);
    genreMap.put("fantasia", 14);
    genreMap.put("história", 36);
    genreMap.put("terror", 27);
    genreMap.put("música", 10402);
    genreMap.put("mistério", 9648);
    genreMap.put("romance", 10749);
    genreMap.put("ficção científica", 878);
    genreMap.put("cinema tv", 10770);
    genreMap.put("thriller", 53);
    genreMap.put("guerra", 10752);
    genreMap.put("faroeste", 37);
}

  public static Integer getGenreId(String genreName) {
    return genreMap.get(genreName);
  }
}
