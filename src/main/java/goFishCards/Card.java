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
public class Card {

   //private String suit; //clubs, spades, diamonds, hearts
   //private int value;//1-13

    public Card() {}
    
    /**
     * Constructor w/ parameters passed to the object
     * @param value
     * @param suit 
     */
    public Card(Value value, Suit suit) {
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
        Card c = (Card) o;
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
        return value + " of " + suit.name();
    }
}