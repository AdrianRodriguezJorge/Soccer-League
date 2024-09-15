package model;

public class Usuario {

     private int id;
     private String nombreUsuario;
     private String contraseña;
     private String rol;

     public Usuario(String nombreUsuario, String contraseña, String rol) {
          setNombreUsuario(nombreUsuario);
          setContraseña(contraseña);
          setRol(rol);
     }

     public Usuario() {

     }

     public Usuario(int id, String nombre, String pass, String rol) {
          setId(id);
          setNombreUsuario(nombre);
          setContraseña(pass);
          setRol(rol);
     }

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public String getNombreUsuario() {
          return nombreUsuario;
     }

     public void setNombreUsuario(String nombreUsuario) {
          if (!nombreUsuario.replace(" ", "").equals("")) {
               this.nombreUsuario = nombreUsuario;
          } else
               throw new IllegalArgumentException();
     }

     public String getContraseña() {
          return contraseña;
     }

     public void setContraseña(String contraseña) {
          if (!contraseña.replace(" ", "").equals("")) {
               this.contraseña = contraseña;
          } else
               throw new IllegalArgumentException();
     }

     public String getRol() {
          return rol;
     }

     public void setRol(String rol) {
          if (rol.equals(Rol.gestor_liga.toString()) || rol.equals(Rol.gestor_usuario.toString())) {
               this.rol = rol;
          } else
               throw new IllegalArgumentException();
     }

     @Override
     public String toString() {
          return nombreUsuario;
     }

}
