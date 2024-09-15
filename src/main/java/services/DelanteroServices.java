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
     * 
     * @param delantero El objeto Delantero a crear.
     */
    public void crearDelantero(Delantero delantero) {
        String sql = "INSERT INTO delantero (idfutbolista, tirosapuerta) VALUES (?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, delantero.getIdFutbolista());
            pstmt.setInt(2, delantero.getTirosAPuerta());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Delantero obtenerDelantero(int idfutbolista) {
        Delantero delantero = null;
        String sql = "SELECT * FROM delantero WHERE idfutbolista = ?";
        try (Connection conn = ConnectionManager.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idfutbolista);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    delantero = new Delantero();
                    delantero.setIdFutbolista(idfutbolista);
                    delantero.setTirosAPuerta(rs.getInt("tirosapuerta"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return delantero;
    }

    /**
     * Método para actualizar un delantero en la base de datos.
     * 
     * @param delantero El objeto Delantero a actualizar.
     */
    public void actualizarDelantero(Delantero delantero) {
        String sql = "UPDATE delantero SET tirosapuerta = ? WHERE idfutbolista = ?";
        try (Connection conn = ConnectionManager.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, delantero.getTirosAPuerta());
            pstmt.setInt(2, delantero.getIdFutbolista());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
