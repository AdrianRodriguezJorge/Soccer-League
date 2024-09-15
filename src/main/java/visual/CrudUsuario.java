package visual;

import java.awt.Color;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.Estadio;
import model.Rol;
import model.Usuario;
import services.ServicesLocator;
import utils.ConnectionManager;
import utils.Generic_Model;

public class CrudUsuario extends javax.swing.JDialog {

    private Generic_Model<Usuario> modelo = new Generic_Model<>();

    public CrudUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        changeStatus(false);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        lblDatosErroneos.setVisible(false);
        lblContraseña.setVisible(false);
        tfContraseña.setVisible(false);

        list.setModel(modelo);

        Principal.soloLetras(tfNombre);

        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int index = list.getSelectedIndex();
                btnEliminar.setEnabled(index > -1);
                changeStatus(index <= -1);
                if (index > -1) {
                    Usuario u = modelo.getElementAt(index);

                    tfNombre.setText(u.getNombreUsuario());
                    tfContraseña.setText(u.getContraseña());

                    comboBoxRol.setSelectedIndex(u.getRol().equals(Rol.gestor_liga.toString()) ? 0 : 1);

                    tfRol.setText(comboBoxRol.getSelectedItem().toString());

                    btnNuevo.setEnabled(true);
                    btnEditar.setEnabled(true);

                } else {
                    btnEditar.setEnabled(false);
                }
            }
        });

        try {
            modelo.setList(ServicesLocator.getUsuarioServices().getAllUsuarios());
        } catch (SQLException e1) {
            System.out.println(e1.getMessage());
        }

    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPanel = new javax.swing.JPanel();
        panel = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblRol = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        tfContraseña = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        lblDatosErroneos = new javax.swing.JLabel();
        lblContraseña = new javax.swing.JLabel();
        tfRol = new javax.swing.JTextField();
        comboBoxRol = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        lblNombre1 = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de estadios");

        contentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(59, 122, 26)));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombre.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombre.setText("Datos de Usuario");
        panel.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 150, -1));

        lblRol.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblRol.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRol.setText("Rol");
        panel.add(lblRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 87, -1));

        tfNombre.setEditable(false);
        tfNombre.setBackground(new java.awt.Color(255, 255, 255));
        tfNombre.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tfNombre.setBorder(null);
        panel.add(tfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 209, -1));

        tfContraseña.setEditable(false);
        tfContraseña.setBackground(new java.awt.Color(255, 255, 255));
        tfContraseña.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tfContraseña.setBorder(null);
        panel.add(tfContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 210, -1));

        btnCancelar.setBackground(new java.awt.Color(255, 51, 51));
        btnCancelar.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setAlignmentY(1.0F);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setMargin(new java.awt.Insets(2, 14, 4, 14));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panel.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, -1, -1));

        btnGuardar.setBackground(new java.awt.Color(59, 122, 26));
        btnGuardar.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.setAlignmentY(1.0F);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setMargin(new java.awt.Insets(2, 14, 4, 14));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        panel.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, -1, -1));

        btnAgregar.setBackground(new java.awt.Color(59, 122, 26));
        btnAgregar.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.setAlignmentY(1.0F);
        btnAgregar.setMargin(new java.awt.Insets(2, 14, 4, 14));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        panel.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, -1, -1));

        lblDatosErroneos.setFont(new java.awt.Font("SansSerif", 3, 16)); // NOI18N
        lblDatosErroneos.setForeground(new java.awt.Color(255, 51, 51));
        lblDatosErroneos.setText("Datos erroneos");
        panel.add(lblDatosErroneos, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 130, -1));

        lblContraseña.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblContraseña.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblContraseña.setText("Contraseña");
        panel.add(lblContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 87, -1));

        tfRol.setEditable(false);
        tfRol.setBackground(new java.awt.Color(255, 255, 255));
        tfRol.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tfRol.setBorder(null);
        panel.add(tfRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 210, 20));

        comboBoxRol.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        comboBoxRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gestor de liga", "Gestor de usuarios" }));
        comboBoxRol.setBorder(null);
        panel.add(comboBoxRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 230, -1));

        jSeparator1.setBackground(new java.awt.Color(51, 51, 51));
        panel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 210, -1));

        jSeparator2.setBackground(new java.awt.Color(51, 51, 51));
        panel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 210, -1));

        jSeparator3.setBackground(new java.awt.Color(51, 51, 51));
        panel.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 123, 210, 10));

        lblNombre1.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblNombre1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombre1.setText("Nombre");
        panel.add(lblNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 87, -1));

        contentPanel.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 380, 290));

        list.setBackground(new java.awt.Color(59, 122, 26));
        list.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        list.setForeground(new java.awt.Color(255, 255, 255));
        list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollPane.setViewportView(list);

        contentPanel.add(scrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 340, 285));

        btnNuevo.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(59, 122, 26));
        btnNuevo.setText("Nuevo");
        btnNuevo.setAlignmentY(1.0F);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.setDefaultCapable(false);
        btnNuevo.setMargin(new java.awt.Insets(2, 14, 4, 14));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        contentPanel.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        btnEditar.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(59, 122, 26));
        btnEditar.setText("Editar");
        btnEditar.setAlignmentY(1.0F);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.setDefaultCapable(false);
        btnEditar.setEnabled(false);
        btnEditar.setMargin(new java.awt.Insets(2, 14, 4, 14));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        contentPanel.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, -1, -1));

        btnEliminar.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(59, 122, 26));
        btnEliminar.setText("Eliminar");
        btnEliminar.setAlignmentY(1.0F);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setDefaultCapable(false);
        btnEliminar.setEnabled(false);
        btnEliminar.setMargin(new java.awt.Insets(2, 14, 4, 14));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        contentPanel.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, -1, -1));

        btnSalir.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 51, 51));
        btnSalir.setText("Salir");
        btnSalir.setAlignmentY(1.0F);
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setDefaultCapable(false);
        btnSalir.setMargin(new java.awt.Insets(2, 14, 4, 14));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        contentPanel.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 370, -1, -1));

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
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNuevoActionPerformed
        limpiar();
        changeStatus(true);
        btnGuardar.setVisible(false);
        tfNombre.requestFocusInWindow();
        lblContraseña.setVisible(true);
        tfContraseña.setVisible(true);
    }// GEN-LAST:event_btnNuevoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAgregarActionPerformed
        String nombre = tfNombre.getText();
        String pass = tfContraseña.getText();
        Rol rol = comboBoxRol.getSelectedIndex() == 0 ? Rol.gestor_liga : Rol.gestor_usuario;

        boolean val = validarDatos(nombre, pass);

        if (val) {
            try {
                Usuario x = new Usuario(nombre, pass, rol.toString());
                ServicesLocator.getUsuarioServices().crearUsuario(x);

                x.setId(ServicesLocator.getUsuarioServices().getAllUsuarios().getLast().getId());
                modelo.addElement(x);

                int lastIndex = list.getModel().getSize() - 1;
                list.setSelectedIndex(lastIndex);
                list.ensureIndexIsVisible(lastIndex);

                changeStatus(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
        String pass = tfContraseña.getText();
        Rol rol = comboBoxRol.getSelectedIndex() == 0 ? Rol.gestor_liga : Rol.gestor_usuario;

        boolean val = validarDatos(nombre, pass);

        if (val) {
            Usuario u = new Usuario(nombre, pass, rol.toString());
            u.setId(modelo.getElementAt(index).getId());

            try {
                ServicesLocator.getUsuarioServices().actualizarUsuario(u);

                modelo.updateElement(index, u);
                changeStatus(false);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }// GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEliminarActionPerformed
        int index = list.getSelectedIndex();
        if (index != -1) {
            if (JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar este usuario?",
                    "Confirmar", 0) == 0) {
                try {
                    ServicesLocator.getUsuarioServices().eliminarUsuario(modelo.getElementAt(index).getId());

                    modelo.removeElement(index);

                    limpiar();
                    changeStatus(false);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Tiene que existir al menos un Gestor de Usuarios.", "Aviso", 2);
                }
            }
        }
    }// GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCancelarActionPerformed
        changeStatus(false);
        lblDatosErroneos.setVisible(false);
        list.requestFocusInWindow();
        list.setSelectedIndex(0);
    }// GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSalirActionPerformed
        ConnectionManager.closeConnection();
        dispose();
    }// GEN-LAST:event_btnSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> comboBoxRol;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblDatosErroneos;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblRol;
    private javax.swing.JList<Estadio> list;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextField tfContraseña;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfRol;
    // End of variables declaration//GEN-END:variables

    private void limpiar() {
        tfNombre.setText("");
        tfContraseña.setText("");
    }

    public boolean validarDatos(String nombre, String pass) {
        boolean correcto = true;
        Usuario temp = new Usuario();

        try { // nombre
            temp.setNombreUsuario(nombre);
        } catch (IllegalArgumentException e) {
            correcto = false;
            lblDatosErroneos.setVisible(true);
            lblNombre.setForeground(Principal.errorColor);
        }

        try { // capacidad
            temp.setContraseña(pass);
        } catch (IllegalArgumentException e) {
            correcto = false;
            lblDatosErroneos.setVisible(true);
            lblContraseña.setForeground(Principal.errorColor);
        }

        if (correcto) {
            lblDatosErroneos.setVisible(false);
            changeStatus(true);
        }
        return correcto;
    }

    private void changeStatus(boolean status) {
        tfNombre.setEditable(status);
        tfRol.setEditable(status);
        tfContraseña.setEditable(status);
        lblContraseña.setVisible(false);
        tfContraseña.setVisible(false);

        btnEliminar.setEnabled(!status);
        btnNuevo.setEnabled(!status);
        btnEditar.setEnabled(!status);
        list.setEnabled(!status);
        btnSalir.setEnabled(!status);

        btnAgregar.setVisible(status);
        btnGuardar.setVisible(status);
        btnCancelar.setVisible(status);

        lblNombre.setForeground(Color.black);
        lblContraseña.setForeground(Color.black);

        tfRol.setVisible(!status);
        comboBoxRol.setVisible(status);
    }
}
