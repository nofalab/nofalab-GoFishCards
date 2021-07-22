/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goFishCards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Jake M
 */
public class CardGenerator {
    
    private StandardCard[] hand = new StandardCard[7];
    private StandardCard[] deck = new StandardCard[52];
    private List<StandardCard> newDeckOfCards = new ArrayList<StandardCard>();
    private List<StandardCard> shuffledDeck = new ArrayList<StandardCard>();
    
    public int randomNum(int max) {
        Random r = new Random();
        int n = r.nextInt(max);
        return n;
    }
    
    public void newStandardDeck() {
    for (int i=0; i<Value.values().length * Suit.values().length; i++)
            if (i < 13) 
                newDeckOfCards.add(i, new StandardCard(Value.values()[i],Suit.values()[0]));
            else if (i < 26)
                newDeckOfCards.add(i, new StandardCard(Value.values()[i-13],Suit.values()[1]));
            else if (i < 39)
                newDeckOfCards.add(i, new StandardCard(Value.values()[i-26],Suit.values()[2]));
            else if (i < 52)
                newDeckOfCards.add(i, new StandardCard(Value.values()[i-39],Suit.values()[3]));
        
}
    public void shuffle() { // Fisher–Yates shuffle
        shuffledDeck.addAll(newDeckOfCards);
        Random r = new Random(); 
        for (int i=shuffledDeck.size(); i >= 1; i--) { 
            int randomIndex = r.nextInt(i);  
            Collections.swap(shuffledDeck, randomIndex, i-1); 
        }                                                    
    }
    
    public List<StandardCard> newHand(List<StandardCard> shuffled) {
        Random r = new Random();
        List<StandardCard> newHand = new ArrayList<StandardCard>(7);
        for (int i=0; i<newHand.size(); i++){
            newHand.add(i,shuffled.get(i));
            shuffled.remove(i);
        }
        return newHand;
    }
    
    public StandardCard newCard(List<StandardCard> shuffled){
        StandardCard c = shuffled.get(0);
        shuffled.remove(0);
        return c;
        
    }
    
    public List<StandardCard> getShuffledDeck(){
        return this.shuffledDeck;
        
            
    }
    
}
