/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visual;

import javax.swing.JFrame;
import services.EquipoServices;
import services.PartidoServices;
import services.ServicesLocator;

/**
 *
 * @author HP 11na
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        setSize(800, 600);
        setLocationRelativeTo(null);

        CrudPartido dialog = new CrudPartido(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        menuBar = new javax.swing.JMenuBar();
        menuGestion = new javax.swing.JMenu();
        menuItemEstadios = new javax.swing.JMenuItem();
        menuItemEquipos = new javax.swing.JMenuItem();
        menuItemPartidos = new javax.swing.JMenuItem();
        menuItemFutbolistas = new javax.swing.JMenuItem();
        menuItemPosJug = new javax.swing.JMenuItem();
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
        setBounds(new java.awt.Rectangle(0, 0, 800, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuGestion.setText("CRUDs");

        menuItemEstadios.setLabel("Estadios");
        menuItemEstadios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEstadiosActionPerformed(evt);
            }
        });
        menuGestion.add(menuItemEstadios);

        menuItemEquipos.setLabel("Equipos");
        menuItemEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEquiposActionPerformed(evt);
            }
        });
        menuGestion.add(menuItemEquipos);

        menuItemPartidos.setLabel("Partidos");
        menuItemPartidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPartidosActionPerformed(evt);
            }
        });
        menuGestion.add(menuItemPartidos);

        menuItemFutbolistas.setLabel("Futbolistas");
        menuItemFutbolistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemFutbolistasActionPerformed(evt);
            }
        });
        menuGestion.add(menuItemFutbolistas);

        menuItemPosJug.setText("Cambiar Pos. Jugador");
        menuGestion.add(menuItemPosJug);

        menuBar.add(menuGestion);

        menuReportes.setLabel("Reportes");

        menuItemRTablaPosiciones.setText("Tabla de posiciones de la liga");
        menuItemRTablaPosiciones.setActionCommand("Reportes");
        menuItemRTablaPosiciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRTablaPosicionesActionPerformed(evt);
            }
        });
        menuReportes.add(menuItemRTablaPosiciones);

        menuItemRPartidosEquipos.setText("Partidos por equipos");
        menuItemRPartidosEquipos.setActionCommand("Reportes");
        menuItemRPartidosEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRPartidosEquiposActionPerformed(evt);
            }
        });
        menuReportes.add(menuItemRPartidosEquipos);

        menuItemRPartidosPorFecha.setText("Partidos jugados por fecha");
        menuItemRPartidosPorFecha.setActionCommand("Reportes");
        menuItemRPartidosPorFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRPartidosPorFechaActionPerformed(evt);
            }
        });
        menuReportes.add(menuItemRPartidosPorFecha);

        menuItemREntrenadoresExperiencia.setText("Entrenadores con más experiencia");
        menuItemREntrenadoresExperiencia.setActionCommand("Reportes");
        menuItemREntrenadoresExperiencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemREntrenadoresExperienciaActionPerformed(evt);
            }
        });
        menuReportes.add(menuItemREntrenadoresExperiencia);

        menuItemREstadiosMayorAudiencia.setText("Estadios con mayor audiencia");
        menuItemREstadiosMayorAudiencia.setActionCommand("Reportes");
        menuItemREstadiosMayorAudiencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemREstadiosMayorAudienciaActionPerformed(evt);
            }
        });
        menuReportes.add(menuItemREstadiosMayorAudiencia);

        menuItemREstadoEquipo.setText("Estado de un equipo");
        menuItemREstadoEquipo.setActionCommand("Reportes");
        menuItemREstadoEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemREstadoEquipoActionPerformed(evt);
            }
        });
        menuReportes.add(menuItemREstadoEquipo);

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

    private void menuItemEstadiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEstadiosActionPerformed
        CrudEstadio dialog = new CrudEstadio(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_menuItemEstadiosActionPerformed

    private void menuItemRTablaPosicionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRTablaPosicionesActionPerformed
        ServicesLocator.getEquipoServices().reporteTablaPosiciones();
    }//GEN-LAST:event_menuItemRTablaPosicionesActionPerformed

    private void menuItemEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEquiposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItemEquiposActionPerformed

    private void menuItemPartidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPartidosActionPerformed
        CrudPartido dialog = new CrudPartido(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_menuItemPartidosActionPerformed

    private void menuItemFutbolistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemFutbolistasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItemFutbolistasActionPerformed

    private void menuItemRPartidosEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRPartidosEquiposActionPerformed
        RPartidosPorEquipos dialog = new RPartidosPorEquipos(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_menuItemRPartidosEquiposActionPerformed

    private void menuItemRPartidosPorFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRPartidosPorFechaActionPerformed
        RPartidosPorFecha dialog = new RPartidosPorFecha(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_menuItemRPartidosPorFechaActionPerformed

    private void menuItemREntrenadoresExperienciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemREntrenadoresExperienciaActionPerformed
        ServicesLocator.getEntrenadorServices().reporteEntrenadoresExp ();
    }//GEN-LAST:event_menuItemREntrenadoresExperienciaActionPerformed

    private void menuItemREstadiosMayorAudienciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemREstadiosMayorAudienciaActionPerformed
        ServicesLocator.getEstadioServices().reportePorcentajeAudiencia();
    }//GEN-LAST:event_menuItemREstadiosMayorAudienciaActionPerformed

    private void menuItemREstadoEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemREstadoEquipoActionPerformed
        REstadoEquipo dialog = new REstadoEquipo(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_menuItemREstadoEquipoActionPerformed

    private void menuItemREquipoEstrellaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemREquipoEstrellaActionPerformed
        ServicesLocator.getEquipoServices().reporteEquipoEstrella();
    }//GEN-LAST:event_menuItemREquipoEstrellaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuGestion;
    private javax.swing.JMenuItem menuItemEquipos;
    private javax.swing.JMenuItem menuItemEstadios;
    private javax.swing.JMenuItem menuItemFutbolistas;
    private javax.swing.JMenuItem menuItemPartidos;
    private javax.swing.JMenuItem menuItemPosJug;
    private javax.swing.JMenuItem menuItemREntrenadoresExperiencia;
    private javax.swing.JMenuItem menuItemREquipoEstrella;
    private javax.swing.JMenuItem menuItemREstadiosMayorAudiencia;
    private javax.swing.JMenuItem menuItemREstadoEquipo;
    private javax.swing.JMenuItem menuItemRPartidosEquipos;
    private javax.swing.JMenuItem menuItemRPartidosPorFecha;
    private javax.swing.JMenuItem menuItemRTablaPosiciones;
    private javax.swing.JMenu menuReportes;
    // End of variables declaration//GEN-END:variables
}
