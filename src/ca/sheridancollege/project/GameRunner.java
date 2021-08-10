/*
//SYST 17796 Project.- Go Fish
//Deliverable 3
//Date of submission: August 4, 2021
 */

package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main class to run whole game   
 * @author Abdallah Nofal, Victor Vieira, Jacob Maltby, Imanuel Chatur
 */

public class GameRunner {

    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in); 
        
        GoFish newFishGame = new GoFish("GoFish");
        
        newFishGame.play(sc);
        
        ArrayList<Player> players = newFishGame.getPlayers();
                 
        ArrayList<Player> winners = newFishGame.declareWinner(players);
        
        //if only one winner or tie, multiple players with same score!
        if (winners.size()==1){
          
        System.out.println("\n******************************************************"
                + "\nThe WINNER is : player " + winners.get(0).getName() + " with "
                        + ((GoFishPlayer) winners.get(0)).getWinComb() +" books."
                        + "\n******************************************************"
                        + "\n\nGeneral Statistics:\n\nThe scores for all: \n ");
        
        } else {
            System.out.println("\n******************************************************"
                + "\nTIE between the following players ");
                       
            for (Player eachWinner: winners){
                System.out.println("-"+ eachWinner.getName() + " with "
                        + ((GoFishPlayer) eachWinner).getWinComb() +" books.");
            }
            
            System.out.println("\n****************************************************"
                    + "**\n\nGeneral Statistics:\n\nThe scores for all: \n ");
            
        }
        for (Player eachPlayer: players){
                    System.out.println("Player " + eachPlayer.getName() + " has " + ((GoFishPlayer)eachPlayer).getWinComb() + " Wins");
                }             
      
        //Printing Statistics 
     
        int k=1;
        System.out.println("\nCompleted books are : \n");
        for (Card eachCard: CardsOnGround.getCardsOnGroundObj().getCards()){
                        System.out.println(k++ + " on Ground "+ eachCard);

        }
        
        System.out.println("\nRemaining cards with players are: \n");

        newFishGame.getPlayers().forEach(eachPlayer -> {
            System.out.println(eachPlayer);
            System.out.println((((GoFishPlayer)eachPlayer).getCardsInHand().getCards()).size() +" "+ ((GoFishPlayer)eachPlayer).getCardsInHand().getCards());
        });
        
        System.out.println("\nRemaining number of cards in the pile is: "
                + "" + GroupOfCardsFish.getTheOnlyDeck().getCards().size() + "\n\nWE PROUDLY "
                        + "MADE THIS GAME FROM SCRATCH, THANK YOU PROFESSOR!");

        
    }//End of Main Method
    
}
