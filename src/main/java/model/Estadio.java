package model;

/**
 * Clase que representa un Estadio donde se juega un partido.
 */
public class Estadio {
     private int idEstadio;
     private String nombreEstadio;
     private int capacidad;

     // Constructor
     public Estadio(int idEstadio, String nombreEstadio, int capacidad) {
          this.idEstadio = idEstadio;
          this.nombreEstadio = nombreEstadio;
          this.capacidad = capacidad;
     }

     // Métodos getter y setter
     public int getIdEstadio() {
          return idEstadio;
     }

     public void setIdEstadio(int idEstadio) {
          this.idEstadio = idEstadio;
     }

     public String getNombreEstadio() {
          return nombreEstadio;
     }

     public void setNombreEstadio(String nombreEstadio) {
          this.nombreEstadio = nombreEstadio;
     }

     public int getCapacidad() {
          return capacidad;
     }

     public void setCapacidad(int capacidad) {
          this.capacidad = capacidad;
     }

     @Override
     public String toString() {
          return  nombreEstadio;
     }
}