package services;

import model.Jugador;
import utils.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de servicios para gestionar las operaciones CRUD de los jugadores.
 */
public class JugadorServices {

    /**
     * Método para crear un nuevo jugador en la base de datos.
     * @param jugador El objeto Jugador a crear.
     */
    public void crearJugador(Jugador jugador) {
        String sql = "INSERT INTO jugador (nombre_equipo, numero, nombre, posicion, partidos_jugados, goles, asistencias, promedio_goles) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, jugador.getIdEquipo());
            pstmt.setInt(2, jugador.getNumero());
            pstmt.setString(3, jugador.getNombre());
            pstmt.setString(4, jugador.getPosicion());
            pstmt.setInt(5, jugador.getPartidosJugados());
            pstmt.setDouble(6, jugador.getPromedioGoles());
            pstmt.setInt(7, jugador.getAsistencias());
            pstmt.setDouble(8, jugador.getPromedioGoles());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para obtener todos los jugadores de la base de datos.
     * @return Lista de jugadores.
     */
    public List<Jugador> obtenerJugadores() {
        List<Jugador> jugadores = new ArrayList<>();
        String sql = "SELECT * FROM jugador";
        try (Connection conn = ConnectionManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
             
            while (rs.next()) {
                // Jugador jugador = new Jugador();
                // jugador.setIdEquipo(rs.getInt("nombre_equipo"));
                // jugador.setNumero(rs.getInt("numero"));
                // jugador.setNombre(rs.getString("nombre"));
                // jugador.setPosicion(rs.getString("posicion"));
                // jugador.setPartidosJugados(rs.getInt("partidos_jugados"));
                // jugador.setCantidadGoles(rs.getInt("goles"));
                // jugador.setAsistencias(rs.getInt("asistencias"));
                // jugador.setPromedioGoles(rs.getDouble("promedio_goles"));
                // jugadores.add(jugador);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jugadores;
    }

    /**
     * Método para obtener un jugador específico por su número y equipo.
     * @param nomEquipo El nombre del equipo del jugador.
     * @param numero El número del jugador.
     * @return El objeto Jugador.
     */
    public Jugador obtenerJugador(String nomEquipo, int numero) {
        Jugador jugador = null;
        String sql = "SELECT * FROM jugador WHERE nombre_equipo = ? AND numero = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, nomEquipo);
            pstmt.setInt(2, numero);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // jugador = new Jugador();
                    // jugador.setIdEquipo(rs.getInt("idequipo"));
                    // jugador.setNumero(rs.getInt("numero"));
                    // jugador.setNombre(rs.getString("nombre"));
                    // jugador.setPosicion(rs.getString("posicion"));
                    // jugador.setPartidosJugados(rs.getInt("partidos_jugados"));
                    // jugador.setPromedioGoles(rs.getDouble("goles"));
                    // jugador.setAsistencias(rs.getInt("asistencias"));
                    // jugador.setPromedioGoles(rs.getDouble("promedio_goles"));
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jugador;
    }

    /**
     * Método para actualizar un jugador en la base de datos.
     * @param jugador El objeto Jugador a actualizar.
     */
    public void actualizarJugador(Jugador jugador) {
        String sql = "UPDATE jugador SET nombre = ?, posicion = ?, partidos_jugados = ?, goles = ?, asistencias = ?, promedio_goles = ? WHERE nombre_equipo = ? AND numero = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, jugador.getNombre());
            pstmt.setString(2, jugador.getPosicion());
            pstmt.setInt(3, jugador.getPartidosJugados());
            pstmt.setInt(4, jugador.getCantidadGoles());
            pstmt.setInt(5, jugador.getAsistencias());
            pstmt.setDouble(6, jugador.getPromedioGoles());
            pstmt.setInt(7, jugador.getIdEquipo());
            pstmt.setInt(8, jugador.getNumero());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para eliminar un jugador de la base de datos.
     * @param nomEquipo El nombre del equipo del jugador.
     * @param numero El número del jugador.
     */
    public void eliminarJugador(String nomEquipo, int numero) {
        String sql = "DELETE FROM jugador WHERE nombre_equipo = ? AND numero = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, nomEquipo);
            pstmt.setInt(2, numero);
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para eliminar la posición de un jugador en la base de datos.
     * @param nomEquipo El nombre del equipo del jugador.
     * @param numero El número del jugador.
     */
    public void eliminarPosicionJugador(String nomEquipo, int numero) {
        String sql = "UPDATE jugador SET posicion = NULL WHERE nombre_equipo = ? AND numero = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, nomEquipo);
            pstmt.setInt(2, numero);
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
