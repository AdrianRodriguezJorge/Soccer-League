package model;

/**
 * Clase que representa un Portero, que es un tipo de Jugador.
 */
public class Portero extends Jugador {
    private int paradas;

    // Constructor
    public Portero(int idEquipo, int numero, String nombre, int añosEnEquipo, int partidosJugados, int golesMarcados, int asistencias, double promedioGoles, int paradas) {
        super(idEquipo, numero, nombre, añosEnEquipo, "Portero", partidosJugados, golesMarcados, asistencias, promedioGoles);
        this.paradas = paradas;
    }

    public Portero() {
	//TODO Auto-generated constructor stub
}

// Métodos getter y setter
    public int getParadas() {
        return paradas;
    }

    public void setParadas(int paradas) {
        this.paradas = paradas;
    }
}
