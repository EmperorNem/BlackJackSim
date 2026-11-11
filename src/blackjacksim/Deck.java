package blackjacksim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private ArrayList<Card> myDeck = new ArrayList<>();

    public Deck() {
        List<String> suits = Card.getSuits();

        List<String> faceNames = Card.getFaceNames();

        for (String suit : suits) {
            for (String faceName : faceNames) {
                myDeck.add(new Card(suit, faceName));
            }
        }
    }

    public ArrayList<Card> getMyDeck() {
        return myDeck;
    }

    public void shuffleDeck() {
        Collections.shuffle(myDeck);
    }

}
