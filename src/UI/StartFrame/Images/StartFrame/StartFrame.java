import javax.swing.*;

public class StartFrame extends JFrame {

    private int WIDTH = 500;
    private int HEIGHT = 500;
    private JButton startButton;
    private JPanel startPanel;
    private JLabel welcomeLabel;
    private JLabel logoLabel;


    public StartFrame() {
        setContentPane(startPanel);
        setTitle("StartFrame");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createUIComponents() {
        logoLabel = new JLabel(new ImageIcon("Images/logotransparent2.png"));
    }
}