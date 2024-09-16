package visual;

import java.awt.Color;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Defensa;
import model.Delantero;
import model.Entrenador;
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
        lblDatosErroneos.setVisible(false);

        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int index = list.getSelectedIndex();
                btnEliminar.setEnabled(index > -1);

                changeStatus(index <= -1);
                if (index > -1) {
                    Futbolista f = modelo.getElementAt(index);

                    int pos = ServicesLocator.getEquipoServices()
                            .getIndexFromId(modelo.getElementAt(list.getSelectedIndex()).getIdEquipo());
                    ComboBoxEquipo.setSelectedIndex(pos);

                    String nomEquipo = ComboBoxEquipo.getSelectedItem().toString();

                    tfNombre.setText(f.getNombre());
                    tfEquipo.setText(nomEquipo);
                    tfNum.setText(f.getNumero() + "");
                    tfAñosEnEq.setText(f.getAñosEnEquipo() + "");

                    if (f instanceof Entrenador) {
                        setOneEnabled(-1);
                        ComboBoxTipo.setSelectedIndex(1);
                        tfExp.setText(((Entrenador) f).getAñosExperiencia() + "");
                    } else {
                        Jugador j = (Jugador) f;
                        ComboBoxTipo.setSelectedIndex(0);
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
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfGolesEnc = new javax.swing.JTextField();
        lblGolesEnc = new javax.swing.JLabel();
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
        lblDatosErroneos = new javax.swing.JLabel();
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

        tfGolesEnc.setEditable(false);
        tfGolesEnc.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        lblGolesEnc.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblGolesEnc.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGolesEnc.setText("Goles encajados");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de partidos");
        setResizable(false);

        contentPanel.setForeground(new java.awt.Color(143, 182, 155));
        contentPanel.setToolTipText("");

        list.setBackground(new java.awt.Color(59, 122, 26));
        list.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        list.setForeground(new java.awt.Color(255, 255, 255));
        list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollPane.setViewportView(list);

        btnNuevo.setFont(new java.awt.Font("Roboto Black", 0, 15)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(59, 122, 26));
        btnNuevo.setText("Nuevo");
        btnNuevo.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(59, 122, 26)));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Roboto Black", 0, 15)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(59, 122, 26));
        btnEditar.setText("Editar");
        btnEditar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(59, 122, 26)));
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Roboto Black", 0, 15)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(59, 122, 26));
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(59, 122, 26)));
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Roboto Black", 0, 15)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 51, 51));
        btnSalir.setText("Salir");
        btnSalir.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 51, 51)));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        panelFutbolista.setBackground(new java.awt.Color(255, 255, 255));
        panelFutbolista.setBorder(new javax.swing.border.MatteBorder(null));
        panelFutbolista.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNum.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblNum.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNum.setText("Número");
        panelFutbolista.add(lblNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 85, 130, -1));

        lblNombre.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombre.setText("Nombre");
        panelFutbolista.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 19, 130, -1));

        lblEquipo.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblEquipo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEquipo.setText("Equipo");
        panelFutbolista.add(lblEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 51, 130, -1));

        lblTipo.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblTipo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTipo.setText("Tipo");
        panelFutbolista.add(lblTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 130, -1));

        tfAñosEnEq.setEditable(false);
        tfAñosEnEq.setBackground(new java.awt.Color(255, 255, 255));
        tfAñosEnEq.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        panelFutbolista.add(tfAñosEnEq, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 50, -1));

        ComboBoxEquipo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        ComboBoxEquipo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelFutbolista.add(ComboBoxEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 160, -1));

        tfNombre.setEditable(false);
        tfNombre.setBackground(new java.awt.Color(255, 255, 255));
        tfNombre.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tfNombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelFutbolista.add(tfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 16, 176, -1));

        tfEquipo.setEditable(false);
        tfEquipo.setBackground(new java.awt.Color(255, 255, 255));
        tfEquipo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        panelFutbolista.add(tfEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 176, -1));

        lblAñosEq.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblAñosEq.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAñosEq.setText("Años en el equipo");
        panelFutbolista.add(lblAñosEq, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 130, -1));

        tfNum.setEditable(false);
        tfNum.setBackground(new java.awt.Color(255, 255, 255));
        tfNum.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        panelFutbolista.add(tfNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 85, 50, -1));

        btnGuardar.setBackground(new java.awt.Color(59, 122, 26));
        btnGuardar.setFont(new java.awt.Font("Roboto Black", 0, 15)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        panelFutbolista.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        btnAgregar.setBackground(new java.awt.Color(59, 122, 26));
        btnAgregar.setFont(new java.awt.Font("Roboto Black", 0, 15)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        panelFutbolista.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, -1, -1));

        btnCancelar.setBackground(new java.awt.Color(255, 102, 102));
        btnCancelar.setFont(new java.awt.Font("Roboto Black", 0, 15)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
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

        lblDatosErroneos.setFont(new java.awt.Font("SansSerif", 3, 16)); // NOI18N
        lblDatosErroneos.setForeground(new java.awt.Color(255, 51, 51));
        lblDatosErroneos.setText("Datos erroneos");
        panelFutbolista.add(lblDatosErroneos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        tabbedPaneTipo.setBackground(new java.awt.Color(255, 255, 255));
        tabbedPaneTipo.setForeground(new java.awt.Color(59, 122, 26));
        tabbedPaneTipo.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N

        panelJugador.setBackground(new java.awt.Color(228, 228, 228));
        panelJugador.setBorder(new javax.swing.border.MatteBorder(null));
        panelJugador.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfPartJugados.setEditable(false);
        tfPartJugados.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        panelJugador.add(tfPartJugados, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 60, -1));

        lblPartJug.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblPartJug.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPartJug.setText("Partidos jugados");
        panelJugador.add(lblPartJug, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, -1));

        lblCantGoles.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblCantGoles.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCantGoles.setText("Cantidad de goles");
        panelJugador.add(lblCantGoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 130, -1));

        tfCantGoles.setEditable(false);
        tfCantGoles.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        panelJugador.add(tfCantGoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 60, -1));

        lblAsistencias.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblAsistencias.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAsistencias.setText("Asistencias");
        panelJugador.add(lblAsistencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 130, -1));

        tfAsist.setEditable(false);
        tfAsist.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        panelJugador.add(tfAsist, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 60, -1));

        lblPromGoles.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblPromGoles.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPromGoles.setText("Promedio de goles");
        panelJugador.add(lblPromGoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 130, -1));

        tfPromGoles.setEditable(false);
        tfPromGoles.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        panelJugador.add(tfPromGoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 60, -1));

        lblPos.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
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

        panelEntrenador.setBackground(new java.awt.Color(228, 228, 228));
        panelEntrenador.setBorder(new javax.swing.border.MatteBorder(null));
        panelEntrenador.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfExp.setEditable(false);
        tfExp.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        panelEntrenador.add(tfExp, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 16, 60, -1));

        lblExp.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblExp.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblExp.setText("Años de experiencia");
        panelEntrenador.add(lblExp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 130, -1));

        tabbedPaneTipo.addTab("Entrenador", panelEntrenador);

        tabbedPanePos.setBackground(new java.awt.Color(255, 255, 255));
        tabbedPanePos.setForeground(new java.awt.Color(59, 122, 26));
        tabbedPanePos.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N

        panelDefensa.setBackground(new java.awt.Color(228, 228, 228));
        panelDefensa.setBorder(new javax.swing.border.MatteBorder(null));
        panelDefensa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfEntradas.setEditable(false);
        tfEntradas.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        panelDefensa.add(tfEntradas, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 60, -1));

        lblEntradas.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblEntradas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEntradas.setText("Entradas");
        panelDefensa.add(lblEntradas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, -1));

        lblBloqueos.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblBloqueos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblBloqueos.setText("Bloqueos");
        panelDefensa.add(lblBloqueos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 130, -1));

        tfBloqueos.setEditable(false);
        tfBloqueos.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        panelDefensa.add(tfBloqueos, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 60, -1));

        tabbedPanePos.addTab("Defensa", panelDefensa);

        panelDefensa1.setBackground(new java.awt.Color(228, 228, 228));
        panelDefensa1.setBorder(new javax.swing.border.MatteBorder(null));
        panelDefensa1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfTirosAPuerta.setEditable(false);
        tfTirosAPuerta.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        panelDefensa1.add(tfTirosAPuerta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 60, -1));

        lblTirosAPuerta.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblTirosAPuerta.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTirosAPuerta.setText("Tiros a puerta");
        panelDefensa1.add(lblTirosAPuerta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, -1));

        tabbedPanePos.addTab("Delantero", panelDefensa1);

        panelDefensa2.setBackground(new java.awt.Color(228, 228, 228));
        panelDefensa2.setBorder(new javax.swing.border.MatteBorder(null));
        panelDefensa2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfPasesC.setEditable(false);
        tfPasesC.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        panelDefensa2.add(tfPasesC, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 60, -1));

        lblPasesC.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblPasesC.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPasesC.setText("Pases completados");
        panelDefensa2.add(lblPasesC, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, -1));

        lblIntercep.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblIntercep.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIntercep.setText("Intercepciones");
        panelDefensa2.add(lblIntercep, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 130, -1));

        tfIntercep.setEditable(false);
        tfIntercep.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        panelDefensa2.add(tfIntercep, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 60, -1));

        tabbedPanePos.addTab("Mediocampista", panelDefensa2);

        panelDefensa3.setBackground(new java.awt.Color(228, 228, 228));
        panelDefensa3.setBorder(new javax.swing.border.MatteBorder(null));
        panelDefensa3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfParadas.setEditable(false);
        tfParadas.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        panelDefensa3.add(tfParadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 60, -1));

        lblParadas.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblParadas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblParadas.setText("Paradas");
        panelDefensa3.add(lblParadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, -1));

        lblGolesE.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
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
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(18, 27, Short.MAX_VALUE)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        setOneEnabled(0);
        ComboBoxTipo.setSelectedIndex(0);

        lblTipo.setVisible(true);
        ComboBoxTipo.setVisible(true);
    }// GEN-LAST:event_btnNuevoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAgregarActionPerformed
        Futbolista f = getFutbFromData();

        if (f != null) {
            try {
                ServicesLocator.getFutbolistaServices().crearFutbolista(f);
                modelo.addElement(f);

                int lastIndex = list.getModel().getSize() - 1;
                list.setSelectedIndex(lastIndex);
                list.ensureIndexIsVisible(lastIndex);

                changeStatus(false);
            } catch (Exception e) {
                btnAgregar.setEnabled(false);
                String nums = ServicesLocator.getFutbolistaServices().getNumsFutbs(f.getIdEquipo());
                JOptionPane.showMessageDialog(null, nums,
                        "Aviso", JOptionPane.INFORMATION_MESSAGE);
                btnAgregar.setEnabled(true);
            }

        }

    }// GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEditarActionPerformed
        changeStatus(true);
        btnAgregar.setVisible(false);
    }// GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnGuardarActionPerformed
        int index = list.getSelectedIndex();

        Futbolista f = getFutbFromData();

        if (f != null) {
            try {
                f.setIdFutbolista(modelo.getElementAt(index).getIdFutbolista());

                ServicesLocator.getFutbolistaServices().actualizarFutbolista(f);

                modelo.updateElement(index, f);
                if (f instanceof Jugador) {
                    tfPromGoles.setText(((Jugador) f).getPromedioGoles() + "");
                }

                changeStatus(false);
            } catch (SQLException e) {
                btnGuardar.setEnabled(false);
                String nums = ServicesLocator.getFutbolistaServices().getNumsFutbs(f.getIdEquipo());
                JOptionPane.showMessageDialog(null, nums,
                        "Aviso", JOptionPane.INFORMATION_MESSAGE);
                btnGuardar.setEnabled(true);
            }
        }
    }// GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEliminarActionPerformed
        int index = list.getSelectedIndex();
        if (index != -1) {
            if (JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar este futbolista?",
                    "Confirmar", 0) == 0) {

                ServicesLocator.getFutbolistaServices()
                        .eliminarFutbolista(modelo.getElementAt(index).getIdFutbolista());

                modelo.removeElement(index);

                limpiar();
                changeStatus(false);
            }
        }
    }// GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCancelarActionPerformed
        changeStatus(false);
        lblDatosErroneos.setVisible(false);
        list.setSelectedIndex(0);
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
    private javax.swing.JLabel lblDatosErroneos;
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
    private javax.swing.JTextField tfGolesEnc;
    private javax.swing.JTextField tfIntercep;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfNum;
    private javax.swing.JTextField tfParadas;
    private javax.swing.JTextField tfPartJugados;
    private javax.swing.JTextField tfPasesC;
    private javax.swing.JTextField tfPromGoles;
    private javax.swing.JTextField tfTirosAPuerta;
    // End of variables declaration//GEN-END:variables

    private void setOneEnabled(int index) {
        tabbedPaneTipo.setSelectedIndex(index == -1 ? 1 : 0);
        tabbedPaneTipo.setEnabledAt(0, index > -1);
        tabbedPaneTipo.setEnabledAt(1, index == -1);

        tabbedPanePos.setVisible(index > -1);

        if (index > -1) {
            tabbedPanePos.setSelectedIndex(index);
            ComboBoxPos.setSelectedIndex(index);

            for (int i = 0; i < 4; i++) {
                tabbedPanePos.setEnabledAt(i, i == index);
            }
        }
    }

    public Futbolista getFutbFromData() {
        Futbolista f = null;
        String nombre = null;
        int num = -1;
        int añosEnE = -1;

        boolean val = validarNombre();
        val = validarInt(tfNum, lblNum) && val;
        val = validarInt(tfAñosEnEq, lblAñosEq) && val;

        if (val) {
            nombre = tfNombre.getText();
            num = Integer.parseInt(tfNum.getText());
            añosEnE = Integer.parseInt(tfAñosEnEq.getText());
        }

        int idEquipo = ServicesLocator.getEquipoServices().getIdFromIndex(ComboBoxEquipo.getSelectedIndex());
        String tipo = ComboBoxTipo.getSelectedItem().toString();

        if (tipo.equals("Entrenador")) {
            val = validarInt(tfExp, lblExp) && val;

            if (val) {
                f = new Entrenador(idEquipo, num, nombre, añosEnE, tipo, Integer.parseInt(tfExp.getText()));
            }
        } else {
            int partJug = -1;
            int cantGoles = -1;
            int asist = -1;

            val = validarInt(tfPartJugados, lblPartJug) && val;
            val = validarInt(tfCantGoles, lblCantGoles) && val;
            val = validarInt(tfAsist, lblAsistencias) && val;

            if (val) {
                partJug = Integer.parseInt(tfPartJugados.getText());
                cantGoles = Integer.parseInt(tfCantGoles.getText());
                asist = Integer.parseInt(tfAsist.getText());
            }

            String pos = ComboBoxPos.getSelectedItem().toString();

            if (pos.equals("Defensa")) {
                int entradas = -1;
                int bloqueos = -1;

                val = validarInt(tfEntradas, lblEntradas) && val;
                val = validarInt(tfBloqueos, lblBloqueos) && val;

                if (val) {
                    entradas = Integer.parseInt(tfEntradas.getText());
                    bloqueos = Integer.parseInt(tfBloqueos.getText());

                    f = new Defensa(idEquipo, num, nombre, añosEnE, tipo, partJug, cantGoles, asist, pos,
                            entradas, bloqueos);
                }
            } else if (pos.equals("Delantero")) {
                int tiros = -1;

                val = validarInt(tfTirosAPuerta, lblTirosAPuerta) && val;

                if (val) {
                    tiros = Integer.parseInt(tfTirosAPuerta.getText());
                    f = new Delantero(idEquipo, num, nombre, añosEnE, tipo, partJug, cantGoles, asist, pos, tiros);
                }
            } else if (pos.equals("Mediocampista")) {
                int pases = -1;
                int interc = -1;

                val = validarInt(tfPasesC, lblPasesC) && val;
                val = validarInt(tfIntercep, lblIntercep) && val;

                if (val) {
                    pases = Integer.parseInt(tfPasesC.getText());
                    interc = Integer.parseInt(tfIntercep.getText());

                    f = new Mediocampista(idEquipo, num, nombre, añosEnE, tipo, partJug, cantGoles, asist, pos,
                            pases, interc);
                }
            } else if (pos.equals("Portero")) {
                int paradas = -1;
                int golesEnc = -1;

                val = validarInt(tfParadas, lblParadas) && val;
                val = validarInt(tfGolesE, lblGolesE) && val;

                if (val) {
                    paradas = Integer.parseInt(tfParadas.getText());
                    golesEnc = Integer.parseInt(tfGolesE.getText());

                    f = new Portero(idEquipo, num, nombre, añosEnE, tipo, partJug, cantGoles, asist, pos, paradas,
                            golesEnc);
                }
            }
        }

        return f;
    }

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

    private boolean validarNombre() {
        boolean correcto = true;
        Defensa temp = new Defensa();

        try { // nombre
            lblNombre.setForeground(Color.BLACK);
            temp.setNombre(tfNombre.getText());
        } catch (IllegalArgumentException e) {
            correcto = false;
            lblDatosErroneos.setVisible(true);
            lblNombre.setForeground(Principal.errorColor);
        }

        return correcto;
    }

    private boolean validarInt(JTextField tf, JLabel lbl) {
        boolean correcto = true;
        Defensa temp = new Defensa();

        try { // generic int
            lbl.setForeground(Color.BLACK);
            int valorEntero = Integer.parseInt(tf.getText().equals("") ? "-1" : tf.getText());
            temp.setCantidadGoles(valorEntero);
        } catch (IllegalArgumentException e) {
            correcto = false;
            lblDatosErroneos.setVisible(true);
            lbl.setForeground(Principal.errorColor);
        }

        return correcto;
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
        btnSalir.setEnabled(!status);

        tfEquipo.setVisible(!status);
        ComboBoxEquipo.setVisible(status);
        lblTipo.setVisible(false); // cambiar en caso de ser necesario
        ComboBoxTipo.setVisible(false);
        lblPos.setVisible(status);
        ComboBoxPos.setVisible(status);

        btnAgregar.setVisible(status);
        btnGuardar.setVisible(status);
        btnCancelar.setVisible(status);

        lblNombre.setForeground(Color.BLACK);
        lblNum.setForeground(Color.BLACK);
        lblAñosEq.setForeground(Color.BLACK);
        lblExp.setForeground(Color.BLACK);
        lblPartJug.setForeground(Color.BLACK);
        lblCantGoles.setForeground(Color.BLACK);
        lblAsistencias.setForeground(Color.BLACK);
        lblPromGoles.setForeground(Color.BLACK);
        lblEntradas.setForeground(Color.BLACK);
        lblBloqueos.setForeground(Color.BLACK);
        lblTirosAPuerta.setForeground(Color.BLACK);
        lblPasesC.setForeground(Color.BLACK);
        lblIntercep.setForeground(Color.BLACK);
        lblParadas.setForeground(Color.BLACK);
        lblGolesE.setForeground(Color.BLACK);

        lblDatosErroneos.setVisible(false);
    }
}
