package services;

import model.Entrenador;
import utils.ConnectionManager;

import java.sql.*;

/**
 * Clase de servicios para gestionar las operaciones CRUD de los entrenadores.
 */
public class EntrenadorServices {

    /**
     * Método para crear un nuevo entrenador en la base de datos.
     * @param entrenador El objeto Entrenador a crear.
     */
    public void crearEntrenador(Entrenador entrenador) {
        String sql = "INSERT INTO entrenador (nombre_equipo, numero, anos_experiencia) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(2, entrenador.getNumero());
            pstmt.setInt(3, entrenador.getAñosExperiencia());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para obtener un entrenador específico.
     * @param nombreEquipo El nombre del equipo del entrenador.
     * @param numero El número del entrenador.
     * @return El objeto Entrenador.
     */
    public Entrenador obtenerEntrenador(String nombreEquipo, int numero) {
        Entrenador entrenador = null;
        String sql = "SELECT * FROM entrenador WHERE nombre_equipo = ? AND numero = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, nombreEquipo);
            pstmt.setInt(2, numero);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    entrenador = new Entrenador();
                    entrenador.setNumero(rs.getInt("numero"));
                    entrenador.setAñosExperiencia(rs.getInt("anos_experiencia"));
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entrenador;
    }

    /**
     * Método para actualizar un entrenador en la base de datos.
     * @param entrenador El objeto Entrenador a actualizar.
     */
    public void actualizarEntrenador(Entrenador entrenador) {
        String sql = "UPDATE entrenador SET anos_experiencia = ? WHERE nombre_equipo = ? AND numero = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, entrenador.getAñosExperiencia());
            pstmt.setInt(3, entrenador.getNumero());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para eliminar un entrenador de la base de datos.
     * @param nombreEquipo El nombre del equipo del entrenador.
     * @param numero El número del entrenador.
     */
    public void eliminarEntrenador(String nombreEquipo, int numero) {
        String sql = "DELETE FROM entrenador WHERE nombre_equipo = ? AND numero = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, nombreEquipo);
            pstmt.setInt(2, numero);
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
