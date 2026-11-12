package blackjacksim;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Card> playerCards = new ArrayList<>();
    int score = 0;

    //Creates Player object when game starts initialized with the first 2 cards dealt
    public Player(List<Card> playerCard) {
        for (Card card : playerCard) {
            playerCards.add(card);
            score = score + card.value;
        }
    }

    public void playerAdd(Card dealtCard) {
        playerCards.add(dealtCard);
        score += dealtCard.value;
    }
    public void resetPlayer() {
        score = 0;
        playerCards.clear();
    }
    public void getPlayerCards() {
        System.out.print("Players cards: ");
        for (Card card : playerCards) {
            System.out.println(card.getCard());
         }
    }
    public int getScore() {
        return score;
    }
}
