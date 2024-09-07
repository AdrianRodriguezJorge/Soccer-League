package model;

/**
 * Clase que representa un Jugador, que es un tipo de Futbolista.
 */
public abstract class Jugador extends Futbolista {
    
    private int partidosJugados;
    private int cantidadGoles;
    private int asistencias;
    private double promedioGoles;
    private String posicion;

    // Constructores
    public Jugador (int idFutbolista, int idEquipo, int numero, String nombre, int añosEnEquipo, String tipo, int partidosJugados, int cantidadGoles, int asistencias, double promedioGoles, String pos) {
        super(idFutbolista, idEquipo, numero, nombre, añosEnEquipo, tipo);
        setPartidosJugados(partidosJugados);
        setCantidadGoles(cantidadGoles);
        setAsistencias(asistencias);
        setPromedioGoles(promedioGoles);
        setPosicion(pos);
    }

    public Jugador (int idEquipo, int numero, String nombre, int añosEnEquipo, String tipo, int partidosJugados, int cantidadGoles, int asistencias, double promedioGoles, String pos) {
        super(idEquipo, numero, nombre, añosEnEquipo, tipo);
        setPartidosJugados(partidosJugados);
        setCantidadGoles(cantidadGoles);
        setAsistencias(asistencias);
        setPromedioGoles(promedioGoles);
        setPosicion(pos);
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

    public int getCantidadGoles() {
        return cantidadGoles;
    }

    public void setCantidadGoles(int cantidadGoles) {
        this.cantidadGoles = cantidadGoles;
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
