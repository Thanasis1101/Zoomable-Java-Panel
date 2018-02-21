package zoomable.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author Thanasis1101
 * @version 1.0
 */
public class MainFrame extends JFrame {

    private MainPanel mainPanel;
    private JLabel infoLabel;

    public MainFrame() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setTitle("Zoomable Panel");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        try {

            // Load the image that will be shown in the panel
            BufferedImage image = ImageIO.read(new File("map.jpg"));
            
            mainPanel = new MainPanel(image);
            mainPanel.setBounds(50, 50, width - 100, height - 240);
            mainPanel.setBorder(BorderFactory.createLineBorder(Color.black));
            this.add(mainPanel);
            mainPanel.setVisible(true);

        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        infoLabel = new JLabel("Roll to zoom. Click and drag to move.", JLabel.CENTER);
        infoLabel.setFont(new Font(infoLabel.getFont().getFontName(), Font.PLAIN, 26));
        infoLabel.setBounds(50, height - 180, width - 100, 80);
        this.add(infoLabel);
        infoLabel.setVisible(true);

    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame myFrame = new MainFrame();
                myFrame.setVisible(true);
            }
        });
    }
}
