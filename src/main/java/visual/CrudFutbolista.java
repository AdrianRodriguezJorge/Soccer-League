package visual;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Defensa;
import model.Delantero;
import model.Entrenador;
import model.Equipo;
import model.Futbolista;
import model.Jugador;
import model.Mediocampista;
import model.Partido;
import model.Portero;
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

        Principal.soloLetras(tfNombre);
        Principal.soloNum(tfNum);
        Principal.soloNum(tfAñosEnEq);
        Principal.soloNum(tfExp);
        Principal.soloNum(tfPartJugados);
        Principal.soloNum(tfCantGoles);
        Principal.soloFloat(tfPromGoles);
        Principal.soloNum(tfAsist);
        Principal.soloNum(tfBloqueos);
        Principal.soloNum(tfEntradas);
        Principal.soloNum(tfTirosAPuerta);
        Principal.soloNum(tfPasesC);
        Principal.soloNum(tfIntercep);
        Principal.soloNum(tfParadas);
        Principal.soloNum(tfGolesE);
        
        

        changeStatus(false);
        btnEliminar.setEnabled(false);
        btnEditar.setEnabled(false);

        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int index = list.getSelectedIndex();
                btnEliminar.setEnabled(index > -1);

                changeStatus(index <= -1);
                if (index > -1) {
                    Futbolista f = modelo.getElementAt(index);

                    String nomEquipo = buscarNombrEquipo(f.getIdEquipo());

                    tfNombre.setText(f.getNombre());
                    tfEquipo.setText(nomEquipo);
                    tfNum.setText(f.getNumero() + "");
                    tfAñosEnEq.setText(f.getAñosEnEquipo() + "");

                    if (f instanceof Entrenador) {
                        setOneEnabled(-1);
                        // ComboBoxTipo.setSelectedIndex(1);
                        tfExp.setText(((Entrenador) f).getAñosExperiencia() + "");
                    } else {
                        // ComboBoxTipo.setSelectedIndex(0);
                        Jugador j = (Jugador) f;
                        tfPartJugados.setText(j.getPartidosJugados() + "");
                        tfCantGoles.setText(j.getCantidadGoles() + "");
                        tfAsist.setText(j.getAsistencias() + "");
                        tfPromGoles.setText(j.getPromedioGoles() + "");

                        if (j instanceof Defensa) {
                            setOneEnabled(0);

                            Defensa def = (Defensa) j;
                            tfEntradas.setText(def.getEntradas() + "");
                            tfBloqueos.setText(def.getBloqueos() + "");

                        } else if (j instanceof Delantero) {
                            setOneEnabled(1);

                            tfTirosAPuerta.setText(((Delantero) j).getTirosAPuerta() + "");
                        } else if (j instanceof Mediocampista) {
                            setOneEnabled(2);

                            Mediocampista med = (Mediocampista) j;
                            tfPasesC.setText(med.getPasesCompletados() + "");
                            tfIntercep.setText(med.getIntercepciones() + "");
                        } else if (j instanceof Portero) {
                            setOneEnabled(3);

                            Portero por = (Portero) j;
                            tfParadas.setText(por.getParadas() + "");
                            tfGolesE.setText(por.getGolesEncajados() + "");
                        }
                    }

                    btnNuevo.setEnabled(true);
                    btnEditar.setEnabled(true);

                    Principal.contP = 0;
                } else {
                    btnEditar.setEnabled(false);
                }
            }

        });

        modelo.setList(ServicesLocator.getFutbolistaServices().obtenerFutbolistas());

    }

    // <editor-fold defaultstate="collapsed" desc="Generated
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
        btnSalir = new javax.swing.JButton();
        panelFutbolista = new javax.swing.JPanel();
        lblNum = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblEquipo = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        tfAñosEnEq = new javax.swing.JTextField();
        ComboBoxEquipo = new javax.swing.JComboBox<>();
        tfNombre = new javax.swing.JTextField();
        tfEquipo = new javax.swing.JTextField();
        lblAñosEq = new javax.swing.JLabel();
        tfNum = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        ComboBoxTipo = new javax.swing.JComboBox<>();
        tabbedPaneTipo = new javax.swing.JTabbedPane();
        panelJugador = new javax.swing.JPanel();
        tfPartJugados = new javax.swing.JTextField();
        lblPartJug = new javax.swing.JLabel();
        lblCantGoles = new javax.swing.JLabel();
        tfCantGoles = new javax.swing.JTextField();
        lblAsistencias = new javax.swing.JLabel();
        tfAsist = new javax.swing.JTextField();
        lblPromGoles = new javax.swing.JLabel();
        tfPromGoles = new javax.swing.JTextField();
        lblPos = new javax.swing.JLabel();
        ComboBoxPos = new javax.swing.JComboBox<>();
        panelEntrenador = new javax.swing.JPanel();
        tfExp = new javax.swing.JTextField();
        lblExp = new javax.swing.JLabel();
        tabbedPanePos = new javax.swing.JTabbedPane();
        panelDefensa = new javax.swing.JPanel();
        tfEntradas = new javax.swing.JTextField();
        lblEntradas = new javax.swing.JLabel();
        lblBloqueos = new javax.swing.JLabel();
        tfBloqueos = new javax.swing.JTextField();
        panelDefensa1 = new javax.swing.JPanel();
        tfTirosAPuerta = new javax.swing.JTextField();
        lblTirosAPuerta = new javax.swing.JLabel();
        panelDefensa2 = new javax.swing.JPanel();
        tfPasesC = new javax.swing.JTextField();
        lblPasesC = new javax.swing.JLabel();
        lblIntercep = new javax.swing.JLabel();
        tfIntercep = new javax.swing.JTextField();
        panelDefensa3 = new javax.swing.JPanel();
        tfParadas = new javax.swing.JTextField();
        lblParadas = new javax.swing.JLabel();
        lblGolesE = new javax.swing.JLabel();
        tfGolesE = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de partidos");
        setResizable(false);

        contentPanel.setForeground(new java.awt.Color(143, 182, 155));
        contentPanel.setToolTipText("");

        list.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        list.setForeground(new java.awt.Color(0, 102, 51));
        list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollPane.setViewportView(list);

        btnNuevo.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevo.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(0, 0, 0));
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(255, 255, 255));
        btnEditar.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(0, 0, 0));
        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(0, 0, 0));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        panelFutbolista.setBackground(new java.awt.Color(143, 182, 155));
        panelFutbolista.setBorder(new javax.swing.border.MatteBorder(null));
        panelFutbolista.setForeground(new java.awt.Color(0, 0, 0));
        panelFutbolista.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNum.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblNum.setForeground(new java.awt.Color(0, 0, 0));
        lblNum.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNum.setText("Número");
        panelFutbolista.add(lblNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 85, 130, -1));

        lblNombre.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(0, 0, 0));
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombre.setText("Nombre");
        panelFutbolista.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 19, 130, -1));

        lblEquipo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblEquipo.setForeground(new java.awt.Color(0, 0, 0));
        lblEquipo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEquipo.setText("Equipo");
        panelFutbolista.add(lblEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 51, 130, -1));

        lblTipo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblTipo.setForeground(new java.awt.Color(0, 0, 0));
        lblTipo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTipo.setText("Tipo");
        panelFutbolista.add(lblTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 130, -1));

        tfAñosEnEq.setEditable(false);
        tfAñosEnEq.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        panelFutbolista.add(tfAñosEnEq, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 50, -1));

        ComboBoxEquipo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        panelFutbolista.add(ComboBoxEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 160, -1));

        tfNombre.setEditable(false);
        tfNombre.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        panelFutbolista.add(tfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 16, 176, -1));

        tfEquipo.setEditable(false);
        tfEquipo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        panelFutbolista.add(tfEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 176, -1));

        lblAñosEq.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblAñosEq.setForeground(new java.awt.Color(0, 0, 0));
        lblAñosEq.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAñosEq.setText("Años en el equipo");
        panelFutbolista.add(lblAñosEq, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 130, -1));

        tfNum.setEditable(false);
        tfNum.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        panelFutbolista.add(tfNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 85, 50, -1));

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 0, 0));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        panelFutbolista.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        btnAgregar.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregar.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        panelFutbolista.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, -1, -1));

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panelFutbolista.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, -1, -1));

        ComboBoxTipo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        ComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jugador", "Entrenador" }));
        ComboBoxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxTipoActionPerformed(evt);
            }
        });
        panelFutbolista.add(ComboBoxTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 130, -1));

        panelJugador.setBackground(new java.awt.Color(143, 182, 155));
        panelJugador.setBorder(new javax.swing.border.MatteBorder(null));
        panelJugador.setForeground(new java.awt.Color(0, 0, 0));
        panelJugador.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfPartJugados.setEditable(false);
        tfPartJugados.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        panelJugador.add(tfPartJugados, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 60, -1));

        lblPartJug.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblPartJug.setForeground(new java.awt.Color(0, 0, 0));
        lblPartJug.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPartJug.setText("Partidos jugados");
        panelJugador.add(lblPartJug, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, -1));

        lblCantGoles.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblCantGoles.setForeground(new java.awt.Color(0, 0, 0));
        lblCantGoles.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCantGoles.setText("Cantidad de goles");
        panelJugador.add(lblCantGoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 130, -1));

        tfCantGoles.setEditable(false);
        tfCantGoles.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        panelJugador.add(tfCantGoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 60, -1));

        lblAsistencias.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblAsistencias.setForeground(new java.awt.Color(0, 0, 0));
        lblAsistencias.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAsistencias.setText("Asistencias");
        panelJugador.add(lblAsistencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 130, -1));

        tfAsist.setEditable(false);
        tfAsist.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        panelJugador.add(tfAsist, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 60, -1));

        lblPromGoles.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblPromGoles.setForeground(new java.awt.Color(0, 0, 0));
        lblPromGoles.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPromGoles.setText("Promedio de goles");
        panelJugador.add(lblPromGoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 130, -1));

        tfPromGoles.setEditable(false);
        tfPromGoles.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        panelJugador.add(tfPromGoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 60, -1));

        lblPos.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblPos.setForeground(new java.awt.Color(0, 0, 0));
        lblPos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPos.setText("Posición");
        panelJugador.add(lblPos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 130, -1));

        ComboBoxPos.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        ComboBoxPos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Defensa", "Delantero", "Mediocampista", "Portero" }));
        ComboBoxPos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxPosActionPerformed(evt);
            }
        });
        panelJugador.add(ComboBoxPos, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 130, -1));

        tabbedPaneTipo.addTab("Jugador", panelJugador);

        panelEntrenador.setBackground(new java.awt.Color(143, 182, 155));
        panelEntrenador.setBorder(new javax.swing.border.MatteBorder(null));
        panelEntrenador.setForeground(new java.awt.Color(0, 0, 0));
        panelEntrenador.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfExp.setEditable(false);
        tfExp.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        panelEntrenador.add(tfExp, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 16, 60, -1));

        lblExp.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblExp.setForeground(new java.awt.Color(0, 0, 0));
        lblExp.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblExp.setText("Años de experiencia");
        panelEntrenador.add(lblExp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 130, -1));

        tabbedPaneTipo.addTab("Entrenador", panelEntrenador);

        panelDefensa.setBackground(new java.awt.Color(143, 182, 155));
        panelDefensa.setBorder(new javax.swing.border.MatteBorder(null));
        panelDefensa.setForeground(new java.awt.Color(0, 0, 0));
        panelDefensa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfEntradas.setEditable(false);
        tfEntradas.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        panelDefensa.add(tfEntradas, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 60, -1));

        lblEntradas.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblEntradas.setForeground(new java.awt.Color(0, 0, 0));
        lblEntradas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEntradas.setText("Entradas");
        panelDefensa.add(lblEntradas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, -1));

        lblBloqueos.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblBloqueos.setForeground(new java.awt.Color(0, 0, 0));
        lblBloqueos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblBloqueos.setText("Bloqueos");
        panelDefensa.add(lblBloqueos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 130, -1));

        tfBloqueos.setEditable(false);
        tfBloqueos.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        panelDefensa.add(tfBloqueos, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 60, -1));

        tabbedPanePos.addTab("Defensa", panelDefensa);

        panelDefensa1.setBackground(new java.awt.Color(143, 182, 155));
        panelDefensa1.setBorder(new javax.swing.border.MatteBorder(null));
        panelDefensa1.setForeground(new java.awt.Color(0, 0, 0));
        panelDefensa1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfTirosAPuerta.setEditable(false);
        tfTirosAPuerta.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        panelDefensa1.add(tfTirosAPuerta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 60, -1));

        lblTirosAPuerta.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblTirosAPuerta.setForeground(new java.awt.Color(0, 0, 0));
        lblTirosAPuerta.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTirosAPuerta.setText("Tiros a puerta");
        panelDefensa1.add(lblTirosAPuerta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, -1));

        tabbedPanePos.addTab("Delantero", panelDefensa1);

        panelDefensa2.setBackground(new java.awt.Color(143, 182, 155));
        panelDefensa2.setBorder(new javax.swing.border.MatteBorder(null));
        panelDefensa2.setForeground(new java.awt.Color(0, 0, 0));
        panelDefensa2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfPasesC.setEditable(false);
        tfPasesC.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        panelDefensa2.add(tfPasesC, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 60, -1));

        lblPasesC.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblPasesC.setForeground(new java.awt.Color(0, 0, 0));
        lblPasesC.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPasesC.setText("Pases completados");
        panelDefensa2.add(lblPasesC, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, -1));

        lblIntercep.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblIntercep.setForeground(new java.awt.Color(0, 0, 0));
        lblIntercep.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIntercep.setText("Intercepciones");
        panelDefensa2.add(lblIntercep, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 130, -1));

        tfIntercep.setEditable(false);
        tfIntercep.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        panelDefensa2.add(tfIntercep, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 60, -1));

        tabbedPanePos.addTab("Mediocampista", panelDefensa2);

        panelDefensa3.setBackground(new java.awt.Color(143, 182, 155));
        panelDefensa3.setBorder(new javax.swing.border.MatteBorder(null));
        panelDefensa3.setForeground(new java.awt.Color(0, 0, 0));
        panelDefensa3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfParadas.setEditable(false);
        tfParadas.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        panelDefensa3.add(tfParadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 60, -1));

        lblParadas.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblParadas.setForeground(new java.awt.Color(0, 0, 0));
        lblParadas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblParadas.setText("Paradas");
        panelDefensa3.add(lblParadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, -1));

        lblGolesE.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblGolesE.setForeground(new java.awt.Color(0, 0, 0));
        lblGolesE.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGolesE.setText("Goles Encajados");
        panelDefensa3.add(lblGolesE, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 130, -1));

        tfGolesE.setEditable(false);
        tfGolesE.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        panelDefensa3.add(tfGolesE, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 60, -1));

        tabbedPanePos.addTab("Portero", panelDefensa3);

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir))
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelFutbolista, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tabbedPaneTipo, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                            .addComponent(tabbedPanePos))))
                .addContainerGap())
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(tabbedPaneTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tabbedPanePos, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(panelFutbolista, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                        .addComponent(scrollPane, javax.swing.GroupLayout.Alignment.LEADING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void ComboBoxTipoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ComboBoxTipoActionPerformed
        int index = ComboBoxTipo.getSelectedIndex();
        tabbedPaneTipo.setSelectedIndex(index);
        tabbedPaneTipo.setEnabledAt(index == 0 ? 0 : 1, true);
        tabbedPaneTipo.setEnabledAt(index == 0 ? 1 : 0, false);
        tabbedPanePos.setVisible(index == 0);

        if (index == 0) {
            tfPartJugados.setText("");
            tfCantGoles.setText("");
            tfAsist.setText("");
            tfPromGoles.setText("");
            tfBloqueos.setText("");
            tfEntradas.setText("");
            tfTirosAPuerta.setText("");
            tfPasesC.setText("");
            tfIntercep.setText("");
            tfParadas.setText("");
            tfGolesE.setText("");
            setOneEnabled(ComboBoxPos.getSelectedIndex());
        } else {
            tfExp.setText("");
        }
    }// GEN-LAST:event_ComboBoxTipoActionPerformed

    private void ComboBoxPosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ComboBoxPosActionPerformed
        setOneEnabled(ComboBoxPos.getSelectedIndex());
    }// GEN-LAST:event_ComboBoxPosActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNuevoActionPerformed
        limpiar();
        changeStatus(true);
        btnGuardar.setVisible(false);
        list.setEnabled(false);
        setOneEnabled(0);

        lblTipo.setVisible(true);
        ComboBoxTipo.setVisible(true);
        
        btnSalir.setEnabled(false);
    }// GEN-LAST:event_btnNuevoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAgregarActionPerformed

        boolean proceder = true; // validarDatos(id, nombre, capacidad);

        if (proceder) {
            // guardar en la BD
            Futbolista f = getFutbFromData();

            ServicesLocator.getFutbolistaServices().crearFutbolista(f);
            modelo.addElement(f);

            int lastIndex = list.getModel().getSize() - 1;
            list.setSelectedIndex(lastIndex);
            list.ensureIndexIsVisible(lastIndex);

            list.setEnabled(true);
            list.requestFocusInWindow();
            
            btnSalir.setEnabled(true);
        }
    }// GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEditarActionPerformed
        list.setEnabled(false);
        changeStatus(true);
        btnAgregar.setVisible(false);
        
        int index = ServicesLocator.getEquipoServices().getIndexFromId(modelo.getElementAt(list.getSelectedIndex()).getIdEquipo());
        ComboBoxEquipo.setSelectedIndex(index);
        
        btnSalir.setEnabled(false);

    }// GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnGuardarActionPerformed
        int index = list.getSelectedIndex();

        boolean proceder = true; // validarDatos(id, nombre, capacidad);

        if (proceder) {
            Futbolista f = getFutbFromData();
            f.setIdFutbolista(modelo.getElementAt(index).getIdFutbolista());

            ServicesLocator.getFutbolistaServices().actualizarFutbolista(f);

            modelo.updateElement(index, f);

            changeStatus(false);
            list.setEnabled(true);
            list.requestFocusInWindow();
            
            btnSalir.setEnabled(true);
        }
    }// GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEliminarActionPerformed
        int index = list.getSelectedIndex();
        if (index != -1) {
            if (JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar este futbolista?",
                    "Confirmar", 0) == 0) {

                ServicesLocator.getFutbolistaServices().eliminarFutbolista(modelo.getElementAt(index).getIdFutbolista());
                
                modelo.removeElement(index);

                limpiar();
                changeStatus(false);
            }
        }
    }// GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCancelarActionPerformed
        changeStatus(false);
        list.setEnabled(true);
        list.requestFocusInWindow();
        limpiar();
        
        lblNum.setForeground(Color.BLACK);
        lblNombre.setForeground(Color.BLACK);
        lblEquipo.setForeground(Color.BLACK);

        btnSalir.setEnabled(true);

        list.setSelectedIndex(0);
        // lblDatosErroneos.setVisible(false);
    }// GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSalirActionPerformed
        ConnectionManager.closeConnection();
        dispose();
    }// GEN-LAST:event_btnSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxEquipo;
    private javax.swing.JComboBox<String> ComboBoxPos;
    private javax.swing.JComboBox<String> ComboBoxTipo;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel lblAsistencias;
    private javax.swing.JLabel lblAñosEq;
    private javax.swing.JLabel lblBloqueos;
    private javax.swing.JLabel lblCantGoles;
    private javax.swing.JLabel lblEntradas;
    private javax.swing.JLabel lblEquipo;
    private javax.swing.JLabel lblExp;
    private javax.swing.JLabel lblGolesE;
    private javax.swing.JLabel lblGolesEnc;
    private javax.swing.JLabel lblIntercep;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNum;
    private javax.swing.JLabel lblParadas;
    private javax.swing.JLabel lblPartJug;
    private javax.swing.JLabel lblPasesC;
    private javax.swing.JLabel lblPos;
    private javax.swing.JLabel lblPromGoles;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTirosAPuerta;
    private javax.swing.JList<Partido> list;
    private javax.swing.JPanel panelDefensa;
    private javax.swing.JPanel panelDefensa1;
    private javax.swing.JPanel panelDefensa2;
    private javax.swing.JPanel panelDefensa3;
    private javax.swing.JPanel panelEntrenador;
    private javax.swing.JPanel panelFutbolista;
    private javax.swing.JPanel panelJugador;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTabbedPane tabbedPanePos;
    private javax.swing.JTabbedPane tabbedPaneTipo;
    private javax.swing.JTextField tfAsist;
    private javax.swing.JTextField tfAñosEnEq;
    private javax.swing.JTextField tfBloqueos;
    private javax.swing.JTextField tfCantGoles;
    private javax.swing.JTextField tfEntradas;
    private javax.swing.JTextField tfEquipo;
    private javax.swing.JTextField tfExp;
    private javax.swing.JTextField tfGolesE;
    private javax.swing.JTextField tfIntercep;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfNum;
    private javax.swing.JTextField tfParadas;
    private javax.swing.JTextField tfPartJugados;
    private javax.swing.JTextField tfPasesC;
    private javax.swing.JTextField tfPromGoles;
    private javax.swing.JTextField tfTirosAPuerta;
    // End of variables declaration//GEN-END:variables

    private void limpiar() {
        tfEquipo.setText("");
        tfNombre.setText("");
        tfNum.setText("");
        tfAñosEnEq.setText("");

        tfPartJugados.setText("");
        tfCantGoles.setText("");
        tfAsist.setText("");
        tfPromGoles.setText("");
        tfBloqueos.setText("");
        tfEntradas.setText("");
        tfTirosAPuerta.setText("");
        tfPasesC.setText("");
        tfIntercep.setText("");
        tfParadas.setText("");
        tfGolesE.setText("");

        tfExp.setText("");
    }

    private void changeStatus(boolean status) {
        tfNombre.setEditable(status);
        tfAñosEnEq.setEditable(status);
        tfEquipo.setEditable(status);
        tfNum.setEditable(status);
        tfExp.setEditable(status);
        tfPartJugados.setEditable(status);
        tfCantGoles.setEditable(status);
        tfAsist.setEditable(status);
        tfPromGoles.setEditable(status);
        tfBloqueos.setEditable(status);
        tfEntradas.setEditable(status);
        tfTirosAPuerta.setEditable(status);
        tfPasesC.setEditable(status);
        tfIntercep.setEditable(status);
        tfParadas.setEditable(status);
        tfGolesE.setEditable(status);

        btnEliminar.setEnabled(!status);
        btnNuevo.setEnabled(!status);
        btnEditar.setEnabled(!status);

        tfEquipo.setVisible(!status);
        ComboBoxEquipo.setVisible(status);
        lblTipo.setVisible(false); // cambiar en caso de ser necesario
        ComboBoxTipo.setVisible(false);
        lblPos.setVisible(status);
        ComboBoxPos.setVisible(status);

        btnAgregar.setVisible(status);
        btnGuardar.setVisible(status);
        btnCancelar.setVisible(status);

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

    private void setOneEnabled(int index) {
        tabbedPaneTipo.setSelectedIndex(index == -1 ? 1 : 0);
        tabbedPaneTipo.setEnabledAt(0, index > -1);
        tabbedPaneTipo.setEnabledAt(1, index == -1);

        tabbedPanePos.setVisible(index > -1);

        if (index > -1) {
            tabbedPanePos.setSelectedIndex(index);
            ComboBoxPos.setSelectedIndex(index);

            for (int i = 0; i < 4; i++) {
                if (i != index) {
                    tabbedPanePos.setEnabledAt(i, false);
                } else {
                    tabbedPanePos.setEnabledAt(i, true);
                }
            }
        }
    }

    public Futbolista getFutbFromData () {
        Futbolista f = null;

        String nombre = tfNombre.getText();
        int idEquipo = ServicesLocator.getEquipoServices().getIdFromIndex(ComboBoxEquipo.getSelectedIndex());
        int num = Integer.parseInt(tfNum.getText());
        int añosEnE = Integer.parseInt(tfAñosEnEq.getText());
        String tipo = ComboBoxTipo.getSelectedItem().toString();

        if (tipo.equals("Entrenador")) {
            f = new Entrenador(idEquipo, num, nombre, añosEnE, tipo, Integer.parseInt(tfExp.getText()));
        } else {
            int partJug = Integer.parseInt(tfPartJugados.getText());
            int cantGoles = Integer.parseInt(tfCantGoles.getText());
            int asist = Integer.parseInt(tfAsist.getText());
            double prom = Double.parseDouble(tfPromGoles.getText());
            String pos = ComboBoxPos.getSelectedItem().toString();

            if (pos.equals("Defensa")) {
                int entradas = Integer.parseInt(tfEntradas.getText());
                int bloqueos = Integer.parseInt(tfBloqueos.getText());
                f = new Defensa(idEquipo, num, nombre, añosEnE, tipo, partJug, cantGoles, asist, prom, pos,
                        entradas, bloqueos);
            } else if (pos.equals("Delantero")) {
                int tiros = Integer.parseInt(tfTirosAPuerta.getText());
                f = new Delantero(idEquipo, num, nombre, añosEnE, tipo, partJug, cantGoles, asist, prom, pos,
                        tiros);
            } else if (pos.equals("Mediocampista")) {
                int pases = Integer.parseInt(tfPasesC.getText());
                int interc = Integer.parseInt(tfIntercep.getText());
                f = new Mediocampista(idEquipo, num, nombre, añosEnE, tipo, partJug, cantGoles, asist, prom, pos,
                        pases, interc);
            } else if (pos.equals("Portero")) {
                int paradas = Integer.parseInt(tfParadas.getText());
                int golesEnc = Integer.parseInt(tfGolesE.getText());
                f = new Portero(idEquipo, num, nombre, añosEnE, tipo, partJug, cantGoles, asist, prom, pos, paradas, golesEnc);
            }
        }
        return f;
    }

    // private void limpiar() {
    //     DateChooserFecha.setDate(new Date());
    //     tfEstadio.setText("");
    //     tfAudiencia.setText("");
    //     tfLocal.setText("");
    //     tfVisit.setText("");
    //     tfGolesLocal.setText("");
    //     tfGolesVisitante.setText("");
    // }

    // private boolean validarDatos(int audiencia, int golesLocal, int golesVisit) {
    //     boolean correcto = true;
    //     Partido temp = new Partido();
    //     Date fecha = null;

    //     try { // fecha
    //         fecha = DateChooserFecha.getDate();
    //         temp.setFecha(fecha);
    //     } catch (Exception e) {
    //         correcto = false;
    //         lblDatosErroneos.setVisible(true);
    //         lblFecha.setForeground(Principal.errorColor);
    //     }
    //     try { // audiencia
    //         temp.setAudiencia(audiencia);
    //     } catch (IllegalArgumentException e) {
    //         correcto = false;
    //         lblDatosErroneos.setVisible(true);
    //         lblAudiencia.setForeground(Principal.errorColor);
    //     }
    //     try { // goles local
    //         temp.setGolesLocal(golesLocal);
    //     } catch (IllegalArgumentException e) {
    //         correcto = false;
    //         lblDatosErroneos.setVisible(true);
    //         lblGolesLocal.setForeground(Principal.errorColor);
    //     }
    //     try { // goles visitante
    //         temp.setGolesVisitante(golesVisit);
    //     } catch (IllegalArgumentException e) {
    //         correcto = false;
    //         lblDatosErroneos.setVisible(true);
    //         lblGolesVisit.setForeground(Principal.errorColor);
    //     }

    //     if (correcto) {
    //         lblDatosErroneos.setVisible(false);
    //         changeStatus(true);
    //     }
    //     return correcto;
    // }

    // private void changeStatus(boolean status) {
    //     tfAudiencia.setEditable(status);
    //     tfGolesLocal.setEditable(status);
    //     tfGolesVisitante.setEditable(status);

    //     tfEstadio.setVisible(!status);
    //     tfLocal.setVisible(!status);
    //     tfVisit.setVisible(!status);

    //     btnEliminar.setEnabled(!status);
    //     btnNuevo.setEnabled(!status);
    //     btnEditar.setEnabled(!status);
    //     list.setEnabled(!status);
    //     btnSalir.setEnabled(!status);

    //     btnAgregar.setVisible(status);
    //     btnGuardar.setVisible(status);
    //     btnCancelar.setVisible(status);

    //     lblAudiencia.setForeground(Color.BLACK);
    //     lblEstadio.setForeground(Color.BLACK);
    //     lblFecha.setForeground(Color.BLACK);
    //     lblGolesLocal.setForeground(Color.BLACK);
    //     lblGolesVisit.setForeground(Color.BLACK);
    //     lblLocal.setForeground(Color.BLACK);
    //     lblVisitante.setForeground(Color.BLACK);

    //     jComboBoxEstadio.setVisible(status);
    //     jComboBoxLocal.setVisible(status);
    //     jComboBoxVisitante.setVisible(status);
    // }
}
