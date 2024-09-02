package services;

import java.sql.Connection;
import java.sql.SQLException;

import utils.ConnectionManager;

public class ServicesLocator {
    private static DefensaServices defensaServices = null;
    private static DelanteroServices delanteroServices  = null;
    private static EntrenadorServices entrenadorServices = null;
    private static EquipoServices equipoServices = null;
    private static EstadioServices estadioServices = null;
    private static FutbolistaServices futbolistaServices = null;
    private static JugadorServices jugadorServices = null;
    private static MediocampistaServices mediocampistaServices = null;
    private static PartidoServices partidoServices = null;
    private static PorteroServices porteroServices = null;

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
    return defensaServices;
}

public static DelanteroServices getDelanteroServices() {
    return delanteroServices;
}

public static EntrenadorServices getEntrenadorServices() {
    if (entrenadorServices == null) {
        entrenadorServices = new EntrenadorServices();
    }
    return entrenadorServices;
}

public static FutbolistaServices getFutbolistaServices() {
    return futbolistaServices;
}

public static JugadorServices getJugadorServices() {
    return jugadorServices;
}

public static MediocampistaServices getMediocampistaServices() {
    return mediocampistaServices;
}

public static PorteroServices getPorteroServices() {
    return porteroServices;
}
}
