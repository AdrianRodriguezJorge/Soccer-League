package visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import services.EquipoServices;
import model.Equipo;

import java.sql.SQLException;

/**
 * Ventana para la gestión de equipos.
 */
public class CrudEquipo extends JFrame {
    private JTextField txtNombreEquipo, txtProvincia, txtCampeonatosParticipados, txtCampeonatosGanados, txtMascota, txtColor;
    private JButton btnAgregar, btnModificar, btnEliminar, btnLimpiar;
    private EquipoServices equipoServices;

    public CrudEquipo() {
        setTitle("Gestión de Equipos");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        equipoServices = new EquipoServices();
        initializeComponents();
    }

    /**
     * Inicializa los componentes de la ventana de gestión de equipos.
     */
    private void initializeComponents() {
        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblNombreEquipo = new JLabel("Nombre del Equipo:");
        JLabel lblProvincia = new JLabel("Provincia:");
        JLabel lblCampeonatosParticipados = new JLabel("Campeonatos Participados:");
        JLabel lblCampeonatosGanados = new JLabel("Campeonatos Ganados:");
        JLabel lblMascota = new JLabel("Mascota:");
        JLabel lblColor = new JLabel("Color:");

        txtNombreEquipo = new JTextField();
        txtProvincia = new JTextField();
        txtCampeonatosParticipados = new JTextField();
        txtCampeonatosGanados = new JTextField();
        txtMascota = new JTextField();
        txtColor = new JTextField();

        btnAgregar = new JButton("Agregar");
        btnModificar = new JButton("Modificar");
        btnEliminar = new JButton("Eliminar");
        btnLimpiar = new JButton("Limpiar");

        // Agregar ActionListener para las acciones de CRUD
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Equipo equipo = new Equipo(txtNombreEquipo.getText(), txtProvincia.getText(), Integer.parseInt(txtCampeonatosParticipados.getText()), Integer.parseInt(txtCampeonatosGanados.getText()), txtMascota.getText(), txtColor.getText(), 0);
                    // equipoServices.agregarEquipo(equipo);
                    JOptionPane.showMessageDialog(CrudEquipo.this, "Equipo agregado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos();
                } catch (Exception ex) {
                    manejarExcepcion(ex);
                }
            }
        });

        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Equipo equipo = new Equipo(txtNombreEquipo.getText(), txtProvincia.getText(), Integer.parseInt(txtCampeonatosParticipados.getText()), Integer.parseInt(txtCampeonatosGanados.getText()), txtMascota.getText(), txtColor.getText(), 0);
                    // equipoServices.actualizarEquipo(equipo);
                    JOptionPane.showMessageDialog(CrudEquipo.this, "Equipo modificado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos();
                } catch (Exception ex) {
                    manejarExcepcion(ex);
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    equipoServices.eliminarEquipo(Integer.parseInt(txtNombreEquipo.getText()));
                    JOptionPane.showMessageDialog(CrudEquipo.this, "Equipo eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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

        panel.add(lblNombreEquipo);
        panel.add(txtNombreEquipo);
        panel.add(lblProvincia);
        panel.add(txtProvincia);
        panel.add(lblCampeonatosParticipados);
        panel.add(txtCampeonatosParticipados);
        panel.add(lblCampeonatosGanados);
        panel.add(txtCampeonatosGanados);
        panel.add(lblMascota);
        panel.add(txtMascota);
        panel.add(lblColor);
        panel.add(txtColor);
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
        txtNombreEquipo.setText("");
        txtProvincia.setText("");
        txtCampeonatosParticipados.setText("");
        txtCampeonatosGanados.setText("");
        txtMascota.setText("");
        txtColor.setText("");
    }

    /**
     * Maneja las excepciones de SQL.
     * @param ex Excepción SQL
     */
    private void manejarExcepcion(Exception ex) {
        JOptionPane.showMessageDialog(CrudEquipo.this, "Error en la base de datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }
}
