package blackjacksim;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
    List<Card> playerCards = new ArrayList<>();
    int hiddenVal = 0;
    public Dealer(List<Card> playerCard) {
        playerCards.addAll(playerCard);
    }
    public void dealerAdd(Card dealtCard) {
        playerCards.add(dealtCard);
    }
    public void dealerHidden(Card dealtCard) {
        playerCards.add(dealtCard);
    }
    public void getDealerCards() {
        System.out.print("Dealers cards: ");
        for (Card card : playerCards) {
            System.out.println(card.getCard());
        }
    }
    public int getScore() {
        int total = 0;
        int aceCount = 0;

        for (Card card : playerCards) {
            total += card.value;

            if (card.face.equals("A")) {
                aceCount++;
            }
        }
//        total += hiddenVal;

        while (total > 21 && aceCount > 0) {
            total -= 10;
            aceCount--;
        }

        return total;
    }
}
