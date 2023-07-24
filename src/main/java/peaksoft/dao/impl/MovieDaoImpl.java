package peaksoft.dao.impl;

import java.sql.*;
import java.util.List;

import peaksoft.config.JdbcConfig;
import peaksoft.dao.MovieDao;
import peaksoft.model.Movie;

public class MovieDaoImpl implements MovieDao {

    private final Connection connection = JdbcConfig.getConnection();

    @Override
    public void createTable(String tableName, List<String> columns) {
        StringBuilder stringBuilder = new StringBuilder(String.format("create table if not exists %s (", tableName));

        try {
            Statement statement = connection.createStatement();
            for (int i = 0; i < columns.size(); i++) {
                stringBuilder.append(columns.get(i));
                if (i < columns.size() - 1) stringBuilder.append(", ");
            }
            stringBuilder.append(")");
            statement.executeUpdate(stringBuilder.toString());
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void saveMovie(Movie movie) {
        String sql = "INSERT INTO movies (title, genre, duration)" +
                "VALUES (?, ?, ?)";
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setString(2, movie.getGenre());
            preparedStatement.setInt(3, movie.getDuration());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Movie findMovieById(Long id) {
        Movie movie = new Movie();
        String sql = "SELECT * FROM movies WHERE id = ?";
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                throw new RuntimeException("movie with id: " + id + "not found");
            } else {
                movie.setId(resultSet.getLong("id"));
                movie.setTitle(resultSet.getString("title"));
                movie.setGenre(resultSet.getString("genre"));
                movie.setDuration(resultSet.getInt("duration"));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return movie;
    }
}
