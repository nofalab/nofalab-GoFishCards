/*
//SYST 17796 Project.- Go Fish
//Deliverable 3
//Date of submission: August 4, 2021
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class that represents Go Fish Game. Extends Game class   
 * @author Abdallah Nofal, Victor Vieira, Jacob Maltby, Imanuel Chatur
 */

public class GoFish extends Game{
    private int numOfCards;
    private int numOfPlayers; 
    
    public GoFish (String name){
        super(name);
    }

    //Game play method get num of players, num of dealt cards,....and iniating the game 
    @Override
    public void play(Scanner sc){
        int booksLimit = 52;
        System.out.println("\nWelcome to the Go Fish Game!\n");
        System.out.println("Do you want to set number of complete books after "
                + "which winner will be declared, or "
                + "continue until the end?\ncostumize ? Y/N");
            if ((sc.next().toUpperCase().charAt(0) == 'Y')){
                System.out.println("Please enter the number of books limit:");
                booksLimit = GeneUtilities.numValidator(sc, 1, 13);
                    
            } 
        System.out.println("Please enter number of players: ");
        this.numOfPlayers = GeneUtilities.numValidator(sc, 2, 7);
        this.numOfCards = numOfCardsCalculator(numOfPlayers);
        playersAdding(sc, numOfPlayers, this);
        GroupOfCardsFish.getTheOnlyDeck();
        //CardsOnGround GR = CardsOnGround.getCardsOnGroundObj(); not req, Singleton
        dealCardsToPlayers(); 
        giveTurns(sc, booksLimit);

    }
    
    //decides how many cards to be dealt to each player
    public static int numOfCardsCalculator(int numOfPlayers){
        if(numOfPlayers >2 && numOfPlayers <= 7)
            return 5;
        else if(numOfPlayers == 2)
            return 7;
        return 0;
    }
    
    
    
     //registering players into game with checking unique names 
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

    public void dealCardsToPlayers() {
        this.getPlayers().forEach(eachPlayer -> {
            eachPlayer.playerDeal(numOfCards);
            ((GoFishPlayer)eachPlayer).checkWinCombinations();
        });    }

    public void giveTurns(Scanner sc, int booksLimit){
        int turnsCounter = 0; 
        while(CardsOnGround.getCardsOnGroundObj().getCards().size() <booksLimit){
            for (Player eachPlayer: getPlayers()){
                if (CardsOnGround.getCardsOnGroundObj().getCards().size()>=booksLimit)
                    break;
                eachPlayer.play(this, sc, turnsCounter, booksLimit);
                //((GoFishPlayer)eachPlayer).checkWinCombinations();
                System.out.println(CardsOnGround.getCardsOnGroundObj().getCards().size() + " Cards on ground are currently\n" + CardsOnGround.getCardsOnGroundObj().getCards());
                
                
               System.out.println("wins are " + ((GoFishPlayer)eachPlayer).getWinComb());

            }
            turnsCounter++;
         }
    }

}
