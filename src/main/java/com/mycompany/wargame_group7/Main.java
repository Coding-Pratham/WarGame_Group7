
package main.java.com.mycompany.wargame_group7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String response;

        do {
            WarGame game = new WarGame("War Card Game");

            System.out.print("Enter name for Player 1: ");
            String player1Name = scanner.nextLine().trim();

            System.out.print("Enter name for Player 2: ");
            String player2Name = scanner.nextLine().trim();

            game.addPlayer(new WarPlayer(player1Name));
            game.addPlayer(new WarPlayer(player2Name));

            game.dealCards();
            game.play();

            System.out.print("Do you want to play again? (yes/no): ");
            response = scanner.nextLine().trim().toLowerCase();

        } while (response.equals("yes"));

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}

