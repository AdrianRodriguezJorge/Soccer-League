package model;

/**
 * Clase que representa un Mediocampista, que es un tipo de Jugador.
 */
public class Mediocampista extends Jugador {
    private int pasesCompletados;

    // Constructor
    public Mediocampista(int idEquipo, int numero, String nombre, int añosEnEquipo, int partidosJugados, int golesMarcados, int asistencias, double promedioGoles, int pasesCompletados) {
        super(idEquipo, numero, nombre, añosEnEquipo, "Mediocampista", partidosJugados, golesMarcados, asistencias, promedioGoles);
        this.pasesCompletados = pasesCompletados;
    }

    public Mediocampista() {
	//TODO Auto-generated constructor stub
}

// Métodos getter y setter
    public int getPasesCompletados() {
        return pasesCompletados;
    }

    public void setPasesCompletados(int pasesCompletados) {
        this.pasesCompletados = pasesCompletados;
    }
}
