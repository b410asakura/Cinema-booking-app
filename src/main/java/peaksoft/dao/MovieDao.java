package peaksoft.dao;

import peaksoft.model.Movie;

import java.util.List;

public interface MovieDao {

    void createTable(String tableName, List<String> columns);

    void saveMovie(Movie movie);

    Movie findMovieById(Long id);
}
