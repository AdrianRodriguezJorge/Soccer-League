package services;

import model.Defensa;
import model.Delantero;
import model.Equipo;
import utils.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;

/**
 * Clase de servicios para gestionar las operaciones CRUD de los defensas.
 */
public class DefensaServices {

    /**
     * Método para crear un nuevo defensa en la base de datos.
     * 
     * @param defensa El objeto Defensa a crear.
     */
    public void crearDefensa(Defensa defensa) {
        String sql = "INSERT INTO defensa (idfutbolista, entradas, bloqueos) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, defensa.getIdFutbolista());
            pstmt.setInt(2, defensa.getEntradas());
            pstmt.setInt(3, defensa.getBloqueos());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Defensa obtenerDefensa(int idfutbolista) {
        Defensa defensa = null;
        String sql = "SELECT * FROM defensa WHERE idfutbolista = ?";
        try (Connection conn = ConnectionManager.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idfutbolista);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    defensa = new Defensa();
                    defensa.setIdFutbolista(idfutbolista);
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
     * 
     * @param defensa El objeto Defensa a actualizar.
     */
    public void actualizarDefensa(Defensa defensa) {
        String sql = "UPDATE defensa SET entradas = ?, bloqueos = ? WHERE idfutbolista = ?";
        try (Connection conn = ConnectionManager.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, defensa.getEntradas());
            pstmt.setInt(2, defensa.getBloqueos());
            pstmt.setInt(3, defensa.getIdFutbolista());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
