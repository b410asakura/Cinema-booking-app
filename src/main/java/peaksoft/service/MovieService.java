package peaksoft.service;

import peaksoft.model.Movie;

import java.util.List;

public interface MovieService {
    String createMovie(String tableName, List<String> columns);

    String saveMovie(Movie movie);

    Movie findMovieById(Long id);
}
