package services;

import model.Portero;
import utils.ConnectionManager;

import java.sql.*;

/**
 * Clase de servicios para gestionar las operaciones CRUD de los porteros.
 */
public class PorteroServices {

    /**
     * Método para crear un nuevo portero en la base de datos.
     * @param portero El objeto Portero a crear.
     */
    public void crearPortero(Portero portero) {
        String sql = "INSERT INTO portero (nombre_equipo, numero, paradas, goles_encajados) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(2, portero.getNumero());
            pstmt.setInt(3, portero.getParadas());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para obtener un portero específico.
     * @param nomEquipo El nombre del equipo del portero.
     * @param numero El número del portero.
     * @return El objeto Portero.
     */
    public Portero obtenerPortero(String nomEquipo, int numero) {
        Portero portero = null;
        String sql = "SELECT * FROM portero WHERE nombre_equipo = ? AND numero = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, nomEquipo);
            pstmt.setInt(2, numero);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    portero = new Portero();
                    portero.setNumero(rs.getInt("numero"));
                    portero.setParadas(rs.getInt("paradas"));
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return portero;
    }

    /**
     * Método para actualizar un portero en la base de datos.
     * @param portero El objeto Portero a actualizar.
     */
    public void actualizarPortero(Portero portero) {
        String sql = "UPDATE portero SET paradas = ?, goles_encajados = ? WHERE nombre_equipo = ? AND numero = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, portero.getParadas());
            pstmt.setInt(4, portero.getNumero());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para eliminar un portero de la base de datos.
     * @param nomEquipo El nombre del equipo del portero.
     * @param numero El número del portero.
     */
    public void eliminarPortero(String nomEquipo, int numero) {
        eliminarPosicionJugador(nomEquipo, numero); // Elimina la posición del jugador.
        String sql = "DELETE FROM portero WHERE nombre_equipo = ? AND numero = ?";
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
