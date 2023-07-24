package peaksoft.dao;

import peaksoft.model.Theatre;

public interface TheatreDao {
    Theatre findTheatreById(Long theatreId);
}
