package model;

public class Estadio {
     public int id;
     public String nombre;
     public int capacidad;

     public Estadio(int id, String nombre, int capacidad) {
          this.id = id;
          this.nombre = nombre;
          this.capacidad = capacidad;
     }
     
     public Estadio(String nombre, int capacidad) {
          this.nombre = nombre;
          this.capacidad = capacidad;
     }

     @Override
     public String toString() {
          return  nombre;
     }
}