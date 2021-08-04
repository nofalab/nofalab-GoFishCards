/*
//SYST 17796 Project.- Go Fish
//Deliverable 3
//Date of submission: August 4, 2021
 */
package ca.sheridancollege.project;

/**
 * A class that represents Standard Card for Go Fish game. Extends Card class   
 * @author Abdallah Nofal, Victor Vieira, Jacob Maltby, Imanuel Chatur
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
