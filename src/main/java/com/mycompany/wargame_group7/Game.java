/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package main.java.com.mycompany.wargame_group7;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 
 * Date = 2025 - 02 - 13
 */
public abstract class Game {
    protected final String name;

    public Game(String name) {
        this.name = name;
    }

    public abstract void play();
}


