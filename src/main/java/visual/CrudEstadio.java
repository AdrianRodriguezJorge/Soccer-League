package visual;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.Estadio;
import services.EstadioServices;
import utils.ConnectionManager;

public class CrudEstadio extends javax.swing.JDialog {

    private Model_Estadio modelo = new Model_Estadio();

    public CrudEstadio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        ConnectionManager.initConnectionManager();
        EstadioServices es = new EstadioServices();

        list = new JList<Estadio>();

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
                                Estadio c = modelo.getEstadioAt(indice);

                                textFieldID.setText(c.getIdEstadio()+"");
                                textFieldNombre.setText(c.getNombreEstadio());
                                textFieldCapacidad.setText(c.getCapacidad()+"");

                                btnNuevo.setEnabled(true);
                                btnEditar.setEnabled(true);

                        } else {
                                btnEditar.setEnabled(false);
                        }
                }
        });
        modelo.setlstEstadios(EstadioServices.readEstadios());

        btnNuevo.setFont(new Font("SansSerif", Font.PLAIN, 18));
        btnEditar.setFont(new Font("SansSerif", Font.PLAIN, 18));
        btnEliminar.setFont(new Font("SansSerif", Font.PLAIN, 18));

        lblD.setHorizontalAlignment(SwingConstants.RIGHT);
        lblD.setFont(new Font("SansSerif", Font.PLAIN, 18));

        lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNombre.setFont(new Font("SansSerif", Font.PLAIN, 18));

        lblCapacidad.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCapacidad.setFont(new Font("SansSerif", Font.PLAIN, 18));

        textFieldID.setFont(new Font("SansSerif", Font.PLAIN, 18));
        textFieldNombre.setFont(new Font("SansSerif", Font.PLAIN, 18));
        textFieldCapacidad.setFont(new Font("SansSerif", Font.PLAIN, 18));

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
        lblCapacidad = new javax.swing.JLabel();
        textFieldID = new javax.swing.JTextField();
        textFieldNombre = new javax.swing.JTextField();
        textFieldCapacidad = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel.setBackground(new java.awt.Color(248, 180, 113));
        panel.setBorder(new javax.swing.border.MatteBorder(null));
        panel.setForeground(new java.awt.Color(0, 0, 0));

        lblD.setForeground(new java.awt.Color(0, 0, 0));
        lblD.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblD.setText("ID");

        lblNombre.setForeground(new java.awt.Color(0, 0, 0));
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombre.setText("Nombre");

        lblCapacidad.setForeground(new java.awt.Color(0, 0, 0));
        lblCapacidad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCapacidad.setText("Capacidad");

        textFieldID.setEditable(false);
        textFieldID.setFocusable(false);

        textFieldNombre.setEditable(false);

        textFieldCapacidad.setEditable(false);
        textFieldCapacidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldCapacidadActionPerformed(evt);
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

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(lblCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(textFieldCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblD, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelLayout.createSequentialGroup()
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
                .addGap(15, 15, 15)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblD)
                    .addComponent(textFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCapacidad)
                    .addComponent(textFieldCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
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
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(btnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 289, Short.MAX_VALUE)
                        .addComponent(btnSalir)))
                .addContainerGap())
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
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
        int capacidad = Integer.parseInt(textFieldCapacidad.getText());

        boolean proceder = true; // validarDatos(id, nombre, capacidad);

        if (proceder) {
            EstadioServices.createEstadio(nombre, capacidad); // guardar en la BD

            Estadio x = new Estadio(EstadioServices.readEstadios().getLast().getIdEstadio(), nombre, capacidad);
            modelo.addEstadio(x);

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
        Estadio x;

        int id = Integer.parseInt(textFieldID.getText());
        String nombre = textFieldNombre.getText();
        int capacidad = Integer.parseInt(textFieldCapacidad.getText());

        boolean proceder = true; // validarDatos(id, nombre, capacidad);

        if (proceder) {
            x = new Estadio (id, nombre, capacidad);

            EstadioServices.updateEstadio(Integer.parseInt(textFieldID.getText()), textFieldNombre.getText(), Integer.parseInt(textFieldCapacidad.getText())); // nuevo

            modelo.updateEstadio(indice, x);
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
                        modelo.removeEstadio(list.getSelectedIndex());
                        
                        EstadioServices.deleteEstadio(Integer.parseInt(textFieldID.getText()));
                        
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
        lblCapacidad.setForeground(Color.BLACK);
//				lblDatosErroneos.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        ConnectionManager.closeConnection();
        dispose();
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void textFieldCapacidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldCapacidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldCapacidadActionPerformed

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
    private javax.swing.JLabel lblD;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JList<Estadio> list;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextField textFieldCapacidad;
    private javax.swing.JTextField textFieldID;
    private javax.swing.JTextField textFieldNombre;
    // End of variables declaration//GEN-END:variables
    
    private void limpiar() {
		textFieldID.setText("");
		textFieldNombre.setText("");
		textFieldCapacidad.setText("");
	}

    private void desactivar_habilitar(boolean estado) {
		textFieldNombre.setEditable(estado);
		textFieldCapacidad.setEditable(estado);
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
