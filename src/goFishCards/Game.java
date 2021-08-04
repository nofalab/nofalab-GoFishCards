/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goFishCards;


/**
 * @author Jacob
 */
public abstract class Game {


    private String name;

    public Game() {
    }

    public Game(String name) {
        this.name = name;

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


    public abstract void playGame();

}
