package model;

/**
 * Clase que representa un Delantero, que es un tipo de Jugador.
 */
public class Delantero extends Jugador {
    private int tirosAPuerta;

    // Constructor
    public Delantero (int idEquipo, int numero, String nombre, int añosEnEquipo, int partidosJugados, int cantidadGoles, int asistencias, double promedioGoles, int tirosAPuerta) {
        super(idEquipo, numero, nombre, añosEnEquipo, partidosJugados, cantidadGoles, asistencias, promedioGoles);
        setTirosAPuerta(tirosAPuerta);
    }

    public Delantero() {
        //TODO Auto-generated constructor stub
    }

    // Métodos getter y setter
    public int getTirosAPuerta() {
        return tirosAPuerta;
    }

    public void setTirosAPuerta(int tirosAPuerta) {
        this.tirosAPuerta = tirosAPuerta;
    }
}
