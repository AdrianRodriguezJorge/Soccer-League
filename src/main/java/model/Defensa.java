package model;

/**
 * Clase que representa un Defensa, que es un tipo de Jugador.
 */
public class Defensa extends Jugador {
     private int bloqueos;
     private int entradas;

     // Constructores
     public Defensa(int idFutbolista, int idEquipo, int numero, String nombre, int añosEnEquipo, String tipo, int partidosJugados,
               int cantidadGoles, int asistencias, double promedioGoles, String pos, int entradas, int bloqueos) {
          super(idFutbolista, idEquipo, numero, nombre, añosEnEquipo, tipo, partidosJugados, cantidadGoles, asistencias,
                    promedioGoles, pos);
          setEntradas(entradas);
          setBloqueos(bloqueos);
     }

     public Defensa(int idEquipo, int numero, String nombre, int añosEnEquipo, String tipo, int partidosJugados, int cantidadGoles,
               int asistencias, String pos, int entradas, int bloqueos) {
          super(idEquipo, numero, nombre, añosEnEquipo, tipo, partidosJugados, cantidadGoles, asistencias, pos);
          setEntradas(entradas);
          setBloqueos(bloqueos);
     }

     public Defensa() {
          // TODO Auto-generated constructor stub
     }

     // Métodos getter y setter
     public int getEntradas() {
          return entradas;
     }

     public void setEntradas(int entradas) {
          if (entradas >= 0) {
               this.entradas = entradas;
           } else
               throw new IllegalArgumentException();
     }

     public int getBloqueos() {
          return bloqueos;
     }

     public void setBloqueos(int bloqueos) {
          if (bloqueos >= 0) {
               this.bloqueos = bloqueos;
           } else
               throw new IllegalArgumentException();
     }
}
