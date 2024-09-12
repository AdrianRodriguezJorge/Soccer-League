package model;

/**
 * Clase que representa un Entrenador, que es un tipo de Futbolista.
 */
public class Entrenador extends Futbolista {
    private int añosExperiencia;

    // Constructores
    public Entrenador (int idFutbolista, int idEquipo, int numero, String nombre, int añosEnEquipo, String tipo, int añosExperiencia) {
        super(idFutbolista, idEquipo, numero, nombre, añosEnEquipo, tipo);
        setAñosExperiencia(añosExperiencia);
    }

    public Entrenador (int idEquipo, int numero, String nombre, int añosEnEquipo, String tipo, int añosExperiencia) {
        super(idEquipo, numero, nombre, añosEnEquipo, tipo);
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
        if (añosExperiencia >= 0) {
            this.añosExperiencia = añosExperiencia;
        } else
            throw new IllegalArgumentException();
    }
}
