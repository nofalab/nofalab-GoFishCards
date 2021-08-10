/*
//SYST 17796 Project.- Go Fish
//Deliverable 3
//Date of submission: August 4, 2021
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * A class for the cards on in hand of each player that extends the group of cards     
 * @author Abdallah Nofal, Victor Vieira, Jacob Maltby, Imanuel Chatur
 */

class CardsInHand extends GroupOfCards{

    public CardsInHand(int size) {
        super(size);
        cardGenerator();
    }

    @Override
     public void cardGenerator(){
       
       for(int i=0; i<getSize(); i++){
           
          getCards().add(GroupOfCardsFish.getTheOnlyDeck().getCards().get(i));
          GroupOfCardsFish.getTheOnlyDeck().getCards().remove(i);
            
               
           }
       }  
}
