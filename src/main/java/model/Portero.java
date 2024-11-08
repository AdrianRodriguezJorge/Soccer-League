package model;

/**
 * Clase que representa un Portero, que es un tipo de Jugador.
 */
public class Portero extends Jugador {
    private int paradas;
    private int golesEncajados;

    // Constructores
    public Portero(int idFutbolista, int idEquipo, int numero, String nombre, int añosEnEquipo, String tipo,
            int partidosJugados,
            int cantidadGoles, int asistencias, double promedioGoles, String pos, int paradas, int golesEncajados) {
        super(idFutbolista, idEquipo, numero, nombre, añosEnEquipo, tipo, partidosJugados, cantidadGoles, asistencias,
                promedioGoles, pos);
        setParadas(paradas);
        setGolesEncajados(golesEncajados);
    }

    public Portero(int idEquipo, int numero, String nombre, int añosEnEquipo, String tipo, int partidosJugados,
            int cantidadGoles, int asistencias, String pos, int paradas, int golesEncajados) {
        super(idEquipo, numero, nombre, añosEnEquipo, tipo, partidosJugados, cantidadGoles, asistencias, pos);
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
        if (paradas >= 0) {
            this.paradas = paradas;
        } else
            throw new IllegalArgumentException();
    }

    public int getGolesEncajados() {
        return golesEncajados;
    }

    public void setGolesEncajados(int golesEncajados) {
        if (golesEncajados >= 0) {
            this.golesEncajados = golesEncajados;
        } else
            throw new IllegalArgumentException();
    }
}
