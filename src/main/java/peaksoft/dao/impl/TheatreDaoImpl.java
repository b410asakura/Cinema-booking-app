package peaksoft.dao.impl;

import peaksoft.config.JdbcConfig;
import peaksoft.dao.TheatreDao;
import peaksoft.model.Theatre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TheatreDaoImpl implements TheatreDao   {

    private final Connection connection = JdbcConfig.getConnection();
    @Override
    public Theatre findTheatreById(Long theatreId) {
        String sql = "SELECT * FROM theatres WHERE id = ?";
        Theatre  theatre = new Theatre();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setLong(1, theatreId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                theatre.setId(resultSet.getLong("id"));
                theatre.setName(resultSet.getString("name"));
                theatre.setLocation(resultSet.getString("location"));
            } else{
                throw new RuntimeException(String.format("Theatre with id: %d not found", theatreId  ));
            }
        } catch (SQLException e){
            e.getMessage();
        }

        return theatre;
    }
}
