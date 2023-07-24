package peaksoft.service.impl;

import java.util.List;
import peaksoft.dao.MovieDao;
import peaksoft.dao.impl.MovieDaoImpl;
import peaksoft.model.Movie;
import peaksoft.service.MovieService;

public class MovieServiceImpl implements MovieService {

    MovieDao movieDao = new MovieDaoImpl();
    @Override
    public String createMovie(String tableName, List<String> columns) {
        movieDao.createTable(tableName, columns);
        return "Successfully created table " + tableName;
    }

    @Override
    public String saveMovie(Movie movie) {
        movieDao.saveMovie(movie);
        return "successfully saved movie";
    }

    @Override
    public Movie findMovieById(Long id) {
        return movieDao.findMovieById(id);
    }
}
