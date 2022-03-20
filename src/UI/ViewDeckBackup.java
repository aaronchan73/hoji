package UI;
import javax.swing.*;
import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Sections.*;

public class ViewDeckBackup implements ActionListener{
public JFrame frame;
public JPanel panel;
public JPanel topPanel;
public JPanel bottomPanel;
public JScrollPane scroll;
GridBagConstraints c = new GridBagConstraints();
public JButton deleteButton;
public JButton startButton;
public JButton addButton;
public DefaultListModel listModel;
public JList list;

public ViewDeckBackup(){
    initViewFrame();
}

public void initViewFrame(){
    frame = new JFrame();
    list = new JList();

    panel = new JPanel(new GridLayout(2,1));
    topPanel = new JPanel();
    bottomPanel = new JPanel();
    panel.add(topPanel);
    panel.add(bottomPanel);


    panel.setLayout(new GridBagLayout());
    panel.setBackground(new Color(52,52,52));
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setSize(500, 500);
    frame.setLocationRelativeTo(null);
    frame.getContentPane().setBackground(Color.DARK_GRAY);
    frame.add(panel);
    frame.setVisible(true);
    panel.setVisible(true);
    initList();
    initButtons();
}

public void initList(){
list = new JList();
scroll = new JScrollPane(list);
c.fill = GridBagConstraints.HORIZONTAL;
c.gridx = 0;
c.gridy = 0;
topPanel.add(scroll,BorderLayout.CENTER);
}

public void initButtons(){
    startButton = new JButton("Start Practicing!");
    startButton.setSize(new Dimension(300,300));
    startButton.addActionListener(this);
    c.anchor = GridBagConstraints.CENTER;
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 3;
    c.gridy = 2;
    bottomPanel.add(startButton,c);


    deleteButton = new JButton("Delete Card");
    deleteButton.setSize(new Dimension(300,300));
    deleteButton.addActionListener(this);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 2;
    bottomPanel.add(deleteButton,c);

    addButton = new JButton("Add New Cards");
    addButton.setSize(new Dimension(300,300));
    addButton.addActionListener(this);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 1;
    c.gridy = 2;
    bottomPanel.add(addButton,c);

}



}