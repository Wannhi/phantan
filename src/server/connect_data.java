package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connect_data {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/qlsv";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
