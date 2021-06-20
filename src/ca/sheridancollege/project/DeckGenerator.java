package ca.sheridancollege.project;

import java.util.ArrayList;

public class DeckGenerator{
    public static ArrayList<Card> generateDeck(){
        ArrayList<Card> deck = new ArrayList<Card>();
        
        //Generate deck
        for(int i = 0; i <= Suit.values().length -1; i++){
            for(int x = 0; x <= Value.values().length-1; x++){
                //deck[x] = new Card(Value.values()[x], Suit.values()[i]);
                deck.add(new Card(Value.values()[x], Suit.values()[i]));
                //System.out.printf("%s of %s\n",deck[x].getValue(),deck[x].getSuit());
            }
            
        }
        return deck;
    }
}