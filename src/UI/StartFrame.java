package UI; 
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class StartFrame implements ActionListener {

    public static int WIDTH = 500;
    public static int HEIGHT = 500;

    public JFrame startFrame;
    //public ViewDeck viewDeck; 
    private JButton start; 
    private BufferedImage startBackground; 
    private JLabel startBackgroundLabel; 
    

    public StartFrame() {
        initStartFrame(); 
    } 

    public void initStartFrame() {
        startFrame = new JFrame();
        startFrame.setVisible(true);
        startFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        startFrame.setSize(WIDTH, HEIGHT); 
        //initStartButtons(); 

        try { // background image 
            startBackground = ImageIO.read(new File("./startBackground.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        startBackgroundLabel = new JLabel(new ImageIcon(startBackground));
        startBackgroundLabel.setBounds(0, 0, 500, 500); 
    }
    
    public void initStartButtons() { 
        start = new JButton("Begin customizing your deck");
        start.setSize(new Dimension(300, 300));
        start.addActionListener(this);
        startFrame.add(start); 
    } 

    public void actionPerformed(ActionEvent e) {
		// if (e.getSource() == start) {
        //     startFrame.setVisible(false); 
        //     viewDeck = new ViewDeck(); 
        //     viewDeck.viewDeck.setVisible(true); 
	    // }
    }


}
