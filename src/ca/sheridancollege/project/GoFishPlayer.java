/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author abdal
 */
class GoFishPlayer extends Player{
    
    private EnumSequence playerSequence;
    private CardsInHand cardsInHand;

    
    public GoFishPlayer (String name, int sequence){
        super(name);
        playerSequence = EnumSequence.values()[sequence-1];
    }

    @Override
    public void play(Game newFishGame) {
        ArrayList<Player> players = newFishGame.getPlayers();
        int currentIndex = players.indexOf(this);
        int nextIndex = (currentIndex+1 == players.size())? 0 : currentIndex +1; 
        
        System.out.println(getName() + ": What card rank would you like to "
                + "ask "+ players.get(nextIndex).getName() + "\nChoose the number "
                + "coressponds to your choice \n1)ACE, 2)TWO, 3)THREE, 4)FOUR, "
                + "5)FIVE, 6)SIX,7)SEVEN, 8)EIGHT, 9)NINE, 10)TEN , 11)JACK, "
                + "12)QUEEN, 13)KING"); 
    }
    

    @Override
    public String toString() {
        return "The " + getPlayerSequence().getDescrisption() + " of GoFish game is " 
                + this.getName();
    }

    @Override
    public void playerDeal(int numOfCards) {
        cardsInHand = new CardsInHand(numOfCards);
    }

    /**
     * @return the playerSequence
     */
    public EnumSequence getPlayerSequence() {
        return playerSequence;
    }

    /**
     * @return the cardsInHand
     */
    public CardsInHand getCardsInHand() {
        return cardsInHand;
    }
}
