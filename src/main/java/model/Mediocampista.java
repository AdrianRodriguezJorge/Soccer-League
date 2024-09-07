package model;

/**
 * Clase que representa un Mediocampista, que es un tipo de Jugador.
 */
public class Mediocampista extends Jugador {
    private int pasesCompletados;
    private int intercepciones;

    // Constructores 
    public Mediocampista (int idFutbolista, int idEquipo, int numero, String nombre, int añosEnEquipo, String tipo,
            int partidosJugados, int cantidadGoles, int asistencias, double promedioGoles, String pos, int pasesCompletados, int intercepciones) {
        super(idFutbolista, idEquipo, numero, nombre, añosEnEquipo, tipo, partidosJugados, cantidadGoles, asistencias,
                promedioGoles, pos);
        setPasesCompletados(pasesCompletados);
        setIntercepciones(intercepciones);
    }

    public Mediocampista (int idEquipo, int numero, String nombre, int añosEnEquipo, String tipo,
            int partidosJugados, int cantidadGoles, int asistencias, double promedioGoles, String pos, int pasesCompletados, int intercepciones) {
        super(idEquipo, numero, nombre, añosEnEquipo, tipo, partidosJugados, cantidadGoles, asistencias,
                promedioGoles, pos);
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
