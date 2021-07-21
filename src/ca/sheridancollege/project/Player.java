package ca.sheridancollege.project;
import java.util.ArrayList;
public class Player extends Card{
    private int pNum;
    private String pName;
    public ArrayList<Card> hand = new ArrayList<Card>();
    private int books = 0;

    public Player(int pNum) {
        this.pNum = pNum;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }
    

    public int getpNum() {
        return pNum;
    }

    public void setpNum(int pNum) {
        this.pNum = pNum;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }
    
}