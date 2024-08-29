package utils;

import model.Estadio;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;

public class DBManager {
    private static Connection connection;
    private static String user = "postgres";
    private static String pass = "1234";
    private static String url = "jdbc:postgresql://localhost:5432/liga";

    public static void initConnection () {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Done");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void closeConnection () {
        try {
            connection.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void create(String nom, int cap) {
        try {
            PreparedStatement stmn = connection.prepareStatement("INSERT INTO estadio (nomestadio, capacidad) VALUES (?,?)");
            stmn.setString(1, nom);
            stmn.setInt(2, cap);
            stmn.execute();
            System.out.println("Estadio agregado correctamente");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static ArrayList <Estadio> read() {
        ArrayList <Estadio> list = new ArrayList<>();
        try {
            PreparedStatement stmn = connection.prepareStatement("SELECT * FROM estadio");
            ResultSet result = stmn.executeQuery();

//            System.out.println("  id              nombre                        capacidad");
            while (result.next()) {
                int id = result.getInt("idestadio");
                String nombre = result.getString("nomestadio");
                int cap = result.getInt("capacidad");

//                System.out.println("- " + id + "              " + nombre + "                         " + cap);

                list.add(new Estadio(id, nombre, cap));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
    public static void update(int objetive, String nom, int cap) {
        try {
            PreparedStatement stmn = connection.prepareStatement("UPDATE estadio SET nomestadio = ?, capacidad = ? WHERE idestadio = ?");
            stmn.setString(1, nom);
            stmn.setInt(2, cap);
            stmn.setInt(3, objetive);

            int afected = stmn.executeUpdate();

            if (afected == 0) {
                throw new SQLException();
            } else {
//                System.out.println("Estadio modificado correctamente"); // cambiar por un label que avise que se actualizó corectamente o un aviso emergente
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void delete(int objetive) {
        try {
            PreparedStatement stmn = connection.prepareStatement("DELETE FROM estadio WHERE idestadio = ?");
            stmn.setInt(1, objetive);

            int afected = stmn.executeUpdate();

            if (afected == 0) {
                System.out.println("Id no encontrado");
            } else {
                System.out.println("Estadio eliminado correctamente");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
