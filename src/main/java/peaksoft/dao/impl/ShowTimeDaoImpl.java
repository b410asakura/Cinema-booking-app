package peaksoft.dao.impl;

import peaksoft.config.JdbcConfig;
import peaksoft.dao.ShowTimeDao;
import peaksoft.model.ShowTime;

import java.sql.*;
import java.time.LocalDateTime;

public class ShowTimeDaoImpl implements ShowTimeDao {
    private final Connection connection = JdbcConfig.getConnection();
    @Override
    public ShowTime save(ShowTime showTime) {

        String sql = "INSERT  INTO show_time (movie_id, theatre_id, start_time, end_time)" +
                "VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, showTime.getMovieId());
            preparedStatement.setLong(2, showTime.getTheatreId());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(showTime.getStartTime()));
            preparedStatement.setTimestamp(4, Timestamp.valueOf(showTime.getEndTime()));
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


}
