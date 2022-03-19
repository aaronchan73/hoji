import javax.swing.*;

public class ViewDeck extends JFrame {
    private JPanel panel1;
    private JButton Add;
    private JButton Delete;
    private JPanel ButtonPanel;
    private JPanel ScrollPanel;


    public ViewDeck() {
        setContentPane(panel1);
        setTitle("DeckView");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        ButtonPanel.setSize(500, 200);


    }
}
