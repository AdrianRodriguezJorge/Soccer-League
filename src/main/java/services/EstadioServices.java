package services;

import model.Estadio;
import utils.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;

import net.sf.jasperreports.engine.*;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import utils.Report;

/**
 * Servicio para manejar las operaciones CRUD relacionadas con los estadios.
 */
public class EstadioServices {

    private static Connection connection;

    public EstadioServices() {
        try {
            this.connection = ConnectionManager.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Crea un nuevo equipo en la base de datos.
     *
     * @param nombre    del estadio a crear
     * @param capacidad del estadio a crear
     * @return Verdadero si el equipo se creó correctamente.
     */
    public boolean agregarEstadio(String nombre, int capacidad) {

        String sql = "INSERT INTO estadio (nomestadio, capacidad) VALUES (?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setInt(2, capacidad);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            // de esta forma se tratarían las excepciones provenientes de la base de datos
            return false;
        }
    } // de esta forma se tratarían las excepciones provenientes de la base de datos

    /**
     * Obtiene todos los equipos de la base de datos.
     *
     * @return Una lista de equipos.
     */
    public ArrayList<Estadio> obtenerEstadios() {
        ArrayList<Estadio> list = new ArrayList<>();
        String sql = "SELECT * FROM estadio";
        try {
            connection = ConnectionManager.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM estadio ORDER BY idestadio");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Estadio estadio = new Estadio(
                        rs.getString("nomestadio"),
                        rs.getInt("capacidad"));
                estadio.setIdEstadio(rs.getInt("idestadio"));
                list.add(estadio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void actualizarEstadio(Estadio estadio) {
        try {
            String sql = "UPDATE estadio SET nomestadio = ?, capacidad = ? WHERE idestadio = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, estadio.getNombreEstadio());
            pstmt.setInt(2, estadio.getCapacidad());
            pstmt.setInt(3, estadio.getIdEstadio());

            int afected = pstmt.executeUpdate();

            if (afected == 0) {
                throw new SQLException();
            } else {
                System.out.println("Estadio modificado correctamente"); // cambiar por un label que avise que se
                                                                        // actualizó corectamente o un aviso emergente
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarEstadio(int objetive) {
        try {
            String sql = "DELETE FROM estadio WHERE idestadio = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, objetive);

            int afected = pstmt.executeUpdate();

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

    public void generarReporteEstadio() {
        try {
            // Ruta del archivo .jasper
            String reportPath = "src/main/java/reports/EstadioR.jasper";

            // Parámetros para pasar al reporte (si se necesitan)
            Map<String, Object> parametros = new HashMap<>();

            // Obtener la conexión a la base de datos
            Connection conn = ConnectionManager.getConnection();

            // Cargar el reporte
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, parametros, conn);

            // Generar y mostrar el reporte usando la clase de utilidades Reports
            Report.mostrarReporte(reportPath, parametros, conn);

        } catch (JRException | SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> obtenerNombresEstadios() {
        ArrayList<String> list = new ArrayList<>();

        for (Estadio e : obtenerEstadios()) {
            list.add(e.getNombreEstadio());
        }

        return list;
    }

    public void reportePorcentajeAudiencia() {
        try {
            // Ruta del archivo .jasper
            String reportPath = "src/main/java/reports/Estadios_porcentaje_audiencia.jasper";

            // Parámetros para pasar al reporte (si se necesitan)
            Map<String, Object> parametros = new HashMap<>();

            // Obtener la conexión a la base de datos
            Connection conn = ConnectionManager.getConnection();

            // Cargar el reporte
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, parametros, conn);

            // Generar y mostrar el reporte usando la clase de utilidades Reports
            Report.mostrarReporte(reportPath, parametros, conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getNombreEstadio(int id) {
        String nom = null;
        ArrayList<Estadio> list = obtenerEstadios();

        for (int i = 0; i < list.size() && nom == null; i++) {
            if (list.get(i).getIdEstadio() == id) {
                nom = list.get(i).getNombreEstadio();
            }
        }
        return nom;
    }

    public int getIdFromIndex(int index) {
        return obtenerEstadios().get(index).getIdEstadio();
    }

    public boolean validarAudiencia(int idEquipo, int audiencia) {
        ArrayList<Estadio> estadios = obtenerEstadios();
        boolean val = true;
        boolean found = false;
        Estadio e = null;

        for (int i = 0; i < estadios.size() && !found; i++) {
            e = estadios.get(i);
            if (e.getIdEstadio() == idEquipo) {
                found = true;
                val = audiencia <= e.getCapacidad();
            }
        }

        if (!val) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una audiencia menor a " + e.getCapacidad() + ", que es la capacidad del estadio " + e.getNombreEstadio() + ".",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return val;
    }
}
