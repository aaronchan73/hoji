package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import Sections.*;

public class MainFrame implements ActionListener {

    public JFrame mainFrame;
    public JPanel mainPanel;
    public Deck deck;

    private JButton correct;
    private JButton wrong;
    private JButton start;
    private JButton pause;
    public static int WIDTH = 500;
    public static int HEIGHT = 500;

    private PomoTimer pomo;


    public MainFrame() {
        initMainFrame();
        // initPomoTimer();
    }

    public void initMainFrame() {
        mainFrame = new JFrame();
        mainFrame.setSize(WIDTH, HEIGHT);
        mainPanel = new JPanel(new GridBagLayout());
        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        initMainButtons();
    }

    public void initMainButtons() {

        correct = new JButton("\u2713");
        // correct = new JButton("Correct");
        correct.setSize(new Dimension(300, 300));
        correct.addActionListener(this);
        mainPanel.add(correct);

        wrong = new JButton("\u2716");
        // wrong = new JButton("Wrong");
        wrong.setSize(new Dimension(300, 300));
        wrong.addActionListener(this);
        mainPanel.add(wrong);

        start = new JButton("Start");
        start.setSize(new Dimension(300, 300));
        start.addActionListener(this);
        mainPanel.add(start);

        pause = new JButton("Pause");
        pause.setSize(new Dimension(300, 300));
        pause.addActionListener(this);
        mainPanel.add(pause);

    }

    // public void initPomoTimer() {
    //     pomo = new PomoTimer();
    //     mainPanel.add(pomo);
    // }

    public void actionPerformed(ActionEvent e) {
        // if (e.getSource() == correct) {
        //     // deck.getNextCard();
        // } else if (e.getSource() == wrong) {
        //     // WRONG
        // } else if (e.getSource() == start) {
        //     pomo.startTimer();
        // } else if (e.getSource() == pause) {
        //     pomo.stopTimer();
        // }
    }

}
