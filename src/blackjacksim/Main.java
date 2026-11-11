package blackjacksim;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deck myDeck = new Deck();

        int choice;
        int dScore;
        int pScore;

        List<Card> playerCards = new ArrayList<>();
        List<Card> dealerCards = new ArrayList<>();

        //System.out.println(myDeck);

        //for (Card card : myDeck.getMyDeck()) { System.out.println(card.getCard()); }
        System.out.println("Welcome to the El Cino....");
        System.out.println("Either win big or well you don't");
        System.out.println("If your ready to play press 1");
        choice = sc.nextInt();

        if  (choice == 1) {
            myDeck.shuffleDeck();
            System.out.println("Welcome ready to play some black jack?");
            System.out.println("Dealing in 3... 2... 1...");

            playerCards.add(myDeck.getMyDeck().getFirst());
            myDeck.getMyDeck().removeFirst();

            dealerCards.add(myDeck.getMyDeck().getFirst());
            myDeck.getMyDeck().removeFirst();

            playerCards.add(myDeck.getMyDeck().getFirst());
            myDeck.getMyDeck().removeFirst();

            dealerCards.add(myDeck.getMyDeck().getFirst());
            myDeck.getMyDeck().removeFirst();

            Player p1 = new Player(playerCards);
            Dealer dealer = new Dealer(dealerCards);

            dealer.getDealerCards();
            p1.getPlayerCards();

            System.out.println("Dealer score: " + dealer.getScore());
            System.out.println("Player score: " + p1.getScore());

        }
    }
}