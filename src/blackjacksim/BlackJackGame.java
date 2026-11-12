package blackjacksim;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackJackGame {
    Scanner sc = new Scanner(System.in);
    Deck myDeck = new Deck();

    int totalAcePlayer = 0;
    int totalAceDealer = 0;

    List<Card> playerCards = new ArrayList<>();
    List<Card> dealerCards = new ArrayList<>();

    public void startGame() {
        myDeck.shuffleDeck();
        System.out.println("Welcome ready to play some black jack?");
        System.out.println("Dealing in 3... 2... 1...");

        playerCards.add(myDeck.getMyDeck().getFirst());
        myDeck.getMyDeck().removeFirst();

        dealerCards.add(myDeck.getMyDeck().getFirst());
        myDeck.getMyDeck().removeFirst();

        playerCards.add(myDeck.getMyDeck().getFirst());
        myDeck.getMyDeck().removeFirst();

        Card hiddenCard = myDeck.getMyDeck().getFirst();
        myDeck.getMyDeck().removeFirst();

        //dealerCards.add(myDeck.getMyDeck().getFirst());
        myDeck.getMyDeck().removeFirst();

        if (dealerCards.getFirst().face == "A") {
            totalAceDealer++;
        }
        if (dealerCards.getLast().face == "A") {
            totalAceDealer++;
        }
        if (playerCards.getFirst().face == "A") {
            totalAcePlayer++;
        }
        if (playerCards.getLast().face == "A") {
            totalAcePlayer++;
        }

        Player p1 = new Player(playerCards);
        Dealer dealer = new Dealer(dealerCards);

        dealer.score += hiddenCard.value;

        dealer.getDealerCards();
        p1.getPlayerCards();

        if (totalAcePlayer == 1) {
            System.out.println("Choose 1 for " + p1.getScore() + " Choose 2 for " + (p1.getScore() - 10));
            int theChoice = sc.nextInt();
            if (theChoice == 1) {
                //Choice stays the same
            } else if (theChoice == 2) {
                p1.score -= 10;
            }
        }
        if (totalAcePlayer == 2) {
            System.out.println("Press 1 for Score: 2 Press 2 for Score: 13");
            int theChoice = sc.nextInt();
            if (theChoice == 1) {
                p1.score = 2;
            } else if (theChoice == 2) {
                p1.score = 13;
            }
        }

        if (p1.getScore() == 21) {
            System.out.println("You win!");
        }

        while (dealer.getScore() <= 21 && p1.getScore() <= 21) {
            System.out.println("Press 1 for hit, Press 2 for stay");
            int pick = sc.nextInt();
            if (pick == 1) {
                Card currCard = playerCards.getLast();
                if (currCard.face.equals("A") && p1.score < 11) {
                    System.out.println("Pick 1 for " + p1.score + " Press 2 for " + (p1.score - 10));
                    int aceValue = sc.nextInt();
                    if (aceValue == 1) {
                        p1.playerCards.add(currCard);
                        continue;
                    } else if (aceValue == 2) {
                        currCard.value = 1;
                        p1.playerAdd(currCard);
                    }
                }

                System.out.println("Player score: " + p1.getScore());
                if (p1.getScore() == 21) {
                    System.out.println("You Win!");
                }
            }
        }
    }
}