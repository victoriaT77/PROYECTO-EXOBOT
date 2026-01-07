package UserInterface.Form;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Container;

public class MainForm extends JFrame {
    MenuPanel pnlMenu = new MenuPanel();
    JPanel    pnlMain = new JPanel();

    public MainForm(String titleApp) {
        customizeComponents(titleApp);
        pnlMenu.btnHome.addActionListener(      e -> setPanel(new JPanel()));
        pnlMenu.btnLogin.addActionListener(     e -> setPanel(new JPanel()));
        pnlMenu.btnSexo.addActionListener(      e -> setPanel(new JPanel()));
        pnlMenu.btnLocalidad.addActionListener( e -> setPanel(new JPanel()));

        //agregar
        pnlMenu.btnTest.addActionListener(e -> {IAStyle.showMsgError("Mensaje de error");});
        
    }

    private void setPanel(JPanel FormularioPanel) {
        Container container = getContentPane();
        container.remove(pnlMain);
        pnlMain = FormularioPanel;
        container.add(pnlMain, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
    
    private void customizeComponents(String titleApp) {
        setTitle(titleApp);
        setSize(930, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //crear un contenedor para los dos paneles con BoderLayout
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        //Agregar los paneles al contenedor
        container.add(pnlMenu, BorderLayout.WEST);
        container.add(pnlMain, BorderLayout.CENTER);
        setVisible(true);
    }
}
