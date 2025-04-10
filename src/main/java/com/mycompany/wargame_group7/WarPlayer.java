/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.mycompany.wargame_group7;

import java.util.LinkedList;
import java.util.Queue;


public class WarPlayer extends Player {
    private final Queue<Card> hand = new LinkedList<>();

    public WarPlayer(String name) {
        super(name);
    }

    @Override
    public Card playCard() {
        return hand.poll();
    }

    @Override
    public void addCard(Card card) {
        hand.offer(card);
    }

    public void addCards(Queue<Card> cards) {
        hand.addAll(cards);
    }

    @Override
    public boolean hasCards() {
        return !hand.isEmpty();
    }

    public int getCardCount() {
        return hand.size();
    }
}
