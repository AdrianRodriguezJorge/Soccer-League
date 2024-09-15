
import java.awt.EventQueue;

import model.Defensa;
import model.Delantero;
import model.Entrenador;
import model.Mediocampista;
import model.Portero;
import services.ServicesLocator;
import utils.ConnectionManager;
import visual.CrudEquipo;
import visual.CrudEstadio;
import visual.CrudFutbolista;
import visual.CrudPartido;
import visual.Login;
import visual.Principal;

public class Main {

    public static void main(String[] args) {

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
