package services;

import model.Delantero;
import utils.ConnectionManager;

import java.sql.*;

/**
 * Clase de servicios para gestionar las operaciones CRUD de los delanteros.
 */
public class DelanteroServices {

    /**
     * Método para crear un nuevo delantero en la base de datos.
     * @param delantero El objeto Delantero a crear.
     */
    public void crearDelantero(Delantero delantero) {
        String sql = "INSERT INTO delantero (nombre_equipo, numero, tiros_a_puerta) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(2, delantero.getNumero());
            pstmt.setInt(3, delantero.getTirosAPuerta());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para obtener un delantero específico.
     * @param nomEquipo El nombre del equipo del delantero.
     * @param numero El número del delantero.
     * @return El objeto Delantero.
     */
    public Delantero obtenerDelantero(String nomEquipo, int numero) {
        Delantero delantero = null;
        String sql = "SELECT * FROM delantero WHERE nombre_equipo = ? AND numero = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, nomEquipo);
            pstmt.setInt(2, numero);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    delantero = new Delantero();
                    delantero.setNumero(rs.getInt("numero"));
                    delantero.setTirosAPuerta(rs.getInt("tiros_a_puerta"));
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return delantero;
    }

    /**
     * Método para actualizar un delantero en la base de datos.
     * @param delantero El objeto Delantero a actualizar.
     */
    public void actualizarDelantero(Delantero delantero) {
        String sql = "UPDATE delantero SET tiros_a_puerta = ? WHERE nombre_equipo = ? AND numero = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, delantero.getTirosAPuerta());
            pstmt.setInt(3, delantero.getNumero());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para eliminar un delantero de la base de datos.
     * @param nomEquipo El nombre del equipo del delantero.
     * @param numero El número del delantero.
     */
    public void eliminarDelantero(String nomEquipo, int numero) {
        eliminarPosicionJugador(nomEquipo, numero); // Elimina la posición del jugador.
        String sql = "DELETE FROM delantero WHERE nombre_equipo = ? AND numero = ?";
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
