package visual;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.Estadio;
import services.ServicesLocator;
import utils.ConnectionManager;
import utils.Generic_Model;

public class CrudEstadio extends javax.swing.JDialog {

    private Generic_Model<Estadio> modelo = new Generic_Model<>();

    public CrudEstadio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        changeStatus(false);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        lblDatosErroneos.setVisible(false);

        list.setModel(modelo);

        Principal.soloNum(tfCapacidad);

        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int index = list.getSelectedIndex();
                btnEliminar.setEnabled(index > -1);
                changeStatus(index <= -1);
                if (index > -1) {
                    Estadio c = modelo.getElementAt(index);

                    tfNombre.setText(c.getNombreEstadio());
                    tfCapacidad.setText(c.getCapacidad() + "");

                    btnNuevo.setEnabled(true);
                    btnEditar.setEnabled(true);

                } else {
                    btnEditar.setEnabled(false);
                }
            }
        });
        modelo.setList(ServicesLocator.getEstadioServices().obtenerEstadios());

    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPanel = new javax.swing.JPanel();
        panel = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblCapacidad = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        tfCapacidad = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        lblDatosErroneos = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de estadios");

        panel.setBackground(new java.awt.Color(143, 182, 155));
        panel.setBorder(new javax.swing.border.MatteBorder(null));
        panel.setForeground(new java.awt.Color(0, 0, 0));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombre.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(0, 0, 0));
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombre.setText("Nombre");
        panel.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 52, 79, -1));

        lblCapacidad.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblCapacidad.setForeground(new java.awt.Color(0, 0, 0));
        lblCapacidad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCapacidad.setText("Capacidad");
        panel.add(lblCapacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 83, 87, -1));

        tfNombre.setEditable(false);
        tfNombre.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        panel.add(tfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 49, 209, -1));

        tfCapacidad.setEditable(false);
        tfCapacidad.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tfCapacidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCapacidadActionPerformed(evt);
            }
        });
        panel.add(tfCapacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 80, 75, -1));

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.setAlignmentY(1.0F);
        btnCancelar.setMargin(new java.awt.Insets(2, 14, 4, 14));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panel.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, -1, -1));

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 0, 0));
        btnGuardar.setText("Guardar");
        btnGuardar.setAlignmentY(1.0F);
        btnGuardar.setMargin(new java.awt.Insets(2, 14, 4, 14));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        panel.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, -1, -1));

        btnAgregar.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregar.setText("Agregar");
        btnAgregar.setAlignmentY(1.0F);
        btnAgregar.setMargin(new java.awt.Insets(2, 14, 4, 14));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        panel.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, -1, -1));

        lblDatosErroneos.setFont(new java.awt.Font("SansSerif", 3, 16)); // NOI18N
        lblDatosErroneos.setForeground(new java.awt.Color(0, 102, 102));
        lblDatosErroneos.setText("Datos erroneos");
        panel.add(lblDatosErroneos, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 195, 198, -1));

        list.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        list.setForeground(new java.awt.Color(18, 110, 0));
        list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollPane.setViewportView(list);

        btnNuevo.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(0, 0, 0));
        btnNuevo.setText("Nuevo");
        btnNuevo.setAlignmentY(1.0F);
        btnNuevo.setDefaultCapable(false);
        btnNuevo.setMargin(new java.awt.Insets(2, 14, 4, 14));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(255, 255, 255));
        btnEditar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(0, 0, 0));
        btnEditar.setText("Editar");
        btnEditar.setAlignmentY(1.0F);
        btnEditar.setDefaultCapable(false);
        btnEditar.setEnabled(false);
        btnEditar.setMargin(new java.awt.Insets(2, 14, 4, 14));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setText("Eliminar");
        btnEliminar.setAlignmentY(1.0F);
        btnEliminar.setDefaultCapable(false);
        btnEliminar.setEnabled(false);
        btnEliminar.setMargin(new java.awt.Insets(2, 14, 4, 14));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(0, 0, 0));
        btnSalir.setText("Salir");
        btnSalir.setAlignmentY(1.0F);
        btnSalir.setDefaultCapable(false);
        btnSalir.setMargin(new java.awt.Insets(2, 14, 4, 14));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(btnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)))
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGap(18, 282, Short.MAX_VALUE)
                        .addComponent(btnSalir)
                        .addContainerGap())
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar)
                    .addComponent(btnNuevo))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNuevoActionPerformed
        limpiar();
        changeStatus(true);
        btnGuardar.setVisible(false);
        tfNombre.requestFocusInWindow();
    }// GEN-LAST:event_btnNuevoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAgregarActionPerformed
        String nombre = tfNombre.getText();
        int capacidad = Integer.parseInt(tfCapacidad.getText().equals("") ? "-1" : tfCapacidad.getText());

        boolean val = validarDatos(nombre, capacidad);

        if (val) {
            ServicesLocator.getEstadioServices().agregarEstadio(nombre, capacidad); // guardar en la BD

            Estadio x = new Estadio(ServicesLocator.getEstadioServices().obtenerEstadios().getLast().getIdEstadio(),
                    nombre, capacidad);
            modelo.addElement(x);

            int lastIndex = list.getModel().getSize() - 1;
            list.setSelectedIndex(lastIndex);
            list.ensureIndexIsVisible(lastIndex);

            changeStatus(false);
        }
    }// GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEditarActionPerformed
        changeStatus(list.getSelectedIndex() > -1);
        tfNombre.requestFocusInWindow();
        btnAgregar.setVisible(false);
    }// GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnGuardarActionPerformed
        int index = list.getSelectedIndex();

        String nombre = tfNombre.getText();
        int capacidad = Integer.parseInt(tfCapacidad.getText().equals("") ? "-1" : tfCapacidad.getText());

        boolean val = validarDatos(nombre, capacidad);

        if (val) {
            Estadio e = new Estadio(nombre, capacidad);
            e.setIdEstadio(modelo.getElementAt(index).getIdEstadio());

            ServicesLocator.getEstadioServices().actualizarEstadio(e);

            modelo.updateElement(index, e);
            changeStatus(false);
        }
    }// GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEliminarActionPerformed
        int index = list.getSelectedIndex();
        if (index != -1) {
            if (JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar este estadio?",
                    "Confirmar", 0) == 0) {

                ServicesLocator.getEstadioServices().eliminarEstadio(modelo.getElementAt(index).getIdEstadio());

                modelo.removeElement(index);

                limpiar();
                changeStatus(false);
            }
        }
    }// GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCancelarActionPerformed
        changeStatus(false);
        lblDatosErroneos.setVisible(false);
        list.setSelectedIndex(0);
    }// GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSalirActionPerformed
        ConnectionManager.closeConnection();
        dispose();
    }// GEN-LAST:event_btnSalirActionPerformed

    private void tfCapacidadActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tfCapacidadActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_tfCapacidadActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel lblCapacidad;
    private javax.swing.JLabel lblDatosErroneos;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JList<Estadio> list;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextField tfCapacidad;
    private javax.swing.JTextField tfNombre;
    // End of variables declaration//GEN-END:variables

    private void limpiar() {
        tfNombre.setText("");
        tfCapacidad.setText("");
    }

    public boolean validarDatos(String nombre, int capacidad) {
        boolean correcto = true;
        Estadio temp = new Estadio();

        try { // nombre
            temp.setNombreEstadio(nombre);
        } catch (IllegalArgumentException e) {
            correcto = false;
            lblDatosErroneos.setVisible(true);
            lblNombre.setForeground(Principal.errorColor);
        }

        try { // capacidad
            temp.setCapacidad(capacidad);
        } catch (IllegalArgumentException e) {
            correcto = false;
            lblDatosErroneos.setVisible(true);
            lblCapacidad.setForeground(Principal.errorColor);
        }

        if (correcto) {
            lblDatosErroneos.setVisible(false);
            changeStatus(true);
        }
        return correcto;
    }

    private void changeStatus(boolean status) {
        tfNombre.setEditable(status);
        tfCapacidad.setEditable(status);

        btnEliminar.setEnabled(!status);
        btnNuevo.setEnabled(!status);
        btnEditar.setEnabled(!status);
        list.setEnabled(!status);
        btnSalir.setEnabled(!status);

        btnAgregar.setVisible(status);
        btnGuardar.setVisible(status);
        btnCancelar.setVisible(status);

        lblNombre.setForeground(Color.black);
        lblCapacidad.setForeground(Color.black);

    }
}
