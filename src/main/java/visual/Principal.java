/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;
import javax.swing.UIManager;

import model.Rol;
import services.ServicesLocator;

/**
 *
 * @author HP 11na
 */
public class Principal extends javax.swing.JFrame {

    public static Color errorColor = new Color(255, 51, 51);
    public static int contP;
    public static Rol rol;
    public static String usuarioActual;

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        setSize(800, 600);
        setLocationRelativeTo(null);

        UIManager.put("OptionPane.messageFont", new Font("SansSerif", Font.PLAIN, 14));
        UIManager.put("OptionPane.buttonFont", new Font("SansSerif", Font.PLAIN, 14));
        UIManager.put("MenuItem.selectionBackground", new Color(217, 242, 220));
        UIManager.put("Menu.selectionBackground", new Color(217, 242, 220));

        menuGestion.setVisible(false);
        menuItemUsuarios.setVisible(false);
        menuItemCerrarS.setEnabled(false);

        boolean activa = ServicesLocator.getIntervaloFServices().ligaActiva();
        menuItemIniciar.setEnabled(!activa);
        menuItemCulminar.setEnabled(activa);
        menuItemPartidos.setEnabled(activa);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuPerfil = new javax.swing.JMenu();
        menuItemInicioS = new javax.swing.JMenuItem();
        menuItemCerrarS = new javax.swing.JMenuItem();
        menuItemUsuarios = new javax.swing.JMenuItem();
        menuGestion = new javax.swing.JMenu();
        menuItemEstadios = new javax.swing.JMenuItem();
        menuItemEquipos = new javax.swing.JMenuItem();
        menuItemPartidos = new javax.swing.JMenuItem();
        menuItemFutbolistas = new javax.swing.JMenuItem();
        menuItemIniciar = new javax.swing.JMenuItem();
        menuItemCulminar = new javax.swing.JMenuItem();
        menuReportes = new javax.swing.JMenu();
        menuItemRTablaPosiciones = new javax.swing.JMenuItem();
        menuItemRPartidosEquipos = new javax.swing.JMenuItem();
        menuItemRPartidosPorFecha = new javax.swing.JMenuItem();
        menuItemREntrenadoresExperiencia = new javax.swing.JMenuItem();
        menuItemREstadiosMayorAudiencia = new javax.swing.JMenuItem();
        menuItemREstadoEquipo = new javax.swing.JMenuItem();
        menuItemREquipoEstrella = new javax.swing.JMenuItem();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Gestión de la Liga Nacional de Fútbol");
        setBackground(new java.awt.Color(60, 63, 64));
        setBounds(new java.awt.Rectangle(0, 0, 800, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon("src\\main\\java\\visual\\images\\1 (9).png")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -20, 860, 590));

        menuBar.setToolTipText("");

        menuPerfil.setIcon(new javax.swing.ImageIcon("src\\main\\java\\visual\\images\\Perfil (1).png")); // NOI18N
        menuPerfil.setText("Perfil");
        menuPerfil.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N

