package ca.sheridancollege.project;

public class Card {

//    private int value;
//    private String suit;
//    
//    //an array of possible suits
//    
//    public static final String[] SUITS={"Hearts","Diamonds","Spades","Clubs"};
//    
    
//    public enum Suit{
//        HEARTS,CLUBS, DIAMONDS, SPADES
//    }
//    public enum Value{
//     ACE,TWO,THREE,FOUR,FIVE, SIX,SEVEN,EIGHT,NINE, TEN ,JACK, QUEEN, KING 
//    }
    
    private Value value;
    private Suit suit;
    
    public Card(){
        
    }
    
    public Card(Value value, Suit suit)
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

    
}