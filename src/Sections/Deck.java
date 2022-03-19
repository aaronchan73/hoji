package Sections;  
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

// deck of cards 
public class Deck { 

    public List<Card> deck;
    private String DeckName; 
    
    // initializes a deck 
    public Deck() { 
        deck = new ArrayList<>(); 
    }

    // add card to deck 
    public void addCard(Card card) { 
        if (!deck.contains(card)) {
            deck.add(card);
        }
    }

    // remove card to deck 
    public void removeCard(Card toRemove) { 
        if (deck.contains(toRemove)) {
            deck.remove(toRemove);
        }
    }

    // count of cards in deck 
    public int getDeckCount() { 
        return deck.size();
    }

    public Card getNextCard(int index) {
        return deck.get(index + 1);
    }

    public void setDeckName(String name) {
        DeckName = name;
    }

    // public JSONObject toJsonDeck() {
    //     JSONObject json = new JSONObject();
    //     json.put("DeckName", DeckName);
    //     json.put("Deck", arrayToJson());
    //     return json;
    // }   

    // public void arrayToJson() {

    // }
}