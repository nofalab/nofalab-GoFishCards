/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author abdal
 */
public class GameRunner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in); 
        
        GoFish newFishGame = new GoFish("GoFish");
        
        newFishGame.play(sc);
        
        ArrayList<Player> players = newFishGame.getPlayers();
             
                 //TESTING PURPOSES 

        players.forEach(eachPlayer -> {
            System.out.println(eachPlayer);
            System.out.println(((GoFishPlayer)eachPlayer).getCardsInHand().getCards());

        });
         
        int o = 1;
        for (Card eachCard: GroupOfCardsFish.getDeck()){
            System.out.println(o++ + " "+ eachCard);
        }
        int s=1;
        
        for (Card eachCard: CardsOnGround.getCardsOnGround()){
                        System.out.println(s++ + " "+ eachCard);

        }
        
        newFishGame.getPlayers().forEach(eachPlayer -> {
            System.out.println(eachPlayer);
            System.out.println((((GoFishPlayer)eachPlayer).getCardsInHand().getCards()).size() +" "+ ((GoFishPlayer)eachPlayer).getCardsInHand().getCards());
        });
        //TESTING UP

         
        
        Player winnerIs = newFishGame.declareWinner(players);
          
        System.out.println("The big WINNER is : " + winnerIs + "\n with " + ((GoFishPlayer) winnerIs).getWinComb() +" books");
                          
        
         
        
        //TESTING PURPOSES
        int n = 1;
        for (Card eachCard: GroupOfCardsFish.getDeck()){
            System.out.println(n++ + " "+ eachCard);
        }
        int k=1;
        
        for (Card eachCard: CardsOnGround.getCardsOnGround()){
                        System.out.println(k++ + " GROUND "+ eachCard);

        }
        
        newFishGame.getPlayers().forEach(eachPlayer -> {
            System.out.println(eachPlayer);
            System.out.println((((GoFishPlayer)eachPlayer).getCardsInHand().getCards()).size() +" "+ ((GoFishPlayer)eachPlayer).getCardsInHand().getCards());

        });
               
        
        
        
    }//End of Main Method
    
    //Validity filter method for number of players that returns numOfCards 
}
