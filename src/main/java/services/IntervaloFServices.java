/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import model.Partido;
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
    
    public boolean ligaActiva () {
        boolean activa = false;
        ArrayList <Date> fechas = new ArrayList<>();
        String sql = "SELECT * FROM intervalo_liga";
        try (Connection conn = ConnectionManager.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                fechas.add(rs.getDate("fecha"));
            }
            Date actual = new Date();
            if (actual.compareTo(fechas.getFirst()) >= 0 && actual.compareTo(fechas.getLast()) <= 0) {
                activa = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return activa;
    }
}
