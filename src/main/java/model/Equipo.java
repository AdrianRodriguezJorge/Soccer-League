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
        if (!nomEquipo.replace(" ", "").equals("")) {
            this.nomEquipo = nomEquipo;
        } else
            throw new IllegalArgumentException();
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        if (!provincia.replace(" ", "").equals("")) {
            this.provincia = provincia;
        } else
            throw new IllegalArgumentException();
    }

    public int getCampParticipados() {
        return campParticipados;
    }

    public void setCampParticipados(int campParticipados) {
        if (campParticipados >= 0) {
            this.campParticipados = campParticipados;
        } else
            throw new IllegalArgumentException();
    }

    public int getCampGanados() {
        return campGanados;
    }

    public void setCampGanados(int campGanados) {
        if (campGanados >= 0) {
            this.campGanados = campGanados;
        } else
            throw new IllegalArgumentException();
    }

    public String getMascota() {
        return mascota;
    }

    public void setMascota(String mascota) {
        if (!mascota.replace(" ", "").equals("")) {
            this.mascota = mascota;
        } else
            throw new IllegalArgumentException();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (!color.replace(" ", "").equals("")) {
            this.color = color;
        } else
            throw new IllegalArgumentException();
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        if (puntos >= 0) {
            this.puntos = puntos;
        } else
            throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return nomEquipo;
    }
    
    
}
