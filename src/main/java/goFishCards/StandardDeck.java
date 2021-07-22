/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goFishCards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Jake M
 */
public class StandardDeck {
    
    private final ArrayList<StandardCard> DECK_OF_CARDS;
    private Random r;
    private final int SIZE_OF_DECK = Value.values().length * Suit.values().length;
    
    public StandardDeck(){
        this.DECK_OF_CARDS = new ArrayList();
        for (int i = 0; i < SIZE_OF_DECK; i++)
        if (i < 13) 
                DECK_OF_CARDS.add(i, new StandardCard(Value.values()[i],Suit.values()[0]));
            else if (i < 26)
                DECK_OF_CARDS.add(i, new StandardCard(Value.values()[i-13],Suit.values()[1]));
            else if (i < 39)
                DECK_OF_CARDS.add(i, new StandardCard(Value.values()[i-26],Suit.values()[2]));
            else if (i < 52)
                DECK_OF_CARDS.add(i, new StandardCard(Value.values()[i-39],Suit.values()[3]));
    }
    
    public void shuffle(){ 
        for (int i=DECK_OF_CARDS.size(); i >= 1; i--) { 
            int randomIndex = r.nextInt(i);  
            Collections.swap(DECK_OF_CARDS, randomIndex, i-1); 
    }
    }
        
    public List<StandardCard> newHand(int numOfCards) {
        
        return DECK_OF_CARDS.subList(0, numOfCards-1);
    }
    
    public StandardCard drawCard(){
            StandardCard topCard = DECK_OF_CARDS.get(0);
            DECK_OF_CARDS.remove(0);
            return topCard;
        }
        
    public void addCard(StandardCard c){
        DECK_OF_CARDS.add(c);
    }
            
    public void burnTopCard(){
        DECK_OF_CARDS.remove(0);
    }
    
    
}
