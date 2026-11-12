package blackjacksim;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        BlackJackGame game = new BlackJackGame();

        System.out.println("Welcome to the El Cino....");
        System.out.println("Either win big or well you don't");
        System.out.println("If your ready to play press 1 or 0 if your a quitter");
        choice = sc.nextInt();

        while (choice != 0) {
            if (choice == 1) {
                game.startGame();
                System.out.println("If you want to play again press 1 or Press 2 if your a quitter");
                choice = sc.nextInt();
            }
            else if (choice == 2) {
                System.out.println("Thanks for playing!");
                System.exit(0);
            }
        }
    }
}