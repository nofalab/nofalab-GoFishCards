/*
//SYST 17796 Project.- Go Fish
//Deliverable 3
//Date of submission: August 4, 2021
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * A class for the cards on ground extends the group of cards     
 * @author Abdallah Nofal, Victor Vieira, Jacob Maltby, Imanuel Chatur
 */
public class CardsOnGround extends GroupOfCards{
    private static ArrayList<Card> cardsOnGround = new ArrayList<>();
    
    public CardsOnGround(int size) {
        super(size);

    }

    @Override
    public void cardGenerator(){
        
    }
    
    public static ArrayList<Card> getCardsOnGround() {
        return cardsOnGround;
    }
}
