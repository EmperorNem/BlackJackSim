package blackjacksim;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
    List<String> playerCards = new ArrayList<>();
    int score = 0;
    public Dealer(List<Card> playerCard) {
        for (Card card : playerCard) {
            playerCards.add(card.getCard());
            score = score + card.value;
        }
    }
    public void dealerAdd(Card dealtCard) {
        playerCards.add(dealtCard.getCard());
        score = score + dealtCard.value;
    }
    public void setScore() {
        score = 0;
    }
    public void getDealerCards() {
        System.out.print("Dealers cards: ");
        for (String card : playerCards) {
            System.out.println(card);
        }
    }
    public int getScore() {
        return score;
    }
}
