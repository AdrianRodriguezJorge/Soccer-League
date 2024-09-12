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
     * 
     * @param portero El objeto Portero a crear.
     */
    public void crearPortero(Portero portero) {
        String sql = "INSERT INTO portero (idfutbolista, paradas, golesencajados) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, portero.getIdFutbolista());
            pstmt.setInt(2, portero.getParadas());
            pstmt.setInt(3, portero.getGolesEncajados());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Portero obtenerPortero(int idfutbolista) {
        Portero portero = null;
        String sql = "SELECT * FROM portero WHERE idfutbolista = ?";
        try (Connection conn = ConnectionManager.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idfutbolista);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    portero = new Portero();
                    portero.setIdFutbolista(idfutbolista);
                    portero.setParadas(rs.getInt("paradas"));
                    portero.setGolesEncajados(rs.getInt("golesencajados"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return portero;
    }

    /**
     * Método para actualizar un portero en la base de datos.
     * 
     * @param portero El objeto Portero a actualizar.
     */
    public void actualizarPortero(Portero portero) {
        String sql = "UPDATE portero SET paradas = ?, golesencajados = ? WHERE idfutbolista = ?";
        try (Connection conn = ConnectionManager.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, portero.getParadas());
            pstmt.setInt(2, portero.getGolesEncajados());
            pstmt.setInt(2, portero.getIdFutbolista());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
