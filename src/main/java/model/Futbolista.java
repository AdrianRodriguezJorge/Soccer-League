package model;

/**
 * Clase base que representa un Futbolista en la Liga Nacional de Fútbol.
 */
public abstract class Futbolista {
    protected int idFutbolista;
    protected int idEquipo;
    protected String nombre;
    protected int numero;
    protected int añosEnEquipo;
    protected String tipo;

    // Constructores
    public Futbolista(int idFutbolista, int idEquipo, int numero, String nombre, int añosEnEquipo, String tipo) {
        setIdFutbolista(idFutbolista);
        setIdEquipo(idEquipo);
        setNumero(numero);
        setNombre(nombre);
        setAñosEnEquipo(añosEnEquipo);
        setTipo(tipo);
    }

    public Futbolista(int idEquipo, int numero, String nombre, int añosEnEquipo, String tipo) {
        setIdFutbolista(idFutbolista);
        setIdEquipo(idEquipo);
        setNumero(numero);
        setNombre(nombre);
        setAñosEnEquipo(añosEnEquipo);
        setTipo(tipo);
    }

    public Futbolista() {

    }

    // Métodos getter y setter
    public int getIdFutbolista() {
        return idFutbolista;
    }

    public void setIdFutbolista(int idFutbolista) {
        this.idFutbolista = idFutbolista;
    }

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
        if (numero >= 0) {
            this.numero = numero;
        } else
            throw new IllegalArgumentException();

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (!nombre.replace(" ", "").equals("")) {
            this.nombre = nombre;
        } else
            throw new IllegalArgumentException();
    }

    public int getAñosEnEquipo() {
        return añosEnEquipo;
    }

    public void setAñosEnEquipo(int añosEnEquipo) {
        if (añosEnEquipo >= 0) {
            this.añosEnEquipo = añosEnEquipo;
        } else
            throw new IllegalArgumentException();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
