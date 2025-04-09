/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.mycompany.wargame_group7;

/**
 *
 * @author Solan
 */
public class Main {
    public static void main(String[] args) {
        WarGame game = new WarGame("War Card Game");

        game.addPlayer(new WarPlayer("P1"));
        game.addPlayer(new WarPlayer("P2"));

        game.dealCards();
        game.play();
    }
}

