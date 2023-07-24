package peaksoft.service.impl;

import peaksoft.dao.MovieDao;
import peaksoft.dao.ShowTimeDao;
import peaksoft.dao.TheatreDao;
import peaksoft.dao.impl.MovieDaoImpl;
import peaksoft.dao.impl.ShowTimeDaoImpl;
import peaksoft.dao.impl.TheatreDaoImpl;
import peaksoft.model.ShowTime;
import peaksoft.service.ShowTimeService;

public class ShowTimeServiceImpl implements ShowTimeService {

    ShowTimeDao showTimeDao = new ShowTimeDaoImpl();
    TheatreDao theatreDao = new TheatreDaoImpl();
    MovieDao movieDao = new MovieDaoImpl();
    @Override
    public String save(ShowTime showTime) {
       theatreDao.findTheatreById(showTime.getTheatreId());
       movieDao.findMovieById(showTime.getMovieId());
        ShowTime timeMovie = showTimeDao.save(showTime);
        return "Successfully saved with show time: " + timeMovie.toString() ;
    }
}
