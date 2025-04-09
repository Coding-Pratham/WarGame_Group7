/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package main.java.com.mycompany.wargame_group7;

import main.java.com.mycompany.wargame_group7.Card;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 *@author GameMaster_Group7 
 * Date = 2025 - 03 - 20
 */
import java.util.*;

public class GroupOfCards {
    private final List<PlayingCard> cards = new ArrayList<>();

    public GroupOfCards() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        for (String suit : suits) {
            for (int i = 2; i <= 14; i++) {
                cards.add(new PlayingCard(i, suit));
            }
        }
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public List<PlayingCard> getCards() {
        return cards;
    }
}


    
