/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import utils.ConnectionManager;

/**
 *
 * @author HP 11na
 */
public class IntervaloFServices {

    public void establecerIntervalo(Date inicio, Date fin) {
        String sql = "UPDATE intervalo_liga SET fecha = ? WHERE id = ?";
        try (Connection conn = ConnectionManager.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setDate(1, new java.sql.Date(inicio.getTime()));
            pstmt.setInt(2, 0);
            pstmt.executeUpdate();
            
            pstmt.setDate(1, new java.sql.Date(fin.getTime()));
            pstmt.setInt(2, 1);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
