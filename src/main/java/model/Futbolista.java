package model;

/**
 * Clase base que representa un Futbolista en la Liga Nacional de Fútbol.
 */
public abstract class Futbolista {
    protected int idEquipo;
    protected int numero;
    protected String nombre;
    protected int añosEnEquipo;

    // Constructor
    public Futbolista(int idEquipo, int numero, String nombre, int añosEnEquipo) {
        this.idEquipo = idEquipo;
        this.numero = numero;
        this.nombre = nombre;
        this.añosEnEquipo = añosEnEquipo;
    }

    public Futbolista () {
        
    }
    // Métodos getter y setter
    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAñosEnEquipo() {
        return añosEnEquipo;
    }

    public void setAñosEnEquipo(int añosEnEquipo) {
        this.añosEnEquipo = añosEnEquipo;
    }
}
