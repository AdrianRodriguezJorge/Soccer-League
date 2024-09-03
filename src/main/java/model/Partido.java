package model;

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
    private int goles_local;
    private int goles_visitante;
    private int audiencia;

    public Partido(int idPartido, int audiencia, Date fecha, int idEstadio, int idEquipoLocal, int idEquipoVisitante,
            int goles_local,
            int goles_visitante) {
        setIdPartido(idPartido);
        setIdEquipoLocal(idEquipoLocal);
        setIdEquipoVisitante(idEquipoVisitante);
        setIdEstadio(idEstadio);
        setFecha(fecha);
        setGoles_local(goles_local);
        setGoles_visitante(goles_visitante);
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
        this.fecha = fecha;
    }

    public int getGoles_local() {
        return goles_local;
    }

    public void setGoles_local(int goles_local) {
        this.goles_local = goles_local;
    }

    public int getGoles_visitante() {
        return goles_visitante;
    }

    public void setGoles_visitante(int goles_visitante) {
        this.goles_visitante = goles_visitante;
    }

    public int getAudiencia() {
        return audiencia;
    }

    public void setAudiencia(int audiencia) {
        this.audiencia = audiencia;
    }

}
