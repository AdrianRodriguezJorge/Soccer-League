package services;

import model.Equipo;
import utils.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    public List<Equipo> obtenerEquipos() {
        List<Equipo> equipos = new ArrayList<>();
        String sql = "SELECT * FROM equipo";
        try (Connection conn = ConnectionManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
             
            while (rs.next()) {
                Equipo equipo = new Equipo();
                equipo.setIdEquipo(rs.getInt("id_equipo"));
                equipo.setNombreEquipo(rs.getString("nombre_equipo"));
                equipo.setProvincia(rs.getString("provincia"));
                equipo.setCampeonatosParticipados(rs.getInt("campeonatos_participados"));
                equipo.setCampeonatosGanados(rs.getInt("campeonatos_ganados"));
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
}
