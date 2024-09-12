package services;

import java.sql.Connection;
import java.sql.SQLException;

import utils.ConnectionManager;

public class ServicesLocator {
    private static DefensaServices defensaServices = null;
    private static DelanteroServices delanteroServices = null;
    private static EntrenadorServices entrenadorServices = null;
    private static EquipoServices equipoServices = null;
    private static EstadioServices estadioServices = null;
    private static FutbolistaServices futbolistaServices = null;
    private static JugadorServices jugadorServices = null;
    private static MediocampistaServices mediocampistaServices = null;
    private static PartidoServices partidoServices = null;
    private static PorteroServices porteroServices = null;
    private static IntervaloFServices intervaloFServices = null;

    public static Connection getConnection() throws SQLException {
        return ConnectionManager.getConnection();
    }

    public static EstadioServices getEstadioServices() {
        if (estadioServices == null) {
            estadioServices = new EstadioServices();
        }
        return estadioServices;
    }

    public static EquipoServices getEquipoServices() {
        if (equipoServices == null) {
            equipoServices = new EquipoServices();
        }
        return equipoServices;
    }

    public static PartidoServices getPartidoServices() {
        if (partidoServices == null) {
            partidoServices = new PartidoServices();
        }
        return partidoServices;
    }

    public static DefensaServices getDefensaServices() {
        if (defensaServices == null) {
            defensaServices = new DefensaServices();
        }
        return defensaServices;
    }

    public static DelanteroServices getDelanteroServices() {
        if (delanteroServices == null) {
            delanteroServices = new DelanteroServices();
        }
        return delanteroServices;
    }

    public static EntrenadorServices getEntrenadorServices() {
        if (entrenadorServices == null) {
            entrenadorServices = new EntrenadorServices();
        }
        return entrenadorServices;
    }

    public static FutbolistaServices getFutbolistaServices() {
        if (futbolistaServices == null) {
            futbolistaServices = new FutbolistaServices();
        }
        return futbolistaServices;
    }

    public static JugadorServices getJugadorServices() {
        if (jugadorServices == null) {
            jugadorServices = new JugadorServices();
        }
        return jugadorServices;
    }

    public static MediocampistaServices getMediocampistaServices() {
        if (mediocampistaServices == null) {
            mediocampistaServices = new MediocampistaServices();
        }
        return mediocampistaServices;
    }

    public static PorteroServices getPorteroServices() {
        if (porteroServices == null) {
            porteroServices = new PorteroServices();
        }
        return porteroServices;
    }
    
    public static IntervaloFServices getIntervaloFServices() {
        if (intervaloFServices == null) {
            intervaloFServices = new IntervaloFServices();
        }
        return intervaloFServices;
    }
}
