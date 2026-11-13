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

    public void restartGame() {
        playerCards.clear();
        dealerCards.clear();

        myDeck = new Deck();
        totalAcePlayer = 0;
        totalAceDealer = 0;

        startGame();

    }
    public void dealDelay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void startGame() {
        myDeck.shuffleDeck();
        System.out.println("Welcome ready to play some black jack?");
        System.out.print("Dealing in 3... ");
        dealDelay();
        System.out.print("2... ");
        dealDelay();
        System.out.print("1... ");
        dealDelay();
        System.out.println("Dealing!");

        playerCards.add(myDeck.getMyDeck().getFirst());
        myDeck.getMyDeck().removeFirst();
        System.out.println("Player Cards: " + playerCards.getFirst().getCard());

        dealDelay();

        dealerCards.add(myDeck.getMyDeck().getFirst());
        myDeck.getMyDeck().removeFirst();
        System.out.println("Dealer Cards: " + dealerCards.getFirst().getCard());

        dealDelay();

        playerCards.add(myDeck.getMyDeck().getFirst());
        myDeck.getMyDeck().removeFirst();
        System.out.println("Player Cards: " + playerCards.getFirst().getCard() + ", " + playerCards.getLast().getCard());

//        if (dealerCards.getFirst().face.equals("A")) {
//            totalAceDealer++;
//        }
//        if (dealerCards.getLast().face.equals("A")) {
//            totalAceDealer++;
//        }
//        if (playerCards.getFirst().face.equals("A")) {
//            totalAcePlayer++;
//        }
//        if (playerCards.getLast().face.equals("A")) {
//            totalAcePlayer++;
//        }
//
//        if (totalAcePlayer == 1) {
//            System.out.println("Player score is " + (playerCards.getFirst().value + playerCards.getLast().value) + " or player score is " + (playerCards.getFirst().value + playerCards.getLast().value - 10));
//        }
//        else if (totalAcePlayer == 2) {
//            System.out.println("Player score is 2 or 13");
//        }
//        else {
//            System.out.println("Player score is " + (playerCards.getFirst().value + playerCards.getLast().value));
//        }

        dealDelay();

        Card hiddenCard = myDeck.getMyDeck().getFirst();
        myDeck.getMyDeck().removeFirst();

        //dealerCards.add(myDeck.getMyDeck().getFirst());
        myDeck.getMyDeck().removeFirst();


        Player p1 = new Player(playerCards);
        Dealer dealer = new Dealer(dealerCards);

        dealer.hiddenVal += hiddenCard.value;
//        Calls cards to display to screen
//        dealer.getDealerCards();
//        p1.getPlayerCards();
        System.out.println("Player Score: " + p1.getScore());

//        System.out.println("Dealer Score: " + dealer.getScore());


        if (p1.getScore() == 21) {

            System.out.println("You win! \nScore: " + p1.getScore());
            dealDelay();
            System.out.println("Press 1 to play again, Press 2 to exit");
            int theChoice = sc.nextInt();
            if (theChoice == 1) {
                restartGame();
            }
            else if (theChoice == 2) {
                System.out.println("Thanks for playing!");
                dealDelay();
                System.exit(0);
            }
        }
        if (dealer.getScore() == 21 && p1.getScore() != 21) {
            System.out.println("Dealer Black Jack You Lose :(");
            dealDelay();
            System.out.println("Press 1 to play again, Press 2 to exit");
            int theChoice = sc.nextInt();
            if (theChoice == 1) {
                restartGame();
            }
            else if (theChoice == 2) {
                System.out.println("Thanks for playing!");
                dealDelay();
                System.exit(0);
            }
        }
        //Main Game Logic
        while (dealer.getScore() <= 21 && p1.getScore() <= 21) {
            System.out.println();
            System.out.println("Press 1 for hit, Press 2 to stand");
            int pick = sc.nextInt();
            if (pick == 1) {
                dealDelay();
                Card currCard = myDeck.getMyDeck().getFirst();
                myDeck.getMyDeck().removeFirst();
                System.out.println("Dealt Card: " +  currCard.getCard());

                if (currCard.value + p1.getScore() > 21) {
                    p1.playerAdd(currCard);
                    dealDelay();
                    p1.getPlayerCards();
                    dealDelay();
                    System.out.println("You Bust :( Score: " + p1.getScore());

                    System.out.println("Press 1 to play again, Press 2 to exit");
                    int theChoice = sc.nextInt();
                    if (theChoice == 1) {
                        restartGame();
                    }
                    else if (theChoice == 2) {
                        System.out.println("Thanks for playing!");
                        dealDelay();
                        System.exit(0);
                    }
                }
                else {
                    p1.playerAdd(currCard);
                    dealDelay();
                    dealer.getDealerCards();
                    dealDelay();
                    p1.getPlayerCards();
                    System.out.println("Score: " + p1.getScore());
                }

                if (p1.getScore() == 21) {
                    System.out.println("You Win!");
                    dealDelay();
                    System.out.println("Press 1 to play again, Press 2 to exit");
                    int theChoice = sc.nextInt();
                    if (theChoice == 1) {
                        restartGame();
                    }
                    else if (theChoice == 2) {
                        System.out.println("Thanks for playing!");
                        dealDelay();
                        System.exit(0);
                    }
                }
            }
            // Handles stand logic
            else if (pick == 2) {
                dealer.dealerHidden(hiddenCard);

                dealer.getDealerCards();
                System.out.println("Dealer Score: " + dealer.getScore());
                dealDelay();

                p1.getPlayerCards();
                System.out.println("Player Score: " + p1.getScore());
                dealDelay();

                if (p1.getScore() > dealer.getScore() && dealer.getScore() >= 17) {
                    System.out.println("You Win!");
                    dealDelay();
                    System.out.println("Press 1 to play again, Press 2 to exit");
                    int theChoice = sc.nextInt();
                    if (theChoice == 1) {
                        restartGame();
                    }
                    else if (theChoice == 2) {
                        System.out.println("Thanks for playing!");
                        dealDelay();
                        System.exit(0);
                    }
                }
                if (dealer.getScore() >= 17 && p1.getScore() == dealer.getScore()) {
                    System.out.println("Tie");
                    dealDelay();
                    System.out.println("Press 1 to play again, Press 2 to exit");
                    int theChoice1 = sc.nextInt();
                    if (theChoice1 == 1) {
                        restartGame();
                    }
                    else if (theChoice1 == 2) {
                        System.out.println("Thanks for playing!");
                        dealDelay();
                        System.exit(0);
                    }
                }
                else if (dealer.getScore() >= 17 && p1.getScore() < dealer.getScore()) {
                    System.out.println("You Lose :(");
                    dealDelay();
                    System.out.println("Press 1 to play again, Press 2 to exit");
                    int theChoice1 = sc.nextInt();
                    if (theChoice1 == 1) {
                        restartGame();
                    } else if (theChoice1 == 2) {
                        System.out.println("Thanks for playing!");
                        dealDelay();
                        System.exit(0);
                    } else {
                        continue;
                    }
                }

                while (dealer.getScore() < 17) {
                    Card currCard = myDeck.getMyDeck().getFirst();
                    myDeck.getMyDeck().removeFirst();

                    System.out.println();
                    dealer.dealerAdd(currCard);
                    System.out.println();
                    System.out.println("Dealt Card: " +  currCard.getCard());

                    dealDelay();
                    dealer.getDealerCards();
                    System.out.println("Dealer Score: " + dealer.getScore());

                    dealDelay();
                    p1.getPlayerCards();
                    System.out.println("Player Score: " + p1.getScore());

                    if (dealer.getScore() > 21) {
                        System.out.println("Dealer Bust You Win!");
                        dealDelay();
                        System.out.println("Press 1 to play again, Press 2 to exit");
                        int theChoice2 = sc.nextInt();
                        if (theChoice2 == 1) {
                            restartGame();
                        } else if (theChoice2 == 2) {
                            System.out.println("Thanks for playing!");
                            dealDelay();
                            System.exit(0);
                        }
                    } else if (dealer.getScore() >= 17 && p1.getScore() > dealer.getScore()) {
                        System.out.println("You Win!");
                        dealDelay();
                        System.out.println("Press 1 to play again, Press 2 to exit");
                        int theChoice2 = sc.nextInt();
                        if (theChoice2 == 1) {
                            restartGame();
                        } else if (theChoice2 == 2) {
                            System.out.println("Thanks for playing!");
                            dealDelay();
                            System.exit(0);
                        }
                    }
                    else if (dealer.getScore() == p1.getScore()) {
                        System.out.println("Tie");
                        dealDelay();
                        System.out.println("Press 1 to play again, Press 2 to exit");
                        int theChoice2 = sc.nextInt();
                        if (theChoice2 == 1) {
                            restartGame();
                        } else if (theChoice2 == 2) {
                            System.out.println("Thanks for playing!");
                            dealDelay();
                            System.exit(0);
                        }
                    }
                    else if (dealer.getScore() >= p1.getScore() && dealer.getScore() >= 17) {
                        System.out.println("You Lose :(");
                        dealDelay();
                        System.out.println("Press 1 to play again, Press 2 to exit");
                        int theChoice2 = sc.nextInt();
                        if (theChoice2 == 1) {
                            restartGame();
                        } else if (theChoice2 == 2) {
                            System.out.println("Thanks for playing!");
                            dealDelay();
                            System.exit(0);
                        }
                    }
                }
                break;
            }
        }
    }
}