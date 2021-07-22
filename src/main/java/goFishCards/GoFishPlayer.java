/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goFishCards;

import java.util.ArrayList;

/**
 *
 * @author Jake M
 */
public class GoFishPlayer extends Player {
    
    public GoFishPlayer(String name, int num){
        super(name,num);
        this.cardsInHand = new ArrayList<StandardCard>();
    }
    
    private ArrayList<StandardCard> cardsInHand;
    private int score;
    public int correctGuesses;
    public int totalGuesses;

    /**
     * @return the cardsInHand
     */
    public ArrayList<StandardCard> getCardsInHand() {
        return cardsInHand;
    }

    /**
     * @param cardsInHand the cardsInHand to set
     */
    public void setCardsInHand(ArrayList<StandardCard> cardsInHand) {
        this.cardsInHand = cardsInHand;
    }
    
    public int getScore(){
        return this.score;
    }
    
    public void setScore(int score){
        this.score = score;
    }
    
}
