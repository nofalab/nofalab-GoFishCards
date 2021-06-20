/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goFishCards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Jake M
 */
public class CardGenerator {
    
    Card[] hand = new Card[7];
    Card[] deck = new Card[52];
    
    
    public int randomNum(int max) {
        Random r = new Random();
        int n = r.nextInt(max);
        return n;
    }
    
    public Card[] newDeck() {
    for (int i=0; i<deck.length; i++)
            if (i < 13) 
                deck[i] = new Card(Value.values()[i],Suit.values()[0]);
            else if (i < 26)
                deck[i] = new Card(Value.values()[i-13],Suit.values()[1]);
            else if (i < 39)
                deck[i] = new Card(Value.values()[i-26],Suit.values()[2]);
            else if (i < 52)
                deck[i] = new Card(Value.values()[i-39],Suit.values()[3]);
        return deck;
}
    public List<Card> shuffle(Card[] deck){
        List<Card> shuffled = new ArrayList<Card>();
        shuffled.addAll(Arrays.asList(deck));
        Random r = new Random();
        for (int i=shuffled.size(), j=0; i >= 1; i--,j++) {
            int randomIndex = r.nextInt(i);
            Card fisher = shuffled.get(randomIndex);
            shuffled.remove(randomIndex);
            shuffled.add(shuffled.size()-j,fisher); 
        }
        return shuffled;
    }
    public List<Card> newHand(List<Card> shuffled) {
        Random r = new Random();
        List<Card> newHand = new ArrayList<Card>(7);
        for (int i=0; i<=newHand.size(); i++){
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
    
}
