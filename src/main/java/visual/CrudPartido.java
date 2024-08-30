package visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import services.PartidoServices;
import model.Partido;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Ventana para la gestión de partidos.
 */
public class CrudPartido extends JFrame {
    private JTextField txtNombreEquipoLocal, txtNombreEquipoVisitante, txtIdEstadio, txtResultado, txtAudiencia;
    private JFormattedTextField txtFecha;
    private JButton btnAgregar, btnModificar, btnEliminar, btnLimpiar;
    private PartidoServices partidoServices;

    public CrudPartido() {
        setTitle("Gestión de Partidos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        partidoServices = new PartidoServices();
        initializeComponents();
    }

    /**
     * Inicializa los componentes de la ventana de gestión de partidos.
     */
    private void initializeComponents() {
        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblNombreEquipoLocal = new JLabel("Equipo Local:");
        JLabel lblNombreEquipoVisitante = new JLabel("Equipo Visitante:");
        JLabel lblNombreEstadio = new JLabel("Estadio:");
        JLabel lblResultado = new JLabel("Resultado:");
        JLabel lblAudiencia = new JLabel("Audiencia:");
        JLabel lblFecha = new JLabel("Fecha:");

        txtNombreEquipoLocal = new JTextField();
        txtNombreEquipoVisitante = new JTextField();
        txtIdEstadio = new JTextField();
        txtResultado = new JTextField();
        txtAudiencia = new JTextField();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        txtFecha = new JFormattedTextField(dateFormat);
        txtFecha.setValue(new Date());

        btnAgregar = new JButton("Agregar");
        btnModificar = new JButton("Modificar");
        btnEliminar = new JButton("Eliminar");
        btnLimpiar = new JButton("Limpiar");

        // Agregar ActionListener para las acciones de CRUD
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Partido partido = new Partido(txtNombreEquipoLocal.getText(), txtNombreEquipoVisitante.getText(), Integer.parseInt(txtIdEstadio.getText()), txtResultado.getText(), Integer.parseInt(txtAudiencia.getText()), (Date) txtFecha.getValue());
                    // partidoServices.agregarPartido(partido);
                    JOptionPane.showMessageDialog(CrudPartido.this, "Partido agregado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos();
                } catch (Exception ex) {
                    manejarExcepcion(ex);
                }
            }
        });

        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Partido partido = new Partido(txtNombreEquipoLocal.getText(), txtNombreEquipoVisitante.getText(), Integer.parseInt(txtIdEstadio.getText()), txtResultado.getText(), Integer.parseInt(txtAudiencia.getText()), (Date) txtFecha.getValue());
                    // partidoServices.actualizarPartido(partido);
                    JOptionPane.showMessageDialog(CrudPartido.this, "Partido modificado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos();
                } catch (Exception ex) {
                    manejarExcepcion(ex);
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // partidoServices.eliminarPartido(txtNombreEquipoLocal.getText(), txtNombreEquipoVisitante.getText(), (Date) txtFecha.getValue());
                    JOptionPane.showMessageDialog(CrudPartido.this, "Partido eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos();
                } catch (Exception ex) {
                    manejarExcepcion(ex);
                }
            }
        });

        btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });

        panel.add(lblNombreEquipoLocal);
        panel.add(txtNombreEquipoLocal);
        panel.add(lblNombreEquipoVisitante);
        panel.add(txtNombreEquipoVisitante);
        panel.add(lblNombreEstadio);
        panel.add(txtIdEstadio);
        panel.add(lblResultado);
        panel.add(txtResultado);
        panel.add(lblAudiencia);
        panel.add(txtAudiencia);
        panel.add(lblFecha);
        panel.add(txtFecha);
        panel.add(btnAgregar);
        panel.add(btnModificar);
        panel.add(btnEliminar);
        panel.add(btnLimpiar);

        add(panel);
    }

    /**
     * Método para limpiar los campos de entrada de datos.
     */
    private void limpiarCampos() {
        txtNombreEquipoLocal.setText("");
        txtNombreEquipoVisitante.setText("");
        txtIdEstadio.setText("");
        txtResultado.setText("");
        txtAudiencia.setText("");
        txtFecha.setValue(new Date());
    }

    /**
     * Maneja las excepciones de SQL.
     * @param ex Excepción SQL
     */
    private void manejarExcepcion(Exception ex) {
        JOptionPane.showMessageDialog(CrudPartido.this, "Error en la base de datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }
}
