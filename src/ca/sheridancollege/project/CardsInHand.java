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
class CardsInHand extends GroupOfCards{

    public CardsInHand(int size) {
        super(size);
        cardGenerator();
    }

    @Override
     public void cardGenerator(){
       
       for(int i=0; i<getSize(); i++){
           
          getCards().add(GroupOfCardsFish.getDeck().get(i));
          GroupOfCardsFish.getDeck().remove(i);
            
               
           }
       }

    
        
    
    
    
}
