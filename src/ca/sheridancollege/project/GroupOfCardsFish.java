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
public class GroupOfCardsFish extends GroupOfCards{
    private static ArrayList<Card> deck = new ArrayList<>();

    
    public GroupOfCardsFish(int size) {
        super(size);
        cardGenerator();
        shuffle();
    }
    
    @Override
    public void cardGenerator(){
       
       for(int i=0; i<Suit.values().length; i++){
           for (int j=0; j<Value.values().length; j++){
               
               getCards().add(new StandardCard(Value.values()[j], Suit.values()[i])); 
               
           }
       }
       deck = getCards();
    }
    
    public static ArrayList<Card> getDeck() {
        return deck;
    }

    


    
    
    
    
}
