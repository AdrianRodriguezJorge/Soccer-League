package visual;

import java.awt.Color;
import java.sql.SQLException;
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

        changeStatus(false);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        lblDatosErroneos.setVisible(false);
        lblFechaIncorrecta.setVisible(false);

        Principal.soloNum(tfAudiencia);
        Principal.soloNum(tfGolesLocal);
        Principal.soloNum(tfGolesVisitante);

        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int index = list.getSelectedIndex();
                btnEliminar.setEnabled(index > -1);
                changeStatus(index <= -1);
                if (index > -1) {
                    Partido p = modelo.getElementAt(index);

                    String nomEquipoLocal = buscarNombrEquipo(p.getIdEquipoLocal());
                    String nomEquipoVisit = buscarNombrEquipo(p.getIdEquipoVisitante());

                    jComboBoxEstadio.setSelectedIndex(ServicesLocator.getEstadioServices().getIndexFromId(p.getIdEstadio()));

                    DateChooserFecha.setDate(p.getFecha());
                    tfEstadio.setText(jComboBoxEstadio.getSelectedItem().toString());
                    tfAudiencia.setText(p.getAudiencia() + "");
                    tfLocal.setText(nomEquipoLocal);
                    tfVisit.setText(nomEquipoVisit);
                    tfGolesLocal.setText(p.getGolesLocal() + "");
                    tfGolesVisitante.setText(p.getGolesVisitante() + "");

                    btnNuevo.setEnabled(true);
                    btnEditar.setEnabled(true);

                } else {
                    btnEditar.setEnabled(false);
                }
            }

        });

        modelo.setList(ServicesLocator.getPartidoServices().obtenerPartidos());

    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
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
        lblDatosErroneos = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lblFechaIncorrecta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de partidos");

        contentPanel.setForeground(new java.awt.Color(143, 182, 155));
        contentPanel.setToolTipText("");

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setBorder(new javax.swing.border.MatteBorder(null));
        panel.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFecha.setFont(new java.awt.Font("Roboto Medium", 0, 16)); // NOI18N
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFecha.setText("Fecha");
        panel.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 12, 165, -1));

        lblAudiencia.setFont(new java.awt.Font("Roboto Medium", 0, 16)); // NOI18N
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

        btnCancelar.setBackground(new java.awt.Color(255, 102, 102));
        btnCancelar.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panel.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, -1, -1));

        btnGuardar.setBackground(new java.awt.Color(59, 122, 26));
        btnGuardar.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        panel.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        btnAgregar.setBackground(new java.awt.Color(59, 122, 26));
        btnAgregar.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        panel.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, -1, -1));

        lblEstadio.setFont(new java.awt.Font("Roboto Medium", 0, 16)); // NOI18N
        lblEstadio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEstadio.setText("Estadio");
        panel.add(lblEstadio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 165, -1));

        lblLocal.setFont(new java.awt.Font("Roboto Medium", 0, 16)); // NOI18N
        lblLocal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblLocal.setText("Equipo local");
        panel.add(lblLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 165, -1));

        lblVisitante.setFont(new java.awt.Font("Roboto Medium", 0, 16)); // NOI18N
        lblVisitante.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblVisitante.setText("Equipo visitante");
        panel.add(lblVisitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 165, -1));

        lblGolesLocal.setFont(new java.awt.Font("Roboto Medium", 0, 16)); // NOI18N
        lblGolesLocal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGolesLocal.setText("Goles del e. local");
        panel.add(lblGolesLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 165, -1));

        lblGolesVisit.setFont(new java.awt.Font("Roboto Medium", 0, 16)); // NOI18N
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
        DateChooserFecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                DateChooserFechaPropertyChange(evt);
            }
        });
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
        panel.add(tfEstadio, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 260, -1));

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

        lblDatosErroneos.setFont(new java.awt.Font("SansSerif", 3, 16)); // NOI18N
        lblDatosErroneos.setForeground(new java.awt.Color(255, 51, 51));
        lblDatosErroneos.setText("Datos erroneos");
        panel.add(lblDatosErroneos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 330, -1));

        list.setBackground(new java.awt.Color(204, 204, 204));
        list.setFont(new java.awt.Font("Roboto Medium", 0, 16)); // NOI18N
        list.setForeground(new java.awt.Color(255, 255, 255));
        list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollPane.setViewportView(list);

        btnNuevo.setBackground(new java.awt.Color(242, 242, 242));
        btnNuevo.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(59, 122, 26));
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(242, 242, 242));
        btnEditar.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(59, 122, 26));
        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(242, 242, 242));
        btnEliminar.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(59, 122, 26));
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(242, 242, 242));
        btnSalir.setFont(new java.awt.Font("Roboto Black", 0, 16)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 51, 51));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lblFechaIncorrecta.setFont(new java.awt.Font("SansSerif", 3, 14)); // NOI18N
        lblFechaIncorrecta.setForeground(new java.awt.Color(255, 51, 51));
        lblFechaIncorrecta.setText("La fecha debe encontrarse dentro del intervalo de duración de la liga");

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
                .addGap(18, 18, 18)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblFechaIncorrecta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFechaIncorrecta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void DateChooserFechaPropertyChange(java.beans.PropertyChangeEvent evt) {// GEN-FIRST:event_DateChooserFechaPropertyChange
        lblDatosErroneos.setText("Datos erroneos");
        lblDatosErroneos.setVisible(false);
    }// GEN-LAST:event_DateChooserFechaPropertyChange

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
        changeStatus(true);
        DateChooserFecha.requestFocusInWindow();
        btnGuardar.setVisible(false);
        jComboBoxVisitante.setSelectedIndex(1);

    }// GEN-LAST:event_btnNuevoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAgregarActionPerformed
        Date fecha = DateChooserFecha.getDate();
        int audiencia = Integer.parseInt(tfAudiencia.getText().equals("") ? "-1" : tfAudiencia.getText());
        int golesLocal = Integer.parseInt(tfGolesLocal.getText().equals("") ? "-1" : tfGolesLocal.getText());
        int golesVisit = Integer.parseInt(tfGolesVisitante.getText().equals("") ? "-1" : tfGolesVisitante.getText());
        int idEquipo = ServicesLocator.getEstadioServices().obtenerEstadios().get(jComboBoxEstadio.getSelectedIndex())
                .getIdEstadio();
        int idLocal = (ServicesLocator.getEquipoServices().obtenerEquipos().get(jComboBoxLocal.getSelectedIndex())
                .getIdEquipo());
        int idVisit = ServicesLocator.getEquipoServices().obtenerEquipos().get(jComboBoxVisitante.getSelectedIndex())
                .getIdEquipo();
                
                audiencia = ServicesLocator.getEstadioServices().validarAudiencia(idEquipo, audiencia) ? audiencia : -1;
        boolean val = validarDatos(fecha, audiencia, idLocal, idVisit, golesLocal, golesVisit);

        if (val) {
            Partido p = new Partido();

            p.setFecha(fecha);
            p.setIdEstadio(ServicesLocator.getEstadioServices().obtenerEstadios()
                    .get(jComboBoxEstadio.getSelectedIndex()).getIdEstadio());
            p.setAudiencia(audiencia);
            p.setIdEquipoLocal(idLocal);
            p.setIdEquipoVisitante(idVisit);

            p.setGolesLocal(Integer.parseInt(tfGolesLocal.getText()));
            p.setGolesVisitante((Integer.parseInt(tfGolesVisitante.getText())));

            try {
                ServicesLocator.getPartidoServices().crearPartido(p);
                p.setIdPartido(ServicesLocator.getPartidoServices().obtenerPartidos().getLast().getIdPartido());
                modelo.addElement(p);

                int lastIndex = list.getModel().getSize() - 1;
                list.setSelectedIndex(lastIndex);
                list.ensureIndexIsVisible(lastIndex);

                changeStatus(false);
            } catch (SQLException e) {
                val = validarDatos(null, audiencia, idLocal, idVisit, golesLocal, golesVisit);
                lblFechaIncorrecta.setVisible(true);
                btnGuardar.setVisible(false);
            }

        }
    }// GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEditarActionPerformed
        changeStatus(list.getSelectedIndex() > -1);
        btnAgregar.setVisible(false);
        DateChooserFecha.requestFocusInWindow();

        int index = ServicesLocator.getEquipoServices()
                .getIndexFromId(modelo.getElementAt(list.getSelectedIndex()).getIdEquipoLocal());
        jComboBoxLocal.setSelectedIndex(index);

        index = ServicesLocator.getEquipoServices()
                .getIndexFromId(modelo.getElementAt(list.getSelectedIndex()).getIdEquipoVisitante());
        jComboBoxVisitante.setSelectedIndex(index);
    }// GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnGuardarActionPerformed
        int index = list.getSelectedIndex();
        Date fecha = DateChooserFecha.getDate();
        int audiencia = Integer.parseInt(tfAudiencia.getText().equals("") ? "-1" : tfAudiencia.getText());
        int golesLocal = Integer.parseInt(tfGolesLocal.getText().equals("") ? "-1" : tfGolesLocal.getText());
        int golesVisit = Integer.parseInt(tfGolesVisitante.getText().equals("") ? "-1" : tfGolesVisitante.getText());
        int idEquipo = ServicesLocator.getEstadioServices().obtenerEstadios().get(jComboBoxEstadio.getSelectedIndex())
                .getIdEstadio();
        int idLocal = ServicesLocator.getEquipoServices().obtenerEquipos().get(jComboBoxLocal.getSelectedIndex())
                .getIdEquipo();
        int idVisit = ServicesLocator.getEquipoServices().obtenerEquipos().get(jComboBoxVisitante.getSelectedIndex())
                .getIdEquipo();

        audiencia = ServicesLocator.getEstadioServices().validarAudiencia(idEquipo, audiencia) ? audiencia : -1;

        boolean val = validarDatos(fecha, audiencia, idLocal, idVisit, golesLocal, golesVisit);

        if (val) {
            Partido p = new Partido();

            p.setFecha(fecha);
            p.setIdEstadio(idEquipo);
            p.setAudiencia(audiencia);
            p.setIdEquipoLocal((ServicesLocator.getEquipoServices().obtenerEquipos()
                    .get(jComboBoxLocal.getSelectedIndex()).getIdEquipo()));
            p.setIdEquipoVisitante((ServicesLocator.getEquipoServices().obtenerEquipos()
                    .get(jComboBoxVisitante.getSelectedIndex()).getIdEquipo()));

            p.setGolesLocal(Integer.parseInt(tfGolesLocal.getText()));
            p.setGolesVisitante((Integer.parseInt(tfGolesVisitante.getText())));
            p.setIdPartido(modelo.getElementAt(index).getIdPartido());

            try {
                ServicesLocator.getPartidoServices().actualizarPartido(p);

                modelo.updateElement(index, p);

                changeStatus(false);

                list.setSelectedIndex(index);
            } catch (SQLException e) {
                val = validarDatos(null, audiencia, idLocal, idVisit, golesLocal, golesVisit);
                lblFechaIncorrecta.setVisible(true);
                btnAgregar.setVisible(false);
            }

        }
    }// GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEliminarActionPerformed
        int index = list.getSelectedIndex();
        if (index != -1) {
            if (JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar la información de este partido?",
                    "Confirmar", 0) == 0) {

                ServicesLocator.getPartidoServices().eliminarPartido(modelo.getElementAt(index).getIdPartido());

                modelo.removeElement(index);

                limpiar();
                changeStatus(false);
            }
        }
    }// GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCancelarActionPerformed
        changeStatus(false);
        lblDatosErroneos.setText("Datos erroneos");
        lblDatosErroneos.setVisible(false);
        lblFechaIncorrecta.setVisible(false);
        list.setSelectedIndex(0);
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
    private javax.swing.JLabel lblDatosErroneos;
    private javax.swing.JLabel lblEstadio;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFechaIncorrecta;
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

    private void limpiar() {
        DateChooserFecha.setDate(new Date());
        tfEstadio.setText("");
        tfAudiencia.setText("");
        tfLocal.setText("");
        tfVisit.setText("");
        tfGolesLocal.setText("");
        tfGolesVisitante.setText("");
    }

    private boolean validarDatos(Date fecha, int audiencia, int idLocal, int idVisit, int golesLocal, int golesVisit) {
        boolean correcto = true;
        Partido temp = new Partido();

        try { // audiencia
            temp.setAudiencia(audiencia);
        } catch (IllegalArgumentException e) {
            correcto = false;
            lblDatosErroneos.setVisible(true);
            lblAudiencia.setForeground(Principal.errorColor);
        }
        try { // goles local
            temp.setGolesLocal(golesLocal);
        } catch (IllegalArgumentException e) {
            correcto = false;
            lblDatosErroneos.setVisible(true);
            lblGolesLocal.setForeground(Principal.errorColor);
        }
        try { // goles visitante
            temp.setGolesVisitante(golesVisit);
        } catch (IllegalArgumentException e) {
            correcto = false;
            lblDatosErroneos.setVisible(true);
            lblGolesVisit.setForeground(Principal.errorColor);
        }
        try { // fecha
            temp.setFecha(fecha);
        } catch (Exception e) {
            correcto = false;
            lblDatosErroneos.setVisible(true);
            lblFecha.setForeground(Principal.errorColor);
        }
        if (idLocal == idVisit) {
            correcto = false;
            lblDatosErroneos.setVisible(true);
            lblLocal.setForeground(Principal.errorColor);
            lblVisitante.setForeground(Principal.errorColor);
            JOptionPane.showMessageDialog(null, "Debe seleccionar 2 equipos diferentes.",
                    "Aviso", JOptionPane.ERROR_MESSAGE);
        }

        if (correcto) {
            lblDatosErroneos.setVisible(false);
            lblFechaIncorrecta.setVisible(false);
            changeStatus(true);
        }
        return correcto;
    }

    private void changeStatus(boolean status) {
        tfAudiencia.setEditable(status);
        tfGolesLocal.setEditable(status);
        tfGolesVisitante.setEditable(status);

        tfEstadio.setVisible(!status);
        tfLocal.setVisible(!status);
        tfVisit.setVisible(!status);

        btnEliminar.setEnabled(!status);
        btnNuevo.setEnabled(!status);
        btnEditar.setEnabled(!status);
        list.setEnabled(!status);
        btnSalir.setEnabled(!status);

        btnAgregar.setVisible(status);
        btnGuardar.setVisible(status);
        btnCancelar.setVisible(status);

        lblAudiencia.setForeground(Color.BLACK);
        lblEstadio.setForeground(Color.BLACK);
        lblFecha.setForeground(Color.BLACK);
        lblGolesLocal.setForeground(Color.BLACK);
        lblGolesVisit.setForeground(Color.BLACK);
        lblLocal.setForeground(Color.BLACK);
        lblVisitante.setForeground(Color.BLACK);

        jComboBoxEstadio.setVisible(status);
        jComboBoxLocal.setVisible(status);
        jComboBoxVisitante.setVisible(status);
    }
}
