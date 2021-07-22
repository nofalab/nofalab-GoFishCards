/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goFishCards;

/**
 *
 * @author Jake M
 */
public class StandardCard {

    public StandardCard() {}
    
    /**
     * Constructor w/ parameters passed to the object
     * @param value
     * @param suit 
     */
    public StandardCard(Value value, Suit suit) {
        this.suit = suit;
        this.value = value;
    }
    
    private Value value;
    private Suit suit;
    
    /**
     * 
     * @param o
     * @return Boolean of 2 card objects equal or not
     */
   public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null || o.getClass() != this.getClass())
            return false;
        StandardCard c = (StandardCard) o;
        return (c.getValue() == this.getValue() && c.getSuit() == this.getSuit());
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
    public String toString(){
        return value.name() + " of " + suit.name();
    }
}