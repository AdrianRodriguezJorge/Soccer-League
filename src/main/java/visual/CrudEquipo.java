package visual;

import java.awt.Color;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.Equipo;
import services.ServicesLocator;
import utils.ConnectionManager;
import utils.Generic_Model;

public class CrudEquipo extends javax.swing.JDialog {

    private Generic_Model<Equipo> modelo = new Generic_Model<Equipo>();

    public CrudEquipo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        changeStatus(false);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        lblDatosErroneos.setVisible(false);

        list.setModel(modelo);

        Principal.soloLetras(tfNombre);
        Principal.soloLetras(tfProvincia);
        Principal.soloNum(tfCampParticip);
        Principal.soloNum(tfCampGanados);
        Principal.soloLetras(tfMascota);
        Principal.soloLetras(tfColor);

        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int index = list.getSelectedIndex();
                btnEliminar.setEnabled(index > -1);
                changeStatus(index <= -1);
                if (index > -1) {
                    Equipo c = modelo.getElementAt(index);

                    tfNombre.setText(c.getNomEquipo());
                    tfProvincia.setText(c.getProvincia());
                    tfCampParticip.setText(String.valueOf(c.getCampParticipados()));
                    tfCampGanados.setText(String.valueOf(c.getCampGanados()));
                    tfMascota.setText(c.getMascota());
                    tfColor.setText(c.getColor());
                    tfPuntos.setText(c.getPuntos() + "");

                    btnNuevo.setEnabled(true);
                    btnEditar.setEnabled(true);

                } else {
                    btnEditar.setEnabled(false);
                }
            }
        });
        modelo.setList(ServicesLocator.getEquipoServices().obtenerEquipos());

    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        contentPanel = new javax.swing.JPanel();
        panel = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        tfProvincia = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        lblMascota = new javax.swing.JLabel();
        lblCampGanados = new javax.swing.JLabel();
        lblCampParticip = new javax.swing.JLabel();
        lblProvincia = new javax.swing.JLabel();
        lblPuntos = new javax.swing.JLabel();
        lblColor = new javax.swing.JLabel();
        tfCampGanados = new javax.swing.JTextField();
        tfCampParticip = new javax.swing.JTextField();
        tfColor = new javax.swing.JTextField();
        tfMascota = new javax.swing.JTextField();
        tfPuntos = new javax.swing.JTextField();
        lblDatosErroneos = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        contentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setBorder(new javax.swing.border.MatteBorder(null));

        lblNombre.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombre.setText("Nombre");

        tfNombre.setEditable(false);
        tfNombre.setBackground(new java.awt.Color(255, 255, 255));
        tfNombre.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tfNombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tfProvincia.setEditable(false);
        tfProvincia.setBackground(new java.awt.Color(255, 255, 255));
        tfProvincia.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tfProvincia.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tfProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfProvinciaActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 102, 102));
        btnCancelar.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(59, 122, 26));
        btnGuardar.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(59, 122, 26));
        btnAgregar.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        lblMascota.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblMascota.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMascota.setText("Mascota");

        lblCampGanados.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblCampGanados.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCampGanados.setText("Campeonatos ganados");

        lblCampParticip.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblCampParticip.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCampParticip.setText("Campeonatos participados");

        lblProvincia.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblProvincia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblProvincia.setText("Provincia");

        lblPuntos.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblPuntos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPuntos.setText("Puntos");

        lblColor.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblColor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblColor.setText("Color");

        tfCampGanados.setEditable(false);
        tfCampGanados.setBackground(new java.awt.Color(255, 255, 255));
        tfCampGanados.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tfCampGanados.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tfCampGanados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCampGanadosActionPerformed(evt);
            }
        });

        tfCampParticip.setEditable(false);
        tfCampParticip.setBackground(new java.awt.Color(255, 255, 255));
        tfCampParticip.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tfCampParticip.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tfCampParticip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCampParticipActionPerformed(evt);
            }
        });

        tfColor.setEditable(false);
        tfColor.setBackground(new java.awt.Color(255, 255, 255));
        tfColor.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tfColor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tfColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfColorActionPerformed(evt);
            }
        });

        tfMascota.setEditable(false);
        tfMascota.setBackground(new java.awt.Color(255, 255, 255));
        tfMascota.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tfMascota.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tfMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMascotaActionPerformed(evt);
            }
        });

        tfPuntos.setEditable(false);
        tfPuntos.setBackground(new java.awt.Color(255, 255, 255));
        tfPuntos.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tfPuntos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tfPuntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPuntosActionPerformed(evt);
            }
        });

        lblDatosErroneos.setFont(new java.awt.Font("SansSerif", 3, 16)); // NOI18N
        lblDatosErroneos.setForeground(new java.awt.Color(255, 51, 51));
        lblDatosErroneos.setText("Datos erroneos");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblColor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPuntos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblProvincia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblMascota, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCampGanados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCampParticip, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfNombre)
                                .addComponent(tfProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tfCampGanados, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addComponent(tfCampParticip, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfMascota, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfColor, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblDatosErroneos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGuardar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProvincia)
                    .addComponent(tfProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCampParticip)
                    .addComponent(tfCampParticip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCampGanados)
                    .addComponent(tfCampGanados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMascota)
                    .addComponent(tfMascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblColor)
                    .addComponent(tfColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPuntos)
                    .addComponent(tfPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDatosErroneos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(17, 17, 17))
        );

        contentPanel.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, -1, 310));

        list.setBackground(new java.awt.Color(59, 122, 26));
        list.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        list.setForeground(new java.awt.Color(255, 255, 255));
        list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollPane.setViewportView(list);

        contentPanel.add(scrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 250));

        btnNuevo.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(59, 122, 26));
        btnNuevo.setText("Nuevo");
        btnNuevo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(59, 122, 26)));
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        contentPanel.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 70, 30));

        btnEditar.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(59, 122, 26));
        btnEditar.setText("Editar");
        btnEditar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(59, 122, 26)));
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        contentPanel.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 70, 30));

        btnEliminar.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(59, 122, 26));
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(59, 122, 26)));
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        contentPanel.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 70, 30));

        btnSalir.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 51, 51));
        btnSalir.setText("Salir");
        btnSalir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        contentPanel.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 330, 70, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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
        String provincia = tfProvincia.getText();
        int campParticip = Integer.parseInt(tfCampParticip.getText().equals("") ? "-1" : tfCampParticip.getText());
        int campGanados = Integer.parseInt(tfCampGanados.getText().equals("") ? "-1" : tfCampGanados.getText());
        String mascota = tfMascota.getText();
        String color = tfColor.getText();
        int puntos = 0;

        boolean val = validarDatos(nombre, provincia, campParticip, campGanados, mascota, color);

        if (val) {
            Equipo x = new Equipo(nombre, provincia, campParticip, campGanados, mascota, color);
            ServicesLocator.getEquipoServices().crearEquipo(x);

            x.setIdEquipo(ServicesLocator.getEquipoServices().obtenerEquipos().getLast().getIdEquipo());
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
        String provincia = tfProvincia.getText();
        int campParticip = Integer.parseInt(tfCampParticip.getText().equals("") ? "-1" : tfCampParticip.getText());
        int campGanados = Integer.parseInt(tfCampGanados.getText().equals("") ? "-1" : tfCampGanados.getText());
        String mascota = tfMascota.getText();
        String color = tfColor.getText();
        int puntos = Integer.parseInt(tfPuntos.getText());

        boolean val = validarDatos(nombre, provincia, campParticip, campGanados, mascota, color);

        if (val) {
            Equipo x = new Equipo(modelo.getElementAt(index).getIdEquipo(), nombre, provincia, campParticip,
                    campGanados, mascota, color, puntos);

            ServicesLocator.getEquipoServices().actualizarEquipo(x);

            modelo.updateElement(index, x);
            changeStatus(false);
        }

    }// GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEliminarActionPerformed
        int index = list.getSelectedIndex();
        if (index != -1) {
            if (JOptionPane.showConfirmDialog(null,
                    "Está seguro que desea eliminar este equipo y los futbolistas que contiene?",
                    "Confirmar", 0) == 0) {

                try {
                    ServicesLocator.getEquipoServices().eliminarEquipo(modelo.getElementAt(index).getIdEquipo());

                    modelo.removeElement(list.getSelectedIndex());

                    limpiar();
                    changeStatus(false);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "No puede eliminar este equipo mientras existan partidos registrados con su participación.", "Aviso",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }// GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCancelarActionPerformed
        changeStatus(false);
        list.setSelectedIndex(0);
        lblDatosErroneos.setVisible(false);
    }// GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSalirActionPerformed
        ConnectionManager.closeConnection();
        dispose();
    }// GEN-LAST:event_btnSalirActionPerformed

    private void tfProvinciaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tfProvinciaActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_tfProvinciaActionPerformed

    private void tfCampGanadosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tfCampGanadosActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_tfCampGanadosActionPerformed

    private void tfCampParticipActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tfCampParticipActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_tfCampParticipActionPerformed

    private void tfColorActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tfColorActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_tfColorActionPerformed

    private void tfMascotaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tfMascotaActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_tfMascotaActionPerformed

    private void tfPuntosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tfPuntosActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_tfPuntosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCampGanados;
    private javax.swing.JLabel lblCampParticip;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblDatosErroneos;
    private javax.swing.JLabel lblMascota;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblProvincia;
    private javax.swing.JLabel lblPuntos;
    private javax.swing.JList<Equipo> list;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextField tfCampGanados;
    private javax.swing.JTextField tfCampParticip;
    private javax.swing.JTextField tfColor;
    private javax.swing.JTextField tfMascota;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfProvincia;
    private javax.swing.JTextField tfPuntos;
    // End of variables declaration//GEN-END:variables

    private void limpiar() {
        tfNombre.setText("");
        tfProvincia.setText("");
        tfCampParticip.setText("");
        tfCampGanados.setText("");
        tfMascota.setText("");
        tfColor.setText("");
        tfPuntos.setText("");
    }

    private boolean validarDatos(String nombre, String provincia, int campParticip, int campGanados, String mascota,
            String color) {
        boolean correcto = true;
        Equipo temp = new Equipo();

        try { // nombre
            temp.setNomEquipo(nombre);
        } catch (IllegalArgumentException e) {
            correcto = false;
            lblDatosErroneos.setVisible(true);
            lblNombre.setForeground(Principal.errorColor);
        }
        try { // provincia
            temp.setProvincia(nombre);
        } catch (IllegalArgumentException e) {
            correcto = false;
            lblDatosErroneos.setVisible(true);
            lblProvincia.setForeground(Principal.errorColor);
        }
        try { // campParticip
            temp.setCampParticipados(campParticip);
        } catch (IllegalArgumentException e) {
            correcto = false;
            lblDatosErroneos.setVisible(true);
            lblCampParticip.setForeground(Principal.errorColor);
        }
        try { // campGanados
            temp.setCampGanados(campGanados);
        } catch (IllegalArgumentException e) {
            correcto = false;
            lblDatosErroneos.setVisible(true);
            lblCampGanados.setForeground(Principal.errorColor);
        }
        try { // mascota
            temp.setMascota(mascota);
        } catch (IllegalArgumentException e) {
            correcto = false;
            lblDatosErroneos.setVisible(true);
            lblMascota.setForeground(Principal.errorColor);
        }
        try { // color
            temp.setColor(color);
        } catch (IllegalArgumentException e) {
            correcto = false;
            lblDatosErroneos.setVisible(true);
            lblColor.setForeground(Principal.errorColor);
        }

        if (correcto) {
            lblDatosErroneos.setVisible(false);
            changeStatus(true);
        }
        return correcto;
    }

    private void changeStatus(boolean status) {
        tfNombre.setEditable(status);
        tfProvincia.setEditable(status);
        tfCampParticip.setEditable(status);
        tfCampGanados.setEditable(status);
        tfMascota.setEditable(status);
        tfColor.setEditable(status);

        btnEliminar.setEnabled(!status);
        btnNuevo.setEnabled(!status);
        btnEditar.setEnabled(!status);
        list.setEnabled(!status);
        btnSalir.setEnabled(!status);

        btnAgregar.setVisible(status);
        btnGuardar.setVisible(status);
        btnCancelar.setVisible(status);

        lblNombre.setForeground(Color.BLACK);
        lblProvincia.setForeground(Color.BLACK);
        lblCampParticip.setForeground(Color.BLACK);
        lblCampGanados.setForeground(Color.BLACK);
        lblMascota.setForeground(Color.BLACK);
        lblColor.setForeground(Color.BLACK);
        lblPuntos.setForeground(Color.BLACK);
    }
}
