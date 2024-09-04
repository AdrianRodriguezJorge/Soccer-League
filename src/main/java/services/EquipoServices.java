package services;

import model.Equipo;
import model.Estadio;
import utils.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import utils.Report;

/**
 * Clase de servicios para gestionar las operaciones CRUD de los equipos.
 */
public class EquipoServices {

    /**
     * Método para crear un nuevo equipo en la base de datos.
     * 
     * @param equipo El objeto Equipo a crear.
     */
    public void crearEquipo(String nomequipo, String provincia, int camparticip, int campganados, String mascota,
            String color, int puntos) {
        String sql = "INSERT INTO equipo (nomequipo, provincia, camparticip, campganados, mascota, color, puntos) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nomequipo);
            pstmt.setString(2, provincia);
            pstmt.setInt(3, camparticip);
            pstmt.setInt(4, campganados);
            pstmt.setString(5, mascota);
            pstmt.setString(6, color);
            pstmt.setInt(7, puntos);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para obtener todos los equipos de la base de datos.
     * 
     * @return Lista de equipos.
     */
    public ArrayList<Equipo> obtenerEquipos() {
        ArrayList<Equipo> equipos = new ArrayList<>();
        String sql = "SELECT * FROM equipo ORDER BY idequipo";
        try (Connection conn = ConnectionManager.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Equipo equipo = new Equipo();
                equipo.setIdEquipo(rs.getInt("idequipo"));
                equipo.setNomEquipo(rs.getString("nomequipo"));
                equipo.setProvincia(rs.getString("provincia"));
                equipo.setCampParticipados(rs.getInt("camparticip"));
                equipo.setCampGanados(rs.getInt("campganados"));
                equipo.setMascota(rs.getString("mascota"));
                equipo.setColor(rs.getString("color"));
                equipo.setPuntos(rs.getInt("puntos"));
                equipos.add(equipo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipos;
    }

    /**
     * Método para actualizar un equipo en la base de datos.
     * 
     * @param equipo El objeto Equipo a actualizar.
     */
    public void actualizarEquipo(Equipo equipo) {
        String sql = "UPDATE equipo SET nomequipo = ?, provincia = ?, camparticip = ?, campganados = ?, mascota = ?, color = ?, puntos = ? WHERE id_equipo = ?";
        try (Connection conn = ConnectionManager.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, equipo.getNomEquipo());
            pstmt.setString(2, equipo.getProvincia());
            pstmt.setInt(3, equipo.getCampParticipados());
            pstmt.setInt(4, equipo.getCampGanados());
            pstmt.setString(5, equipo.getMascota());
            pstmt.setString(6, equipo.getColor());
            pstmt.setInt(7, equipo.getPuntos());
            pstmt.setInt(8, equipo.getIdEquipo());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para eliminar un equipo de la base de datos.
     * 
     * @param idEquipo El ID del equipo a eliminar.
     */
    public void eliminarEquipo(int idEquipo) {
        String sql = "DELETE FROM equipo WHERE idequipo = ?";
        try (Connection conn = ConnectionManager.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idEquipo);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void reporteTablaPosiciones() {
        try {
            // Ruta del archivo .jasper
            String reportPath = "src/main/java/reports/Tabla_de_posiciones.jasper";

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

    public ArrayList<String> obtenerNombresEquipos() {
        ArrayList<String> list = new ArrayList<>();

        for (Equipo e : obtenerEquipos()) {
            list.add(e.getNomEquipo());
        }

        return list;
    }

    public void reporteEstadoEquipo(int index) {
        try {

            int idEquipo1 = getIdFromIndex(index);

            // Ruta del archivo .jasper
            String reportPath = "src/main/java/reports/Estado_equipo.jasper";

            // Parámetros para pasar al reporte (si se necesitan)
            Map<String, Object> parametros = new HashMap<>();

            parametros.put("equipo", idEquipo1);

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

    public void reporteEquipoEstrella() {
        try {
            // Ruta del archivo .jasper
            String reportPath = "src/main/java/reports/Equipo_estrella.jasper";

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

    public String getNombreEquipo(int id) {
        String nom = null;
        ArrayList<Equipo> list = obtenerEquipos();

        for (int i = 0; i < list.size() && nom == null; i++) {
            if (list.get(i).getIdEquipo() == id) {
                nom = list.get(i).getNomEquipo();
            }
        }
        return nom;
    }

    public int getIdFromIndex (int index) {
        return obtenerEquipos().get(index).getIdEquipo();
    }
}
