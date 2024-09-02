package services;

import java.sql.Connection;
import java.sql.SQLException;

import utils.ConnectionManager;

public class ServicesLocator {

    private static EstadioServices estadioServices = null;
    private static EquipoServices equipoServices = null;
    private static PartidoServices partidoServices = null;

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
}
