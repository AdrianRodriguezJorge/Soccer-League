package model;

/**
 * Clase que representa un Equipo en la Liga Nacional de Fútbol.
 */
public class Equipo {
    private int idEquipo;
    private String nombreEquipo;
    private String provincia;
    private int campeonatosParticipados;
    private int campeonatosGanados;
    private String mascota;
    private String color;
    private int puntos;

    // Constructor
    public Equipo(int idEquipo, String nombreEquipo, String provincia, int campeonatosParticipados, int campeonatosGanados, String mascota, String color, int puntos) {
        this.idEquipo = idEquipo;
        this.nombreEquipo = nombreEquipo;
        this.provincia = provincia;
        this.campeonatosParticipados = campeonatosParticipados;
        this.campeonatosGanados = campeonatosGanados;
        this.mascota = mascota;
        this.color = color;
        this.puntos = puntos;
    }

    public Equipo() {
    
    }

// Métodos getter y setter
    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getCampeonatosParticipados() {
        return campeonatosParticipados;
    }

    public void setCampeonatosParticipados(int campeonatosParticipados) {
        this.campeonatosParticipados = campeonatosParticipados;
    }

    public int getCampeonatosGanados() {
        return campeonatosGanados;
    }

    public void setCampeonatosGanados(int campeonatosGanados) {
        this.campeonatosGanados = campeonatosGanados;
    }

    public String getMascota() {
        return mascota;
    }

    public void setMascota(String mascota) {
        this.mascota = mascota;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}
