// package visual;

// import java.awt.Color;
// import java.awt.Font;
// import javax.swing.*;
// import javax.swing.event.ListSelectionEvent;
// import javax.swing.event.ListSelectionListener;
// import model.Equipo;
// import model.Equipo;
// import services.EquipoServices;
// import services.EquipoServices;
// import utils.ConnectionManager;

// public class CrudEquipo extends javax.swing.JDialog {

//     private Model_Equipo modelo = new Model_Equipo();

//     public CrudEquipo(java.awt.Frame parent, boolean modal) {
//         super(parent, modal);
//         initComponents();

//         ConnectionManager.getConnection();
//         EquipoServices es = new EquipoServices();

//         list = new JList<Equipo>();

//         scrollPane.setViewportView(list);
//         list.setFont(new Font("SansSerif", Font.PLAIN, 18));
//         list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

//         list.setModel(modelo);

//         list.addListSelectionListener(new ListSelectionListener() {
//             public void valueChanged(ListSelectionEvent e) {
//                 int indice = list.getSelectedIndex();
//                 btnEliminar.setEnabled(indice > -1);
//                 desactivar_habilitar(indice <= -1);
//                 if (indice > -1) {
//                     Equipo c = modelo.getEquipoAt(indice);

//                     textFieldID.setText(c.getIdEquipo() + "");
//                     textFieldNombre.setText(c.getNomEquipo());
//                     textFieldCiudad.setText(c.getCiudad());
//                     textFieldAnioFundacion.setText(c.get() + "");

//                     btnNuevo.setEnabled(true);
//                     btnEditar.setEnabled(true);

//                 } else {
//                     btnEditar.setEnabled(false);
//                 }
//             }
//         });

//         modelo.setlstEquipos(EquipoServices.readEquipos());

//         btnNuevo.setFont(new Font("SansSerif", Font.PLAIN, 18));
//         btnEditar.setFont(new Font("SansSerif", Font.PLAIN, 18));
//         btnEliminar.setFont(new Font("SansSerif", Font.PLAIN, 18));

//         lblID.setHorizontalAlignment(SwingConstants.RIGHT);
//         lblID.setFont(new Font("SansSerif", Font.PLAIN, 18));

//         lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
//         lblNombre.setFont(new Font("SansSerif", Font.PLAIN, 18));

//         lblCiudad.setHorizontalAlignment(SwingConstants.RIGHT);
//         lblCiudad.setFont(new Font("SansSerif", Font.PLAIN, 18));

//         lblAnioFundacion.setHorizontalAlignment(SwingConstants.RIGHT);
//         lblAnioFundacion.setFont(new Font("SansSerif", Font.PLAIN, 18));

//         textFieldID.setFont(new Font("SansSerif", Font.PLAIN, 18));
//         textFieldNombre.setFont(new Font("SansSerif", Font.PLAIN, 18));
//         textFieldCiudad.setFont(new Font("SansSerif", Font.PLAIN, 18));
//         textFieldAnioFundacion.setFont(new Font("SansSerif", Font.PLAIN, 18));

//         btnGuardar.setFont(new Font("SansSerif", Font.PLAIN, 17));
//         btnGuardar.setVisible(false);
        
//         btnAgregar.setFont(new Font("SansSerif", Font.PLAIN, 17));
//         btnAgregar.setVisible(false);

//         btnCancelar.setVisible(false);
//         btnCancelar.setFont(new Font("SansSerif", Font.PLAIN, 17));

//         btnSalir.setFont(new Font("SansSerif", Font.PLAIN, 18));
//     }

//     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
//     private void initComponents() {

//         contentPanel = new javax.swing.JPanel();
//         panel = new javax.swing.JPanel();
//         lblID = new javax.swing.JLabel();
//         lblNombre = new javax.swing.JLabel();
//         lblCiudad = new javax.swing.JLabel();
//         lblAnioFundacion = new javax.swing.JLabel();
//         textFieldID = new javax.swing.JTextField();
//         textFieldNombre = new javax.swing.JTextField();
//         textFieldCiudad = new javax.swing.JTextField();
//         textFieldAnioFundacion = new javax.swing.JTextField();
//         btnCancelar = new javax.swing.JButton();
//         btnGuardar = new javax.swing.JButton();
//         btnAgregar = new javax.swing.JButton();
//         scrollPane = new javax.swing.JScrollPane();
//         list = new javax.swing.JList<>();
//         btnNuevo = new javax.swing.JButton();
//         btnEditar = new javax.swing.JButton();
//         btnEliminar = new javax.swing.JButton();
//         btnSalir = new javax.swing.JButton();
//         btnReporte = new javax.swing.JButton();

