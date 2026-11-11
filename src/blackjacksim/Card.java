package blackjacksim;
import java.util.Arrays;
import java.util.List;

public class Card {
    private static final String[] faceNames = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private static final String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};

    String suit;
    String face;
    int value;
    public Card(String suit, String face) {
        this.suit = suit;
        this.face = face;
        if (this.face.equals("J") || this.face.equals("Q") || this.face.equals("K")) {
            this.value = 10;
        }
        else if (this.face.equals("A")) {
            this.value = 11;
        }
        else {
            this.value = Integer.parseInt(this.face);
        }

    }

    public static List<String> getSuits() {
        return Arrays.asList(suits);
    }
    public static List<String> getFaceNames() {
        return Arrays.asList(faceNames);
    }

    public String getCard() {
        return this.face + " of " + this.suit;
    }

}
