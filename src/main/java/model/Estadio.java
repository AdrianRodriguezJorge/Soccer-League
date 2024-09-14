package model;

/**
 * Clase que representa un Estadio donde se juega un partido.
 */
public class Estadio {

    private int idEstadio;
    private String nombreEstadio;
    private int capacidad;

    // Constructor
    public Estadio(String nombreEstadio, int capacidad) {
        setNombreEstadio(nombreEstadio);
        setCapacidad(capacidad);
    }

    public Estadio() {
        // TODO Auto-generated constructor stub
    }

    public Estadio(int idEstadio, String nombreEstadio, int capacidad) {
        setIdEstadio(idEstadio);
        setNombreEstadio(nombreEstadio);
        setCapacidad(capacidad);
}

// Métodos getter y setter
    public int getIdEstadio() {
        return idEstadio;
    }

    public void setIdEstadio(int idEstadio) {
        this.idEstadio = idEstadio;
    }

    public String getNombreEstadio() {
        return nombreEstadio;
    }

    public void setNombreEstadio(String nombreEstadio) {
        if (!nombreEstadio.replace(" ", "").equals("")) {
            this.nombreEstadio = nombreEstadio;
        } else
            throw new IllegalArgumentException();
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        if (capacidad >= 0) {
            this.capacidad = capacidad;
        } else
            throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return nombreEstadio;
    }
}
