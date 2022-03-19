package Sections;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

// deck of cards 
public class Deck {
    String name;
    public List<Card> deck;
    private String DeckName;
    private int indexDeck;

    // initializes a deck
    public Deck() {
        deck = new ArrayList<>();
        indexDeck = 0;
    }

    public Deck(String name) {
        this.name = name;
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

    public Card getNextCard() {
        if (indexDeck++ == getDeckCount()) {
            indexDeck = 0;
        }
        return deck.get(indexDeck);
    }

    public void setDeckName(String name) {
        DeckName = name;
    }

    public JSONObject toJsonDeck() {
        JSONObject json = new JSONObject();
        json.put("DeckName", DeckName);
        json.put("Deck", arrayToJson());
        return json;
    }

    public JSONArray arrayToJson() {
        JSONArray arr = new JSONArray();

        for (Card c : deck) {
            arr.put(c.toJson());
        }

        return arr;
    }

    public Card getCard() {
        return deck.get(indexDeck);
    }
}