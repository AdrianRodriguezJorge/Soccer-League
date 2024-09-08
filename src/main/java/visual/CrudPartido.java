package visual;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Equipo;
import model.Partido;
import services.ServicesLocator;
import utils.ConnectionManager;
import utils.Generic_Model;

public class CrudPartido extends javax.swing.JDialog {

    private Generic_Model<Partido> modelo = new Generic_Model<>();

    public CrudPartido(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        list.setModel(modelo);

        for (String s : ServicesLocator.getEstadioServices().obtenerNombresEstadios()) {
            jComboBoxEstadio.addItem(s);
        }

        for (String s : ServicesLocator.getEquipoServices().obtenerNombresEquipos()) {
            jComboBoxLocal.addItem(s);
            jComboBoxVisitante.addItem(s);
        }

        btnAgregar.setVisible(false);
        btnGuardar.setVisible(false);
        btnCancelar.setVisible(false);
        jComboBoxEstadio.setVisible(false);
        jComboBoxLocal.setVisible(false);
        jComboBoxVisitante.setVisible(false);
        
        jComboBoxEstadio.setLocation(tfEstadio.getLocation());

        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int index = list.getSelectedIndex();
                btnEliminar.setEnabled(index > -1);
                editabled(index <= -1);
                if (index > -1) {
                    Partido p = modelo.getElementAt(index);

                    String nomEquipoLocal = buscarNombrEquipo(p.getIdEquipoLocal());
                    String nomEquipoVisit = buscarNombrEquipo(p.getIdEquipoVisitante());

                    DateChooserFecha.setDate(p.getFecha());
                    tfEstadio.setText(ServicesLocator.getEstadioServices()
                            .getNombreEstadio(p.getIdEstadio()));
                    tfAudiencia.setText(p.getAudiencia() + "");
                    tfLocal.setText(nomEquipoLocal);
                    tfVisit.setText(nomEquipoVisit);
                    tfGolesLocal.setText(p.getGoles_local() + "");
                    tfGolesVisitante.setText(p.getGoles_visitante() + "");

                    btnNuevo.setEnabled(true);
                    btnEditar.setEnabled(true);

                } else {
                    btnEditar.setEnabled(false);
                }
            }

        });

        modelo.setList(ServicesLocator.getPartidoServices().obtenerPartidos());

        // lblDatosErroneos = new JLabel("Datos erroneos");
        // lblDatosErroneos.setForeground(new Color(0,0,139));
        // lblDatosErroneos.setFont(new Font("SansSerif", Font.PLAIN, 20));
        // lblDatosErroneos.setBounds(330, 207, 200, 50);
        // lblDatosErroneos.setVisible(false);
        // contentPanel.add(lblDatosErroneos);

    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPanel = new javax.swing.JPanel();
        panel = new javax.swing.JPanel();
        lblFecha = new javax.swing.JLabel();
        lblAudiencia = new javax.swing.JLabel();
        tfAudiencia = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        lblEstadio = new javax.swing.JLabel();
        lblLocal = new javax.swing.JLabel();
        lblVisitante = new javax.swing.JLabel();
        lblGolesLocal = new javax.swing.JLabel();
        lblGolesVisit = new javax.swing.JLabel();
        tfGolesLocal = new javax.swing.JTextField();
        tfGolesVisitante = new javax.swing.JTextField();
        DateChooserFecha = new com.toedter.calendar.JDateChooser();
        jComboBoxEstadio = new javax.swing.JComboBox<>();
        jComboBoxLocal = new javax.swing.JComboBox<>();
        jComboBoxVisitante = new javax.swing.JComboBox<>();
        tfEstadio = new javax.swing.JTextField();
        tfVisit = new javax.swing.JTextField();
        tfLocal = new javax.swing.JTextField();
        scrollPane = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de partidos");

        contentPanel.setForeground(new java.awt.Color(143, 182, 155));
        contentPanel.setToolTipText("");

        panel.setBackground(new java.awt.Color(143, 182, 155));
        panel.setBorder(new javax.swing.border.MatteBorder(null));
        panel.setForeground(new java.awt.Color(0, 0, 0));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFecha.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(0, 0, 0));
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFecha.setText("Fecha");
        panel.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 12, 165, -1));

        lblAudiencia.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lblAudiencia.setForeground(new java.awt.Color(0, 0, 0));
        lblAudiencia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAudiencia.setText("Audiencia");
        panel.add(lblAudiencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 165, -1));

        tfAudiencia.setEditable(false);
        tfAudiencia.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        tfAudiencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAudienciaActionPerformed(evt);
            }
        });
        panel.add(tfAudiencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 50, -1));

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panel.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, -1, -1));

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 0, 0));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        panel.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        btnAgregar.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregar.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        panel.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, -1, -1));

        lblEstadio.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lblEstadio.setForeground(new java.awt.Color(0, 0, 0));
        lblEstadio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEstadio.setText("Estadio");
        panel.add(lblEstadio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 165, -1));

        lblLocal.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lblLocal.setForeground(new java.awt.Color(0, 0, 0));
        lblLocal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblLocal.setText("Equipo local");
        panel.add(lblLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 165, -1));

        lblVisitante.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lblVisitante.setForeground(new java.awt.Color(0, 0, 0));
        lblVisitante.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblVisitante.setText("Equipo visitante");
        panel.add(lblVisitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 165, -1));

        lblGolesLocal.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lblGolesLocal.setForeground(new java.awt.Color(0, 0, 0));
        lblGolesLocal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGolesLocal.setText("Goles del e. local");
        panel.add(lblGolesLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 165, -1));

        lblGolesVisit.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lblGolesVisit.setForeground(new java.awt.Color(0, 0, 0));
        lblGolesVisit.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGolesVisit.setText("Goles del e. visitante");
        panel.add(lblGolesVisit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 225, 165, -1));

        tfGolesLocal.setEditable(false);
        tfGolesLocal.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        tfGolesLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfGolesLocalActionPerformed(evt);
            }
        });
        panel.add(tfGolesLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 50, -1));

        tfGolesVisitante.setEditable(false);
        tfGolesVisitante.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        tfGolesVisitante.setMinimumSize(new java.awt.Dimension(64, 24));
        tfGolesVisitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfGolesVisitanteActionPerformed(evt);
            }
        });
        panel.add(tfGolesVisitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 225, 50, -1));

        DateChooserFecha.setDateFormatString("yyyy-MM-dd HH:mm");
        DateChooserFecha.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        panel.add(DateChooserFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 170, 25));

        jComboBoxEstadio.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jComboBoxEstadio.setFocusable(false);
        jComboBoxEstadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEstadioActionPerformed(evt);
            }
        });
        panel.add(jComboBoxEstadio, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, -1, -1));

        jComboBoxLocal.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        panel.add(jComboBoxLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, -1, -1));

        jComboBoxVisitante.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        panel.add(jComboBoxVisitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, -1, -1));

        tfEstadio.setEditable(false);
        tfEstadio.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        tfEstadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEstadioActionPerformed(evt);
            }
        });
        panel.add(tfEstadio, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 176, -1));

        tfVisit.setEditable(false);
        tfVisit.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        tfVisit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfVisitActionPerformed(evt);
            }
        });
        panel.add(tfVisit, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 176, -1));

        tfLocal.setEditable(false);
        tfLocal.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        tfLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfLocalActionPerformed(evt);
            }
        });
        panel.add(tfLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 176, -1));

        list.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        list.setForeground(new java.awt.Color(0, 102, 51));
        list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollPane.setViewportView(list);

        btnNuevo.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevo.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(0, 0, 0));
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(255, 255, 255));
        btnEditar.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(0, 0, 0));
        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
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
                        .addGap(18, 18, 18)
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir)
                        .addGap(21, 21, 21))))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar)
                    .addComponent(btnNuevo)
                    .addComponent(btnSalir))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        contentPanel.getAccessibleContext().setAccessibleParent(contentPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxEstadioActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBoxEstadioActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jComboBoxEstadioActionPerformed

    private void tfLocalActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tfLocalActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_tfLocalActionPerformed

    private void tfVisitActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tfVisitActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_tfVisitActionPerformed

    private void tfEstadioActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tfEstadioActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_tfEstadioActionPerformed

    private void tfGolesVisitanteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tfGolesVisitanteActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_tfGolesVisitanteActionPerformed

    private void tfGolesLocalActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tfGolesLocalActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_tfGolesLocalActionPerformed

    private void tfAudienciaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tfAudienciaActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_tfAudienciaActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNuevoActionPerformed
        limpiar();
        btnAgregar.setVisible(true);
        editabled(true);
        list.setEnabled(false);
        DateChooserFecha.requestFocusInWindow();
        btnEliminar.setEnabled(false);
        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnGuardar.setVisible(false);
        btnCancelar.setVisible(true);

        tfEstadio.setVisible(false);
        tfLocal.setVisible(false);
        tfVisit.setVisible(false);
        
        jComboBoxEstadio.setVisible(true);
        jComboBoxEstadio.setLocation(tfEstadio.getLocation());

        jComboBoxLocal.setVisible(true);
        jComboBoxLocal.setLocation(tfLocal.getLocation());

        jComboBoxVisitante.setVisible(true);
        jComboBoxVisitante.setLocation(tfVisit.getLocation());
    }// GEN-LAST:event_btnNuevoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAgregarActionPerformed

        boolean proceder = true; // validarDatos(id, nombre, capacidad);

        if (proceder) {
            // guardar en la BD
            Partido p = new Partido();

            p.setFecha(DateChooserFecha.getDate());
            p.setIdEstadio(ServicesLocator.getEstadioServices().obtenerEstadios()
                    .get(jComboBoxEstadio.getSelectedIndex()).getIdEstadio());
            p.setAudiencia(Integer.parseInt(tfAudiencia.getText()));
            p.setIdEquipoLocal((ServicesLocator.getEquipoServices().obtenerEquipos()
                    .get(jComboBoxLocal.getSelectedIndex()).getIdEquipo()));
            p.setIdEquipoVisitante((ServicesLocator.getEquipoServices().obtenerEquipos()
                    .get(jComboBoxVisitante.getSelectedIndex()).getIdEquipo()));

            p.setGoles_local(Integer.parseInt(tfGolesLocal.getText()));
            p.setGoles_visitante((Integer.parseInt(tfGolesVisitante.getText())));

            ServicesLocator.getPartidoServices().crearPartido(p);
            modelo.addElement(p);

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

            jComboBoxEstadio.setVisible(false);
            jComboBoxLocal.setVisible(false);
            jComboBoxVisitante.setVisible(false);
        }
    }// GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEditarActionPerformed
        editabled(list.getSelectedIndex() > -1);
        list.setEnabled(false);
        DateChooserFecha.requestFocusInWindow();
        btnEliminar.setEnabled(false);
        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnGuardar.setVisible(true);
        btnAgregar.setVisible(false);
        btnCancelar.setVisible(true);

        tfEstadio.setVisible(false);
        tfLocal.setVisible(false);
        tfVisit.setVisible(false);
        
        jComboBoxEstadio.setVisible(true);
        jComboBoxEstadio.setLocation(tfEstadio.getLocation());

        jComboBoxLocal.setVisible(true);
        jComboBoxLocal.setLocation(tfLocal.getLocation());

        jComboBoxVisitante.setVisible(true);
        jComboBoxVisitante.setLocation(tfVisit.getLocation());
    }// GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnGuardarActionPerformed
        int index = list.getSelectedIndex();

        boolean proceder = true; // validarDatos(id, nombre, capacidad);

        if (proceder) {
            Partido p = new Partido();

            p.setFecha(DateChooserFecha.getDate());
            p.setIdEstadio(ServicesLocator.getEstadioServices().getIdFromIndex(jComboBoxEstadio.getSelectedIndex()));
            p.setAudiencia(Integer.parseInt(tfAudiencia.getText()));
            p.setIdEquipoLocal((ServicesLocator.getEquipoServices().obtenerEquipos()
                    .get(jComboBoxLocal.getSelectedIndex()).getIdEquipo()));
            p.setIdEquipoVisitante((ServicesLocator.getEquipoServices().obtenerEquipos()
                    .get(jComboBoxVisitante.getSelectedIndex()).getIdEquipo()));

            p.setGoles_local(Integer.parseInt(tfGolesLocal.getText()));
            p.setGoles_visitante((Integer.parseInt(tfGolesVisitante.getText())));

            p.setIdPartido(modelo.getElementAt(index).getIdPartido());

            ServicesLocator.getPartidoServices().actualizarPartido(p);

            modelo.updateElement(index, p);

            editabled(false);
            list.setEnabled(true);
            btnEliminar.setEnabled(true);
            btnEditar.setEnabled(true);
            btnNuevo.setEnabled(true);

            btnGuardar.setVisible(false);
            btnCancelar.setVisible(false);

            
            jComboBoxEstadio.setVisible(false);
            jComboBoxLocal.setVisible(false);
            jComboBoxVisitante.setVisible(false);
        }
    }// GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEliminarActionPerformed
        int index = list.getSelectedIndex();
        if (index != -1) {
            if (JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar la información de este estadio?",
                    "Confirmar", 0) == 0) {
                modelo.removeElement(index);

                ServicesLocator.getPartidoServices().eliminarPartido(ServicesLocator
                        .getPartidoServices().getIdFromIndex(index));

                limpiar();
                editabled(false);
            }
        }
    }// GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCancelarActionPerformed
        editabled(false);
        list.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnEditar.setEnabled(true);
        btnNuevo.setEnabled(true);
        btnAgregar.setVisible(false);
        btnGuardar.setVisible(false);
        btnCancelar.setVisible(false);

        lblAudiencia.setForeground(Color.BLACK);
        lblEstadio.setForeground(Color.BLACK);
        lblFecha.setForeground(Color.BLACK);
        lblGolesLocal.setForeground(Color.BLACK);
        lblGolesVisit.setForeground(Color.BLACK);
        lblLocal.setForeground(Color.BLACK);
        lblVisitante.setForeground(Color.BLACK);

        jComboBoxEstadio.setVisible(false);
        jComboBoxLocal.setVisible(false);
        jComboBoxVisitante.setVisible(false);

        tfEstadio.setVisible(true);
        tfLocal.setVisible(true);
        tfVisit.setVisible(true);

        // lblDatosErroneos.setVisible(false);
    }// GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSalirActionPerformed
        ConnectionManager.closeConnection();
        dispose();
    }// GEN-LAST:event_btnSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateChooserFecha;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JComboBox<String> jComboBoxEstadio;
    private javax.swing.JComboBox<String> jComboBoxLocal;
    private javax.swing.JComboBox<String> jComboBoxVisitante;
    private javax.swing.JLabel lblAudiencia;
    private javax.swing.JLabel lblEstadio;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblGolesLocal;
    private javax.swing.JLabel lblGolesVisit;
    private javax.swing.JLabel lblLocal;
    private javax.swing.JLabel lblVisitante;
    private javax.swing.JList<Partido> list;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextField tfAudiencia;
    private javax.swing.JTextField tfEstadio;
    private javax.swing.JTextField tfGolesLocal;
    private javax.swing.JTextField tfGolesVisitante;
    private javax.swing.JTextField tfLocal;
    private javax.swing.JTextField tfVisit;
    // End of variables declaration//GEN-END:variables

    private void limpiar() {
        DateChooserFecha.setDate(new Date());
        tfEstadio.setText("");
        tfAudiencia.setText("");
        tfLocal.setText("");
        tfVisit.setText("");
        tfGolesLocal.setText("");
        tfGolesVisitante.setText("");

    }

    private void editabled(boolean status) {
        tfAudiencia.setEditable(status);
        tfEstadio.setEditable(status);
        tfGolesLocal.setEditable(status);
        tfGolesVisitante.setEditable(status);
        tfLocal.setEditable(status);
        tfVisit.setEditable(status);
    }

    private String buscarNombrEquipo(int id) {
        String nom = null;
        ArrayList<Equipo> equipos = ServicesLocator.getEquipoServices().obtenerEquipos();

        for (int i = 0; i < equipos.size() && nom == null; i++) {
            if (equipos.get(i).getIdEquipo() == id) {
                nom = equipos.get(i).getNomEquipo();
            }
        }

        return nom;
    }

    // public boolean validarDatos(String n, String nombre, String capacidad) {
    // boolean correcto = true;
    // Votante temp = new Votante();

    // try { // nombre
    // lblD.setForeground(Color.BLACK);
    // temp.setNombre(n);
    // } catch (IllegalArgumentException e) {
    // correcto = false;
    // lblDatosErroneos.setVisible(true);
    // lblD.setForeground(new Color(0,0,139));
    // }

    // try { // nombre
    // lblNombre.setForeground(Color.BLACK);
    // temp.setCorreo(nombre);
    // } catch (IllegalArgumentException e) {
    // correcto = false;
    // lblDatosErroneos.setVisible(true);
    // lblNombre.setForeground(new Color(0,0,139));
    // }

    // try { // contrase�a
    // lblCapacidad.setForeground(Color.BLACK);
    // temp.setContrasenna(capacidad);
    // } catch (IllegalArgumentException e) {
    // correcto = false;
    // lblDatosErroneos.setVisible(true);
    // lblCapacidad.setForeground(new Color(0,0,139));
    // }

    // if (correcto) {
    // lblDatosErroneos.setVisible(false);
    // }
    // return correcto;
    // }

}
