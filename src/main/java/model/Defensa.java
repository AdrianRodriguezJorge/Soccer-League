package model;

/**
 * Clase que representa un Defensa, que es un tipo de Jugador.
 */
public class Defensa extends Jugador {
    private int bloqueos;
    private int entradas;

     // Constructor
     public Defensa(int idEquipo, int numero, String nombre, int añosEnEquipo, int partidosJugados, int golesMarcados, int asistencias, double promedioGoles, int entradas, int bloqueos) {
          super(idEquipo, numero, nombre, añosEnEquipo, "Defensa", partidosJugados, golesMarcados, asistencias, promedioGoles);
          setEntradas(entradas);
          setBloqueos(bloqueos);
     }

     public Defensa() {
          //TODO Auto-generated constructor stub
     }

     // Métodos getter y setter
     public int getEntradas() {
          return entradas;
     }

     public void setEntradas(int entradas) {
          this.entradas = entradas;
     }

     public int getBloqueos() {
          return bloqueos;
     }

     public void setBloqueos(int bloqueos) {
          this.bloqueos = bloqueos;
     }
}
