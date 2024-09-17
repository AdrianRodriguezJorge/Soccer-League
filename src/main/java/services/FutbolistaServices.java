package services;

import model.Defensa;
import model.Delantero;
import model.Entrenador;
import model.Futbolista;
import model.Jugador;
import model.Mediocampista;
import model.Portero;
import utils.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de servicios para gestionar las operaciones CRUD de los futbolistas.
 */
public class FutbolistaServices {

    /**
     * Método para crear un nuevo futbolista en la base de datos.
     *
     * @param futbolista El objeto Futbolista a crear.
     * @throws SQLException
     */
    public void crearFutbolista(Futbolista futbolista) throws SQLException {
        String sql = "INSERT INTO futbolista (idequipo, nombre, numero, añosenequipo, tipo) VALUES (?, ?, ?, ?, ?)";
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // se inserta el futbolista
        pstmt.setInt(1, futbolista.getIdEquipo());
        pstmt.setString(2, futbolista.getNombre());
        pstmt.setInt(3, futbolista.getNumero());
        pstmt.setInt(4, futbolista.getAñosEnEquipo());
        pstmt.setString(5, futbolista.getTipo());
        pstmt.executeUpdate();

        // se obtiene el id recien ingresado para ser utilizado en las otras tablas
        sql = "SELECT idfutbolista FROM futbolista WHERE idequipo = ? AND numero = ?";
        pstmt = conn.prepareStatement(sql);

        pstmt.setInt(1, futbolista.getIdEquipo());
        pstmt.setInt(2, futbolista.getNumero());

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            int idFutb = rs.getInt("idfutbolista");
            futbolista.setIdFutbolista(idFutb);
        } else
            throw new SQLException("Algo salió mal al crear al futbolista.");

