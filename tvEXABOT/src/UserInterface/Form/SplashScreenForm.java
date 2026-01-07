package UserInterface.Form;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import java.awt.BorderLayout;
public abstract class SplashScreenForm {
    private static JFrame frmSplash;
    private static JProgressBar prbLoanding;
    private static ImageIcon icoImagen;
    private static JLabel lblSplash;

    public static void show() {
        // Cargar imagen y componentes
        icoImagen = new ImageIcon("src/Resource/Images/EXOBOT.jpg");
        lblSplash = new JLabel(icoImagen);
        prbLoanding = new JProgressBar();
        prbLoanding.setStringPainted(true);

        // Crear ventana splash
        frmSplash = new JFrame();
        frmSplash.setUndecorated(true);
        frmSplash.setLayout(new BorderLayout());
        frmSplash.add(lblSplash, BorderLayout.CENTER);
        frmSplash.add(prbLoanding, BorderLayout.SOUTH);
        frmSplash.setSize(icoImagen.getIconWidth(), icoImagen.getIconHeight() + 30);
        frmSplash.setLocationRelativeTo(null);

        // Mostrar ventana antes del bucle
        frmSplash.setVisible(true);
        frmSplash.repaint(); // fuerza el pintado inicial

        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(50); // Simula tiempo de carga
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            prbLoanding.setValue(i);
        }

        // Cerrar splash al terminar
        frmSplash.setVisible(false);
        frmSplash.dispose();
    }
}