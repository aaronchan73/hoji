package UI;

import javax.swing.*;
import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Sections.*;

public class AddCard implements ActionListener {
    public JFrame frame;
    public JFrame errorFrame;
    public JPanel panel;
    GridBagConstraints c = new GridBagConstraints();
    private JButton addButton;
    private JButton startButton;
    private JTextField questionField;
    private JTextField answerField;
    private JComboBox level;
    private JLabel questionLabel;
    private JLabel answerLabel;
    Deck deck = new Deck();

    public AddCard() {
        initNewCardFrame();
        deck.addCard(new Card("hi","bye",1));
        deck.addCard(new Card("see","you",2));
        deck.addCard(new Card("lol","lel", 3));
        deck.addCard(new Card("test","test",1));
        deck.addCard(new Card("yum","yum",2));
        deck.addCard(new Card("haha","hahah", 3));
        
    }

    public void initPanel() {
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(52, 52, 52));

    }

    public void initNewCardFrame() {
        frame = new JFrame();
        initPanel();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.add(panel);
        frame.setVisible(true);
        panel.setVisible(true);
        errorFrame = new JFrame();
        initTextFields();
        initDropDown();
        initNewCardButtons();
        initLabels();
    }

    public void initNewCardButtons() {
        addButton = new JButton("Add FlashCard");
        addButton.setSize(new Dimension(300, 300));
        addButton.addActionListener(this);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        panel.add(addButton, c); 

        startButton = new JButton("Back");
        startButton.setSize(new Dimension(300, 300));
        startButton.addActionListener(this);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 2;
        panel.add(startButton, c); 
    }

    public void initTextFields() {
        questionField = new JTextField(20);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        panel.add(questionField, c);

        answerField = new JTextField(20);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        panel.add(answerField, c);

        questionField.setText(null);
        answerField.setText(null);
    }

    public void initDropDown() {
        String[] levels = { "Easy", "Medium", "Hard" };
        level = new JComboBox(levels);
        level.setSelectedIndex(2);
        level.addActionListener(this);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        panel.add(level, c);
    }

    public void initLabels() {
        questionLabel = new JLabel("Question:");
        // questionLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        questionLabel.setForeground(Color.WHITE);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        panel.add(questionLabel, c);

        answerLabel = new JLabel("Answer: ");
        // answerLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        answerLabel.setForeground(Color.WHITE);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        panel.add(answerLabel, c);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            checkTextFields();
            if (!questionField.getText().isEmpty() && !answerField.getText().isEmpty()) {
                addNewCard();
            }
        }
        if(e.getSource() == startButton){
            frame.setVisible(false);
            
        } 
    }
    // public void addButtonAction(){
    // addButton.addActionListener(new ActionListener(){
    // @Override
    // public void actionPerformed(ActionEvent e) {
    // //checkTextFields();
    // addNewCard();
    // }

    // });
    // }

    private void errorWindow(String string) {
        JOptionPane.showMessageDialog(errorFrame, string);
    }

    private void checkTextFields() {
        String question = questionField.getText();
        String answer = answerField.getText();
        if (question.length() == 0) {
            errorWindow("Please enter a valid question!");
        } else if (answer.length() == 0) {
            errorWindow("Please enter a valid answer!");
        } else if (question.length() == 0 && answer.length() == 0) {
            errorWindow("No question or answer entered!");
        }
    }

    private void addNewCard() {
        int levelNum = 0;
        if (level.getSelectedItem() == "Easy") {
            levelNum = 1;
        }
        if (level.getSelectedItem() == "Medium") {
            levelNum = 2;
        }
        if (level.getSelectedItem() == "Hard") {
            levelNum = 3;
        }
        Card card = new Card(questionField.getText(), answerField.getText(), levelNum);
        deck.addCard(card);
        // for (int i = 0; i < deck.getDeckCount(); i++) {
        //     System.out.println(deck.getCard(i));
        // }
         questionField.setText("");
         answerField.setText("");
    }

}
