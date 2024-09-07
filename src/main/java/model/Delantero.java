package model;

/**
 * Clase que representa un Delantero, que es un tipo de Jugador.
 */
public class Delantero extends Jugador {
    private int tirosAPuerta;

    // Constructores
    public Delantero(int idFutbolista, int idEquipo, int numero, String nombre, int añosEnEquipo, String tipo, int partidosJugados,
            int cantidadGoles, int asistencias, double promedioGoles,  String pos, int tirosAPuerta) {
        super(idFutbolista, idEquipo, numero, nombre, añosEnEquipo, tipo, partidosJugados, cantidadGoles, asistencias,
                promedioGoles, pos);
        setTirosAPuerta(tirosAPuerta);
    }

    public Delantero(int idEquipo, int numero, String nombre, int añosEnEquipo, String tipo, int partidosJugados, int cantidadGoles,
            int asistencias, double promedioGoles, String pos, int tirosAPuerta) {
        super(idEquipo, numero, nombre, añosEnEquipo, tipo, partidosJugados, cantidadGoles, asistencias, promedioGoles, pos);
        setTirosAPuerta(tirosAPuerta);
    }

    public Delantero() {
        // TODO Auto-generated constructor stub
    }

    // Métodos getter y setter
    public int getTirosAPuerta() {
        return tirosAPuerta;
    }

    public void setTirosAPuerta(int tirosAPuerta) {
        this.tirosAPuerta = tirosAPuerta;
    }
}
