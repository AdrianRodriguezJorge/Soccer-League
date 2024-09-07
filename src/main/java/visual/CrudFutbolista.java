package visual;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Equipo;
import model.Futbolista;
import model.Partido;
import services.ServicesLocator;
import utils.ConnectionManager;
import utils.Generic_Model;

public class CrudFutbolista extends javax.swing.JDialog {

    private Generic_Model<Futbolista> modelo = new Generic_Model<>();

    public CrudFutbolista(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        list.setModel(modelo);

        for (String s : ServicesLocator.getEquipoServices().obtenerNombresEquipos()) {
            ComboBoxEquipo.addItem(s);
        }

        btnAgregar.setVisible(false);
        btnGuardar.setVisible(false);
        btnCancelar.setVisible(false);
        ComboBoxEquipo.setVisible(false);

        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int index = list.getSelectedIndex();
                btnEliminar.setEnabled(index > -1);
                desactivar_habilitar(index <= -1);
                if (index > -1) {
                    Futbolista f = modelo.getElementAt(index);

                    String nomEquipo = buscarNombrEquipo(f.getIdEquipo());

                    textFieldNombre.setText(f.getNombre());
                    textFieldNum.setText(f.getNumero() + "");
                    textFieldEquipo.setText(nomEquipo);
                    textFieldAñosEnE.setText(f.getAñosEnEquipo() + "");

                    btnNuevo.setEnabled(true);
                    btnEditar.setEnabled(true);

                } else {
                    btnEditar.setEnabled(false);
                }
            }

        });

        modelo.setList(ServicesLocator.getFutbolistaServices().obtenerFutbolistas());

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
        scrollPane = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jTabbedPane = new javax.swing.JTabbedPane();
        panelFutbolista = new javax.swing.JPanel();
        lblAudiencia = new javax.swing.JLabel();
        textFieldNum = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        lblEquipo = new javax.swing.JLabel();
        lblGolesLocal = new javax.swing.JLabel();
        textFieldAñosEnE = new javax.swing.JTextField();
        ComboBoxEquipo = new javax.swing.JComboBox<>();
        textFieldNombre = new javax.swing.JTextField();
        textFieldEquipo = new javax.swing.JTextField();
        panelFutbolista2 = new javax.swing.JPanel();
        lblAudiencia2 = new javax.swing.JLabel();
        textFieldNum2 = new javax.swing.JTextField();
        btnCancelar2 = new javax.swing.JButton();
        btnGuardar2 = new javax.swing.JButton();
        btnAgregar2 = new javax.swing.JButton();
        lblNombre2 = new javax.swing.JLabel();
        lblEquipo2 = new javax.swing.JLabel();
        lblGolesTipo = new javax.swing.JLabel();
        textFieldAñosEnE2 = new javax.swing.JTextField();
        ComboBoxTipo = new javax.swing.JComboBox<>();
        textFieldNombre2 = new javax.swing.JTextField();
        textFieldEquipo2 = new javax.swing.JTextField();
        lblGolesLocal4 = new javax.swing.JLabel();
        ComboBoxEquipo4 = new javax.swing.JComboBox<>();
        panelFutbolista3 = new javax.swing.JPanel();
        lblAudiencia3 = new javax.swing.JLabel();
        textFieldNum3 = new javax.swing.JTextField();
        lblNombre3 = new javax.swing.JLabel();
        lblEquipo3 = new javax.swing.JLabel();
        lblGolesLocal3 = new javax.swing.JLabel();
        textFieldAñosEnE3 = new javax.swing.JTextField();
        ComboBoxEquipo3 = new javax.swing.JComboBox<>();
        textFieldNombre3 = new javax.swing.JTextField();
        textFieldEquipo3 = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de partidos");

        contentPanel.setForeground(new java.awt.Color(143, 182, 155));
        contentPanel.setToolTipText("");

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

        jTabbedPane.setName(""); // NOI18N

        panelFutbolista.setBackground(new java.awt.Color(143, 182, 155));
        panelFutbolista.setBorder(new javax.swing.border.MatteBorder(null));
        panelFutbolista.setForeground(new java.awt.Color(0, 0, 0));
        panelFutbolista.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAudiencia.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lblAudiencia.setForeground(new java.awt.Color(0, 0, 0));
        lblAudiencia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAudiencia.setText("Número");
        panelFutbolista.add(lblAudiencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 85, 165, -1));

        textFieldNum.setEditable(false);
        textFieldNum.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        textFieldNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNumActionPerformed(evt);
            }
        });
        panelFutbolista.add(textFieldNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 85, 50, -1));

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panelFutbolista.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, -1, -1));

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 0, 0));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        panelFutbolista.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));

        btnAgregar.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregar.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        panelFutbolista.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, -1, -1));

        lblNombre.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(0, 0, 0));
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombre.setText("Nombre");
        panelFutbolista.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 51, 165, -1));

        lblEquipo.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lblEquipo.setForeground(new java.awt.Color(0, 0, 0));
        lblEquipo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEquipo.setText("Equipo");
        panelFutbolista.add(lblEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 165, -1));

        lblGolesLocal.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lblGolesLocal.setForeground(new java.awt.Color(0, 0, 0));
        lblGolesLocal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGolesLocal.setText("Años en el equipo");
        panelFutbolista.add(lblGolesLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 165, -1));

        textFieldAñosEnE.setEditable(false);
        textFieldAñosEnE.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        textFieldAñosEnE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldAñosEnEActionPerformed(evt);
            }
        });
        panelFutbolista.add(textFieldAñosEnE, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 50, -1));

        ComboBoxEquipo.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        panelFutbolista.add(ComboBoxEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 16, -1, -1));

        textFieldNombre.setEditable(false);
        textFieldNombre.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        textFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNombreActionPerformed(evt);
            }
        });
        panelFutbolista.add(textFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 176, -1));

        textFieldEquipo.setEditable(false);
        textFieldEquipo.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        textFieldEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldEquipoActionPerformed(evt);
            }
        });
        panelFutbolista.add(textFieldEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 16, 176, -1));

        jTabbedPane.addTab("Futbolista", panelFutbolista);

        panelFutbolista2.setBackground(new java.awt.Color(143, 182, 155));
        panelFutbolista2.setBorder(new javax.swing.border.MatteBorder(null));
        panelFutbolista2.setForeground(new java.awt.Color(0, 0, 0));
        panelFutbolista2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAudiencia2.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lblAudiencia2.setForeground(new java.awt.Color(0, 0, 0));
        lblAudiencia2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAudiencia2.setText("Número");
        panelFutbolista2.add(lblAudiencia2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 85, 165, -1));

        textFieldNum2.setEditable(false);
        textFieldNum2.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        textFieldNum2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNum2ActionPerformed(evt);
            }
        });
        panelFutbolista2.add(textFieldNum2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 85, 50, -1));

        btnCancelar2.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar2.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        btnCancelar2.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelar2.setText("Cancelar");
        btnCancelar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar2ActionPerformed(evt);
            }
        });
        panelFutbolista2.add(btnCancelar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, -1, -1));

        btnGuardar2.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar2.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        btnGuardar2.setForeground(new java.awt.Color(0, 0, 0));
        btnGuardar2.setText("Guardar");
        btnGuardar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar2ActionPerformed(evt);
            }
        });
        panelFutbolista2.add(btnGuardar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));

        btnAgregar2.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregar2.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        btnAgregar2.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregar2.setText("Agregar");
        btnAgregar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar2ActionPerformed(evt);
            }
        });
        panelFutbolista2.add(btnAgregar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, -1, -1));

        lblNombre2.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lblNombre2.setForeground(new java.awt.Color(0, 0, 0));
        lblNombre2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombre2.setText("Nombre");
        panelFutbolista2.add(lblNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 51, 165, -1));

        lblEquipo2.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lblEquipo2.setForeground(new java.awt.Color(0, 0, 0));
        lblEquipo2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEquipo2.setText("Equipo");
        panelFutbolista2.add(lblEquipo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 165, -1));

        lblGolesTipo.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lblGolesTipo.setForeground(new java.awt.Color(0, 0, 0));
        lblGolesTipo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGolesTipo.setText("Tipo");
        panelFutbolista2.add(lblGolesTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 165, -1));

        textFieldAñosEnE2.setEditable(false);
        textFieldAñosEnE2.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        textFieldAñosEnE2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldAñosEnE2ActionPerformed(evt);
            }
        });
        panelFutbolista2.add(textFieldAñosEnE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 50, -1));

        ComboBoxTipo.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        panelFutbolista2.add(ComboBoxTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, -1, -1));

        textFieldNombre2.setEditable(false);
        textFieldNombre2.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        textFieldNombre2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNombre2ActionPerformed(evt);
            }
        });
        panelFutbolista2.add(textFieldNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 176, -1));

        textFieldEquipo2.setEditable(false);
        textFieldEquipo2.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        textFieldEquipo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldEquipo2ActionPerformed(evt);
            }
        });
        panelFutbolista2.add(textFieldEquipo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 16, 176, -1));

        lblGolesLocal4.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lblGolesLocal4.setForeground(new java.awt.Color(0, 0, 0));
        lblGolesLocal4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGolesLocal4.setText("Años en el equipo");
        panelFutbolista2.add(lblGolesLocal4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 165, -1));

        ComboBoxEquipo4.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        panelFutbolista2.add(ComboBoxEquipo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 16, -1, -1));

        jTabbedPane.addTab("Entrenador", panelFutbolista2);

        panelFutbolista3.setBackground(new java.awt.Color(143, 182, 155));
        panelFutbolista3.setBorder(new javax.swing.border.MatteBorder(null));
        panelFutbolista3.setForeground(new java.awt.Color(0, 0, 0));
        panelFutbolista3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAudiencia3.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lblAudiencia3.setForeground(new java.awt.Color(0, 0, 0));
        lblAudiencia3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAudiencia3.setText("Número");
        panelFutbolista3.add(lblAudiencia3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 85, 165, -1));

        textFieldNum3.setEditable(false);
        textFieldNum3.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        textFieldNum3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNum3ActionPerformed(evt);
            }
        });
        panelFutbolista3.add(textFieldNum3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 85, 50, -1));

        lblNombre3.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lblNombre3.setForeground(new java.awt.Color(0, 0, 0));
        lblNombre3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombre3.setText("Nombre");
        panelFutbolista3.add(lblNombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 51, 165, -1));

        lblEquipo3.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lblEquipo3.setForeground(new java.awt.Color(0, 0, 0));
        lblEquipo3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEquipo3.setText("Equipo");
        panelFutbolista3.add(lblEquipo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 165, -1));

        lblGolesLocal3.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lblGolesLocal3.setForeground(new java.awt.Color(0, 0, 0));
        lblGolesLocal3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGolesLocal3.setText("Años en el equipo");
        panelFutbolista3.add(lblGolesLocal3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 165, -1));

        textFieldAñosEnE3.setEditable(false);
        textFieldAñosEnE3.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        textFieldAñosEnE3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldAñosEnE3ActionPerformed(evt);
            }
        });
        panelFutbolista3.add(textFieldAñosEnE3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 50, -1));

        ComboBoxEquipo3.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        panelFutbolista3.add(ComboBoxEquipo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 16, -1, -1));

        textFieldNombre3.setEditable(false);
        textFieldNombre3.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        textFieldNombre3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNombre3ActionPerformed(evt);
            }
        });
        panelFutbolista3.add(textFieldNombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 176, -1));

        textFieldEquipo3.setEditable(false);
        textFieldEquipo3.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        textFieldEquipo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldEquipo3ActionPerformed(evt);
            }
        });
        panelFutbolista3.add(textFieldEquipo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 16, 176, -1));

        jTabbedPane.addTab("Jugador", panelFutbolista3);

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
                .addGap(7, 7, 7)
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(21, 21, 21))
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 436, Short.MAX_VALUE))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar)
                    .addComponent(btnNuevo)
                    .addComponent(btnSalir))
                .addContainerGap())
        );

        jTabbedPane.getAccessibleContext().setAccessibleName("");

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

    private void textFieldEquipo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldEquipo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldEquipo2ActionPerformed

    private void textFieldNombre2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNombre2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNombre2ActionPerformed

    private void textFieldAñosEnE2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldAñosEnE2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldAñosEnE2ActionPerformed

    private void btnAgregar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregar2ActionPerformed

    private void btnGuardar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardar2ActionPerformed

    private void btnCancelar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelar2ActionPerformed

    private void textFieldNum2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNum2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNum2ActionPerformed

    private void textFieldEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldEquipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldEquipoActionPerformed

    private void textFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNombreActionPerformed

    private void textFieldAñosEnEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldAñosEnEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldAñosEnEActionPerformed

    private void textFieldNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNumActionPerformed

    private void textFieldNum3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNum3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNum3ActionPerformed

    private void textFieldAñosEnE3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldAñosEnE3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldAñosEnE3ActionPerformed

    private void textFieldNombre3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNombre3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNombre3ActionPerformed

    private void textFieldEquipo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldEquipo3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldEquipo3ActionPerformed

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
        btnEliminar.setEnabled(false);
        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnGuardar.setVisible(false);
        btnCancelar.setVisible(true);

        textFieldNombre.setVisible(false);
        textFieldEquipo.setVisible(false);

        ComboBoxEquipo.setVisible(true);
        ComboBoxEquipo.setLocation(textFieldEquipo.getLocation());

    }// GEN-LAST:event_btnNuevoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAgregarActionPerformed

        boolean proceder = true; // validarDatos(id, nombre, capacidad);

        if (proceder) {
            // guardar en la BD
            Futbolista f = new Futbolista();

            // codigo aqui

            ServicesLocator.getFutbolistaServices().crearFutbolista(f);
            modelo.addElement(f);

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

            ComboBoxEquipo.setVisible(false);
        }
    }// GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEditarActionPerformed
        desactivar_habilitar(list.getSelectedIndex() > -1);
        list.setEnabled(false);
        textFieldNum.requestFocusInWindow();
        btnEliminar.setEnabled(false);
        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnGuardar.setVisible(true);
        btnAgregar.setVisible(false);
        btnCancelar.setVisible(true);

        textFieldNombre.setVisible(false);
        textFieldEquipo.setVisible(false);
        
        ComboBoxEquipo.setVisible(true);
        ComboBoxEquipo.setLocation(textFieldEquipo.getLocation());

    }// GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnGuardarActionPerformed
        int index = list.getSelectedIndex();

        boolean proceder = true; // validarDatos(id, nombre, capacidad);

        if (proceder) {
            Futbolista f = new Futbolista();


            // p.setIdPartido(modelo.getElementAt(index).getIdPartido());

            ServicesLocator.getFutbolistaServices().actualizarFutbolista(f);

            modelo.updateElement(index, f);

            desactivar_habilitar(false);
            list.setEnabled(true);
            btnEliminar.setEnabled(true);
            btnEditar.setEnabled(true);
            btnNuevo.setEnabled(true);

            btnGuardar.setVisible(false);
            btnCancelar.setVisible(false);

            
            ComboBoxEquipo.setVisible(false);
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
        lblNombre.setForeground(Color.BLACK);
        lblGolesLocal.setForeground(Color.BLACK);
        lblEquipo.setForeground(Color.BLACK);

        ComboBoxEquipo.setVisible(false);

        textFieldNombre.setVisible(true);
        textFieldEquipo.setVisible(true);

        // lblDatosErroneos.setVisible(false);
    }// GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSalirActionPerformed
        ConnectionManager.closeConnection();
        dispose();
    }// GEN-LAST:event_btnSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxEquipo;
    private javax.swing.JComboBox<String> ComboBoxEquipo3;
    private javax.swing.JComboBox<String> ComboBoxEquipo4;
    private javax.swing.JComboBox<String> ComboBoxTipo;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregar2;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelar2;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardar2;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JLabel lblAudiencia;
    private javax.swing.JLabel lblAudiencia2;
    private javax.swing.JLabel lblAudiencia3;
    private javax.swing.JLabel lblEquipo;
    private javax.swing.JLabel lblEquipo2;
    private javax.swing.JLabel lblEquipo3;
    private javax.swing.JLabel lblGolesLocal;
    private javax.swing.JLabel lblGolesLocal3;
    private javax.swing.JLabel lblGolesLocal4;
    private javax.swing.JLabel lblGolesTipo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblNombre3;
    private javax.swing.JList<Partido> list;
    private javax.swing.JPanel panelFutbolista;
    private javax.swing.JPanel panelFutbolista2;
    private javax.swing.JPanel panelFutbolista3;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextField textFieldAñosEnE;
    private javax.swing.JTextField textFieldAñosEnE2;
    private javax.swing.JTextField textFieldAñosEnE3;
    private javax.swing.JTextField textFieldEquipo;
    private javax.swing.JTextField textFieldEquipo2;
    private javax.swing.JTextField textFieldEquipo3;
    private javax.swing.JTextField textFieldNombre;
    private javax.swing.JTextField textFieldNombre2;
    private javax.swing.JTextField textFieldNombre3;
    private javax.swing.JTextField textFieldNum;
    private javax.swing.JTextField textFieldNum2;
    private javax.swing.JTextField textFieldNum3;
    // End of variables declaration//GEN-END:variables

    private void limpiar() {
        textFieldNombre.setText("");
        textFieldNum.setText("");
        textFieldEquipo.setText("");
        textFieldAñosEnE.setText("");

    }

    private void desactivar_habilitar(boolean estado) {
        textFieldNum.setEditable(estado);
        textFieldNombre.setEditable(estado);
        textFieldAñosEnE.setEditable(estado);
        textFieldEquipo.setEditable(estado);
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
