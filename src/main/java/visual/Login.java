package visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ventana de inicio de sesión para la aplicación.
 */
public class Login extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;

    public Login() {
        setTitle("Inicio de Sesión");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initializeComponents();
    }

    /**
     * Inicializa los componentes de la ventana de inicio de sesión.
     */
    private void initializeComponents() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblUsername = new JLabel("Usuario:");
        JLabel lblPassword = new JLabel("Contraseña:");

        txtUsername = new JTextField();
        txtPassword = new JPasswordField();

        btnLogin = new JButton("Iniciar Sesión");

        // Agregar ActionListener para manejar el inicio de sesión
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());
                // Validar credenciales
                if (validarCredenciales(username, password)) {
                    new Principal().setVisible(true);
                    dispose(); // Cierra la ventana de inicio de sesión
                } else {
                    JOptionPane.showMessageDialog(Login.this, "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(new JLabel()); // Espacio en blanco
        panel.add(btnLogin);

        add(panel);
    }

    /**
     * Método para validar las credenciales del usuario.
     * @param username Nombre de usuario
     * @param password Contraseña
     * @return true si las credenciales son válidas, false en caso contrario
     */
    private boolean validarCredenciales(String username, String password) {
        // Implementación de validación de usuario (por ejemplo, comparar con una base de datos)
        return username.equals("admin") && password.equals("admin"); // Ejemplo simple
    }

    public static void main(String[] args) {
        
    }
}
