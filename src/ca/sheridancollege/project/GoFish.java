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
public class GoFish extends Game{
    private static final int SIZE_FISH = 52;
    private int numOfCards;
    private int numOfPlayers; 
    
    public GoFish (String name){
        super(name);
    }

    @Override
    public void play(Scanner sc){
        System.out.println("Welcome to the Go Fish Game!");
        this.numOfPlayers = validatedNumOfPlayers(sc);
        this.numOfCards = numOfCardsCalculator(numOfPlayers);
        playersAdding(sc, numOfPlayers, this);
        new GroupOfCardsFish(SIZE_FISH);
        new CardsOnGround(0);
        dealCardsToPlayers(); 
        giveTurns(sc);

    }
    
    public static int numOfCardsCalculator(int numOfPlayers){
        if(numOfPlayers >2 && numOfPlayers <= 7)
            return 5;
        else if(numOfPlayers == 2)
            return 7;
        return 0;
    }
    
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

    void dealCardsToPlayers() {
        this.getPlayers().forEach(eachPlayer -> {
            eachPlayer.playerDeal(numOfCards);
            ((GoFishPlayer)eachPlayer).checkWinCombinations();
        });    }

    public void giveTurns(Scanner sc){
        while(CardsOnGround.getCardsOnGround().size() <52){
            for (Player eachPlayer: getPlayers()){
                if (CardsOnGround.getCardsOnGround().size()>=52)
                    break;
                eachPlayer.play(this, sc);
                ((GoFishPlayer)eachPlayer).checkWinCombinations();
                System.out.println(CardsOnGround.getCardsOnGround().size() + " Cards on ground are currently\n" + CardsOnGround.getCardsOnGround());
                
                
               System.out.println("wins are " + ((GoFishPlayer)eachPlayer).getWinComb());

            }
        
         }
    }

}