        menuItemInicioS.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        menuItemInicioS.setIcon(new javax.swing.ImageIcon("src\\main\\java\\visual\\images\\User (1).png")); // NOI18N
        menuItemInicioS.setText("Iniciar sesión");
        menuItemInicioS.setActionCommand("");
        menuItemInicioS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuItemInicioSMousePressed(evt);
            }
        });
        menuItemInicioS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemInicioSActionPerformed(evt);
            }
        });
        menuPerfil.add(menuItemInicioS);

        menuItemCerrarS.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        menuItemCerrarS.setIcon(new javax.swing.ImageIcon("src\\main\\java\\visual\\images\\No user (1).png")); // NOI18N
        menuItemCerrarS.setText("Cerrar sesión");
        menuItemCerrarS.setToolTipText("");
        menuItemCerrarS.setActionCommand("");
        menuItemCerrarS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuItemCerrarSMousePressed(evt);
            }
        });
        menuItemCerrarS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCerrarSActionPerformed(evt);
            }
        });
        menuPerfil.add(menuItemCerrarS);

        menuItemUsuarios.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        menuItemUsuarios.setIcon(new javax.swing.ImageIcon("src\\main\\java\\visual\\images\\Gestión usuarios.png")); // NOI18N
        menuItemUsuarios.setText("Gestión de usuarios");
        menuItemUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemUsuariosActionPerformed(evt);
            }
        });
        menuPerfil.add(menuItemUsuarios);

        menuBar.add(menuPerfil);

        menuGestion.setIcon(new javax.swing.ImageIcon("src\\main\\java\\visual\\images\\gestionLiga (1).png")); // NOI18N
        menuGestion.setText("Gestión de la liga");
        menuGestion.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N

        menuItemEstadios.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        menuItemEstadios.setIcon(new javax.swing.ImageIcon("src\\main\\java\\visual\\images\\balon (1).png")); // NOI18N
        menuItemEstadios.setLabel("Estadios");
        menuItemEstadios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEstadiosActionPerformed(evt);
            }
        });
        menuGestion.add(menuItemEstadios);

        menuItemEquipos.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        menuItemEquipos.setIcon(new javax.swing.ImageIcon("src\\main\\java\\visual\\images\\balon (1).png")); // NOI18N
        menuItemEquipos.setLabel("Equipos");
        menuItemEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEquiposActionPerformed(evt);
            }
        });
        menuGestion.add(menuItemEquipos);

        menuItemPartidos.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        menuItemPartidos.setIcon(new javax.swing.ImageIcon("src\\main\\java\\visual\\images\\balon (1).png")); // NOI18N
        menuItemPartidos.setLabel("Partidos");
        menuItemPartidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPartidosActionPerformed(evt);
            }
        });
        menuGestion.add(menuItemPartidos);

        menuItemFutbolistas.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        menuItemFutbolistas.setIcon(new javax.swing.ImageIcon("src\\main\\java\\visual\\images\\balon (1).png")); // NOI18N
        menuItemFutbolistas.setLabel("Futbolistas");
        menuItemFutbolistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemFutbolistasActionPerformed(evt);
            }
        });
        menuGestion.add(menuItemFutbolistas);

        menuItemIniciar.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        menuItemIniciar.setIcon(new javax.swing.ImageIcon("src\\main\\java\\visual\\images\\Abrir (1).png")); // NOI18N
        menuItemIniciar.setText("Comenzar la liga");
        menuItemIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemIniciarActionPerformed(evt);
            }
        });
        menuGestion.add(menuItemIniciar);

        menuItemCulminar.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        menuItemCulminar.setIcon(new javax.swing.ImageIcon("src\\main\\java\\visual\\images\\Cerrar (1).png")); // NOI18N
        menuItemCulminar.setText("Culminar la liga");
        menuItemCulminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCulminarActionPerformed(evt);
            }
        });
        menuGestion.add(menuItemCulminar);

        menuBar.add(menuGestion);

        menuReportes.setIcon(new javax.swing.ImageIcon("src\\main\\java\\visual\\images\\Reportes (1).png")); // NOI18N
        menuReportes.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        menuReportes.setLabel("Reportes");

        menuItemRTablaPosiciones.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        menuItemRTablaPosiciones.setIcon(new javax.swing.ImageIcon("src\\main\\java\\visual\\images\\Posiciones (1).png")); // NOI18N
        menuItemRTablaPosiciones.setText("Tabla de posiciones de la liga");
        menuItemRTablaPosiciones.setActionCommand("Reportes");
        menuItemRTablaPosiciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRTablaPosicionesActionPerformed(evt);
            }
        });
        menuReportes.add(menuItemRTablaPosiciones);

        menuItemRPartidosEquipos.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        menuItemRPartidosEquipos.setIcon(new javax.swing.ImageIcon("src\\main\\java\\visual\\images\\Partido (1).png")); // NOI18N
        menuItemRPartidosEquipos.setText("Partidos por equipos");
        menuItemRPartidosEquipos.setActionCommand("Reportes");
        menuItemRPartidosEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRPartidosEquiposActionPerformed(evt);
            }
        });
        menuReportes.add(menuItemRPartidosEquipos);

        menuItemRPartidosPorFecha.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        menuItemRPartidosPorFecha.setIcon(new javax.swing.ImageIcon("src\\main\\java\\visual\\images\\Partido (1).png")); // NOI18N
        menuItemRPartidosPorFecha.setText("Partidos jugados por fecha");
        menuItemRPartidosPorFecha.setActionCommand("Reportes");
        menuItemRPartidosPorFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRPartidosPorFechaActionPerformed(evt);
            }
        });
        menuReportes.add(menuItemRPartidosPorFecha);

        menuItemREntrenadoresExperiencia.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        menuItemREntrenadoresExperiencia.setIcon(new javax.swing.ImageIcon("src\\main\\java\\visual\\images\\Entrenador (1).png")); // NOI18N
        menuItemREntrenadoresExperiencia.setText("Entrenadores con más experiencia");
        menuItemREntrenadoresExperiencia.setActionCommand("Reportes");
        menuItemREntrenadoresExperiencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemREntrenadoresExperienciaActionPerformed(evt);
            }
        });
        menuReportes.add(menuItemREntrenadoresExperiencia);

        menuItemREstadiosMayorAudiencia.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        menuItemREstadiosMayorAudiencia.setIcon(new javax.swing.ImageIcon("src\\main\\java\\visual\\images\\report (1).png")); // NOI18N
        menuItemREstadiosMayorAudiencia.setText("Estadios con mayor audiencia");
        menuItemREstadiosMayorAudiencia.setActionCommand("Reportes");
        menuItemREstadiosMayorAudiencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemREstadiosMayorAudienciaActionPerformed(evt);
            }
        });
        menuReportes.add(menuItemREstadiosMayorAudiencia);

        menuItemREstadoEquipo.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        menuItemREstadoEquipo.setIcon(new javax.swing.ImageIcon("src\\main\\java\\visual\\images\\balon (1).png")); // NOI18N
        menuItemREstadoEquipo.setText("Estado de un equipo");
        menuItemREstadoEquipo.setActionCommand("Reportes");
        menuItemREstadoEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemREstadoEquipoActionPerformed(evt);
            }
        });
        menuReportes.add(menuItemREstadoEquipo);

        menuItemREquipoEstrella.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        menuItemREquipoEstrella.setIcon(new javax.swing.ImageIcon("src\\main\\java\\visual\\images\\Mejor (1).png")); // NOI18N
        menuItemREquipoEstrella.setText("Equipo todas estrellas");
        menuItemREquipoEstrella.setActionCommand("Reportes");
        menuItemREquipoEstrella.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemREquipoEstrellaActionPerformed(evt);
            }
        });
        menuReportes.add(menuItemREquipoEstrella);

        menuBar.add(menuReportes);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemCulminarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuItemCulminarActionPerformed
        menuItemIniciar.setEnabled(true);
        menuItemCulminar.setEnabled(false);
        ServicesLocator.getEquipoServices().reporteTablaPosiciones();
    }// GEN-LAST:event_menuItemCulminarActionPerformed

    private void menuItemCerrarSActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuItemCerrarSActionPerformed
        menuItemCerrarS.setEnabled(false);
        menuItemInicioS.setEnabled(true);
        menuGestion.setVisible(false);
        menuItemUsuarios.setVisible(false);
    }// GEN-LAST:event_menuItemCerrarSActionPerformed

    private void menuItemInicioSMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_menuItemInicioSMousePressed
        menuItemInicioS.setBackground(Color.GREEN);

    }// GEN-LAST:event_menuItemInicioSMousePressed

    private void menuItemCerrarSMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_menuItemCerrarSMousePressed
        menuItemInicioS.setBackground(Color.white);
    }// GEN-LAST:event_menuItemCerrarSMousePressed

    private void menuItemInicioSActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuItemInicioSActionPerformed
        rol = null;
        Login dialog = new Login(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        if (rol != null) {
            if (rol == Rol.gestor_liga) {
                menuGestion.setVisible(true);
                menuItemUsuarios.setVisible(false);
                menuGestion.setEnabled(true);
            } else {
                menuGestion.setVisible(false);
                menuItemUsuarios.setVisible(true);
            }
            menuItemInicioS.setEnabled(false);
            menuItemCerrarS.setEnabled(true);
        }
    }// GEN-LAST:event_menuItemInicioSActionPerformed

    private void menuItemUsuariosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuItemUsuariosActionPerformed
        CrudUsuario dialog = new CrudUsuario(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }// GEN-LAST:event_menuItemUsuariosActionPerformed

    private void menuItemEstadiosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuItemEstadiosActionPerformed
        CrudEstadio dialog = new CrudEstadio(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }// GEN-LAST:event_menuItemEstadiosActionPerformed

    private void menuItemRTablaPosicionesActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuItemRTablaPosicionesActionPerformed
        ServicesLocator.getEquipoServices().reporteTablaPosiciones();
    }// GEN-LAST:event_menuItemRTablaPosicionesActionPerformed

    private void menuItemEquiposActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuItemEquiposActionPerformed
        CrudEquipo dialog = new CrudEquipo(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }// GEN-LAST:event_menuItemEquiposActionPerformed

    private void menuItemPartidosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuItemPartidosActionPerformed
        CrudPartido dialog = new CrudPartido(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }// GEN-LAST:event_menuItemPartidosActionPerformed

    private void menuItemFutbolistasActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuItemFutbolistasActionPerformed
        CrudFutbolista dialog = new CrudFutbolista(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }// GEN-LAST:event_menuItemFutbolistasActionPerformed

    private void menuItemRPartidosEquiposActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuItemRPartidosEquiposActionPerformed
        RPartidosPorEquipos dialog = new RPartidosPorEquipos(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }// GEN-LAST:event_menuItemRPartidosEquiposActionPerformed

    private void menuItemRPartidosPorFechaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuItemRPartidosPorFechaActionPerformed
        RPartidosPorFecha dialog = new RPartidosPorFecha(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }// GEN-LAST:event_menuItemRPartidosPorFechaActionPerformed

    private void menuItemREntrenadoresExperienciaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuItemREntrenadoresExperienciaActionPerformed
        ServicesLocator.getEntrenadorServices().reporteEntrenadoresExp();
    }// GEN-LAST:event_menuItemREntrenadoresExperienciaActionPerformed

    private void menuItemREstadiosMayorAudienciaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuItemREstadiosMayorAudienciaActionPerformed
        ServicesLocator.getEstadioServices().reportePorcentajeAudiencia();
    }// GEN-LAST:event_menuItemREstadiosMayorAudienciaActionPerformed

    private void menuItemREstadoEquipoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuItemREstadoEquipoActionPerformed
        REstadoEquipo dialog = new REstadoEquipo(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }// GEN-LAST:event_menuItemREstadoEquipoActionPerformed

    private void menuItemREquipoEstrellaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuItemREquipoEstrellaActionPerformed
        ServicesLocator.getEquipoServices().reporteEquipoEstrella();
    }// GEN-LAST:event_menuItemREquipoEstrellaActionPerformed

    private void menuItemIniciarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuItemInicioActionPerformed
        DialogDuracionLiga dialog = new DialogDuracionLiga(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

        boolean activa = ServicesLocator.getIntervaloFServices().ligaActiva();
        menuItemIniciar.setEnabled(!activa);
        menuItemCulminar.setEnabled(activa);
        menuItemPartidos.setEnabled(activa);

    }// GEN-LAST:event_menuItemInicioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuGestion;
    private javax.swing.JMenuItem menuItemCerrarS;
    private javax.swing.JMenuItem menuItemCulminar;
    private javax.swing.JMenuItem menuItemEquipos;
    private javax.swing.JMenuItem menuItemEstadios;
    private javax.swing.JMenuItem menuItemFutbolistas;
    private javax.swing.JMenuItem menuItemIniciar;
    private javax.swing.JMenuItem menuItemInicioS;
    private javax.swing.JMenuItem menuItemPartidos;
    private javax.swing.JMenuItem menuItemREntrenadoresExperiencia;
    private javax.swing.JMenuItem menuItemREquipoEstrella;
    private javax.swing.JMenuItem menuItemREstadiosMayorAudiencia;
    private javax.swing.JMenuItem menuItemREstadoEquipo;
    private javax.swing.JMenuItem menuItemRPartidosEquipos;
    private javax.swing.JMenuItem menuItemRPartidosPorFecha;
    private javax.swing.JMenuItem menuItemRTablaPosiciones;
    private javax.swing.JMenuItem menuItemUsuarios;
    private javax.swing.JMenu menuPerfil;
    private javax.swing.JMenu menuReportes;
    // End of variables declaration//GEN-END:variables

    // método que usa un textField como parámetro y que recibirá solo numeros
    public static void soloNum(JTextField a) {
        a.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
    }

    // método que usa un textField como parámetro y que recibirá solo letras
    public static void soloLetras(JTextField a) {
        a.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isAlphabetic(c)) {
                    e.consume();
                }
            }
        });
    }

    public static void soloFloat(JTextField a) {
        a.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (c == '.') {
                    contP++;
                }

                if (!Character.isDigit(c) && (c != '.' || contP > 1)) {
                    e.consume();
                }
            }
        });
    }
}