//         setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

//         panel.setBackground(new java.awt.Color(101, 161, 101));
//         panel.setBorder(new javax.swing.border.MatteBorder(null));
//         panel.setForeground(new java.awt.Color(0, 0, 0));

//         lblID.setForeground(new java.awt.Color(0, 0, 0));
//         lblID.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
//         lblID.setText("ID");

//         lblNombre.setForeground(new java.awt.Color(0, 0, 0));
//         lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
//         lblNombre.setText("Nombre");

//         lblCiudad.setForeground(new java.awt.Color(0, 0, 0));
//         lblCiudad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
//         lblCiudad.setText("Ciudad");

//         lblAnioFundacion.setForeground(new java.awt.Color(0, 0, 0));
//         lblAnioFundacion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
//         lblAnioFundacion.setText("Año Fundación");

//         textFieldID.setEditable(false);
//         textFieldID.setFocusable(false);

//         textFieldNombre.setEditable(false);

//         textFieldCiudad.setEditable(false);
//         textFieldAnioFundacion.setEditable(false);
//         textFieldAnioFundacion.addActionListener(new java.awt.event.ActionListener() {
//             public void actionPerformed(java.awt.event.ActionEvent evt) {
//                 textFieldAnioFundacionActionPerformed(evt);
//             }
//         });

//         btnCancelar.setText("Cancelar");
//         btnCancelar.addActionListener(new java.awt.event.ActionListener() {
//             public void actionPerformed(java.awt.event.ActionEvent evt) {
//                 btnCancelarActionPerformed(evt);
//             }
//         });

//         btnGuardar.setText("Guardar");
//         btnGuardar.addActionListener(new java.awt.event.ActionListener() {
//             public void actionPerformed(java.awt.event.ActionEvent evt) {
//                 btnGuardarActionPerformed(evt);
//             }
//         });

//         btnAgregar.setText("Agregar");
//         btnAgregar.addActionListener(new java.awt.event.ActionListener() {
//             public void actionPerformed(java.awt.event.ActionEvent evt) {
//                 btnAgregarActionPerformed(evt);
//             }
//         });

//         javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
//         panel.setLayout(panelLayout);
//         panelLayout.setHorizontalGroup(
//             panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGroup(panelLayout.createSequentialGroup()
//                 .addContainerGap()
//                 .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                     .addGroup(panelLayout.createSequentialGroup()
//                         .addComponent(lblAnioFundacion, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
//                         .addGap(24, 24, 24)
//                         .addComponent(textFieldAnioFundacion, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
//                     .addGroup(panelLayout.createSequentialGroup()
//                         .addGap(8, 8, 8)
//                         .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
//                             .addComponent(lblCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
//                             .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
//                             .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
//                         .addGap(24, 24, 24)
//                         .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                             .addComponent(textFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
//                             .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
//                             .addComponent(textFieldCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
//                     .addGroup(panelLayout.createSequentialGroup()
//                         .addComponent(btnGuardar)
//                         .addGap(18, 18, 18)
//                         .addComponent(btnAgregar)
//                         .addGap(18, 18, 18)
//                         .addComponent(btnCancelar)))
//                 .addContainerGap(15, Short.MAX_VALUE))
//         );
//         panelLayout.setVerticalGroup(
//             panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGroup(panelLayout.createSequentialGroup()
//                 .addGap(15, 15, 15)
//                 .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                     .addComponent(lblID)
//                     .addComponent(textFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                 .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                     .addComponent(lblNombre)
//                     .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                 .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                     .addComponent(lblCapacidad)
//                     .addComponent(textFieldCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
//                 .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                     .addComponent(btnCancelar)
//                     .addComponent(btnAgregar)
//                     .addComponent(btnGuardar))
//                 .addContainerGap())
//         );

//         list.setForeground(new java.awt.Color(0, 153, 153));
//         scrollPane.setViewportView(list);

//         btnNuevo.setText("Nuevo");
//         btnNuevo.addActionListener(new java.awt.event.ActionListener() {
//             public void actionPerformed(java.awt.event.ActionEvent evt) {
//                 btnNuevoActionPerformed(evt);
//             }
//         });

