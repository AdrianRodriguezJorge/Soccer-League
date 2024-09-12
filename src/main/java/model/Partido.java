package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase que representa un Partido en la Liga Nacional de Fútbol.
 */
public class Partido {
    private int idPartido;
    private int idEquipoLocal;
    private int idEquipoVisitante;
    private int idEstadio;
    private Date fecha;
    private int golesLocal;
    private int golesVisitante;
    private int audiencia;

    public Partido(int idPartido, int audiencia, Date fecha, int idEstadio, int idEquipoLocal, int idEquipoVisitante,
            int golesLocal,
            int golesVisitante) {
        setIdPartido(idPartido);
        setIdEquipoLocal(idEquipoLocal);
        setIdEquipoVisitante(idEquipoVisitante);
        setIdEstadio(idEstadio);
        setFecha(fecha);
        setGolesLocal(golesLocal);
        setGolesVisitante(golesVisitante);
        setAudiencia(audiencia);
    }

    public Partido() {
        // TODO Auto-generated constructor stub
    }

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
        if (fecha != null) {
            this.fecha = fecha;
        } else
            throw new IllegalArgumentException();

    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(int golesLocal) {
        if (golesLocal >= 0) {
            this.golesLocal = golesLocal;
        } else
            throw new IllegalArgumentException();
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(int golesVisitante) {
        if (golesVisitante >= 0) {
            this.golesVisitante = golesVisitante;
        } else
            throw new IllegalArgumentException();
    }

    public int getAudiencia() {
        return audiencia;
    }

    public void setAudiencia(int audiencia) {
        if (audiencia >= 0) {
            this.audiencia = audiencia;
        } else
            throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return formatoFecha.format(fecha);
    }

}
