package model;

/**
 * Clase que representa un Equipo en la Liga Nacional de Fútbol.
 */
public class Equipo {
    private int idEquipo;
    private String nomEquipo;
    private String provincia;
    private int campParticipados;
    private int campGanados;
    private String mascota;
    private String color;
    private int puntos;

    // Constructores
    public Equipo(String nomEquipo, String provincia, int campParticipados, int campGanados, String mascota, String color, int puntos) {
        setNomEquipo(nomEquipo);
        setProvincia(provincia);
        setCampParticipados(campParticipados);
        setCampGanados(campGanados);
        setMascota(mascota);
        setColor(color);
        setPuntos(puntos);
    }

    public Equipo(int idEquipo, String nomEquipo, String provincia, int campParticipados, int campGanados, String mascota, String color, int puntos) {
        setIdEquipo(idEquipo);
        setNomEquipo(nomEquipo);
        setProvincia(provincia);
        setCampParticipados(campParticipados);
        setCampGanados(campGanados);
        setMascota(mascota);
        setColor(color);
        setPuntos(puntos);
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

    public String getNomEquipo() {
        return nomEquipo;
    }

    public void setNomEquipo(String nomEquipo) {
        this.nomEquipo = nomEquipo;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getCampParticipados() {
        return campParticipados;
    }

    public void setCampParticipados(int campParticipados) {
        this.campParticipados = campParticipados;
    }

    public int getCampGanados() {
        return campGanados;
    }

    public void setCampGanados(int campGanados) {
        this.campGanados = campGanados;
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

    @Override
    public String toString() {
        return nomEquipo;
    }
    
    
}
