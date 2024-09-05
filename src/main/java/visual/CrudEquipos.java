package visual;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.Equipo;
import services.EquipoServices;
import services.ServicesLocator;
import utils.ConnectionManager;
import utils.Generic_Model;

public class CrudEquipos extends javax.swing.JDialog {

    private Generic_Model <Equipo> modelo = new Generic_Model<Equipo>();

    public CrudEquipos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        try {
            ConnectionManager.getConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        EquipoServices es = new EquipoServices();

        list = new JList<Equipo>();

        scrollPane.setViewportView(list);
        list.setFont(new Font("SansSerif", Font.PLAIN, 18));
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        list.setModel(modelo);

        list.addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                        int indice = list.getSelectedIndex();
                        btnEliminar.setEnabled(indice > -1);
				        desactivar_habilitar(indice <= -1);
                        if (indice > -1) {
                                Equipo c = modelo.getElementAt(indice);
  
                                 textFieldID.setText(String.valueOf(c.getIdEquipo()));
                                 textFieldNombre.setText(c.getNomEquipo());
                                 textFieldProvincia.setText(c.getProvincia());
                                 textFieldCampParticip.setText(String.valueOf(c.getCampParticipados()));
                                 textFieldCampGanados.setText(String.valueOf(c.getCampGanados()));
                                 textFieldMascota.setText(c.getMascota());
                                 textFieldColor.setText(c.getColor());

                                btnNuevo.setEnabled(true);
                                btnEditar.setEnabled(true);

                        } else {
                                btnEditar.setEnabled(false);
                        }
                }
        });
        modelo.setList(ServicesLocator.getEquipoServices().obtenerEquipos());

         btnNuevo.setFont(new Font("SansSerif", Font.PLAIN, 18));
         btnEditar.setFont(new Font("SansSerif", Font.PLAIN, 18));
         btnEliminar.setFont(new Font("SansSerif", Font.PLAIN, 18));

         lblD.setHorizontalAlignment(SwingConstants.RIGHT);
         lblD.setFont(new Font("SansSerif", Font.PLAIN, 18));

         lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNombre.setFont(new Font("SansSerif", Font.PLAIN, 18));

         lblProvincia.setHorizontalAlignment(SwingConstants.RIGHT);
         lblProvincia.setFont(new Font("SansSerif", Font.PLAIN, 18));

         lblCampParticip.setHorizontalAlignment(SwingConstants.RIGHT);
         lblCampParticip.setFont(new Font("SansSerif", Font.PLAIN, 18));
         
         lblCampGanados.setHorizontalAlignment(SwingConstants.RIGHT);
         lblCampGanados.setFont(new Font("SansSerif", Font.PLAIN, 18));

         lblMascota.setHorizontalAlignment(SwingConstants.RIGHT);
         lblMascota.setFont(new Font("SansSerif", Font.PLAIN, 18));
 
         lblColor.setHorizontalAlignment(SwingConstants.RIGHT);
         lblColor.setFont(new Font("SansSerif", Font.PLAIN, 18));

         lblPuntos.setHorizontalAlignment(SwingConstants.RIGHT);
         lblPuntos.setFont(new Font("SansSerif", Font.PLAIN, 18));

        textFieldID.setFont(new Font("SansSerif", Font.PLAIN, 18));
        textFieldNombre.setFont(new Font("SansSerif", Font.PLAIN, 18));
        textFieldProvincia.setFont(new Font("SansSerif", Font.PLAIN, 18));

        btnGuardar.setFont(new Font("SansSerif", Font.PLAIN, 17));
        btnGuardar.setVisible(false);
        
        btnAgregar.setFont(new Font("SansSerif", Font.PLAIN, 17));
        btnAgregar.setVisible(false);

        btnCancelar.setVisible(false);
        btnCancelar.setFont(new Font("SansSerif", Font.PLAIN, 17));

        btnSalir.setFont(new Font("SansSerif", Font.PLAIN, 18));

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
        lblD = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        textFieldID = new javax.swing.JTextField();
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

        panel.setBackground(new java.awt.Color(101, 161, 101));
        panel.setBorder(new javax.swing.border.MatteBorder(null));

        lblD.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblD.setText("ID");

        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombre.setText("Nombre");

        textFieldID.setEditable(false);
        textFieldID.setFocusable(false);

        textFieldNombre.setEditable(false);

        textFieldProvincia.setEditable(false);
        textFieldProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldProvinciaActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        lblMascota.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMascota.setText("Mascota");

        lblCampGanados.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCampGanados.setText("CampGanados");

        lblCampParticip.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCampParticip.setText("CampParticip");

        lblProvincia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblProvincia.setText("Provincia");

        lblPuntos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPuntos.setText("Puntos");

        lblColor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblColor.setText("Color");

        textFieldCampGanados.setEditable(false);
        textFieldCampGanados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldCampGanadosActionPerformed(evt);
            }
        });

        textFieldCampParticip.setEditable(false);
        textFieldCampParticip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldCampParticipActionPerformed(evt);
            }
        });

        textFieldColor.setEditable(false);
        textFieldColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldColorActionPerformed(evt);
            }
        });

        textFieldMascota.setEditable(false);
        textFieldMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldMascotaActionPerformed(evt);
            }
        });

        textFieldPuntos.setEditable(false);
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
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblMascota, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblCampGanados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblCampParticip, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblPuntos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(lblColor, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(lblD, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(textFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textFieldNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                .addComponent(textFieldProvincia))
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(textFieldCampGanados, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addComponent(textFieldCampParticip, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(textFieldMascota, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldColor, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblD)
                    .addComponent(textFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAgregar)
                    .addComponent(btnGuardar))
                .addContainerGap())
        );

        list.setForeground(new java.awt.Color(0, 153, 153));
        scrollPane.setViewportView(list);

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

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
                .addGap(18, 18, 18)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalir))
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
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

        if (proceder){ 
           ServicesLocator.getEquipoServices().crearEquipo(nombre, provincia, campParticip, campGanados, mascota, color, puntos);

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
        Equipo x;

        String nombre = textFieldNombre.getText();  
        String provincia = textFieldProvincia.getText(); 
        int campParticip = Integer.parseInt(textFieldCampParticip.getText()); 
        int campGanados = Integer.parseInt(textFieldCampGanados.getText()); 
        String mascota = textFieldMascota.getText(); 
        String color = textFieldColor.getText(); 
        int puntos = Integer.parseInt(textFieldPuntos.getText()); 

        boolean proceder = true; // validarDatos(id, nombre, capacidad);

        if (proceder) {
           ServicesLocator.getEquipoServices().crearEquipo(nombre, provincia, campParticip, campGanados, mascota, color, puntos);

           x = new Equipo(ServicesLocator.getEquipoServices().obtenerEquipos().getLast().getIdEquipo(), nombre, provincia, campParticip, campGanados, mascota, color, puntos); 
           
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
                if (JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar este estadio?",
                                "Confirmar", 0) == 0) {
                        modelo.removeElement(list.getSelectedIndex());
                        
                        ServicesLocator.getEstadioServices().eliminarEstadio(Integer.parseInt(textFieldID.getText()));
                        
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
        lblD.setForeground(Color.BLACK);
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
        System.exit(0);
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
    private javax.swing.JLabel lblD;
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
    private javax.swing.JTextField textFieldID;
    private javax.swing.JTextField textFieldMascota;
    private javax.swing.JTextField textFieldNombre;
    private javax.swing.JTextField textFieldProvincia;
    private javax.swing.JTextField textFieldPuntos;
    // End of variables declaration//GEN-END:variables
    
    private void limpiar() {
			textFieldID.setText("");
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
