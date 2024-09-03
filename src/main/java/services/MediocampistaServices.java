package services;

import model.Mediocampista;
import utils.ConnectionManager;

import java.sql.*;

/**
 * Clase de servicios para gestionar las operaciones CRUD de los mediocampistas.
 */
public class MediocampistaServices {

    /**
     * Método para crear un nuevo mediocampista en la base de datos.
     * @param mediocampista El objeto Mediocampista a crear.
     */
    public void crearMediocampista(Mediocampista mediocampista) {
        String sql = "INSERT INTO mediocampista (nombre_equipo, numero, pases_completados, intercepciones) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(2, mediocampista.getNumero());
            pstmt.setInt(3, mediocampista.getPasesCompletados());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para obtener un mediocampista específico.
     * @param nomEquipo El nombre del equipo del mediocampista.
     * @param numero El número del mediocampista.
     * @return El objeto Mediocampista.
     */
    public Mediocampista obtenerMediocampista(String nomEquipo, int numero) {
        Mediocampista mediocampista = null;
        String sql = "SELECT * FROM mediocampista WHERE nombre_equipo = ? AND numero = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, nomEquipo);
            pstmt.setInt(2, numero);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    mediocampista = new Mediocampista();
                    mediocampista.setNumero(rs.getInt("numero"));
                    mediocampista.setPasesCompletados(rs.getInt("pases_completados"));
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mediocampista;
    }

    /**
     * Método para actualizar un mediocampista en la base de datos.
     * @param mediocampista El objeto Mediocampista a actualizar.
     */
    public void actualizarMediocampista(Mediocampista mediocampista) {
        String sql = "UPDATE mediocampista SET pases_completados = ?, intercepciones = ? WHERE nombre_equipo = ? AND numero = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, mediocampista.getPasesCompletados());
            pstmt.setInt(4, mediocampista.getNumero());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para eliminar un mediocampista de la base de datos.
     * @param nomEquipo El nombre del equipo del mediocampista.
     * @param numero El número del mediocampista.
     */
    public void eliminarMediocampista(String nomEquipo, int numero) {
        eliminarPosicionJugador(nomEquipo, numero); // Elimina la posición del jugador.
        String sql = "DELETE FROM mediocampista WHERE nombre_equipo = ? AND numero = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, nomEquipo);
            pstmt.setInt(2, numero);
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Método para eliminar la posición del jugador
    private void eliminarPosicionJugador(String nomEquipo, int numero) {
        JugadorServices jugadorServices = new JugadorServices();
        jugadorServices.eliminarPosicionJugador(nomEquipo, numero);
    }
}
