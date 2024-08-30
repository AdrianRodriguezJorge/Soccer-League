package model;

import java.sql.Date;

/**
 * Clase que representa un Partido en la Liga Nacional de Fútbol.
 */
public class Partido {
    private int idPartido;
    private int idEquipoLocal;
    private int idEquipoVisitante;
    private int idEstadio;
    private Date fecha;
    private String resultado;
    private int audiencia;

    // Constructor
    public Partido(int idPartido, int idEquipoLocal, int idEquipoVisitante, int idEstadio, Date fecha, String resultado, int audiencia) {
        this.idPartido = idPartido;
        this.idEquipoLocal = idEquipoLocal;
        this.idEquipoVisitante = idEquipoVisitante;
        this.idEstadio = idEstadio;
        this.fecha = fecha;
        this.resultado = resultado;
        this.audiencia = audiencia;
    }

    public Partido() {
        //TODO Auto-generated constructor stub
    }

    // Métodos getter y setter
    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public int getIdEquipoLocal() {
        return idEquipoLocal;
    }

    public void setIdEquipoLocal(int idEquipoLocal) {
        this.idEquipoLocal = idEquipoLocal;
    }

    public int getIdEquipoVisitante() {
        return idEquipoVisitante;
    }

    public void setIdEquipoVisitante(int idEquipoVisitante) {
        this.idEquipoVisitante = idEquipoVisitante;
    }

    public int getIdEstadio() {
        return idEstadio;
    }

    public void setIdEstadio(int idEstadio) {
        this.idEstadio = idEstadio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public int getAudiencia() {
        return audiencia;
    }

    public void setAudiencia(int audiencia) {
        this.audiencia = audiencia;
    }
}
