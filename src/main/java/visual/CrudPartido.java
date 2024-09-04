package visual;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Equipo;
import model.Estadio;
import model.Partido;
import services.ServicesLocator;
import utils.ConnectionManager;
import utils.Generic_Model;

public class CrudPartido extends javax.swing.JDialog {

    private Generic_Model<Partido> modelo = new Generic_Model<>();

    public CrudPartido(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        scrollPane.setViewportView(list);

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

        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int index = list.getSelectedIndex();
                btnEliminar.setEnabled(index > -1);
                desactivar_habilitar(index <= -1);
                if (index > -1) {
                    Partido p = modelo.getElementAt(index);

                    System.out.println(p.getIdEquipoVisitante());

                    String nomEquipoLocal = buscarNombrEquipo(p.getIdEquipoLocal());
                    String nomEquipoVisit = buscarNombrEquipo(p.getIdEquipoVisitante());

                    System.out.println(nomEquipoLocal + " / " + nomEquipoVisit);

                    DateChooserFecha.setDate(p.getFecha());
                    textFieldEstadio.setText(ServicesLocator.getEstadioServices()
                            .getNombreEstadio(p.getIdEstadio()));
                    textFieldAudiencia.setText(p.getAudiencia() + "");
                    textFieldLocal.setText(nomEquipoLocal);
                    textFieldVisit.setText(nomEquipoVisit);
                    textFieldGolesLocal.setText(p.getGoles_local() + "");
                    textFieldGolesVisitante.setText(p.getGoles_visitante() + "");

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
        textFieldAudiencia = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        lblEstadio = new javax.swing.JLabel();
        lblLocal = new javax.swing.JLabel();
        lblVisitante = new javax.swing.JLabel();
        lblGolesLocal = new javax.swing.JLabel();
        lblGolesVisit = new javax.swing.JLabel();
        textFieldGolesLocal = new javax.swing.JTextField();
        textFieldGolesVisitante = new javax.swing.JTextField();
        DateChooserFecha = new com.toedter.calendar.JDateChooser();
        jComboBoxEstadio = new javax.swing.JComboBox<>();
        jComboBoxLocal = new javax.swing.JComboBox<>();
        jComboBoxVisitante = new javax.swing.JComboBox<>();
        textFieldEstadio = new javax.swing.JTextField();
        textFieldVisit = new javax.swing.JTextField();
        textFieldLocal = new javax.swing.JTextField();
        scrollPane = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel.setBackground(new java.awt.Color(101, 161, 101));
        panel.setBorder(new javax.swing.border.MatteBorder(null));
        panel.setForeground(new java.awt.Color(0, 0, 0));

        lblFecha.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(0, 0, 0));
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFecha.setText("Fecha");

        lblAudiencia.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lblAudiencia.setForeground(new java.awt.Color(0, 0, 0));
        lblAudiencia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAudiencia.setText("Audiencia");

        textFieldAudiencia.setEditable(false);
        textFieldAudiencia.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        textFieldAudiencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldAudienciaActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 0, 0));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregar.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        lblEstadio.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lblEstadio.setForeground(new java.awt.Color(0, 0, 0));
        lblEstadio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEstadio.setText("Estadio");

        lblLocal.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lblLocal.setForeground(new java.awt.Color(0, 0, 0));
        lblLocal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblLocal.setText("Equipo local");

        lblVisitante.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        lblVisitante.setForeground(new java.awt.Color(0, 0, 0));
        lblVisitante.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblVisitante.setText("Equipo visitante");

        lblGolesLocal.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        lblGolesLocal.setForeground(new java.awt.Color(0, 0, 0));
        lblGolesLocal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGolesLocal.setText("Goles del e. local");

        lblGolesVisit.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblGolesVisit.setForeground(new java.awt.Color(0, 0, 0));
        lblGolesVisit.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGolesVisit.setText("Goles del e. visitante");

        textFieldGolesLocal.setEditable(false);
        textFieldGolesLocal.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        textFieldGolesLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldGolesLocalActionPerformed(evt);
            }
        });

        textFieldGolesVisitante.setEditable(false);
        textFieldGolesVisitante.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        textFieldGolesVisitante.setMinimumSize(new java.awt.Dimension(64, 24));
        textFieldGolesVisitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldGolesVisitanteActionPerformed(evt);
            }
        });

        DateChooserFecha.setDateFormatString("yyyy-MM-dd HH:mm");

        jComboBoxEstadio.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jComboBoxEstadio.setFocusable(false);
        jComboBoxEstadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEstadioActionPerformed(evt);
            }
        });

        jComboBoxLocal.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N

        jComboBoxVisitante.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N

        textFieldEstadio.setEditable(false);
        textFieldEstadio.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        textFieldEstadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldEstadioActionPerformed(evt);
            }
        });

        textFieldVisit.setEditable(false);
        textFieldVisit.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        textFieldVisit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldVisitActionPerformed(evt);
            }
        });

        textFieldLocal.setEditable(false);
        textFieldLocal.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        textFieldLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldLocalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblGolesLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGolesVisit, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(textFieldGolesLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBoxEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(textFieldGolesVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(textFieldLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelLayout.createSequentialGroup()
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelLayout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblEstadio)
                                        .addComponent(lblAudiencia, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(lblVisitante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(24, 24, 24)
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(textFieldAudiencia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(DateChooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textFieldVisit, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                .addComponent(textFieldEstadio)))))
                .addGap(84, 84, 84))
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jComboBoxLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(jComboBoxVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFecha)
                            .addComponent(DateChooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jComboBoxEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(104, 104, 104))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblEstadio)
                                    .addComponent(textFieldEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblAudiencia)
                                    .addComponent(textFieldAudiencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblLocal)
                                    .addComponent(textFieldLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblVisitante)
                                    .addComponent(textFieldVisit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblGolesLocal)
                                    .addComponent(textFieldGolesLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblGolesVisit)
                                    .addComponent(textFieldGolesVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(77, 77, 77)))))
                .addGap(39, 39, 39)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAgregar)
                    .addComponent(btnGuardar))
                .addContainerGap())
        );

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
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
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

    private void textFieldLocalActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_textFieldLocalActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_textFieldLocalActionPerformed

    private void textFieldVisitActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_textFieldVisitActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_textFieldVisitActionPerformed

    private void textFieldEstadioActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_textFieldEstadioActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_textFieldEstadioActionPerformed

    private void textFieldGolesVisitanteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_textFieldGolesVisitanteActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_textFieldGolesVisitanteActionPerformed

    private void textFieldGolesLocalActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_textFieldGolesLocalActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_textFieldGolesLocalActionPerformed

    private void textFieldAudienciaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_textFieldAudienciaActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_textFieldAudienciaActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNuevoActionPerformed
        limpiar();
        btnAgregar.setVisible(true);
        desactivar_habilitar(true);
        list.setEnabled(false);
        DateChooserFecha.requestFocusInWindow();
        btnEliminar.setEnabled(false);
        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnGuardar.setVisible(false);
        btnCancelar.setVisible(true);

        textFieldEstadio.setVisible(false);
        textFieldLocal.setVisible(false);
        textFieldVisit.setVisible(false);
        
        jComboBoxEstadio.setVisible(true);
        jComboBoxEstadio.setLocation(textFieldEstadio.getLocation());

        jComboBoxLocal.setVisible(true);
        jComboBoxLocal.setLocation(textFieldLocal.getLocation());

        jComboBoxVisitante.setVisible(true);
        jComboBoxVisitante.setLocation(textFieldVisit.getLocation());
    }// GEN-LAST:event_btnNuevoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAgregarActionPerformed

        boolean proceder = true; // validarDatos(id, nombre, capacidad);

        if (proceder) {
            // guardar en la BD
            Partido p = new Partido();

            p.setFecha(DateChooserFecha.getDate());
            p.setIdEstadio(ServicesLocator.getEstadioServices().obtenerEstadios()
                    .get(jComboBoxEstadio.getSelectedIndex()).getIdEstadio());
            p.setAudiencia(Integer.parseInt(textFieldAudiencia.getText()));
            p.setIdEquipoLocal((ServicesLocator.getEquipoServices().obtenerEquipos()
                    .get(jComboBoxLocal.getSelectedIndex()).getIdEquipo()));
            p.setIdEquipoVisitante((ServicesLocator.getEquipoServices().obtenerEquipos()
                    .get(jComboBoxVisitante.getSelectedIndex()).getIdEquipo()));

            p.setGoles_local(Integer.parseInt(textFieldGolesLocal.getText()));
            p.setGoles_visitante((Integer.parseInt(textFieldGolesVisitante.getText())));

            System.out.println(jComboBoxLocal.getSelectedIndex());
            System.out.println(jComboBoxVisitante.getSelectedIndex());

            ServicesLocator.getPartidoServices().crearPartido(p);
            modelo.addElement(p);

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

            jComboBoxEstadio.setVisible(false);
            jComboBoxLocal.setVisible(false);
            jComboBoxVisitante.setVisible(false);
        }
    }// GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEditarActionPerformed
        desactivar_habilitar(list.getSelectedIndex() > -1);
        list.setEnabled(false);
        DateChooserFecha.requestFocusInWindow();
        btnEliminar.setEnabled(false);
        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnGuardar.setVisible(true);
        btnAgregar.setVisible(false);
        btnCancelar.setVisible(true);

        textFieldEstadio.setVisible(false);
        textFieldLocal.setVisible(false);
        textFieldVisit.setVisible(false);
        
        jComboBoxEstadio.setVisible(true);
        jComboBoxEstadio.setLocation(textFieldEstadio.getLocation());

        jComboBoxLocal.setVisible(true);
        jComboBoxLocal.setLocation(textFieldLocal.getLocation());

        jComboBoxVisitante.setVisible(true);
        jComboBoxVisitante.setLocation(textFieldVisit.getLocation());
    }// GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnGuardarActionPerformed
        int index = list.getSelectedIndex();

        boolean proceder = true; // validarDatos(id, nombre, capacidad);

        if (proceder) {
            Partido p = new Partido();

            p.setFecha(DateChooserFecha.getDate());
            p.setIdEstadio(ServicesLocator.getEstadioServices().getIdFromIndex(jComboBoxEstadio.getSelectedIndex()));
            p.setAudiencia(Integer.parseInt(textFieldAudiencia.getText()));
            p.setIdEquipoLocal((ServicesLocator.getEquipoServices().obtenerEquipos()
                    .get(jComboBoxLocal.getSelectedIndex()).getIdEquipo()));
            p.setIdEquipoVisitante((ServicesLocator.getEquipoServices().obtenerEquipos()
                    .get(jComboBoxVisitante.getSelectedIndex()).getIdEquipo()));

            p.setGoles_local(Integer.parseInt(textFieldGolesLocal.getText()));
            p.setGoles_visitante((Integer.parseInt(textFieldGolesVisitante.getText())));

            p.setIdPartido(modelo.getElementAt(index).getIdPartido());

            ServicesLocator.getPartidoServices().actualizarPartido(p);

            modelo.updateElement(index, p);

            desactivar_habilitar(false);
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
            if (JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar este estadio?",
                    "Confirmar", 0) == 0) {
                modelo.removeElement(index);

                ServicesLocator.getPartidoServices().eliminarPartido(ServicesLocator
                        .getPartidoServices().getIdFromIndex(index));

                limpiar();
                desactivar_habilitar(false);
            }
        }
    }// GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCancelarActionPerformed
        desactivar_habilitar(false);
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

        textFieldEstadio.setVisible(true);
        textFieldLocal.setVisible(true);
        textFieldVisit.setVisible(true);

        // lblDatosErroneos.setVisible(false);
    }// GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSalirActionPerformed
        ConnectionManager.closeConnection();
        dispose();
        System.exit(0);
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
    private javax.swing.JList<Estadio> list;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextField textFieldAudiencia;
    private javax.swing.JTextField textFieldEstadio;
    private javax.swing.JTextField textFieldGolesLocal;
    private javax.swing.JTextField textFieldGolesVisitante;
    private javax.swing.JTextField textFieldLocal;
    private javax.swing.JTextField textFieldVisit;
    // End of variables declaration//GEN-END:variables

    private void limpiar() {
        DateChooserFecha.setDate(new Date());
        textFieldEstadio.setText("");
        textFieldAudiencia.setText("");
        textFieldLocal.setText("");
        textFieldVisit.setText("");
        textFieldGolesLocal.setText("");
        textFieldGolesVisitante.setText("");

    }

    private void desactivar_habilitar(boolean estado) {
        textFieldAudiencia.setEditable(estado);
        textFieldEstadio.setEditable(estado);
        textFieldGolesLocal.setEditable(estado);
        textFieldGolesVisitante.setEditable(estado);
        textFieldLocal.setEditable(estado);
        textFieldVisit.setEditable(estado);
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
