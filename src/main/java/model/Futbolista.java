package model;

/**
 * Clase base que representa un Futbolista en la Liga Nacional de Fútbol.
 */
public class Futbolista {
    protected int idFutbolista;
    protected int idEquipo;
    protected String nombre;
    protected int numero;
    protected int añosEnEquipo;
    protected String tipo;

    // Constructores
    public Futbolista (int idFutbolista, int idEquipo, int numero, String nombre, int añosEnEquipo, String tipo) {
        setIdFutbolista(idFutbolista);
        setIdEquipo(idEquipo);
        setNumero(numero);
        setNombre(nombre);
        setAñosEnEquipo(añosEnEquipo);
        setTipo(tipo);
    }

    public Futbolista (int idEquipo, int numero, String nombre, int añosEnEquipo, String tipo) {
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
