/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

/**
 *
 * @author abdal
 */
public class StandardCard extends Card {
    
    private Value value;
    private Suit suit;
    
    public StandardCard(Value value, Suit suit)
    {
        this.value=value;
        this.suit=suit;
    }

    /**
     * @return the value
     */
    public Value getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Value value) {
        this.value = value;
    }

    /**
     * @return the suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * @param suit the suit to set
     */
    public void setSuit(Suit suit) {
        this.suit = suit;
    }

       
    @Override
    public String toString() {
        return "Card suit is " + getSuit() + " of a value of " + getValue();
    }
    
}
