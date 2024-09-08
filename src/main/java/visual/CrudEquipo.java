package visual;

import java.awt.Color;

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

        btnAgregar.setVisible(false);
        btnGuardar.setVisible(false);
        btnCancelar.setVisible(false);

        list.setModel(modelo);

        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int indice = list.getSelectedIndex();
                btnEliminar.setEnabled(indice > -1);
                editabled(indice <= -1);
                if (indice > -1) {
                    Equipo c = modelo.getElementAt(indice);

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

//		lblDatosErroneos = new JLabel("Datos erroneos");
//		lblDatosErroneos.setForeground(new Color(0,0,139));
//		lblDatosErroneos.setFont(new Font("SansSerif", Font.PLAIN, 20));
//		lblDatosErroneos.setBounds(330, 207, 200, 50);
//		lblDatosErroneos.setVisible(false);
//		contentPanel.add(lblDatosErroneos);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        scrollPane = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel.setBackground(new java.awt.Color(143, 182, 155));
        panel.setBorder(new javax.swing.border.MatteBorder(null));
        panel.setForeground(new java.awt.Color(0, 0, 0));

        lblNombre.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(0, 0, 0));
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombre.setText("Nombre");

        tfNombre.setEditable(false);
        tfNombre.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        tfProvincia.setEditable(false);
        tfProvincia.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tfProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfProvinciaActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 0, 0));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        lblMascota.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblMascota.setForeground(new java.awt.Color(0, 0, 0));
        lblMascota.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMascota.setText("Mascota");

        lblCampGanados.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblCampGanados.setForeground(new java.awt.Color(0, 0, 0));
        lblCampGanados.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCampGanados.setText("Campeonatos ganados");

        lblCampParticip.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblCampParticip.setForeground(new java.awt.Color(0, 0, 0));
        lblCampParticip.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCampParticip.setText("Campeonatos participados");

        lblProvincia.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblProvincia.setForeground(new java.awt.Color(0, 0, 0));
        lblProvincia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblProvincia.setText("Provincia");

        lblPuntos.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblPuntos.setForeground(new java.awt.Color(0, 0, 0));
        lblPuntos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPuntos.setText("Puntos");

        lblColor.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblColor.setForeground(new java.awt.Color(0, 0, 0));
        lblColor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblColor.setText("Color");

        tfCampGanados.setEditable(false);
        tfCampGanados.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tfCampGanados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCampGanadosActionPerformed(evt);
            }
        });

        tfCampParticip.setEditable(false);
        tfCampParticip.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tfCampParticip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCampParticipActionPerformed(evt);
            }
        });

        tfColor.setEditable(false);
        tfColor.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tfColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfColorActionPerformed(evt);
            }
        });

        tfMascota.setEditable(false);
        tfMascota.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tfMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMascotaActionPerformed(evt);
            }
        });

        tfPuntos.setEditable(false);
        tfPuntos.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tfPuntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPuntosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblMascota, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCampGanados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCampParticip, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(lblColor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPuntos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblProvincia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(btnGuardar)
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
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(17, 17, 17))
        );

        list.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        list.setForeground(new java.awt.Color(18, 110, 0));
        list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollPane.setViewportView(list);

        btnNuevo.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(0, 0, 0));
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(255, 255, 255));
        btnEditar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(0, 0, 0));
        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(0, 0, 0));
        btnSalir.setText("Salir");
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
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir)))
                .addContainerGap())
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnEliminar)
                    .addComponent(btnNuevo)
                    .addComponent(btnEditar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiar();
        btnAgregar.setVisible(true);
        editabled(true);
        list.setEnabled(false);
        tfNombre.requestFocusInWindow();
        btnEliminar.setEnabled(false);
        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnGuardar.setVisible(false);
        btnCancelar.setVisible(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String nombre = tfNombre.getText();
        String provincia = tfProvincia.getText();
        int campParticip = Integer.parseInt(tfCampParticip.getText());
        int campGanados = Integer.parseInt(tfCampGanados.getText());
        String mascota = tfMascota.getText();
        String color = tfColor.getText();
        int puntos = Integer.parseInt(tfPuntos.getText());

        boolean proceder = true;

        if (proceder) {
            ServicesLocator.getEquipoServices().crearEquipo(new Equipo(nombre, provincia, campParticip, campGanados, mascota, color, puntos));

            Equipo x = new Equipo(ServicesLocator.getEquipoServices().obtenerEquipos().getLast().getIdEquipo(), nombre, provincia, campParticip, campGanados, mascota, color, puntos);
            modelo.addElement(x);

            int lastIndex = list.getModel().getSize() - 1;
            list.setSelectedIndex(lastIndex);
            list.ensureIndexIsVisible(lastIndex);

            editabled(false);
            list.setEnabled(true);
            btnEliminar.setEnabled(true);
            btnEditar.setEnabled(true);
            btnNuevo.setEnabled(true);

            btnAgregar.setVisible(false);
            btnCancelar.setVisible(false);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        editabled(list.getSelectedIndex() > -1);
        list.setEnabled(false);
        tfNombre.requestFocusInWindow();
        btnEliminar.setEnabled(false);
        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnGuardar.setVisible(true);
        btnAgregar.setVisible(false);
        btnCancelar.setVisible(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        int indice = list.getSelectedIndex();

        String nombre = tfNombre.getText();
        String provincia = tfProvincia.getText();
        int campParticip = Integer.parseInt(tfCampParticip.getText());
        int campGanados = Integer.parseInt(tfCampGanados.getText());
        String mascota = tfMascota.getText();
        String color = tfColor.getText();
        int puntos = Integer.parseInt(tfPuntos.getText());

        boolean proceder = true; // validarDatos(id, nombre, capacidad);

        if (proceder) {
            Equipo x = new Equipo(modelo.getElementAt(indice).getIdEquipo(), nombre, provincia, campParticip, campGanados, mascota, color, puntos);

            ServicesLocator.getEquipoServices().actualizarEquipo(x);

            modelo.updateElement(indice, x);
            editabled(false);
            list.setEnabled(true);
            btnEliminar.setEnabled(true);
            btnEditar.setEnabled(true);
            btnNuevo.setEnabled(true);

            btnGuardar.setVisible(false);
            btnCancelar.setVisible(false);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int indice = list.getSelectedIndex();
        if (indice != -1) {
            if (JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar este equipo?",
                    "Confirmar", 0) == 0) {
                
                ServicesLocator.getEquipoServices().eliminarEquipo(modelo.getElementAt(indice).getIdEquipo());

                modelo.removeElement(list.getSelectedIndex());

                limpiar();
                editabled(false);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        editabled(false);
        list.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnEditar.setEnabled(true);
        btnNuevo.setEnabled(true);
        btnAgregar.setVisible(false);
        btnGuardar.setVisible(false);
        btnCancelar.setVisible(false);
        lblNombre.setForeground(Color.BLACK);
        lblProvincia.setForeground(Color.BLACK);
        lblCampParticip.setForeground(Color.BLACK);
        lblCampGanados.setForeground(Color.BLACK);
        lblMascota.setForeground(Color.BLACK);
        lblColor.setForeground(Color.BLACK);
        lblPuntos.setForeground(Color.BLACK);
//				lblDatosErroneos.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        ConnectionManager.closeConnection();
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tfProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfProvinciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfProvinciaActionPerformed

    private void tfCampGanadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCampGanadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCampGanadosActionPerformed

    private void tfCampParticipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCampParticipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCampParticipActionPerformed

    private void tfColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfColorActionPerformed

    private void tfMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfMascotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfMascotaActionPerformed

    private void tfPuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPuntosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPuntosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel lblCampGanados;
    private javax.swing.JLabel lblCampParticip;
    private javax.swing.JLabel lblColor;
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

    private void editabled(boolean status) {
        tfNombre.setEditable(status);
        tfProvincia.setEditable(status);
        tfCampParticip.setEditable(status);
        tfCampGanados.setEditable(status);
        tfMascota.setEditable(status);
        tfColor.setEditable(status);
        tfPuntos.setEditable(status);
    }

    // public boolean validarDatos(String n, String nombre, String capacidad) {
    // 	boolean correcto = true;
    // 	Votante temp = new Votante();
    // 	try { // nombre
    // 		lblD.setForeground(Color.BLACK);
    // 		temp.setNombre(n);
    // 	} catch (IllegalArgumentException e) {
    // 		correcto = false;
    // 		lblDatosErroneos.setVisible(true);
    // 		lblD.setForeground(new Color(0,0,139));
    // 	}
    // 	try { // nombre
    // 		lblNombre.setForeground(Color.BLACK);
    // 		temp.setCorreo(nombre);
    // 	} catch (IllegalArgumentException e) {
    // 		correcto = false;
    // 		lblDatosErroneos.setVisible(true);
    // 		lblNombre.setForeground(new Color(0,0,139));
    // 	}
    // 	try { // contrase�a
    // 		lblCapacidad.setForeground(Color.BLACK);
    // 		temp.setContrasenna(capacidad);
    // 	} catch (IllegalArgumentException e) {
    // 		correcto = false;
    // 		lblDatosErroneos.setVisible(true);
    // 		lblCapacidad.setForeground(new Color(0,0,139));
    // 	}
    // 	if (correcto) {
    // 		lblDatosErroneos.setVisible(false);
    // 	}
    // 	return correcto;
    // }
}
