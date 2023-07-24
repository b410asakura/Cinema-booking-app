package peaksoft.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConfig {

    private final static String url = "jdbc:postgresql://localhost:5432/booking";
    private final static String username = "postgres";
    private final static String password = "57206700";

    public static Connection getConnection (){
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
