package main.java.com.mycompany.wargame_group7;

import java.util.*;

public class WarGame extends Game {
    private final List<WarPlayer> players = new ArrayList<>();
    private GroupOfCards deck;
    private static final int MAX_ROUNDS = 26;

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

        WarPlayer winner = determineWinner();
        System.out.println("Game over after " + MAX_ROUNDS + " rounds!");
        if (winner != null) {
            System.out.println(winner.getName() + " is the final winner with " + winner.getCardCount() + " cards!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    private void playRound() {
        Scanner scanner = new Scanner(System.in); // For player input

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

        Card winningCard = playedCards.stream().max(Comparator.comparingInt(Card::getValue)).orElse(null);
        long maxCount = playedCards.stream().filter(c -> c.getValue() == winningCard.getValue()).count();

        if (maxCount > 1) {
            System.out.println("WAR! Tie detected.\n");

            int highestValue = winningCard.getValue();
            List<WarPlayer> warPlayers = new ArrayList<>();
            for (Card c : playedCards) {
                if (c.getValue() == highestValue) {
                    warPlayers.add(cardOwnerMap.get(c));
                }
            }

            Map<Card, WarPlayer> warCardsMap = new HashMap<>();
            List<Card> warCards = new ArrayList<>();

            for (WarPlayer player : warPlayers) {
                System.out.println(player.getName() + " goes to WAR!");

                List<Card> warSet = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    if (player.hasCards()) {
                        Card card = player.playCard();
                        warSet.add(card);
                    }
                }

                if (warSet.size() == 0) continue;

                System.out.println(player.getName() + ", choose your face-up card from the following:");
                for (int i = 0; i < warSet.size(); i++) {
                    System.out.println((i + 1) + ": " + warSet.get(i));
                }

                int choice;
                do {
                    System.out.print("Enter the number of the card to play face-up: ");
                    while (!scanner.hasNextInt()) scanner.next();
                    choice = scanner.nextInt();
                } while (choice < 1 || choice > warSet.size());

                Card faceUpCard = warSet.remove(choice - 1);
                warCards.add(faceUpCard);
                warCardsMap.put(faceUpCard, player);

                // Remaining go into the pile
                warCards.addAll(warSet);
            }

            // Reveal all face-up cards chosen
            System.out.println("\nRevealing face-up cards:");
            for (Map.Entry<Card, WarPlayer> entry : warCardsMap.entrySet()) {
                System.out.println(entry.getValue().getName() + " chose: " + entry.getKey());
            }

            Card finalWarCard = warCardsMap.keySet().stream().max(Comparator.comparingInt(Card::getValue)).orElse(null);
            long finalWarCount = warCardsMap.keySet().stream().filter(c -> c.getValue() == finalWarCard.getValue()).count();

            if (finalWarCard != null && finalWarCount == 1) {
                WarPlayer warWinner = warCardsMap.get(finalWarCard);
                System.out.println("\n" + warWinner.getName() + " wins the WAR with the card: " + finalWarCard + "!\n");

                for (Card c : playedCards) warWinner.addCard(c);
                for (Card c : warCards) warWinner.addCard(c);

            } else {
                System.out.println("\nWAR tie again! Nobody wins this round.\n");
            }

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