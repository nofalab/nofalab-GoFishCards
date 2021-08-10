/*
//SYST 17796 Project.- Go Fish
//Deliverable 3
//Date of submission: August 4, 2021
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 * A class that represents Go Fish Player. Extends Player class   
 * @author Abdallah Nofal, Victor Vieira, Jacob Maltby, Imanuel Chatur
 */

class GoFishPlayer extends Player{
    
    //sequence id, cards in hand of each, and num of complete books /win
    private EnumSequence playerSequence;
    private CardsInHand cardsInHand;
    private int winComb;
    
    public GoFishPlayer (String name, int sequence){
        super(name);
        playerSequence = EnumSequence.values()[sequence-1];
    }

    @Override
    public void play(Game newFishGame, Scanner sc, int turnsCounter, int booksLimit) {
        
        ArrayList<Player> players = newFishGame.getPlayers();
        //geting index of tha player in player array 
        int currentIndex = players.indexOf(this);
        //flag 
        boolean goFish;
        //entry to retreive player to ask name 
        int playerToAsk;
        do {
            goFish=true;
            
            //if three players or more, we ask the player whom to ask for rank
            if(players.size()>2){
                System.out.println("Player "+ getName() +": Pick a player you want to ask for card rank "
                        + "(Please select the number corresponds to your selection): ");
                //listing other players by numbered list, excluding this player  
                int i =0;
                for (Player eachPlayer: players){
                    if (!eachPlayer.equals(this))
                        System.out.println(++i + ")" + eachPlayer.getName());
                }

            //method to handle if player chosses invalid entry, Ex, if total 4 
            //players, 1 to 3 only will be passed    
            playerToAsk = (GeneUtilities.numValidator(sc, 1, players.size()-1))-1;
            
            //code to ensure removing the current player from the sequence and rearrange
            if (playerToAsk>= currentIndex)
                playerToAsk += 1; 
            
            //if only two players in game no need to ask whom to ask, obvious!
            } else {
                playerToAsk = (currentIndex==0)? 1:0; 
            }               
            
            //option to show score so far 
            if (turnsCounter > 2){
            System.out.println("Player "+ getName() + ": would you like to "
                    + "show your score list so far? (y/n)");
            if ((sc.next().toUpperCase().charAt(0) == 'Y')){
                System.out.println("The score sheet is: \n");
                for (Player eachPlayer: players){
                    System.out.println("Player " + eachPlayer.getName() + " has " + ((GoFishPlayer)eachPlayer).getWinComb() + " Wins");
                }
                sc.nextLine();
                if (sc.nextLine().matches("")){};
            }
            }
            
            System.out.println("\n***********************************************"
                    + "****************\nPlayer "+ getName() + ": What card rank would you like to "
                    + "ask "+ players.get(playerToAsk).getName() + "\nChoose the number "
                    + "coressponds to your choice \n\n1)ACE, 2)TWO, 3)THREE, 4)FOUR, "
                    + "5)FIVE, 6)SIX, 7)SEVEN, 8)EIGHT, 9)NINE, 10)TEN , 11)JACK, "
                    + "12)QUEEN, 13)KING\n");
            
            //ALL CARDS LISTED FOR TESTING ONLY
            for (Player eachPlayer: players){
                System.out.println("CARDS for TESTING ONLY, To be removed later, For player \n " + eachPlayer.getName() );
                for (Card eachCard: ((GoFishPlayer) eachPlayer).cardsInHand.getCards()){
                    System.out.print(((StandardCard)eachCard).getValue() + " _ ");
                }
                System.out.println("");
                
            }
            
            //method to handle if player chosses invalid entry for value, 1-13 only 
            
            Value choice = Value.values()[GeneUtilities.numValidator(sc, 1, 13)-1];

            ArrayList<Card> otherPlayerCards = ((GoFishPlayer)players.get(playerToAsk)).getCardsInHand().getCards();
            
            //iterating through opponent cards to check for match. Then add the 
            //collected cards into this player and remove from opponent 
            Iterator<Card> it = otherPlayerCards.iterator();
            int cardsGained = 0;
            while(it.hasNext()){
                Card eachCard = it.next();
                
                if(((StandardCard)eachCard).getValue().equals(choice)){
                   this.getCardsInHand().getCards().add(eachCard);
                   it.remove();
                   goFish = false;
                   cardsGained++;
                }
            }
                if (cardsGained>0)
                   System.out.println("great, you made it, you gained " + cardsGained + " "
                           + "card(s) of rank " + choice.name() + ", keep going!");
               
                this.checkWinCombinations();
                        
            //if no match, then its Go fish and this player is asked to pick 
            //card from pile if any left 
            if (goFish){
                if (!GroupOfCardsFish.getTheOnlyDeck().getCards().isEmpty()){
                System.out.println("Player " + getName() + " You didn't guess "
                        + "valid number in other player's cards, so you need to"
                        + " press enter to draw from pile");
               
                //creating enter break "press enter to pick card"
                sc.nextLine();
                if (sc.nextLine().matches("")){};
                
                Card drawPile = GroupOfCardsFish.getTheOnlyDeck().getCards().get(0);
                System.out.println("Player " + getName() + ": you picked " + drawPile.toString());
                this.getCardsInHand().getCards().add(drawPile);
                GroupOfCardsFish.getTheOnlyDeck().getCards().remove(drawPile);
                
                //if player picks from pile matches his original rank he get to keep turn
                if (((StandardCard)drawPile).getValue().equals(choice)){
                    System.out.println("You're lucky! you picked matching rank "
                            + "from pile, you get to keep your turn.");
                    goFish=false;
                }
                }

            }
            turnsCounter++;
            if (CardsOnGround.getCardsOnGroundObj().getCards().size() >= booksLimit){
                break;
            }
        }while (!goFish);    
    }
       
