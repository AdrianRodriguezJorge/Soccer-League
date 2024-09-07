package model;

/**
 * Clase que representa un Estadio donde se juega un partido.
 */
public class Estadio {
     private int idEstadio;
     private String nombreEstadio;
     private int capacidad;

     // Constructor
     public Estadio(String nombreEstadio, int capacidad) {
          this.nombreEstadio = nombreEstadio;
          this.capacidad = capacidad;
     }

     public Estadio() {
          //TODO Auto-generated constructor stub
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