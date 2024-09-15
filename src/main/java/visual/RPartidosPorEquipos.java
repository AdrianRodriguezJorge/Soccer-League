/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package visual;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import services.EquipoServices;
import services.PartidoServices;
import services.ServicesLocator;

/**
 *
 * @author HP 11na
 */
public class RPartidosPorEquipos extends javax.swing.JDialog {

    /**
     * Creates new form RPartidosEquipos
     */
    public RPartidosPorEquipos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        ArrayList<String> list = ServicesLocator.getEquipoServices().obtenerNombresEquipos();

        for (String s : list) {
            ComboBoxEquipo1.addItem(s);
            ComboBoxEquipo2.addItem(s);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTit = new javax.swing.JLabel();
        ComboBoxEquipo1 = new javax.swing.JComboBox<>();
        jLabelEquipo1 = new javax.swing.JLabel();
        ComboBoxEquipo2 = new javax.swing.JComboBox<>();
        jLabelEquipo2 = new javax.swing.JLabel();
        jButtonGeneraR = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelTit.setText("Seleccione los equipos de los que desea ver los partidos jugados entre ellos:");

        ComboBoxEquipo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxEquipo1ActionPerformed(evt);
            }
        });

        jLabelEquipo1.setText("Equipo # 1");

        jLabelEquipo2.setText("Equipo # 2");

        jButtonGeneraR.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonGeneraR.setText("Generar Reporte");
        jButtonGeneraR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGeneraRActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelTit, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabelEquipo2)
                                                .addGap(18, 18, 18)
                                                .addComponent(ComboBoxEquipo2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabelEquipo1)
                                                .addGap(18, 18, 18)
                                                .addComponent(ComboBoxEquipo1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonGeneraR, javax.swing.GroupLayout.PREFERRED_SIZE, 141,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelTit, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelEquipo1)
                                        .addComponent(ComboBoxEquipo1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ComboBoxEquipo2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelEquipo2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52,
                                        Short.MAX_VALUE)
                                .addComponent(jButtonGeneraR, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboBoxEquipo1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ComboBoxEquipo1ActionPerformed
    }// GEN-LAST:event_ComboBoxEquipo1ActionPerformed

    private void jButtonGeneraRActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonGeneraRActionPerformed
        int contenidoComboBox1 = ComboBoxEquipo1.getSelectedIndex();
        int contenidoComboBox2 = ComboBoxEquipo2.getSelectedIndex();
        if (contenidoComboBox1 != contenidoComboBox2) {
            ServicesLocator.getPartidoServices().reportePartidosPorEquipos(contenidoComboBox1, contenidoComboBox2);

            dispose();
        } else
            JOptionPane.showMessageDialog(null, "Debe seleccionar 2 equipos diferentes.",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE);

    }// GEN-LAST:event_jButtonGeneraRActionPerformed

    /**
     * @param args the command line arguments
     */
    // public static void main(String args[]) {
    // try {
    // for (javax.swing.UIManager.LookAndFeelInfo info :
    // javax.swing.UIManager.getInstalledLookAndFeels()) {
    // if ("Nimbus".equals(info.getName())) {
    // javax.swing.UIManager.setLookAndFeel(info.getClassName());
    // break;
    // }
    // }
    // } catch (ClassNotFoundException ex) {
    // java.util.logging.Logger.getLogger(RPartidosPorEquipos.class.getName()).log(java.util.logging.Level.SEVERE,
    // null, ex);
    // } catch (InstantiationException ex) {
    // java.util.logging.Logger.getLogger(RPartidosPorEquipos.class.getName()).log(java.util.logging.Level.SEVERE,
    // null, ex);
    // } catch (IllegalAccessException ex) {
    // java.util.logging.Logger.getLogger(RPartidosPorEquipos.class.getName()).log(java.util.logging.Level.SEVERE,
    // null, ex);
    // } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    // java.util.logging.Logger.getLogger(RPartidosPorEquipos.class.getName()).log(java.util.logging.Level.SEVERE,
    // null, ex);
    // }
    // //</editor-fold>

    // /* Create and display the dialog */
    // java.awt.EventQueue.invokeLater(new Runnable() {
    // public void run() {
    // RPartidosPorEquipos dialog = new RPartidosPorEquipos(new
    // javax.swing.JFrame(), true);
    // dialog.addWindowListener(new java.awt.event.WindowAdapter() {
    // @Override
    // public void windowClosing(java.awt.event.WindowEvent e) {
    // System.exit(0);
    // }
    // });
    // dialog.setVisible(true);
    // }
    // });
    // }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxEquipo1;
    private javax.swing.JComboBox<String> ComboBoxEquipo2;
    private javax.swing.JButton jButtonGeneraR;
    private javax.swing.JLabel jLabelEquipo1;
    private javax.swing.JLabel jLabelEquipo2;
    private javax.swing.JLabel jLabelTit;
    // End of variables declaration//GEN-END:variables
}
