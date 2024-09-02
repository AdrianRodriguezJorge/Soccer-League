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
     * @param equipo El objeto Equipo a crear.
     */
    public void crearEquipo(Equipo equipo) {
        String sql = "INSERT INTO equipo (nombre_equipo, provincia, campeonatos_participados, campeonatos_ganados, mascota, color, puntos) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, equipo.getNombreEquipo());
            pstmt.setString(2, equipo.getProvincia());
            pstmt.setInt(3, equipo.getCampeonatosParticipados());
            pstmt.setInt(4, equipo.getCampeonatosGanados());
            pstmt.setString(5, equipo.getMascota());
            pstmt.setString(6, equipo.getColor());
            pstmt.setInt(7, equipo.getPuntos());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para obtener todos los equipos de la base de datos.
     * @return Lista de equipos.
     */
    public ArrayList<Equipo> obtenerEquipos() {
        ArrayList<Equipo> equipos = new ArrayList<>();
        String sql = "SELECT * FROM equipo";
        try (Connection conn = ConnectionManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
             
            while (rs.next()) {
                Equipo equipo = new Equipo();
                equipo.setIdEquipo(rs.getInt("idequipo"));
                equipo.setNombreEquipo(rs.getString("nomequipo"));
                equipo.setProvincia(rs.getString("provincia"));
                equipo.setCampeonatosParticipados(rs.getInt("camparticip"));
                equipo.setCampeonatosGanados(rs.getInt("campganados"));
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
     * @param equipo El objeto Equipo a actualizar.
     */
    public void actualizarEquipo(Equipo equipo) {
        String sql = "UPDATE equipo SET nombre_equipo = ?, provincia = ?, campeonatos_participados = ?, campeonatos_ganados = ?, mascota = ?, color = ?, puntos = ? WHERE id_equipo = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, equipo.getNombreEquipo());
            pstmt.setString(2, equipo.getProvincia());
            pstmt.setInt(3, equipo.getCampeonatosParticipados());
            pstmt.setInt(4, equipo.getCampeonatosGanados());
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
     * @param idEquipo El ID del equipo a eliminar.
     */
    public void eliminarEquipo(int idEquipo) {
        String sql = "DELETE FROM equipo WHERE id_equipo = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, idEquipo);
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void reporteTablaPosiciones () {
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
    
    // public static int getIdEquipoDadoNombre (String nom)  {
		// String function = "{?= call getIdEquipoDadoNombre('?')}";
		// java.sql.Connection connection = ServicesLocator.getConnection();
		// connection.setAutoCommit(false);
		// CallableStatement preparedFunction = connection.prepareCall(function);
		// preparedFunction.registerOutParameter(1, java.sql.Types.INTEGER); 
		// preparedFunction.setString(2, nom);
		// preparedFunction.execute();
		// ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
		// int id = resultSet.getInt(1);
		// resultSet.close();
		// preparedFunction.close();
		// connection.close();
		
        // String sql = "SELECT getIdEquipoDadoNombre('?')";
        // Connection connection = ConnectionManager.getConnection();
        // PreparedStatement stmn = connection.prepareStatement(sql);
        // stmn.setString(1, nom);
        // ResultSet rs = stmn.executeQuery();
        // int id = rs.getInt("idequipo");

		    // return id;
	// }
    
    public ArrayList <String> obtenerNombresEquipos () {
        ArrayList <String> list = new ArrayList<>();

        for (Equipo e : obtenerEquipos()) {
            list.add(e.getNombreEquipo());
        }

        return list;
    }
}
