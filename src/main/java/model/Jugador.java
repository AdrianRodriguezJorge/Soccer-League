package model;

/**
 * Clase que representa un Jugador, que es un tipo de Futbolista.
 */
public class Jugador extends Futbolista {
    private String posicion;
    private int partidosJugados;
    private int golesMarcados;
    private int asistencias;
    private double promedioGoles;

    // Constructor
    public Jugador(int idEquipo, int numero, String nombre, int añosEnEquipo, String posicion, int partidosJugados, int golesMarcados, int asistencias, double promedioGoles) {
        super(idEquipo, numero, nombre, añosEnEquipo);
        this.posicion = posicion;
        this.partidosJugados = partidosJugados;
        this.golesMarcados = golesMarcados;
        this.asistencias = asistencias;
        this.promedioGoles = promedioGoles;
    }

    public Jugador() {
	//TODO Auto-generated constructor stub
    }

// Métodos getter y setter
    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public int getGolesMarcados() {
        return golesMarcados;
    }

    public void setGolesMarcados(int golesMarcados) {
        this.golesMarcados = golesMarcados;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    public double getPromedioGoles() {
        return promedioGoles;
    }

    public void setPromedioGoles(double promedioGoles) {
        this.promedioGoles = promedioGoles;
    }
}
