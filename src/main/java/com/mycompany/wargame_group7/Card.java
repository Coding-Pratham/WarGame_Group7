/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package main.java.com.mycompany.wargame_group7;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author GameMaster_Group7 
 * Date = 2025 - 03- 20
 */
public abstract class Card {
    public abstract int getValue();
    public abstract String getSuit();
    public abstract String toString();
}