import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

 class TrabajadoresFrame extends JFrame {
    private JTextField nombreTrabajadorTextField;
    private JComboBox<String> franjaEdadComboBox;
    private JRadioButton sexoMasculinoRadioButton;
    private JRadioButton sexoFemeninoRadioButton;
    private JCheckBox[] aficionesCheckBoxes;
    private JButton nuevoEmpleadoButton;
    private JButton mostrarEmpleadosButton;
    public ButtonGroup sexoButtonGroup;

    public TrabajadoresFrame(String usuario) {
        setTitle("Trabajadores");
        setSize(600, 600); // Aumenta el tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        add(panelPrincipal);

        // Agrega un nuevo JLabel para mostrar el texto "Bienvenido (usuario logeado)" en negrita
        JLabel bienvenidoLabel = new JLabel("Bienvenido " + usuario);
        bienvenidoLabel.setFont(new Font("Arial", Font.BOLD, 24));
        bienvenidoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // AGREGA PANEL DEL NOMBRE DEL TRABAJADOR
        JPanel nombreTrabajadorPanel = new JPanel();
        nombreTrabajadorPanel.add(new JLabel("Nombre del trabajador:"));
        nombreTrabajadorTextField = new JTextField(20);
        nombreTrabajadorPanel.add(nombreTrabajadorTextField);

        //PANEL DE AFICCIONES
        JPanel aficionesPanel = new JPanel();
        aficionesPanel.add(new JLabel("Aficiones:"));
        String[] aficiones = {"Cine", "Deportes", "Lectura", "Música", "Viajes"};
        aficionesCheckBoxes = new JCheckBox[aficiones.length];
        for (int i = 0; i < aficiones.length; i++) {
            aficionesCheckBoxes[i] = new JCheckBox(aficiones[i]);
            aficionesPanel.add(aficionesCheckBoxes[i]);
        }

        //PANEL DE FRANJA DE EDAD
        JPanel franjaEdadPanel = new JPanel();
        franjaEdadPanel.add(new JLabel("Franja de edad:"));
        String[] franjasEdad = {"10-15", "15-20", "20-25", "25-30", "30-35", "35-40"};
        franjaEdadComboBox = new JComboBox<>(franjasEdad);
        franjaEdadPanel.add(franjaEdadComboBox);

        //PANEL DEL SEXO
        JPanel sexoPanel = new JPanel();
        sexoPanel.add(new JLabel("Sexo:"));
        sexoMasculinoRadioButton = new JRadioButton("Masculino");
        sexoFemeninoRadioButton = new JRadioButton("Femenino");
        sexoButtonGroup = new ButtonGroup();
        sexoButtonGroup.add(sexoMasculinoRadioButton);
        sexoButtonGroup.add(sexoFemeninoRadioButton);
        sexoPanel.add(sexoMasculinoRadioButton);
        sexoPanel.add(sexoFemeninoRadioButton);

        // Ajusta la posición de los botones
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        buttonsPanel.add(Box.createHorizontalGlue());
        nuevoEmpleadoButton = new JButton("Nuevo Empleado");
        nuevoEmpleadoButton.addActionListener(new nuevoEmpleadoButton());
        buttonsPanel.add(nuevoEmpleadoButton);

        buttonsPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        mostrarEmpleadosButton = new JButton("Mostrar Empleados");
        mostrarEmpleadosButton.addActionListener(new mostrarEmpleadosButton());
        buttonsPanel.add(mostrarEmpleadosButton);
        buttonsPanel.add(Box.createHorizontalGlue());

        

        // Centra los elementos en el medio de la ventana
        panelPrincipal.add(Box.createVerticalGlue());
        panelPrincipal.add(bienvenidoLabel);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));
        panelPrincipal.add(nombreTrabajadorPanel);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));
        panelPrincipal.add(aficionesPanel);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));
        panelPrincipal.add(franjaEdadPanel);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));
        panelPrincipal.add(sexoPanel);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));
        panelPrincipal.add(buttonsPanel);
        panelPrincipal.add(Box.createVerticalGlue());

        setVisible(true);
    }

    //LISTENER DEL BOTON NUEVO EMPLEADO
    private class nuevoEmpleadoButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombreTrabajador = nombreTrabajadorTextField.getText();
            String franjaEdad = (String) franjaEdadComboBox.getSelectedItem();
            String sexo = sexoMasculinoRadioButton.isSelected() ? "Hombre" : sexoFemeninoRadioButton.isSelected() ? "Mujer" : "";
            ArrayList<String> aficiones = new ArrayList<>();

            for (JCheckBox checkBox : aficionesCheckBoxes) {
                if (checkBox.isSelected()) {
                    aficiones.add(checkBox.getText());
                }
            }
            if (nombreTrabajador.isEmpty() || sexo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
            } else {
                ArrayList<Empleado> empleados = new ArrayList<>();
                String empleadosFileName = "datos_empleados";

                try {
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(empleadosFileName));
                    empleados = (ArrayList<Empleado>) ois.readObject();
                    ois.close();
                } catch (FileNotFoundException ex) {
                    System.out.println("Archivo de empleados no encontrado. Creando uno nuevo...");
                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }

                Empleado nuevoEmpleado = new Empleado(nombreTrabajador, sexo, franjaEdad, aficiones);
                empleados.add(nuevoEmpleado);

                try {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(empleadosFileName));
                    oos.writeObject(empleados);
                    oos.close();
                    JOptionPane.showMessageDialog(null, "Gracias por usar la aplicación");
                    nombreTrabajadorTextField.setText("");
                    franjaEdadComboBox.setSelectedIndex(0);
                    sexoButtonGroup.clearSelection();
                    for (JCheckBox checkBox : aficionesCheckBoxes) {
                        checkBox.setSelected(false);
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }

    //LISTENER DE MOSTRAR EMPLEADOS
    private class mostrarEmpleadosButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Empleado> empleados = new ArrayList<>();
            String empleadosFileName = "datos_empleados";

            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(empleadosFileName));
                empleados = (ArrayList<Empleado>) ois.readObject();
                ois.close();
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "No hay empleados guardados.");
                return;
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }

            if (!empleados.isEmpty()) {
                StringBuilder empleadosInfo = new StringBuilder();
                for (Empleado empleado : empleados) {
                    empleadosInfo.append("Nombre: ").append(empleado.getNombre()).append("\n");
                    empleadosInfo.append("Sexo: ").append(empleado.getSexo()).append("\n");
                    empleadosInfo.append("Franja de edad: ").append(empleado.getFranjaEdad()).append("\n");
                    empleadosInfo.append("Aficiones: ").append(String.join(", ", empleado.getAficiones()))
                            .append("\n\n");
                }

                JTextArea empleadosTextArea = new JTextArea(empleadosInfo.toString());
                empleadosTextArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(empleadosTextArea);
                scrollPane.setPreferredSize(new Dimension(400, 300));
                JOptionPane.showMessageDialog(null, scrollPane, "Lista de Empleados", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No hay empleados guardados.");
            }
        }
    }
}
