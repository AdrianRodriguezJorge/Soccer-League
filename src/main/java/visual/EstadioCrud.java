package visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import services.EstadioServices;
import model.Estadio;
import java.sql.SQLException;
import utils.ConnectionManager;

/**
 * Ventana para la gestión de estadios.
 */
public class EstadioCrud extends JFrame {
    private JTextField txtIdEstadio, txtCapacidad;
    private JButton btnAgregar, btnModificar, btnEliminar, btnLimpiar;

    public EstadioCrud() {
        setTitle("Gestión de Estadios");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initializeComponents();
        
        ConnectionManager.initConnectionManager();
        EstadioServices es = new EstadioServices();
    }

    /**
     * Inicializa los componentes de la ventana de gestión de estadios.
     */
    private void initializeComponents() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblNombreEstadio = new JLabel("Nombre del Estadio:");
        JLabel lblCapacidad = new JLabel("Capacidad:");

        txtIdEstadio = new JTextField();
        txtCapacidad = new JTextField();

        btnAgregar = new JButton("Agregar");
        btnModificar = new JButton("Modificar");
        btnEliminar = new JButton("Eliminar");
        btnLimpiar = new JButton("Limpiar");

        // Agregar ActionListener para las acciones de CRUD
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Estadio estadio = new Estadio(); //Integer.parseInt(txtIdEstadio.getText()), Integer.parseInt(txtCapacidad.getText()));
                    EstadioServices.agregarEstadio("Coliseo",1500);
                    JOptionPane.showMessageDialog(EstadioCrud.this, "Estadio agregado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos();
                } catch (Exception ex) {
                    manejarExcepcion(ex);
                }
            }
        });

        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    EstadioServices.actualizarEstadio(Integer.parseInt(txtIdEstadio.getText()), "error", Integer.parseInt(txtCapacidad.getText()));
                    JOptionPane.showMessageDialog(EstadioCrud.this, "Estadio modificado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos();
                } catch (Exception ex) {
                    manejarExcepcion(ex);
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    EstadioServices.eliminarEstadio(Integer.parseInt(txtIdEstadio.getText()));
                    JOptionPane.showMessageDialog(EstadioCrud.this, "Estadio eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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

        panel.add(lblNombreEstadio);
        panel.add(txtIdEstadio);
        panel.add(lblCapacidad);
        panel.add(txtCapacidad);
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
        txtIdEstadio.setText("");
        txtCapacidad.setText("");
    }

    /**
     * Maneja las excepciones de SQL.
     * @param ex Excepción SQL
     */
    private void manejarExcepcion(Exception ex) {
        JOptionPane.showMessageDialog(EstadioCrud.this, "Error en la base de datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }
}
