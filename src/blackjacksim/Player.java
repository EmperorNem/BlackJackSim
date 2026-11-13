package blackjacksim;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Card> playerCards = new ArrayList<>();

    //Creates Player object when game starts initialized with the first 2 cards dealt
    public Player(List<Card> playerCard) {
        for (Card card : playerCard) {
            playerCards.add(card);
        }
    }

    public void playerAdd(Card dealtCard) {
        playerCards.add(dealtCard);
    }
    public void resetPlayer() {
        playerCards.clear();
    }
    public void getPlayerCards() {
        System.out.print("Players cards: ");
        for (Card card : playerCards) {
            System.out.println(card.getCard());
         }
    }
    //Dynamic Score to calculate aces
    public int getScore() {
        int total = 0;
        int aceCount = 0;

        for (Card card : playerCards) {
            total += card.value;

            if (card.face.equals("A")) {
                aceCount++;
            }
        }

        while (total > 21 && aceCount > 0) {
            total -= 10;
            aceCount--;
        }

        return total;
    }
}
