package services;

import model.Usuario;
import utils.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;

public class UsuarioServices {

     // Método para obtener todos los usuarios
     public ArrayList <Usuario> getAllUsuarios() throws SQLException {
          ArrayList <Usuario> usuarios = new ArrayList<>();
          String query = "SELECT id, nombre_usuario, contraseña, rol FROM usuario ORDER BY rol";

          try (Statement stmt = ConnectionManager.getConnection().createStatement();
                    ResultSet rs = stmt.executeQuery(query)) {
               while (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getInt("id"));
                    usuario.setNombreUsuario(rs.getString("nombre_usuario"));
                    usuario.setContraseña(rs.getString("contraseña"));
                    usuario.setRol(rs.getString("rol"));
                    usuarios.add(usuario);
               }
          }
          return usuarios;
     }

     // Método para obtener un usuario por ID
     public Usuario getById(Long id) throws SQLException {
          Usuario usuario = null;
          String query = "SELECT id, nombre_usuario, contraseña, rol FROM usuario WHERE id = ?";
          try (PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(query)) {
               pstmt.setLong(1, id);
               try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                         usuario = new Usuario();
                         usuario.setId(rs.getInt("id"));
                         usuario.setNombreUsuario(rs.getString("nombre_usuario"));
                         usuario.setContraseña(rs.getString("contraseña"));
                         usuario.setRol(rs.getString("rol"));
                    }
               }
          }
          return usuario;
     }

     // Método para crear un nuevo usuario
     public Usuario crearUsuario(Usuario usuario) throws SQLException {
          String query = "INSERT INTO usuario (nombre_usuario, contraseña, rol) VALUES (?, crypt(?, gen_salt('bf')), ?)";
          PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
          pstmt.setString(1, usuario.getNombreUsuario());
          pstmt.setString(2, usuario.getContraseña());
          pstmt.setString(3, usuario.getRol());
          pstmt.executeUpdate();
          return usuario;
     }

     // Método para actualizar un usuario
     public Usuario actualizarUsuario(Usuario usuario) throws SQLException {
          String query = "UPDATE usuario SET nombre_usuario = ?, contraseña = crypt(?, gen_salt('bf')), rol = ? WHERE id = ?";
          try (PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(query)) {
               pstmt.setString(1, usuario.getNombreUsuario());
               pstmt.setString(2, usuario.getContraseña());
               pstmt.setString(3, usuario.getRol());
               pstmt.setLong(4, usuario.getId());
               pstmt.executeUpdate();
          }
          return usuario;
     }

     // Método para eliminar un usuario por ID
     public void eliminarUsuario(int id) throws SQLException {
          String query = "DELETE FROM usuario WHERE id = ?";
          try (PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(query)) {
               pstmt.setInt(1, id);
               pstmt.executeUpdate();
          }
     }

     // Método para encontrar un usuario por su nombre de usuario
     public Usuario getByNombreUsuario(String nombreUsuario) throws SQLException {
          String query = "SELECT id, nombre_usuario, contraseña, rol FROM usuario WHERE nombre_usuario = ?";
          PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(query);
          pstmt.setString(1, nombreUsuario);
          ResultSet rs = pstmt.executeQuery();
          Usuario usuario = null;
          if (rs.next()) {
               usuario = new Usuario();
               usuario.setId(rs.getInt("id"));
               usuario.setNombreUsuario(rs.getString("nombre_usuario"));
               usuario.setContraseña(rs.getString("contraseña"));
               usuario.setRol(rs.getString("rol"));
          }
          return usuario;
     }

     public boolean verificarContrasena(String nombreUsuario, String contraseñaIngresada) throws SQLException {
          String query = "SELECT contraseña = crypt(?, contraseña) AS contraseña_valida " +
                    "FROM usuario WHERE nombre_usuario = ?";

          try (PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(query)) {
               pstmt.setString(1, contraseñaIngresada); // Contraseña ingresada por el usuario
               pstmt.setString(2, nombreUsuario); // Nombre de usuario para buscar en la BD

               try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                         return rs.getBoolean("contraseña_valida"); // Devuelve true si la contraseña es válida
                    }
               }
          }
          return false; // Si no se encuentra el usuario o la contraseña no es válida
     }
}
