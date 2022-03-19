package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Sections.*;
import org.json.JSONArray;
import org.json.JSONObject;
import JSON.*;
import java.io.IOException;

public class MainFrame implements ActionListener {

    public JFrame mainFrame;
    public JPanel mainPanel;

    private JPanel buttonPanel;
    private JButton showAnswer;
    private JButton correct;
    private JButton wrong;
    private JButton start;
    private JButton pause;
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
    private static final String JSON_Save = "./data/data.json";
    JsonWriter jsonWriter = new JsonWriter(JSON_Save);
    JsonReader jsonReader = new JsonReader(JSON_Save);

    public MainFrame() {
        initMainFrame();
        initQA();
        initPomoTimer();
        initMainButtons();
    }

    public void initMainFrame() {
        loadDeck();
        mainFrame = new JFrame();
        mainFrame.setSize(WIDTH, HEIGHT);
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1));
        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void initQA() {
        qaPanel = new JPanel();
        qaPanel.setLayout(new GridLayout(2, 1));
        question = new JLabel(questionString);
        answer = new JLabel(answerString);
        question.setHorizontalAlignment(JLabel.CENTER);
        answer.setHorizontalAlignment(JLabel.CENTER);
        qaPanel.add(question);
        qaPanel.add(answer);
        answer.setVisible(false);
        mainPanel.add(qaPanel);
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

        showAnswer = new JButton("Answer");
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

        start = new JButton("Start");
        start.setSize(new Dimension(300, 300));
        start.addActionListener(this);
        buttonPanel.add(start);

        pause = new JButton("Pause");
        pause.setSize(new Dimension(300, 300));
        pause.addActionListener(this);
        buttonPanel.add(pause);

        mainPanel.add(buttonPanel);
    }

    public void initPomoTimer() {
        pomo = new PomoTimer();
        pomoLabel = pomo.label;
        pomoLabel.setHorizontalAlignment(JLabel.CENTER);
        mainPanel.add(pomoLabel);
    }

    public void actionPerformed(ActionEvent e) {
      //  if (!pomo.doneTimer()) {
            if (e.getSource() == correct) {
                loadedDeck.removeCard(card);
                card = loadedDeck.getNextCard();
                questionString = card.getQuestion();
                answerString = card.getAnswer();
                question.setText(questionString);
                answer.setText(answerString);
                answer.setVisible(false);
            } else if (e.getSource() == wrong) {
                card = loadedDeck.getNextCard();
                questionString = card.getQuestion();
                question.setText(questionString);
                answerString = card.getAnswer();
                answer.setText(answerString);
                answer.setVisible(false);
            } else if (e.getSource() == showAnswer) {
                answer.setVisible(true);
            } else if (e.getSource() == start) {
                pomo.startTimer();
            } else if (e.getSource() == pause) {
                pomo.stopTimer();
            }
    //    }
    }

    public void loadDeck() {
        try {
            loadedDeck = jsonReader.readDeck();
            System.out.println("Loaded Deck from " + JSON_Save);
        } catch (IOException e) {
            System.out.println("Unable to read deck from file: " + JSON_Save);
        }
    }

}
