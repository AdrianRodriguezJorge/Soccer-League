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
     * 
     * @param mediocampista El objeto Mediocampista a crear.
     */
    public void crearMediocampista(Mediocampista mediocampista) {
        String sql = "INSERT INTO mediocampista (idfutbolista, pasescompletados, intercepciones) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, mediocampista.getIdFutbolista());
            pstmt.setInt(2, mediocampista.getPasesCompletados());
            pstmt.setInt(3, mediocampista.getIntercepciones());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para obtener un mediocampista específico.
     * 
     * @return El objeto Mediocampista.
     */
    public Mediocampista obtenerMediocampista(int idfutbolista) {
        Mediocampista mediocampista = null;
        String sql = "SELECT * FROM mediocampista WHERE idfutbolista = ?";
        try (Connection conn = ConnectionManager.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idfutbolista);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    mediocampista = new Mediocampista();
                    mediocampista.setPasesCompletados(rs.getInt("pasescompletados"));
                    mediocampista.setIntercepciones(rs.getInt("intercepciones"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mediocampista;
    }

    /**
     * Método para actualizar un mediocampista en la base de datos.
     * 
     * @param mediocampista El objeto Mediocampista a actualizar.
     */
    public void actualizarMediocampista(Mediocampista mediocampista) {
        String sql = "UPDATE mediocampista SET pasescompletados = ?, intercepciones = ? WHERE idfutbolista = ?";
        try (Connection conn = ConnectionManager.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, mediocampista.getPasesCompletados());
            pstmt.setInt(2, mediocampista.getIntercepciones());
            pstmt.setInt(2, mediocampista.getIdFutbolista());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
