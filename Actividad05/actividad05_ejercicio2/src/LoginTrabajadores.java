import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LoginTrabajadores {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginFrame::new);
    }
}

class LoginFrame extends JFrame {
    private JTextField usuarioTextField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel errorDatosLabel;
    private JLabel errorCredencialesLabel;

    public LoginFrame() {
        
        setTitle("Login");
        setSize(500, 350); // Aumenta el tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        add(panelPrincipal);

        // Agrega un nuevo JLabel para mostrar el texto "LOGIN" en negrita
        JLabel loginLabel = new JLabel("LOGIN");
        loginLabel.setFont(new Font("Arial", Font.BOLD, 12));
        loginLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Centra los elementos en el medio de la ventana
        JPanel usuarioPanel = new JPanel();
        usuarioPanel.setBorder(new EmptyBorder(0, 0, -30, 0)); // Agrega un borde vacío con margen inferior ajustado
        usuarioPanel.add(new JLabel("Usuario:"));
        usuarioTextField = new JTextField(20);
        usuarioPanel.add(usuarioTextField);


        //PANEL PARA CONTRASEÑA
        JPanel passwordPanel = new JPanel();
        passwordPanel.setBorder(new EmptyBorder(0, 0, 0, 0)); // Agrega un borde vacío con margen inferior ajustado
        passwordPanel.add(new JLabel("Contraseña:"));
        passwordField = new JPasswordField(20);
        passwordPanel.add(passwordField);

        //BOTON LOGIN
        JPanel buttonPanel = new JPanel();
        loginButton = new JButton("Login");
        loginButton.addActionListener(new LoginButtonListener());
        buttonPanel.add(loginButton);

        //EN CASO DE DEJARLO VACIO
        errorDatosLabel = new JLabel("DEBES INTRODUCIR LOS DATOS");
        errorDatosLabel.setForeground(Color.RED);
        errorDatosLabel.setVisible(false);
        errorDatosLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // EN CASO DE CREDENCIALES INCORRECTAS
        errorCredencialesLabel = new JLabel("CREDENCIALES INCORRECTAS");
        errorCredencialesLabel.setForeground(Color.RED);
        errorCredencialesLabel.setVisible(false);
        errorCredencialesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        //ORGANIZACION DE LA INTERFAZ
        panelPrincipal.add(Box.createVerticalGlue());
        panelPrincipal.add(loginLabel);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));
        panelPrincipal.add(usuarioPanel);
        panelPrincipal.add(passwordPanel);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));
        panelPrincipal.add(buttonPanel);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));
        panelPrincipal.add(errorDatosLabel);
        panelPrincipal.add(errorCredencialesLabel);
        panelPrincipal.add(Box.createVerticalGlue());

        setVisible(true);
    }

    //LISTNENER DEL BOTON LOGIN
    private class LoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String usuario = usuarioTextField.getText();
            char[] password = passwordField.getPassword();

            if (usuario.isEmpty() || password.length == 0) {
                errorDatosLabel.setVisible(true);
                errorCredencialesLabel.setVisible(false);
            } else {
                try {
                    BufferedReader reader; 
                    reader = new BufferedReader(new FileReader("datos_login.txt"));
                    String userFromFile = reader.readLine();
                    String passwordFromFile = reader.readLine();
                    reader.close();
                    if (usuario.equals(userFromFile) && String.valueOf(password).equals(passwordFromFile)) {
                        errorDatosLabel.setVisible(false);
                        errorCredencialesLabel.setVisible(false);
                        new TrabajadoresFrame(usuario);
                        dispose();
                    } else {
                        errorDatosLabel.setVisible(false);
                        errorCredencialesLabel.setVisible(true);
                    }

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }
}
