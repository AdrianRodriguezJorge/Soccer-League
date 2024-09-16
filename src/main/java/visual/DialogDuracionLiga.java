/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package visual;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

import services.ServicesLocator;

/**
 *
 * @author HP 11na
 */
public class DialogDuracionLiga extends javax.swing.JDialog {

    public DialogDuracionLiga(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        lblError.setVisible(false);
        lblErrorIni.setVisible(false);

        ArrayList<String> list = ServicesLocator.getEstadioServices().obtenerNombresEstadios();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelFechaInicio = new javax.swing.JLabel();
        jButtonIniciar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        DateChooserFechaInicio = new com.toedter.calendar.JDateChooser();
        DateChooserFechaFinal = new com.toedter.calendar.JDateChooser();
        jLabelFechaFinal = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();
        lblErrorIni = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(700, 250, 231, 231));
        setMinimumSize(new java.awt.Dimension(588, 231));
        setResizable(false);
        setSize(new java.awt.Dimension(588, 231));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelFechaInicio.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabelFechaInicio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelFechaInicio.setText("Fecha de inicio");
        getContentPane().add(jLabelFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 134, -1));

        jButtonIniciar.setBackground(new java.awt.Color(59, 122, 26));
        jButtonIniciar.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jButtonIniciar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonIniciar.setText("Comenzar liga");
        jButtonIniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, -1, 35));

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel1.setText("Fecha de la Temporada");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 220, -1));

        DateChooserFechaInicio.setDate(new Date());
        DateChooserFechaInicio.setDateFormatString("yyyy-MM-dd");
        DateChooserFechaInicio.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                DateChooserFechaInicioPropertyChange(evt);
            }
        });
        getContentPane().add(DateChooserFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 160, -1));

        DateChooserFechaFinal.setDateFormatString("yyyy-MM-dd");
        DateChooserFechaFinal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                DateChooserFechaFinalPropertyChange(evt);
            }
        });
        getContentPane().add(DateChooserFechaFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 160, -1));

        jLabelFechaFinal.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabelFechaFinal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelFechaFinal.setText("Fecha de culminación");
        getContentPane().add(jLabelFechaFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 133, 150, -1));

        lblError.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        lblError.setForeground(new java.awt.Color(204, 0, 51));
        lblError.setText("Ha ingresado incorrectamente una de las fechas o ha dejado un campo vacío");
        getContentPane().add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 167, 416, -1));

        lblErrorIni.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        lblErrorIni.setForeground(new java.awt.Color(204, 0, 51));
        lblErrorIni.setText("La fecha de inicio debe ser antes que la de culminación");
        getContentPane().add(lblErrorIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 189, 355, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\ALMACEN\\Proyectos Java\\New folder\\Liga\\src\\main\\java\\visual\\images\\5 (2).png")); // NOI18N
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 230));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarActionPerformed
        try {
            Date inicio = DateChooserFechaInicio.getDate();
            Date fin = DateChooserFechaFinal.getDate();

            if (fin.compareTo(inicio) > 0) {
                ServicesLocator.getIntervaloFServices().establecerIntervalo(inicio, fin);

                JOptionPane.showMessageDialog(null, "La Liga Nacional de Fútbol ha comenzado", "Atención", 1);

                // // ServicesLocator.getPartidoServices().limpiarPartidos(); // elimina todos los partidos anteriores registrados

                dispose();
            } else {
                lblErrorIni.setVisible(true);
            }
        } catch (Exception e) {
            lblError.setVisible(true);
        }
    }//GEN-LAST:event_jButtonIniciarActionPerformed

    private void DateChooserFechaInicioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_DateChooserFechaInicioPropertyChange
        lblError.setVisible(false);
        lblErrorIni.setVisible(false);
    }//GEN-LAST:event_DateChooserFechaInicioPropertyChange

    private void DateChooserFechaFinalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_DateChooserFechaFinalPropertyChange
        lblError.setVisible(false);
        lblErrorIni.setVisible(false);
    }//GEN-LAST:event_DateChooserFechaFinalPropertyChange

    /**
     * @param args the command line arguments
     */
    // public static void main(String args[]) {
    //     try {
    //         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
    //             if ("Nimbus".equals(info.getName())) {
    //                 javax.swing.UIManager.setLookAndFeel(info.getClassName());
    //                 break;
    //             }
    //         }
    //     } catch (ClassNotFoundException ex) {
    //         java.util.logging.Logger.getLogger(RPartidosEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (InstantiationException ex) {
    //         java.util.logging.Logger.getLogger(RPartidosEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (IllegalAccessException ex) {
    //         java.util.logging.Logger.getLogger(RPartidosEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    //         java.util.logging.Logger.getLogger(RPartidosEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     }
    //     //</editor-fold>
    //     /* Create and display the dialog */
    //     java.awt.EventQueue.invokeLater(new Runnable() {
    //         public void run() {
    //             RPartidosEquipos dialog = new RPartidosEquipos(new javax.swing.JFrame(), true);
    //             dialog.addWindowListener(new java.awt.event.WindowAdapter() {
    //                 @Override
    //                 public void windowClosing(java.awt.event.WindowEvent e) {
    //                     System.exit(0);
    //                 }
    //             });
    //             dialog.setVisible(true);
    //         }
    //     });
    // }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateChooserFechaFinal;
    private com.toedter.calendar.JDateChooser DateChooserFechaInicio;
    private javax.swing.JButton jButtonIniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelFechaFinal;
    private javax.swing.JLabel jLabelFechaInicio;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblErrorIni;
    // End of variables declaration//GEN-END:variables
}
