package model;

/**
 * Clase que representa un Entrenador, que es un tipo de Futbolista.
 */
public class Entrenador extends Futbolista {
    private int añosExperiencia;

    // Constructor
    public Entrenador(int idFutbolista, int idEquipo, int numero, String nombre, int añosEnEquipo, int añosExperiencia) {
        super(idFutbolista, idEquipo, numero, nombre, añosEnEquipo);
        setAñosExperiencia(añosExperiencia);
    }

    public Entrenador() {
        //TODO Auto-generated constructor stub
    }

    // Métodos getter y setter
    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    public void setAñosExperiencia(int añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }
}