    @Override
    public String toString(){
        return "The " + getPlayerSequence().getDescrisption() + " of GoFish "
                + "game is " + this.getName();
    }

    @Override
    public void playerDeal(int numOfCards) {
        cardsInHand = new CardsInHand(numOfCards);
    }

    /**
     * @return the playerSequence
     */
    public EnumSequence getPlayerSequence() {
        return playerSequence;
    }

    /**
     * @return the cardsInHand
     */
    public CardsInHand getCardsInHand() {
        return cardsInHand;
    }
    
    //Method to check winning or completed books, if success put them on ground 
    //and remove from hand.. This method took us forever!
    public void checkWinCombinations(){
       
        ArrayList<Card> thoseCards = this.getCardsInHand().getCards();
        ArrayList<Card> tempContainer = new ArrayList<>();
        ArrayList<Card> thoseCardsCopy = (ArrayList<Card>) thoseCards.clone();
        int k=0;
            
            for (int i=0; i<thoseCardsCopy.size()-1; i++){
                k=0;
                boolean repeated = false;

                for (Card eachCardGr: CardsOnGround.getCardsOnGroundObj().getCards()){
                    if (((StandardCard)eachCardGr).getValue().equals(((StandardCard)thoseCardsCopy.get(i)).getValue()) ){
                        repeated = true;
                        break;
                    }
                }
                if (!repeated){
                    for (int j=i+1; j<thoseCardsCopy.size(); j++){
                        if (((StandardCard)thoseCardsCopy.get(i)).getValue().equals(((StandardCard)thoseCardsCopy.get(j)).getValue())){
                            tempContainer.add(thoseCardsCopy.get(j));
                            k++;
                        }
                    }
                }
                if (k >= 3){
                winComb ++;
                tempContainer.add(thoseCardsCopy.get(i));
                thoseCards.removeAll(tempContainer);
                CardsOnGround.getCardsOnGroundObj().getCards().addAll(tempContainer);
                }
            }
  
            tempContainer.clear();
            }   
     
    public int getWinComb(){
        return winComb;
    }
  
}



