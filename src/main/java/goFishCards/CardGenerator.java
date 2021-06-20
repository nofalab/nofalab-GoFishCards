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
    
    private Card[] hand = new Card[7];
    private Card[] deck = new Card[52];
    private List<Card> newDeckOfCards = new ArrayList<Card>();
    private List<Card> shuffledDeck = new ArrayList<Card>();
    
    public int randomNum(int max) {
        Random r = new Random();
        int n = r.nextInt(max);
        return n;
    }
    
    public void newDeck() {
    for (int i=0; i<deck.length; i++)
            if (i < 13) 
                newDeckOfCards.add(i, new Card(Value.values()[i],Suit.values()[0]));
            else if (i < 26)
                newDeckOfCards.add(i, new Card(Value.values()[i-13],Suit.values()[1]));
            else if (i < 39)
                newDeckOfCards.add(i, new Card(Value.values()[i-26],Suit.values()[2]));
            else if (i < 52)
                newDeckOfCards.add(i, new Card(Value.values()[i-39],Suit.values()[3]));
        
}
    public void shuffle() { // Fisher–Yates shuffle
        shuffledDeck.addAll(newDeckOfCards);
        Random r = new Random(); 
        for (int i=shuffledDeck.size(); i >= 1; i--) { 
            int randomIndex = r.nextInt(i);  
            Collections.swap(shuffledDeck, randomIndex, i-1); 
        }                                                    
    }
    
    public List<Card> newHand(List<Card> shuffled) {
        Random r = new Random();
        List<Card> newHand = new ArrayList<Card>(7);
        for (int i=0; i<newHand.size(); i++){
            newHand.add(i,shuffled.get(i));
            shuffled.remove(i);
        }
        return newHand;
    }
    
    public Card newCard(List<Card> shuffled){
        Card c = shuffled.get(0);
        shuffled.remove(0);
        return c;
        
    }
    
    public List<Card> getShuffledDeck(){
        return this.shuffledDeck;
        
            
    }
    
}
