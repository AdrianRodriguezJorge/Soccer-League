package utils;

import model.Estadio;

import java.sql.*;

public class ConnectionManager {

    private static Connection connection;
    private static String user = "postgres";
    private static String pass = "1234";
    private static String url = "jdbc:postgresql://localhost:5432/liga";

    private static void initConnectionManager() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            initConnectionManager();
            System.out.println("Done");
        } else if (connection.isClosed()) {
            initConnectionManager();
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
