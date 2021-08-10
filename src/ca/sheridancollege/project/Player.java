/*
//SYST 17796 Project.- Go Fish
//Deliverable 3
//Date of submission: August 4, 2021
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 * A class that models each Player in the game. Players have a name identifier, 
 * which should be unique.
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Megha Patel
 * @modifier Abdallah Nofal, Victor Vieira, Jacob Maltby, Imanuel Chatur

 */
public abstract class Player {

    private String name; //the unique name for this player

    /**
     * A constructor that allows you to set the player's unique ID/name
     *
     * @param name the unique ID to assign to this player.
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * @return the player name
     */
    public String getName() {
        return name;
    }

    /**
     * Ensure that the playerID is unique
     *
     * @param name the player name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The method to be overridden when you subclass the Player class with your specific type of Player and filled in
     * with logic to play your game.
     * @param newFishGame
     * @param sc
     * @param turnsCounter
     * @param booksLimit
     */
    public abstract void play(Game newFishGame, Scanner sc, int turnsCounter, int booksLimit);
    
    @Override
    public abstract String toString();

    public abstract void playerDeal(int numOfCards);

}
