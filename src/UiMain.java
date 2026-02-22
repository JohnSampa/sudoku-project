import br.com.dio.ui.custom.frame.MainFrame;
import br.com.dio.ui.custom.panel.MainPanel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;


public class UiMain {

    public static void main(String[] args) {

        Dimension dimension = new Dimension(600, 600);
        JPanel mainPanel = new MainPanel(dimension);
        JFrame mainFrame = new MainFrame(dimension,mainPanel);

        mainFrame.revalidate();
        mainFrame.repaint();
    }
}
