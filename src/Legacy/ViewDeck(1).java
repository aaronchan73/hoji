// package UI;

// import Sections.*;
// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.util.*;

// public class ViewDeck implements ActionListener {
//     public JFrame viewDeck;
//     public JPanel viewPanel;
//     private JButton delete;
//     private JButton addCard;
//     private AddCard addCardWindow;
//     private Deck deckOfCards;
//     public static int WIDTH = 500;
//     public static int HEIGHT = 500;
//     //private static final String JSON_Save = "./data/BackEnd.json";
    
//     public ViewDeck() {
//         initViewDeck();
//         initButton();
//     }

//     public void initViewDeck() {
//         viewDeck = new JFrame();
//         viewPanel = new JPanel(new GridBagLayout());
//         viewDeck.setSize(WIDTH, HEIGHT);
//     }

//     public void actionPerformed(ActionEvent e) {
//         if (e.getSource() == addCard) {
//             addCardWindow = new AddCard();
//         }
//     }

//     public void initButton() {
//         delete = new JButton("Delete");
//         delete.addActionListener(this);
//         addCard = new JButton("Add Card");
//         addCard.addActionListener(this);
//         viewPanel.add(delete);
//         viewPanel.add(addCard);
//     }
// }
