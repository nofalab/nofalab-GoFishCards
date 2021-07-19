/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author abdal
 */
public class CardsOnGround extends GroupOfCards{
    private static ArrayList<Card> cardsOnGround = new ArrayList<>();
    
    public CardsOnGround(int size) {
        super(size);

    }

    /**
     *
     */
    @Override
    public void cardGenerator(){
        
    }
    
    public static ArrayList<Card> getCardsOnGround() {
        return cardsOnGround;
    }
}