//         btnEditar.setText("Editar");
//         btnEditar.setEnabled(false);
//         btnEditar.addActionListener(new java.awt.event.ActionListener() {
//             public void actionPerformed(java.awt.event.ActionEvent evt) {
//                 btnEditarActionPerformed(evt);
//             }
//         });

//         btnEliminar.setText("Eliminar");
//         btnEliminar.setEnabled(false);
//         btnEliminar.addActionListener(new java.awt.event.ActionListener() {
//             public void actionPerformed(java.awt.event.ActionEvent evt) {
//                 btnEliminarActionPerformed(evt);
//             }
//         });

//         btnSalir.setText("Salir");
//         btnSalir.addActionListener(new java.awt.event.ActionListener() {
//             public void actionPerformed(java.awt.event.ActionEvent evt) {
//                 btnSalirActionPerformed(evt);
//             }
//         });

//         btnReporte.setText("Reporte");
//         btnReporte.addActionListener(new java.awt.event.ActionListener() {
//             public void actionPerformed(java.awt.event.ActionEvent evt) {
//                 btnReporteActionPerformed(evt);
//             }
//         });

//         javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
//         contentPanel.setLayout(contentPanelLayout);
//         contentPanelLayout.setHorizontalGroup(
//             contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGroup(contentPanelLayout.createSequentialGroup()
//                 .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                     .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
//                     .addGroup(contentPanelLayout.createSequentialGroup()
//                         .addGap(7, 7, 7)
//                         .addComponent(btnNuevo)
//                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                         .addComponent(btnEliminar)
//                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                         .addComponent(btnEditar)))
//                 .addGap(18, 18, 18)
//                 .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                     .addGroup(contentPanelLayout.createSequentialGroup()
//                         .addComponent(btnReporte)
//                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                         .addComponent(btnSalir))
//                     .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//                 .addContainerGap())
//         );
//         contentPanelLayout.setVerticalGroup(
//             contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGroup(contentPanelLayout.createSequentialGroup()
//                 .addContainerGap()
//                 .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                     .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
//                     .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
//                 .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                     .addComponent(btnSalir)
//                     .addComponent(btnEditar)
//                     .addComponent(btnEliminar)
//                     .addComponent(btnNuevo)
//                     .addComponent(btnReporte))
//                 .addContainerGap())
//         );

//         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//         getContentPane().setLayout(layout);
//         layout.setHorizontalGroup(
//             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
//                 .addContainerGap()
//                 .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                 .addContainerGap())
//         );
//         layout.setVerticalGroup(
//             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGroup(layout.createSequentialGroup()
//                 .addContainerGap()
//                 .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                 .addContainerGap())
//         );

//         pack();
//     }// </editor-fold>//GEN-END:initComponents
//     private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
//         limpiar();
//         btnAgregar.setVisible(true);
//         desactivar_habilitar(true);
//         list.setEnabled(false);
//         textFieldNombre.requestFocusInWindow();
//         btnEliminar.setEnabled(false);
//         btnNuevo.setEnabled(false);
//         btnEditar.setEnabled(false);
//         btnGuardar.setVisible(false);
//         btnCancelar.setVisible(true);
//     }//GEN-LAST:event_btnNuevoActionPerformed

//     private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
//         String nombre = textFieldNombre.getText();
//         int capacidad = Integer.parseInt(textFieldCapacidad.getText());

//         boolean proceder = true; // validarDatos(id, nombre, capacidad);

//         if (proceder) {
//             EquipoServices.agregarEquipo(nombre, capacidad); // guardar en la BD

//             Equipo x = new Equipo(EquipoServices.obtenerEquipos().getLast().getIdEquipo(), nombre, capacidad);
//             modelo.addEquipo(x);

//             int lastIndex = list.getModel().getSize() - 1;
//             list.setSelectedIndex(lastIndex);
//             list.ensureIndexIsVisible(lastIndex);

//             desactivar_habilitar(false);
//             list.setEnabled(true);
//             btnEliminar.setEnabled(true);
//             btnEditar.setEnabled(true);
//             btnNuevo.setEnabled(true);

//             btnAgregar.setVisible(false);
//             btnCancelar.setVisible(false);
//         }
//     }//GEN-LAST:event_btnAgregarActionPerformed

//     private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
//         desactivar_habilitar(list.getSelectedIndex() > -1);
//         list.setEnabled(false);
//         textFieldNombre.requestFocusInWindow();
//         btnEliminar.setEnabled(false);
//         btnNuevo.setEnabled(false);
//         btnEditar.setEnabled(false);
//         btnGuardar.setVisible(true);
//         btnAgregar.setVisible(false);
//         btnCancelar.setVisible(true);
//     }//GEN-LAST:event_btnEditarActionPerformed

