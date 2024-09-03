package model;

/**
 * Clase que representa un Mediocampista, que es un tipo de Jugador.
 */
public class Mediocampista extends Jugador {
    private int pasesCompletados;
    private int intercepciones;

    // Constructor
    public Mediocampista(int idFutbolista, int idEquipo, int numero, String nombre, int añosEnEquipo,
            int partidosJugados, int cantidadGoles, int asistencias, double promedioGoles, int pasesCompletados, int intercepciones) {
        super(idFutbolista, idEquipo, numero, nombre, añosEnEquipo, partidosJugados, cantidadGoles, asistencias,
                promedioGoles);
        setPasesCompletados(pasesCompletados);
        setIntercepciones(intercepciones);
    }

    public Mediocampista() {
        // TODO Auto-generated constructor stub
    }

    // Métodos getter y setter
    public int getIntercepciones() {
        return intercepciones;
    }

    public void setIntercepciones(int intercepciones) {
        this.intercepciones = intercepciones;
    }

    public int getPasesCompletados() {
        return pasesCompletados;
    }

    public void setPasesCompletados(int pasesCompletados) {
        this.pasesCompletados = pasesCompletados;
    }
}