        // se ingresan los datos según el tipo de futbolista y jugador
        if (futbolista.getTipo().equals("Entrenador")) {
            ServicesLocator.getEntrenadorServices().crearEntrenador((Entrenador) futbolista);
        } else {
            ServicesLocator.getJugadorServices().crearJugador((Jugador) futbolista);

            String pos = ((Jugador) futbolista).getPosicion();
            if (pos.equals("Defensa")) {
                ServicesLocator.getDefensaServices().crearDefensa((Defensa) futbolista);
            } else if (pos.equals("Delantero")) {
                ServicesLocator.getDelanteroServices().crearDelantero((Delantero) futbolista);
            } else if (pos.equals("Mediocampista")) {
                ServicesLocator.getMediocampistaServices().crearMediocampista((Mediocampista) futbolista);
            } else if (pos.equals("Portero")) {
                ServicesLocator.getPorteroServices().crearPortero((Portero) futbolista);
            }
        }
    }

    /**
     * Método para obtener todos los futbolistas de la base de datos.
     *
     * @return Lista de futbolistas.
     */
    public ArrayList<Futbolista> obtenerFutbolistas() {
        ArrayList<Futbolista> futbolistas = new ArrayList<>();
        Futbolista futbolista = null;
        String sql = "SELECT * FROM futbolista ORDER BY idequipo, numero";
        try (Connection conn = ConnectionManager.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int idfutb = rs.getInt("idfutbolista");
                int idEquipo = rs.getInt("idequipo");
                String nombre = rs.getString("nombre");
                int num = rs.getInt("numero");
                int añosEnEquipo = rs.getInt("añosenequipo");

                String tipo = rs.getString("tipo");

                if (tipo.equals("Entrenador")) {
                    int añosExp = ServicesLocator.getEntrenadorServices().obtenerDatosEntrenador(idfutb);
                    futbolista = new Entrenador(idfutb, idEquipo, num, nombre, añosEnEquipo, tipo, añosExp);

                } else {
                    Jugador jugador = ServicesLocator.getJugadorServices().obtenerJugador(idfutb);
                    jugador.setTipo("Jugador");
                    String pos = jugador.getPosicion();

                    if (pos.equals("Defensa")) {
                        Defensa e = ServicesLocator.getDefensaServices().obtenerDefensa(idfutb);

                        e.setIdEquipo(idEquipo);
                        e.setNombre(nombre);
                        e.setNumero(num);
                        e.setAñosEnEquipo(añosEnEquipo);

                        e.setPosicion(jugador.getPosicion());
                        e.setPartidosJugados(jugador.getPartidosJugados());
                        e.setCantidadGoles(jugador.getCantidadGoles());
                        e.setAsistencias(jugador.getAsistencias());
                        e.setPromedioGoles(jugador.getPromedioGoles());
                        e.setTipo(jugador.getTipo());

                        futbolista = e;
                    } else if (pos.equals("Delantero")) {
                        Delantero e = ServicesLocator.getDelanteroServices().obtenerDelantero(idfutb);

                        e.setIdEquipo(idEquipo);
                        e.setNombre(nombre);
                        e.setNumero(num);
                        e.setAñosEnEquipo(añosEnEquipo);

                        e.setPosicion(jugador.getPosicion());
                        e.setPartidosJugados(jugador.getPartidosJugados());
                        e.setCantidadGoles(jugador.getCantidadGoles());
                        e.setAsistencias(jugador.getAsistencias());
                        e.setPromedioGoles(jugador.getPromedioGoles());
                        e.setTipo(jugador.getTipo());

                        futbolista = e;
                    } else if (pos.equals("Mediocampista")) {
                        Mediocampista e = ServicesLocator.getMediocampistaServices().obtenerMediocampista(idfutb);

                        e.setIdEquipo(idEquipo);
                        e.setNombre(nombre);
                        e.setNumero(num);
                        e.setAñosEnEquipo(añosEnEquipo);

                        e.setPosicion(jugador.getPosicion());
                        e.setPartidosJugados(jugador.getPartidosJugados());
                        e.setCantidadGoles(jugador.getCantidadGoles());
                        e.setAsistencias(jugador.getAsistencias());
                        e.setPromedioGoles(jugador.getPromedioGoles());
                        e.setTipo(jugador.getTipo());

                        futbolista = e;
                    } else if (pos.equals("Portero")) {
                        Portero e = ServicesLocator.getPorteroServices().obtenerPortero(idfutb);

                        e.setIdEquipo(idEquipo);
                        e.setNombre(nombre);
                        e.setNumero(num);
                        e.setAñosEnEquipo(añosEnEquipo);

                        e.setPosicion(jugador.getPosicion());
                        e.setPartidosJugados(jugador.getPartidosJugados());
                        e.setCantidadGoles(jugador.getCantidadGoles());
                        e.setAsistencias(jugador.getAsistencias());
                        e.setPromedioGoles(jugador.getPromedioGoles());
                        e.setTipo(jugador.getTipo());

                        futbolista = e;
                    } else
                        throw new SQLException("Algo fue mal.");
                }

                futbolistas.add(futbolista);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return futbolistas;
    }

    /**
     * Método para actualizar un futbolista en la base de datos.
     *
     * @param futbolista El objeto Futbolista a actualizar.
     * @throws SQLException
     */
    public void actualizarFutbolista(Futbolista futbolista) throws SQLException {
        eliminarFutbolista(futbolista.getIdFutbolista());
        crearFutbolista(futbolista);
        
        // String sql = "UPDATE futbolista SET idequipo = ?, nombre = ?, numero = ?,
        // añosenequipo = ?, tipo = ? WHERE idfutbolista = ?";
        // try (Connection conn = ConnectionManager.getConnection();
        // PreparedStatement pstmt = conn.prepareStatement(sql)) {

        // pstmt.setInt(1, futbolista.getIdEquipo());
        // pstmt.setString(2, futbolista.getNombre());
        // pstmt.setInt(3, futbolista.getNumero());
        // pstmt.setInt(4, futbolista.getAñosEnEquipo());

        // String tipo = futbolista.getTipo();
        // pstmt.setString(5, tipo);
        // pstmt.setInt(6, futbolista.getIdFutbolista());
        // pstmt.executeUpdate();

        // if (tipo.equals("Entrenador")) {
        // ServicesLocator.getEntrenadorServices().actualizarEntrenador((Entrenador)
        // futbolista);
        // } else {
        // String pos = ((Jugador) futbolista).getPosicion();
        // if (pos.equals("Defensa")) {
        // ServicesLocator.getDefensaServices().actualizarDefensa((Defensa) futbolista);
        // } else if (pos.equals("Delantero")) {
        // ServicesLocator.getDelanteroServices().actualizarDelantero((Delantero)
        // futbolista);
        // } else if (pos.equals("Mediocampista")) {
        // ServicesLocator.getMediocampistaServices().actualizarMediocampista((Mediocampista)
        // futbolista);
        // } else if (pos.equals("Portero")) {
        // ServicesLocator.getPorteroServices().actualizarPortero((Portero) futbolista);
        // }
        // }

        // } catch (SQLException e) {
        // e.printStackTrace();
        // }
    }

    /**
     * Método para eliminar un futbolista de la base de datos.
     *
     * @param idFutbolista El ID del futbolista a eliminar.
     */
    public void eliminarFutbolista(int idFutbolista) {
        String sql = "DELETE FROM futbolista WHERE idfutbolista = ?";
        try (Connection conn = ConnectionManager.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idFutbolista);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getNumsFutbs(int idEquipo) {
        String list = "Los siguientes números ya están ocupados por otro de los jugadores de este equipo: \n";
        int salto = 0;
        ArrayList<Integer> nums = new ArrayList<>();

        for (Futbolista e : obtenerFutbolistas()) {
            if (e.getIdEquipo() == idEquipo) {

                nums.add(e.getNumero());
            }
        }

        nums.sort(null);

        for (int e : nums) {
            list += e;
            salto++;
            if (salto < 3) {
                list += ", ";
            } else {
                list += "\n";
                salto = 0;
            }
        }

        list += "\n Por favor, escoja uno diferente.";
        return list;
    }
}
