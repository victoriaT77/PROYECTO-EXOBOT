package UserInterface.Form;

import javax.swing.*;
import java.awt.*;

/**
 * Panel principal que se muestra al iniciar la aplicación.
 */
public class MainPanel extends JPanel {

    public MainPanel() {
        // Configuración básica del panel
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Crear un título de bienvenida
        JLabel lblTitulo = new JLabel("Bienvenido a la aplicación", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setForeground(new Color(50, 50, 150));

        // Crear un área de texto descriptiva
        JTextArea txtDescripcion = new JTextArea(
            "Este es el panel principal.\n\n" +
            "Desde aquí puedes navegar usando el menú lateral.\n" +
            "Selecciona una opción para cambiar de panel."
        );
        txtDescripcion.setEditable(false);
        txtDescripcion.setFont(new Font("Arial", Font.PLAIN, 14));
        txtDescripcion.setBackground(Color.WHITE);
        txtDescripcion.setMargin(new Insets(10, 10, 10, 10));

        // Agregar componentes al panel
        add(lblTitulo, BorderLayout.NORTH);
        add(txtDescripcion, BorderLayout.CENTER);
    }
}
