
package main.java.com.mycompany.wargame_group7;

import main.java.com.mycompany.wargame_group7.GroupOfCards;
import main.java.com.mycompany.wargame_group7.Card;
import java.util.ArrayList;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
  Date = 2025 - 03 - 20
 */
public abstract class Player {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract Card playCard();
    public abstract void addCard(Card card);
    public abstract boolean hasCards();
}

