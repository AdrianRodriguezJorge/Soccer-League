package services;

import model.Equipo;
import model.Estadio;
import utils.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.util.HashMap;
import java.util.Map;

/**
 * Servicio para manejar las operaciones CRUD relacionadas con los estadios.
 */
public class EstadioServices {
    private static Connection connection;

    public EstadioServices() {
        this.connection = ConnectionManager.getConnection();
    }

    /**
     * Crea un nuevo equipo en la base de datos.
     *
     * @param estadio El equipo a crear.
     * @return Verdadero si el equipo se creó correctamente.
     */
     public static boolean agregarEstadio (String nombre, int capacidad) {

          String sql = "INSERT INTO estadio (nomestadio, capacidad) VALUES (?,?)";
          try (PreparedStatement stmt = connection.prepareStatement(sql)) {
               stmt.setString(1, nombre);
               stmt.setInt(2, capacidad);
               stmt.execute();
               return true;
          } catch (SQLException e) {
               System.out.println(e.getMessage());
               return false;
          }
     }

     /**
          * Obtiene todos los equipos de la base de datos.
          *
          * @return Una lista de equipos.
          */
     public static ArrayList<Estadio> readEstadios() {
          ArrayList <Estadio> list = new ArrayList<>();
          String sql = "SELECT * FROM estadio";
          try {
               PreparedStatement stmn = connection.prepareStatement("SELECT * FROM estadio");
               ResultSet rs = stmn.executeQuery();
               while (rs.next()) {
                    Estadio estadio = new Estadio(
                         rs.getInt("idestadio"),
                         rs.getString("nomestadio"),
                         rs.getInt("capacidad")
                    );
                    list.add(estadio);
               }
          } catch (SQLException e) {
               e.printStackTrace();
          }
          return list;
     }

     public static void actualizarEstadio (int objetive, String nom, int cap) {
          try {
               String sql = "UPDATE estadio SET nomestadio = ?, capacidad = ? WHERE idestadio = ?";
               PreparedStatement stmn = connection.prepareStatement(sql);
               stmn.setString(1, nom);
               stmn.setInt(2, cap);
               stmn.setInt(3, objetive);

               int afected = stmn.executeUpdate();

               if (afected == 0) {
                    throw new SQLException();
               } else {
                    System.out.println("Estadio modificado correctamente"); // cambiar por un label que avise que se actualizó corectamente o un aviso emergente
               }

          } catch (SQLException e) {
               System.out.println(e.getMessage());
          }
     }
     public static void eliminarEstadio (int objetive) {
          try {
               String sql = "DELETE FROM estadio WHERE idestadio = ?";
               PreparedStatement stmn = connection.prepareStatement(sql);
               stmn.setInt(1, objetive);

               int afected = stmn.executeUpdate();

               if (afected == 0) {
                    System.out.println("Id no encontrado");
                    throw new SQLException();
               } else {
                    System.out.println("Estadio eliminado correctamente");
               }

          } catch (SQLException e) {
               System.out.println(e.getMessage());
          }
     }
     
     public static void generarReporteEstadio() {
        try {
            // Ruta del archivo .jasper
            String reportPath = "src/main/java/reports/EstadioR.jasper";

            // Parámetros para pasar al reporte (si se necesitan)
            Map<String, Object> parametros = new HashMap<>();

            // Obtener la conexión a la base de datos
            Connection conn = ConnectionManager.getConnection();

            // Cargar el reporte
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, parametros, conn);

            // Mostrar el reporte
            JasperViewer viewer = new JasperViewer(jasperPrint, false);
            viewer.setTitle("Reporte de Estadios");
            viewer.setVisible(true);

        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}
