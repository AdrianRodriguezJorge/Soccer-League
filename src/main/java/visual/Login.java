// package visual;

// // import services.LoginServices;
// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// /**
//  * Formulario de inicio de sesión para autenticar usuarios.
//  */
// public class Login extends JFrame {
//     private JTextField userField;
//     private JPasswordField passField;
//     private JButton loginButton;

//     public Login () {
//         setTitle("Inicio de Sesión");
//         setSize(300, 150);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLocationRelativeTo(null);

//         JPanel panel = new JPanel();
//         panel.setLayout(new GridLayout(3, 2));

//         JLabel userLabel = new JLabel("Usuario:");
//         userField = new JTextField();

//         JLabel passLabel = new JLabel("Contraseña:");
//         passField = new JPasswordField();

//         loginButton = new JButton("Iniciar Sesión");
//         loginButton.addActionListener(new LoginButtonListener());

//         panel.add(userLabel);
//         panel.add(userField);
//         panel.add(passLabel);
//         panel.add(passField);
//         panel.add(new JLabel());
//         panel.add(loginButton);

//         add(panel);
//     }

//     private class LoginButtonListener implements ActionListener {
//         @Override
//         public void actionPerformed(ActionEvent e) {
//             String username = userField.getText();
//             String password = new String(passField.getPassword());

//             if (LoginServices.authenticateUser
