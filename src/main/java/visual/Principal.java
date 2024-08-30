package visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ventana principal de la aplicación.
 * Contiene el menú para acceder a todas las funcionalidades.
 */
public class Principal extends JFrame {
    private JMenuBar menuBar;
    private JMenu menuGestion;
    private JMenu menuReportes;
    private JMenuItem menuItemEquipos;
    private JMenuItem menuItemEstadios;
    private JMenuItem menuItemPartidos;
    private JMenuItem menuItemFutbolistas;
    private JMenuItem menuItemReportes;

    public Principal() {
        setTitle("Sistema de Gestión de la Liga Nacional de Fútbol");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initializeComponents();
    }

    /**
     * Inicializa los componentes de la ventana principal.
     */
    private void initializeComponents() {
        menuBar = new JMenuBar();
        menuGestion = new JMenu("Gestión");
        menuReportes = new JMenu("Reportes");

        menuItemEquipos = new JMenuItem("Equipos");
        menuItemEstadios = new JMenuItem("Estadios");
        menuItemPartidos = new JMenuItem("Partidos");
        menuItemFutbolistas = new JMenuItem("Futbolistas");
        menuItemReportes = new JMenuItem("Generar Reportes");

        // Agregar ActionListener para abrir cada ventana de gestión
        menuItemEquipos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                new CrudEquipo().setVisible(true);
            }
        });

        menuItemEstadios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CrudEstadio dialog = new CrudEstadio(new javax.swing.JFrame(), true);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
        });

        menuItemPartidos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                new CrudPartido().setVisible(true);
            }
        });

        menuItemFutbolistas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // new FutbolistaFrame().setVisible(true);
            }
        });

        menuItemReportes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // new ReportesFrame().setVisible(true);
            }
        });

        menuGestion.add(menuItemEquipos);
        menuGestion.add(menuItemEstadios);
        menuGestion.add(menuItemPartidos);
        menuGestion.add(menuItemFutbolistas);
        menuReportes.add(menuItemReportes);

        menuBar.add(menuGestion);
        menuBar.add(menuReportes);
        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Principal frame = new Principal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
