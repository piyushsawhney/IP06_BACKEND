package in.knaps.domain.model.db;

import java.sql.*;

public class PostgresConnection {
    Connection connection;

    public Connection getConnection() {
        return connection;
    }


    public PostgresConnection(String url, String user, String password) {
        try {
            this.connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}


