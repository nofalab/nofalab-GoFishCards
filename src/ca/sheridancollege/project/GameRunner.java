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
    public static final int SIZE_FISH = 52;
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in); 
        System.out.println("Welcome to the Go Fish Game!");
        int numOfPlayers = validatedNumOfPlayers(sc);
        int numOfCards = numOfCardsCalculator(numOfPlayers);
        GoFish newFishGame = new GoFish("GoFish");

        playersAdding(sc, numOfPlayers, newFishGame);
        
        new GroupOfCardsFish(SIZE_FISH);
        new CardsOnGround(0);
        ArrayList<Card> deck = GroupOfCardsFish.getDeck();
        ArrayList<Player> players = newFishGame.getPlayers();
        players.forEach(eachPlayer -> {
            eachPlayer.playerDeal(numOfCards);
            ((GoFishPlayer)eachPlayer).checkWinCombinations();
        });
        
        
         newFishGame.getPlayers().forEach(eachPlayer -> {
            System.out.println(eachPlayer);
            System.out.println(((GoFishPlayer)eachPlayer).getCardsInHand().getCards());

        });
         
         //TESTING PURPOSES
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
//TESTING UP
        });
        int t = 0;
         while(t !=5){
            for (Player eachPlayer: players){
            eachPlayer.play(newFishGame, sc);
            ((GoFishPlayer)eachPlayer).checkWinCombinations();
               System.out.println("wins are " + ((GoFishPlayer)eachPlayer).getWinComb());

            }
            t++;
         }     
                    
        
         
        
        //TESTING PURPOSES
        int n = 1;
        for (Card eachCard: GroupOfCardsFish.getDeck()){
            System.out.println(n++ + " "+ eachCard);
        }
        int k=1;
        
        for (Card eachCard: CardsOnGround.getCardsOnGround()){
                        System.out.println(k++ + " "+ eachCard);

        }
        
        newFishGame.getPlayers().forEach(eachPlayer -> {
            System.out.println(eachPlayer);
            System.out.println((((GoFishPlayer)eachPlayer).getCardsInHand().getCards()).size() +" "+ ((GoFishPlayer)eachPlayer).getCardsInHand().getCards());

        });
               
        
        
        
    }//End of Main Method
    
    //Validity filter method for number of players that returns numOfCards 
    public static int validatedNumOfPlayers(Scanner sc){
        int num = 0;
        String strNum;
        
        do {
            System.out.println("Please enter number of players: ");
            strNum = sc.next();
            if (strNum.matches("-?\\d+")){
                num = Integer.parseInt(strNum);
                if (num >=2 && num <=7){
                    return num;
                } 
                else 
                    System.out.print("Game can not be played with less than 2 "
                            + "or more than 7 players, please try again\n");
            } else
                System.out.print("number of players can not be letters\n");
        }while (!strNum.matches("-?\\d+") || num<2 || num>7 );
        return 0;

    }
    
    public static int numOfCardsCalculator(int numOfPlayers){
        if(numOfPlayers >2 && numOfPlayers <= 7)
            return 5;
        else if(numOfPlayers == 2)
            return 7;
        return 0;
    }
    
   
    public static void playersAdding(Scanner sc, int numOfPlayers, Game newGame){

        for (int i=1; i<=numOfPlayers; i++){
            String name; 
            boolean matchFound;
            do {  
                matchFound = false;
                System.out.println("The " + EnumSequence.values()[i-1].
                    getDescrisption() + ", Please provide your name: ");
                
                name = sc.next();
                
                for (Player eachPlayer: newGame.getPlayers()) {
                    if (name.equals(eachPlayer.getName())){
                        matchFound = true;
                        System.out.println("The name is repeated, please use "
                                + "other name or add suffix");
                        break; 
                    }
                }
                
            }while (matchFound);
             GoFishPlayer player = new GoFishPlayer(name, i);

                newGame.addPlayer(player);
        }
    }
}
