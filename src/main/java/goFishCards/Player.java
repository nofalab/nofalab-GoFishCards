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
public abstract class Player {
      
    private String name;
    private int playerNumber;
    private boolean isDealer;
    
    public Player(String name, int num){
        this.name = name;
        this.playerNumber=num;
    }
    
    /**
     * @return the isDealer
     */
    public boolean isIsDealer() {
        return isDealer;
    }

    /**
     * @param isDealer the isDealer to set
     */
    public void setIsDealer(boolean isDealer) {
        this.isDealer = isDealer;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the playerNumber
     */
    public int getPlayerNumber() {
        return playerNumber;
    }

    /**
     * @param playerNumber the playerNumber to set
     */
    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

   
    
}
