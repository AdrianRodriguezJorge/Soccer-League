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
                desactivar_habilitar(indice <= -1);
                if (indice > -1) {
                    Equipo c = modelo.getElementAt(indice);

                    textFieldNombre.setText(c.getNomEquipo());
                    textFieldProvincia.setText(c.getProvincia());
                    textFieldCampParticip.setText(String.valueOf(c.getCampParticipados()));
                    textFieldCampGanados.setText(String.valueOf(c.getCampGanados()));
                    textFieldMascota.setText(c.getMascota());
                    textFieldColor.setText(c.getColor());
                    textFieldPuntos.setText(c.getPuntos() + "");

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
        textFieldNombre = new javax.swing.JTextField();
        textFieldProvincia = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        lblMascota = new javax.swing.JLabel();
        lblCampGanados = new javax.swing.JLabel();
        lblCampParticip = new javax.swing.JLabel();
        lblProvincia = new javax.swing.JLabel();
        lblPuntos = new javax.swing.JLabel();
        lblColor = new javax.swing.JLabel();
        textFieldCampGanados = new javax.swing.JTextField();
        textFieldCampParticip = new javax.swing.JTextField();
        textFieldColor = new javax.swing.JTextField();
        textFieldMascota = new javax.swing.JTextField();
        textFieldPuntos = new javax.swing.JTextField();
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

        textFieldNombre.setEditable(false);
        textFieldNombre.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        textFieldProvincia.setEditable(false);
        textFieldProvincia.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        textFieldProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldProvinciaActionPerformed(evt);
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

        textFieldCampGanados.setEditable(false);
        textFieldCampGanados.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        textFieldCampGanados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldCampGanadosActionPerformed(evt);
            }
        });

        textFieldCampParticip.setEditable(false);
        textFieldCampParticip.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        textFieldCampParticip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldCampParticipActionPerformed(evt);
            }
        });

        textFieldColor.setEditable(false);
        textFieldColor.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        textFieldColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldColorActionPerformed(evt);
            }
        });

        textFieldMascota.setEditable(false);
        textFieldMascota.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        textFieldMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldMascotaActionPerformed(evt);
            }
        });

        textFieldPuntos.setEditable(false);
        textFieldPuntos.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        textFieldPuntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldPuntosActionPerformed(evt);
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
                                .addComponent(textFieldNombre)
                                .addComponent(textFieldProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(textFieldCampGanados, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addComponent(textFieldCampParticip, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(textFieldMascota, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldColor, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProvincia)
                    .addComponent(textFieldProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCampParticip)
                    .addComponent(textFieldCampParticip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCampGanados)
                    .addComponent(textFieldCampGanados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMascota)
                    .addComponent(textFieldMascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblColor)
                    .addComponent(textFieldColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPuntos)
                    .addComponent(textFieldPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        desactivar_habilitar(true);
        list.setEnabled(false);
        textFieldNombre.requestFocusInWindow();
        btnEliminar.setEnabled(false);
        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnGuardar.setVisible(false);
        btnCancelar.setVisible(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String nombre = textFieldNombre.getText();
        String provincia = textFieldProvincia.getText();
        int campParticip = Integer.parseInt(textFieldCampParticip.getText());
        int campGanados = Integer.parseInt(textFieldCampGanados.getText());
        String mascota = textFieldMascota.getText();
        String color = textFieldColor.getText();
        int puntos = Integer.parseInt(textFieldPuntos.getText());

        boolean proceder = true;

        if (proceder) {
            ServicesLocator.getEquipoServices().crearEquipo(new Equipo(nombre, provincia, campParticip, campGanados, mascota, color, puntos));

            Equipo x = new Equipo(ServicesLocator.getEquipoServices().obtenerEquipos().getLast().getIdEquipo(), nombre, provincia, campParticip, campGanados, mascota, color, puntos);
            modelo.addElement(x);

            int lastIndex = list.getModel().getSize() - 1;
            list.setSelectedIndex(lastIndex);
            list.ensureIndexIsVisible(lastIndex);

            desactivar_habilitar(false);
            list.setEnabled(true);
            btnEliminar.setEnabled(true);
            btnEditar.setEnabled(true);
            btnNuevo.setEnabled(true);

            btnAgregar.setVisible(false);
            btnCancelar.setVisible(false);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        desactivar_habilitar(list.getSelectedIndex() > -1);
        list.setEnabled(false);
        textFieldNombre.requestFocusInWindow();
        btnEliminar.setEnabled(false);
        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnGuardar.setVisible(true);
        btnAgregar.setVisible(false);
        btnCancelar.setVisible(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        int indice = list.getSelectedIndex();

        String nombre = textFieldNombre.getText();
        String provincia = textFieldProvincia.getText();
        int campParticip = Integer.parseInt(textFieldCampParticip.getText());
        int campGanados = Integer.parseInt(textFieldCampGanados.getText());
        String mascota = textFieldMascota.getText();
        String color = textFieldColor.getText();
        int puntos = Integer.parseInt(textFieldPuntos.getText());

        boolean proceder = true; // validarDatos(id, nombre, capacidad);

        if (proceder) {
            Equipo x = new Equipo(modelo.getElementAt(indice).getIdEquipo(), nombre, provincia, campParticip, campGanados, mascota, color, puntos);

            ServicesLocator.getEquipoServices().actualizarEquipo(x);

            modelo.updateElement(indice, x);
            desactivar_habilitar(false);
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
                desactivar_habilitar(false);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        desactivar_habilitar(false);
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

    private void textFieldProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldProvinciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldProvinciaActionPerformed

    private void textFieldCampGanadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldCampGanadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldCampGanadosActionPerformed

    private void textFieldCampParticipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldCampParticipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldCampParticipActionPerformed

    private void textFieldColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldColorActionPerformed

    private void textFieldMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldMascotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldMascotaActionPerformed

    private void textFieldPuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPuntosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPuntosActionPerformed

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
    private javax.swing.JTextField textFieldCampGanados;
    private javax.swing.JTextField textFieldCampParticip;
    private javax.swing.JTextField textFieldColor;
    private javax.swing.JTextField textFieldMascota;
    private javax.swing.JTextField textFieldNombre;
    private javax.swing.JTextField textFieldProvincia;
    private javax.swing.JTextField textFieldPuntos;
    // End of variables declaration//GEN-END:variables

    private void limpiar() {
        textFieldNombre.setText("");
        textFieldProvincia.setText("");
        textFieldCampParticip.setText("");
        textFieldCampGanados.setText("");
        textFieldMascota.setText("");
        textFieldColor.setText("");
        textFieldPuntos.setText("");
    }

    private void desactivar_habilitar(boolean estado) {
        textFieldNombre.setEditable(estado);
        textFieldProvincia.setEditable(estado);
        textFieldCampParticip.setEditable(estado);
        textFieldCampGanados.setEditable(estado);
        textFieldMascota.setEditable(estado);
        textFieldColor.setEditable(estado);
        textFieldPuntos.setEditable(estado);
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
