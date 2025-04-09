package main.java.com.mycompany.wargame_group7;

import java.util.*;

public class WarGame extends Game {
    private final List<WarPlayer> players = new ArrayList<>();
    private GroupOfCards deck;
    private static final int MAX_ROUNDS = 26; // Game stops after 26 rounds

    public WarGame(String name) {
        super(name);
    }

    public void addPlayer(WarPlayer player) {
        players.add(player);
    }

    public void dealCards() {
        deck = new GroupOfCards();
        List<PlayingCard> cards = deck.getCards();
        int numPlayers = players.size();
        for (int i = 0; i < cards.size(); i++) {
            players.get(i % numPlayers).addCard(cards.get(i));
        }
    }

    @Override
    public void play() {
        System.out.println("=== Starting War Game ===");

        int round = 1;
        while (round <= MAX_ROUNDS && players.stream().filter(WarPlayer::hasCards).count() > 1) {
            System.out.println("Round " + round + " begins:");
            playRound();
            round++;
        }

        // Determine the winner after 26 rounds
        WarPlayer winner = determineWinner();
        System.out.println("Game over after " + MAX_ROUNDS + " rounds!");
        if (winner != null) {
            System.out.println(winner.getName() + " is the final winner with " + winner.getCardCount() + " cards!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    private void playRound() {
        List<Card> playedCards = new ArrayList<>();
        Map<Card, WarPlayer> cardOwnerMap = new HashMap<>();

        for (WarPlayer player : players) {
            if (player.hasCards()) {
                Card card = player.playCard();
                playedCards.add(card);
                cardOwnerMap.put(card, player);
                System.out.println(player.getName() + " plays: " + card);
            }
        }

        // Find the highest value card
        Card winningCard = playedCards.stream().max(Comparator.comparingInt(Card::getValue)).orElse(null);

        // Check for tie
        long maxCount = playedCards.stream().filter(c -> c.getValue() == winningCard.getValue()).count();
        if (maxCount > 1) {
            System.out.println("Tie detected! WAR! (not implemented yet)\n");
            // You can implement full war logic here
        } else {
            WarPlayer winner = cardOwnerMap.get(winningCard);
            System.out.println(winner.getName() + " wins the round!\n");
            for (Card c : playedCards) {
                winner.addCard(c);
            }
        }
    }

    private WarPlayer determineWinner() {
        return players.stream().max(Comparator.comparingInt(WarPlayer::getCardCount)).orElse(null);
    }
}
