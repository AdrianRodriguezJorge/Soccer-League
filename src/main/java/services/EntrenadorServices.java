package services;

import model.Entrenador;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import utils.ConnectionManager;
import utils.Report;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase de servicios para gestionar las operaciones CRUD de los entrenadores.
 */
public class EntrenadorServices {

    /**
     * Método para crear un nuevo entrenador en la base de datos.
     * @param entrenador El objeto Entrenador a crear.
     */
    public void crearEntrenador(Entrenador entrenador) {
        String sql = "INSERT INTO entrenador (idfutbolista, añosexperiencia) VALUES (?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, entrenador.getIdFutbolista());
            pstmt.setInt(2, entrenador.getAñosExperiencia());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para obtener un entrenador específico.
     * @param nomEquipo El nombre del equipo del entrenador.
     * @param numero El número del entrenador.
     * @return El objeto Entrenador.
     */
    public int obtenerDatosEntrenador(int idFutb) {
        int years = -1;
        String sql = "SELECT * FROM entrenador WHERE idfutbolista = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, idFutb);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    years = rs.getInt("añosexperiencia");
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return years;
    }

    /**
     * Método para actualizar un entrenador en la base de datos.
     * @param entrenador El objeto Entrenador a actualizar.
     */
    public void actualizarEntrenador(Entrenador entrenador) {
        String sql = "UPDATE entrenador SET añosexperiencia = ? WHERE idfutbolista = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, entrenador.getAñosExperiencia());
            pstmt.setInt(2, entrenador.getIdFutbolista());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void reporteEntrenadoresExp () {
        try {
            // Ruta del archivo .jasper
            String reportPath = "src/main/java/reports/Entrenadores_exp.jasper";

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
}
