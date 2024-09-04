package services;

import model.Partido;
import utils.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import model.Estadio;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import utils.Report;

/**
 * Clase de servicios para gestionar las operaciones CRUD de los partidos.
 */
public class PartidoServices {

    /**
     * Método para crear un nuevo partido en la base de datos.
     * @param partido El objeto Partido a crear.
     */
    public void crearPartido(Partido partido) {
        String sql = "INSERT INTO partido (audiencia, fecha, fkestadio, local, visitante, goles_local, goles_visitante) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, partido.getAudiencia());
            pstmt.setTimestamp(2, new Timestamp(partido.getFecha().getTime()));
            pstmt.setInt(3, partido.getIdEstadio());
            pstmt.setInt(4, partido.getIdEquipoLocal());
            pstmt.setInt(5, partido.getIdEquipoVisitante());
            pstmt.setInt(6, partido.getGoles_local());
            pstmt.setInt(7, partido.getGoles_visitante());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para obtener todos los partidos de la base de datos.
     * @return Lista de partidos.
     */
    public List<Partido> obtenerPartidos() {
        List<Partido> partidos = new ArrayList<>();
        String sql = "SELECT * FROM partido";
        try (Connection conn = ConnectionManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
             
            while (rs.next()) {
                Partido partido = new Partido();
                partido.setIdPartido(rs.getInt("idpartido"));
                partido.setAudiencia(rs.getInt("audiencia"));
                partido.setFecha(rs.getTimestamp("fecha"));
                System.out.println(partido.getFecha());
                partido.setIdEstadio(rs.getInt("fkestadio"));
                partido.setIdEquipoLocal(rs.getInt("local"));
                partido.setIdEquipoVisitante(rs.getInt("visitante"));
                partido.setGoles_local(rs.getInt("goles_local"));
                partido.setIdEquipoVisitante(rs.getInt("goles_visitante"));
                partidos.add(partido);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return partidos;
    }

    /**
     * Método para actualizar un partido en la base de datos.
     * @param partido El objeto Partido a actualizar.
     */
    public void actualizarPartido(Partido partido) {
        String sql = "UPDATE partido SET audiencia = ?, fecha = ?, fkestadio = ?, local = ?, visitante = ?, goles_local = ?, goles_visitante = ?  WHERE idpartido = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, partido.getAudiencia());
            pstmt.setTimestamp(2, new Timestamp(partido.getFecha().getTime()));
            pstmt.setInt(3, partido.getIdEstadio());
            pstmt.setInt(4, partido.getIdEquipoLocal());
            pstmt.setInt(5, partido.getIdEquipoVisitante());
            pstmt.setInt(6, partido.getIdEquipoLocal());
            pstmt.setInt(7, partido.getIdEquipoVisitante());
            pstmt.setInt(8, partido.getIdPartido());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para eliminar un partido de la base de datos.
     * @param idPartido El ID del partido a eliminar.
     */
    public void eliminarPartido(int idPartido) {
        String sql = "DELETE FROM partido WHERE idpartido = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, idPartido);
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void reportePartidosPorEquipos (int equipo1, int equipo2) {
        try {
            
            int idEquipo1 = ServicesLocator.getEquipoServices().obtenerEquipos().get(equipo1).getIdEquipo();
            int idEquipo2 = ServicesLocator.getEquipoServices().obtenerEquipos().get(equipo2).getIdEquipo();
            
            // Ruta del archivo .jasper
            String reportPath = "src/main/java/reports/Partidos_por_equipos.jasper";

            // Parámetros para pasar al reporte (si se necesitan)
            Map<String, Object> parametros = new HashMap<>();
            
            parametros.put("equipo1", idEquipo1);
            parametros.put("equipo2", idEquipo2);

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
    
    public void reportePartidosPorFecha (Date fecha, int index) {
        try {
            // Ruta del archivo .jasper
            String reportPath = "src/main/java/reports/Partidos_por_fecha.jasper";
            
            // Parámetros para pasar al reporte
            Map<String, Object> parametros = new HashMap<>();
            
            parametros.put("fecha", new java.sql.Date(fecha.getTime()));
            
            
            if (index == 0) {
                reportPath = "src/main/java/reports/Partidos_por_fecha_all.jasper";
            } 
            else {
                Estadio estadio = ServicesLocator.getEstadioServices().obtenerEstadios().get(index - 1);
                parametros.put("estadio", estadio.getIdEstadio());
            }
            
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
}
