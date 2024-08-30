package utils;

import model.Estadio;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;

public class ConnectionManager {
    private static Connection connection;
    private static String user = "postgres";
    private static String pass = "1234";
    private static String url = "jdbc:postgresql://localhost:5432/liga";

    public static void initConnectionManager () {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Done");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Connection getConnection() {
		return connection;
	}

    public static void closeConnection () {
        try {
            connection.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
