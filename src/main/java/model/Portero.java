package model;

/**
 * Clase que representa un Portero, que es un tipo de Jugador.
 */
public class Portero extends Jugador {
    private int paradas;
    private int golesEncajados;

    // Constructor
    public Portero(int idFutbolista, int idEquipo, int numero, String nombre, int añosEnEquipo, int partidosJugados,
            int cantidadGoles, int asistencias, double promedioGoles, int paradas, int golesEncajados) {
        super(idFutbolista, idEquipo, numero, nombre, añosEnEquipo, partidosJugados, cantidadGoles, asistencias,
                promedioGoles);
        setParadas(paradas);
        setGolesEncajados(golesEncajados);
    }

    public Portero() {
        // TODO Auto-generated constructor stub
    }

    // Métodos getter y setter
    public int getParadas() {
        return paradas;
    }

    public void setParadas(int paradas) {
        this.paradas = paradas;
    }

    public int getGolesEncajados() {
        return golesEncajados;
    }

    public void setGolesEncajados(int golesEncajados) {
        this.golesEncajados = golesEncajados;
    }
}
