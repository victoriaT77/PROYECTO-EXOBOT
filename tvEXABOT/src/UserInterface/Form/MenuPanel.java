package UserInterface.Form;

import javax.swing.*;
import java.awt.*;

/**
 * Panel lateral de menú con botones de navegación.
 */
public class MenuPanel extends JPanel {
    // Botones accesibles desde MainForm
    public JButton btnHome;
    public JButton btnLogin;
    public JButton btnSexo;
    public JButton btnLocalidad;
    public JButton btnTest;

    public MenuPanel() {
        // Configuración del layout: botones en columna
        setLayout(new GridLayout(5, 1, 10, 10)); // 5 filas, 1 columna, espacio entre botones
        setPreferredSize(new Dimension(150, 600)); // ancho fijo para el menú lateral
        setBackground(new Color(230, 230, 250));   // color suave de fondo

        // Inicializar botones
        btnHome      = new JButton("Home");
        btnLogin     = new JButton("Login");
        btnSexo      = new JButton("Sexo");
        btnLocalidad = new JButton("Localidad");
        btnTest      = new JButton("Test");

        // Personalizar estilo de los botones
        customizeButton(btnHome);
        customizeButton(btnLogin);
        customizeButton(btnSexo);
        customizeButton(btnLocalidad);
        customizeButton(btnTest);

        // Agregar botones al panel
        add(btnHome);
        add(btnLogin);
        add(btnSexo);
        add(btnLocalidad);
        add(btnTest);
    }

    /**
     * Método auxiliar para dar estilo uniforme a los botones.
     */
    private void customizeButton(JButton button) {
        button.setFocusPainted(false); // quita el borde de enfoque
        button.setBackground(new Color(200, 200, 255));
        button.setFont(new Font("Arial", Font.BOLD, 14));
    }
}