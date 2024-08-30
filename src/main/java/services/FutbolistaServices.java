package services;

import model.Futbolista;
import utils.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de servicios para gestionar las operaciones CRUD de los futbolistas.
 */
public class FutbolistaServices {

    /**
     * Método para crear un nuevo futbolista en la base de datos.
     * @param futbolista El objeto Futbolista a crear.
     */
    public void crearFutbolista(Futbolista futbolista) {
        String sql = "INSERT INTO futbolista (nombre, numero, edad, equipo, goles, asistencias) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, futbolista.getNombre());
            pstmt.setInt(2, futbolista.getNumero());
            pstmt.setInt(3, futbolista.getAñosEnEquipo());
            pstmt.setInt(4, futbolista.getIdEquipo());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para obtener todos los futbolistas de la base de datos.
     * @return Lista de futbolistas.
     */
    public List<Futbolista> obtenerFutbolistas() {
        List<Futbolista> futbolistas = new ArrayList<>();
        String sql = "SELECT * FROM futbolista";
        try (Connection conn = ConnectionManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
             
            while (rs.next()) {
                // Futbolista futbolista = new Futbolista();
                // futbolista.setIdFutbolista(rs.getInt("id_futbolista"));
                // futbolista.setNombre(rs.getString("nombre"));
                // futbolista.setNumero(rs.getInt("numero"));
                // futbolista.setEdad(rs.getInt("edad"));
                // futbolista.setEquipo(rs.getInt("equipo"));
                // futbolista.setGoles(rs.getInt("goles"));
                // futbolista.setAsistencias(rs.getInt("asistencias"));
                // futbolistas.add(futbolista);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return futbolistas;
    }

    /**
     * Método para actualizar un futbolista en la base de datos.
     * @param futbolista El objeto Futbolista a actualizar.
     */
    public void actualizarFutbolista(Futbolista futbolista) {
        String sql = "UPDATE futbolista SET nombre = ?, numero = ?, edad = ?, equipo = ?, goles = ?, asistencias = ? WHERE id_futbolista = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, futbolista.getNombre());
            pstmt.setInt(2, futbolista.getNumero());
            pstmt.setInt(3, futbolista.getAñosEnEquipo());
            pstmt.setInt(4, futbolista.getIdEquipo());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para eliminar un futbolista de la base de datos.
     * @param idFutbolista El ID del futbolista a eliminar.
     */
    public void eliminarFutbolista(int idFutbolista) {
        String sql = "DELETE FROM futbolista WHERE id_futbolista = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, idFutbolista);
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
