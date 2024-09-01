
import java.awt.EventQueue;
import utils.ConnectionManager;
import visual.CrudEstadio;
import visual.Login;
import visual.Principal;

public class Main {

    public static void main(String[] args) {

//        CrudEstadio dialog = new CrudEstadio(new javax.swing.JFrame(), true);
//        dialog.setLocationRelativeTo(null);
//        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//            @Override
//            public void windowClosing(java.awt.event.WindowEvent e) {
//                System.exit(0);
//            }
//        });
//        dialog.setVisible(true);

    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                new Principal().setVisible(true);
                
//                Login frame = new Login();
//                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
    }
}