//     private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
//         int indice = list.getSelectedIndex();
//         Equipo x;

//         int id = Integer.parseInt(textFieldID.getText());
//         String nombre = textFieldNombre.getText();
//         int capacidad = Integer.parseInt(textFieldCapacidad.getText());

//         boolean proceder = true; // validarDatos(id, nombre, capacidad);

//         if (proceder) {
//             x = new Equipo (id, nombre, capacidad);

//             EquipoServices.actualizarEquipo(Integer.parseInt(textFieldID.getText()), textFieldNombre.getText(), Integer.parseInt(textFieldCapacidad.getText())); // nuevo

//             modelo.actualizarEquipo(indice, x);
//             desactivar_habilitar(false);
//             list.setEnabled(true);
//             btnEliminar.setEnabled(true);
//             btnEditar.setEnabled(true);
//             btnNuevo.setEnabled(true);

//             btnGuardar.setVisible(false);
//             btnCancelar.setVisible(false);
//         }
//     }//GEN-LAST:event_btnGuardarActionPerformed

//     private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
//         int indice = list.getSelectedIndex();
//         if (indice != -1) {
//                 if (JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar este estadio?",
//                                 "Confirmar", 0) == 0) {
//                         modelo.removeEquipo(list.getSelectedIndex());
                        
//                         EquipoServices.eliminarEquipo(Integer.parseInt(textFieldID.getText()));
                        
//                         limpiar();
//                         desactivar_habilitar(false);
//                 }
//         }
//     }//GEN-LAST:event_btnEliminarActionPerformed

//     private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
//         desactivar_habilitar(false);
//         list.setEnabled(true);
//         btnEliminar.setEnabled(true);
//         btnEditar.setEnabled(true);
//         btnNuevo.setEnabled(true);
//         btnAgregar.setVisible(false);
//         btnGuardar.setVisible(false);
//         btnCancelar.setVisible(false);
//         lblD.setForeground(Color.BLACK);
//         lblNombre.setForeground(Color.BLACK);
//         lblCapacidad.setForeground(Color.BLACK);
// //				lblDatosErroneos.setVisible(false);
//     }//GEN-LAST:event_btnCancelarActionPerformed

//     private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
//         ConnectionManager.closeConnection();
//         dispose();
//         System.exit(0);
//     }//GEN-LAST:event_btnSalirActionPerformed

//     private void textFieldCapacidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldCapacidadActionPerformed
//         // TODO add your handling code here:
//     }//GEN-LAST:event_textFieldCapacidadActionPerformed

//     private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
//         EquipoServices.generarReporteEquipo();
//     }//GEN-LAST:event_btnReporteActionPerformed

//     // Variables declaration - do not modify//GEN-BEGIN:variables
//     private javax.swing.JButton btnAgregar;
//     private javax.swing.JButton btnCancelar;
//     private javax.swing.JButton btnEditar;
//     private javax.swing.JButton btnEliminar;
//     private javax.swing.JButton btnGuardar;
//     private javax.swing.JButton btnNuevo;
//     private javax.swing.JButton btnReporte;
//     private javax.swing.JButton btnSalir;
//     private javax.swing.JPanel contentPanel;
//     private javax.swing.JLabel lblD;
//     private javax.swing.JLabel lblNombre;
//     private javax.swing.JLabel lblCiudad;
//     private javax.swing.JLabel lblAnioFundacion;
//     private JList<Equipo> list;
//     private javax.swing.JPanel panel;
//     private javax.swing.JScrollPane scrollPane;
//     private javax.swing.JTextField textFieldID;
//     private javax.swing.JTextField textFieldNombre;
//     private javax.swing.JTextField textFieldCiudad;
//     private javax.swing.JTextField textFieldAnioFundacion;
//     // End of variables declaration//GEN-END:variables
    
//     private void limpiar() {
// 		textFieldID.setText("");
// 		textFieldNombre.setText("");
// 		textFieldCiudad.setText("");
//           textFieldAnioFundacion.setText("");
// 	}

//     private void desactivar_habilitar(boolean estado) {
// 		textFieldNombre.setEditable(estado);
// 		textFieldCiudad.setEditable(estado);
//           textFieldAnioFundacion.setEditable(estado);
// 	}
// }
