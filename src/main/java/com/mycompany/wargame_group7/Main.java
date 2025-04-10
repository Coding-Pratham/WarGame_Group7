/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.mycompany.wargame_group7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String response;

        do {
            WarGame game = new WarGame("War Card Game");

            game.addPlayer(new WarPlayer("P1"));
            game.addPlayer(new WarPlayer("P2"));

            game.dealCards();
            game.play();

            System.out.print("Do you want to play again? (yes/no): ");
            response = scanner.nextLine().trim().toLowerCase();
        } while (response.equals("yes"));

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}

