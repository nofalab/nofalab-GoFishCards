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
public class GoFish extends Game{
    
    public GoFish (String name){
        super(name);
    }

    @Override
    public void play(){
       
    }
    @Override
    public Player declareWinner(ArrayList<Player> players){
        Player winner = players.get(0);
        for (Player eachPlayer: players){
          if (((GoFishPlayer) eachPlayer).getWinComb() > ((GoFishPlayer) winner).getWinComb()){
              winner = eachPlayer;
          }
        }
        return winner;
    }
    
    @Override
    public void addPlayer(Player player){
        getPlayers().add(player);
    }


}
