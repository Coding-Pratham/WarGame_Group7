/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.mycompany.wargame_group7;


public class PlayingCard extends Card {
    private final int value; // 2 to 14 (Ace = 14)
    private final String suit;

    public PlayingCard(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return valueToString() + " of " + suit;
    }

    private String valueToString() {
    switch (value) {
        case 11:
            return "Jack";
        case 12:
            return "Queen";
        case 13:
            return "King";
        case 14:
            return "Ace";
        default:
            return String.valueOf(value);
    }
}

}

