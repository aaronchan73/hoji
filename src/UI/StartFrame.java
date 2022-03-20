package UI;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class StartFrame implements ActionListener {

    public static int WIDTH = 500;
    public static int HEIGHT = 500;

    public JFrame startFrame;
    public JPanel startPanel;
    // public ViewDeck viewDeck;
    private JButton start;
    private BufferedImage startBackground;
    private JLabel startBackgroundLabel;
    private JLabel welcomeLabel;
    GridBagConstraints c = new GridBagConstraints();
    // private JLabel d;

    public StartFrame() {
        initStartFrame();
    }

    public void initStartFrame() {
        startFrame = new JFrame();
        initPanel();
        startFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        startFrame.setSize(WIDTH, HEIGHT);
        startFrame.getContentPane().setBackground(Color.DARK_GRAY);
        startFrame.add(startPanel);
        startFrame.setVisible(true);
        startPanel.setVisible(true);
        initStartButtons();
        initWelcomeLabel();

        try { // logo
            startBackground = ImageIO.read(new File("./logotransparent2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        startBackgroundLabel = new JLabel(new ImageIcon(startBackground));
        startBackgroundLabel.setBounds(0, 0, 500, 300);
        c.fill = GridBagConstraints.CENTER;
        c.gridx = 2;
        c.gridy = 1;
        startPanel.add(startBackgroundLabel, c);
    }

    public void initPanel() {
        startPanel = new JPanel();
        startPanel.setLayout(new GridBagLayout());
        startPanel.setBackground(new Color(52, 52, 52));
    }

    public void initStartButtons() {
        start = new JButton("Begin customizing your deck.");
        start.setSize(new Dimension(300, 300));
        start.addActionListener(this);
        c.fill = GridBagConstraints.CENTER;
        c.gridx = 2;
        c.gridy = 3;
        startPanel.add(start, c);
    }

    public void initWelcomeLabel() {
        welcomeLabel = new JLabel("Welcome!");
        welcomeLabel.setForeground(Color.WHITE);
        c.fill = GridBagConstraints.CENTER;
        c.gridx = 2;
        c.gridy = 2;
        startPanel.add(welcomeLabel, c);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start) {
           // startFrame.setVisible(false);
          //  viewDeck = new ViewDeck();
         //   viewDeck.viewDeck.setVisible(true);
        }
    }


}
