package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Sections.*;

public class AddCard implements ActionListener{
    public JFrame frame;
    public JFrame errorFrame;
    public JPanel panel;
    private JButton addButton;
    private JTextField questionField;
    private JTextField answerField;
    private JComboBox level;
    //Deck deck = new Deck();

    public AddCard() {
        initNewCardFrame();
    }

    public void initNewCardFrame() {
        panel = new JPanel(new GridBagLayout());
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.add(panel);
        // errorFrame = new JFrame();
         initTextFields();
         initDropDown();
         initNewCardButtons();
         addElementsToPanel();
    }

    public void initNewCardButtons() {
        addButton = new JButton("Add FlashCard");
        addButton.setSize(new Dimension(300, 300));
        addButton.addActionListener(this);
    }

    public void initTextFields() {
        questionField = new JTextField(20);
        answerField = new JTextField(20);
        questionField.setText(null);
        answerField.setText(null);
    }

    public void initDropDown() {
        String[] levels = { "Easy", "Medium", "Hard" };
        level = new JComboBox(levels);
        level.setSelectedIndex(2);
        level.addActionListener(this);
    }

    public void addElementsToPanel() {
        panel.add(addButton);
        panel.add(questionField);
        panel.add(answerField);
        panel.add(level);
        panel.add(level);
    }

// 	@Override
// 	public void actionPerformed(ActionEvent e) {
// 		if(e.getSource() == addButton){
//          //checkTextFields();
//          addNewCard();	   
//         }
		
// 	}
    
//     public void addButtonAction(){
//         addButton.addActionListener(new ActionListener(){
// 			@Override
// 			public void actionPerformed(ActionEvent e) {
// 			checkTextFields();
//             addNewCard();	
// 			}
            
//         });
//     }


// private void errorWindow(String string){
//     JOptionPane.showMessageDialog(errorFrame,string);
//     initTextFields();
// }

// private void checkTextFields(){
//     String question = questionField.getText();
//     String answer  = answerField.getText();
//     if(question.isEmpty()){
//         errorWindow("Please enter a valid question!");
//     }
//     if(answer.isEmpty()){
//         errorWindow("Please enter a valid answer!");
//     }
//     if(question.isEmpty() && answer.isEmpty()){
//         errorWindow("No question or answer entered!");
//     }
// }

// private void addNewCard(){
//     int levelNum = 0; 
//     if(level.getSelectedItem() == "Easy"){
//         levelNum = 1;
//     }
//     if(level.getSelectedItem() == "Medium"){
//         levelNum = 2;
//     }
//     if(level.getSelectedItem() == "Hard"){
//         levelNum = 3;
//     }
//     Card card = new Card(questionField.getText(), answerField.getText(), levelNum);
//     //deck.addCard(card);
// }


}
