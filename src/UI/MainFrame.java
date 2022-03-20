package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Sections.*;
import java.io.IOException;

public class MainFrame implements ActionListener {

    public JFrame mainFrame;
    public JPanel mainPanel;

    private JPanel buttonPanel;
    private JButton showAnswer;
    private JButton correct;
    private JButton wrong;
    private JButton start;
    private JButton add;
    public static int WIDTH = 500;
    public static int HEIGHT = 500;

    private PomoTimer pomo;
    private JLabel pomoLabel;

    private JPanel qaPanel;
    private JLabel question;
    String questionString;
    private JLabel answer;
    String answerString;

    private Deck loadedDeck;
    private Card card;

    AddCard addCard;

    public MainFrame() {
        initMainFrame();
        initQA();
        initAddCard();
        initPomoTimer();
        initMainButtons();
    }

    public void initMainFrame() {
        mainFrame = new JFrame();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setBackground(new Color(52,52,52));
        mainFrame.setSize(WIDTH, HEIGHT);
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1));
        mainPanel.setBackground(new Color(52,52,52));
        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void initQA() {
        qaPanel = new JPanel();
        qaPanel.setLayout(new GridLayout(2, 1));
        qaPanel.setBackground(new Color(52,52,52));
        question = new JLabel(questionString);
        question.setForeground(Color.WHITE);
        answer = new JLabel(answerString);
        answer.setForeground(Color.WHITE);
        question.setHorizontalAlignment(JLabel.CENTER);
        answer.setHorizontalAlignment(JLabel.CENTER);
        qaPanel.add(question);
        qaPanel.add(answer);
        answer.setVisible(true);
        mainPanel.add(qaPanel); 
    }

    public void initAddCard() {
        card = new Card("Questions show up here!", "Click the checkmark to begin!", 1);
        question.setText(card.getQuestion());
        question.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        answer.setText(card.getAnswer());
        answer.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        addCard = new AddCard();
        addCard.frame.setVisible(false);
    }

    public void setQuestion(String question) {
        questionString = question;
    }

    public void setAnswer(String answer) {
        answerString = answer;
    }

    public void initMainButtons() {

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setBackground(new Color(52,52,52));
        buttonPanel.setForeground(Color.WHITE); 

        showAnswer = new JButton("\u003D");
        showAnswer.setBackground(new Color(200,200,200));
        showAnswer.setForeground(new Color(45,35,66));
        showAnswer.setSize(new Dimension(300, 300));
        showAnswer.addActionListener(this);
        buttonPanel.add(showAnswer); 

        correct = new JButton("\u2713");
        correct.setSize(new Dimension(300, 300));
        correct.addActionListener(this);
        buttonPanel.add(correct);

        wrong = new JButton("\u2717");
        wrong.setSize(new Dimension(300, 300));
        wrong.addActionListener(this);
        buttonPanel.add(wrong);

        start = new JButton("\u25B6");
        start.setSize(new Dimension(300, 300));
        start.addActionListener(this);
        buttonPanel.add(start);

        add = new JButton("\u002B");
        add.setSize(new Dimension(300, 300));
        add.addActionListener(this);
        buttonPanel.add(add);

        mainPanel.add(buttonPanel);
    }

    public void initPomoTimer() {
        pomo = new PomoTimer();
        pomoLabel = pomo.label;
        pomoLabel.setHorizontalAlignment(JLabel.CENTER);
        pomoLabel.setForeground(Color.WHITE);
        mainPanel.add(pomoLabel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == correct) {

            if (addCard.deck.getDeckCount() == 1 || addCard.deck.getDeckCount() == 1 ) {
                question.setText("Congratulations! You have completed all the cards in this deck");
                answer.setText("Add more cards by pressing + symbol");
            }

            addCard.deck.removeCard(card);
            card = addCard.deck.getNextCard();
            questionString = card.getQuestion();
            answerString = card.getAnswer();
            question.setText(questionString);
            answer.setText(answerString);
            answer.setVisible(false);
        } else if (e.getSource() == wrong) {
            card = addCard.deck.getNextCard();
            questionString = card.getQuestion();
            answerString = card.getAnswer();
            question.setText(questionString);
            answer.setText(answerString);
            answer.setVisible(false); 
        } else if (e.getSource() == showAnswer) {
            answer.setVisible(true);
        } else if (e.getSource() == start) {
            pomo.startTimer();
        } else if (e.getSource() == add) {
            mainFrame.setVisible(true);
            addCard.frame.setVisible(true);
        }
    }

}
