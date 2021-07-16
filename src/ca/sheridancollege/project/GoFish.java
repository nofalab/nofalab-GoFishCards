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
public class GoFish extends Game{
    
    public GoFish (String name){
        super(name);
    }
    
    @Override
    public void play(){
       
    }
    @Override
    public void declareWinner(){
    }
    
    @Override
    public void addPlayer(Player player){
        getPlayers().add(player);
    }


}
