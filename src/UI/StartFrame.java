package UI; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.image.BufferedImage; 
import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StartFrame implements ActionListener {

    public static int WIDTH = 500;
    public static int HEIGHT = 500;

    public JFrame startFrame;
    // public ViewDeck viewDeck; 
    private JButton start; 
    // private ImageIcon imgIcon;
    // private Image img;  
    private JLabel startBackgroundLabel; 
    private BufferedImage startBackground; 
    private JPanel startPanel; 
    private SplashScreen splash; 
    
    // public class BackgroundImage extends JPanel { 
    //     Image Pic; 
    
    //     public BackgroundImage() { 
    //         ImageIcon obj = new ImageIcon("./stardBackground.png"); 
    //         Pic = obj.getImage(); 
    //     }
    
    //     public void paintComponent(Graphics g) { 
    //         super.paintComponent(g); 
    //         g.drawImage(Pic, 0, 0, null); 
    //     }
    // }

    public StartFrame() {
        initStartFrame(); 
    } 

    public void initStartFrame() {
        startFrame = new JFrame(); 
        // BackgroundImage Pic = new BackgroundImage(); 
        startPanel = new JPanel(new GridBagLayout());
        startFrame.add(startPanel); 
        
        // imgIcon = new ImageIcon("startBackground.png"); 
    
        startFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        startFrame.setSize(WIDTH, HEIGHT); 
        // startPanel.add(Pic); 
        initStartButtons(); 
        startFrame.setVisible(true); 

       // background image  
        try { 
            startBackground = ImageIO.read(new File("./startBackground.png"));
        } catch (IOException e) {
            e.printStackTrace(); 
        }
        startBackgroundLabel = new JLabel(new ImageIcon(startBackground));
        startBackgroundLabel.setLayout(new GridBagLayout());
        startBackgroundLabel.setBounds(0, 0, 500, 500);  

        startPanel.add(startBackgroundLabel); 
    }
    
    public void initStartButtons() { 
        start = new JButton("Begin customizing your deck");
        start.setSize(300, 300);
        start.addActionListener(this);
        startPanel.add(start); 
    } 

    public void actionPerformed(ActionEvent e) {
		// if (e.getSource() == start) {
        //     startFrame.setVisible(false); 
        //     viewDeck = new ViewDeck(); 
        //     viewDeck.viewDeck.setVisible(true); 
	    // }
    }
    
    // public void paintComponent(Graphics g) { 
    //     super.paintComponent(g); 
    //     g.drawImage(img, 0, 0, null); 
    // }
} 

