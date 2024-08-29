
import utils.DBManager;
import visual.CrudEstadio;

public class Main {

    public static void main(String[] args) {

        CrudEstadio dialog = new CrudEstadio(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        dialog.setVisible(true);
    }
}
