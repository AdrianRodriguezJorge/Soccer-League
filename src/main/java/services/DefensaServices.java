package services;

import model.Defensa;
import utils.ConnectionManager;

import java.sql.*;

/**
 * Clase de servicios para gestionar las operaciones CRUD de los defensas.
 */
public class DefensaServices {

    /**
     * Método para crear un nuevo defensa en la base de datos.
     * @param defensa El objeto Defensa a crear.
     */
    public void crearDefensa(Defensa defensa) {
        String sql = "INSERT INTO defensa (nombre_equipo, numero, entradas, bloqueos) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(2, defensa.getNumero());
            pstmt.setInt(3, defensa.getEntradas());
            pstmt.setInt(4, defensa.getBloqueos());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para obtener un defensa específico.
     * @param nomEquipo El nombre del equipo del defensa.
     * @param numero El número del defensa.
     * @return El objeto Defensa.
     */
    public Defensa obtenerDefensa(String nomEquipo, int numero) {
        Defensa defensa = null;
        String sql = "SELECT * FROM defensa WHERE nombre_equipo = ? AND numero = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, nomEquipo);
            pstmt.setInt(2, numero);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    defensa = new Defensa();
                    defensa.setIdEquipo(rs.getInt("idequipo"));
                    defensa.setNumero(rs.getInt("numero"));
                    defensa.setEntradas(rs.getInt("entradas"));
                    defensa.setBloqueos(rs.getInt("bloqueos"));
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return defensa;
    }

    /**
     * Método para actualizar un defensa en la base de datos.
     * @param defensa El objeto Defensa a actualizar.
     */
    public void actualizarDefensa(Defensa defensa) {
        String sql = "UPDATE defensa SET entradas = ?, bloqueos = ? WHERE nombre_equipo = ? AND numero = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, defensa.getEntradas());
            pstmt.setInt(2, defensa.getBloqueos());
            pstmt.setInt(3, defensa.getIdEquipo());
            pstmt.setInt(4, defensa.getNumero());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para eliminar un defensa de la base de datos.
     * @param nomEquipo El nombre del equipo del defensa.
     * @param numero El número del defensa.
     */
    public void eliminarDefensa(String nomEquipo, int numero) {
        eliminarPosicionJugador(nomEquipo, numero); // Elimina la posición del jugador.
        String sql = "DELETE FROM defensa WHERE nombre_equipo = ? AND numero = ?";
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
