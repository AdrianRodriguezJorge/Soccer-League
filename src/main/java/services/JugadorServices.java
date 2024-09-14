package services;

import model.Jugador;
import model.Mediocampista;
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
     * 
     * @param jugador El objeto Jugador a crear.
     * @throws SQLException
     */
    public void crearJugador(Jugador jugador) throws SQLException {
        String sql = "INSERT INTO jugador (idfutbolista, posicion, partidosjugados, cantidadgoles, asistencias) VALUES (?, ?, ?, ?, ?)";

        Connection conn = ConnectionManager.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, jugador.getIdFutbolista());
        pstmt.setString(2, jugador.getPosicion());
        pstmt.setInt(3, jugador.getPartidosJugados());
        pstmt.setInt(4, jugador.getCantidadGoles());
        pstmt.setInt(5, jugador.getAsistencias());
        pstmt.executeUpdate();

        // se obtiene el id recien ingresado para ser utilizado en las otras tablas
        sql = "SELECT promediogoles FROM jugador WHERE idfutbolista = ?";
        pstmt = conn.prepareStatement(sql);

        pstmt.setInt(1, jugador.getIdFutbolista());

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            double prom = rs.getDouble("promediogoles");
            jugador.setPromedioGoles(prom);
        } else
            throw new SQLException("Algo salió mal al establecer el promedio de goles del jugador.");

    }

    /**
     * Método para obtener un jugador específico.
     * 
     * @return El objeto Jugador.
     */
    public Jugador obtenerJugador(int idfutbolista) {
        Jugador jugador = null;
        String sql = "SELECT * FROM jugador WHERE idfutbolista = ?";
        try (Connection conn = ConnectionManager.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idfutbolista);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    jugador = new Mediocampista();
                    jugador.setPosicion(rs.getString("posicion"));
                    jugador.setPartidosJugados(rs.getInt("partidosjugados"));
                    jugador.setCantidadGoles(rs.getInt("cantidadgoles"));
                    jugador.setAsistencias(rs.getInt("asistencias"));
                    jugador.setPromedioGoles(rs.getDouble("promediogoles"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jugador;
    }

    /**
     * Método para actualizar un jugador en la base de datos.
     * 
     * @param jugador El objeto Jugador a actualizar.
     */
    public void actualizarJugador(Jugador jugador) {
        String sql = "UPDATE jugador SET posicion = ?, partidosjugados = ?, cantidadgoles = ?, asistencias = ?, promediogoles = ? WHERE idfutbolista = ?";
        try (Connection conn = ConnectionManager.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, jugador.getPosicion());
            pstmt.setInt(2, jugador.getPartidosJugados());
            pstmt.setInt(3, jugador.getCantidadGoles());
            pstmt.setInt(4, jugador.getAsistencias());
            pstmt.setDouble(5, jugador.getPromedioGoles());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
