/*
//SYST 17796 Project.- Go Fish
//Deliverable 3
//Date of submission: August 4, 2021
 */
package ca.sheridancollege.project;
import java.util.ArrayList;
/**
 * A class that represents Go Fish Deck for Go Fish game. Extends GroupOfCards class   
 * @author Abdallah Nofal, Victor Vieira, Jacob Maltby, Imanuel Chatur
 */

public class GroupOfCardsFish extends GroupOfCards{
    
    //deck cards, set to static to call it by class name throught project
    private static ArrayList<Card> deck = new ArrayList<>();

    //constructor to creat, shuffle the deck
    public GroupOfCardsFish(int size) {
        super(size);
        cardGenerator();
        shuffle();
    }
    
    @Override
    public void cardGenerator(){
       
       for(int i=0; i<Suit.values().length; i++){
           for (int j=0; j<Value.values().length; j++){
               //creating cards and assign them to deck, for each suit we have 13, total 52 
               getCards().add(new StandardCard(Value.values()[j], Suit.values()[i])); 
               
           }
       }
       deck = getCards();
    }
    
    //getting deck cards, set to static to call it by class name throught project
    public static ArrayList<Card> getDeck() {
        return deck;
    }

    


    
    
    
    
}
