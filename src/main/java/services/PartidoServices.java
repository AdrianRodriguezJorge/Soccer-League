package services;

import model.Partido;
import utils.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de servicios para gestionar las operaciones CRUD de los partidos.
 */
public class PartidoServices {

    /**
     * Método para crear un nuevo partido en la base de datos.
     * @param partido El objeto Partido a crear.
     */
    public void crearPartido(Partido partido) {
        String sql = "INSERT INTO partido (fecha, estadio, resultado, equipo_local, equipo_visitante, audiencia) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setDate(1, partido.getFecha());
            pstmt.setInt(2, partido.getIdEstadio());
            pstmt.setString(3, partido.getResultado());
            pstmt.setInt(4, partido.getIdEquipoLocal());
            pstmt.setInt(5, partido.getIdEquipoVisitante());
            pstmt.setInt(6, partido.getAudiencia());
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
                partido.setFecha(rs.getDate("fecha"));
                partido.setIdEstadio(rs.getInt("fk_estadio"));
                partido.setResultado(rs.getString("resultado"));
                partido.setIdEquipoLocal(rs.getInt("equipo_local"));
                partido.setIdEquipoVisitante(rs.getInt("equipo_visitante"));
                partido.setAudiencia(rs.getInt("audiencia"));
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
        String sql = "UPDATE partido SET fecha = ?, estadio = ?, resultado = ?, equipo_local = ?, equipo_visitante = ?, audiencia = ? WHERE idpartido = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setDate(1, partido.getFecha());
            pstmt.setInt(2, partido.getIdEstadio());
            pstmt.setString(3, partido.getResultado());
            pstmt.setInt(4, partido.getIdEquipoLocal());
            pstmt.setInt(5, partido.getIdEquipoVisitante());
            pstmt.setInt(6, partido.getAudiencia());
            pstmt.setInt(7, partido.getIdPartido());
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
}
