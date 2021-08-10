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
        private static final int SIZE_GR = 0;

    //We apply singleton pattern as we only need to have only one object 

    private static CardsOnGround cardsOnGround = null;
    
    private CardsOnGround(int size){
        super(size);

    }

    @Override
    public void cardGenerator(){
        
    }
    
    public static CardsOnGround getCardsOnGroundObj() {
        if (cardsOnGround == null) {
            cardsOnGround = new CardsOnGround(SIZE_GR);

        }
        return cardsOnGround;
    }
}
