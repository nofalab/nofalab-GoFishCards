/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author abdal
 */
class GoFishPlayer extends Player{
    
    private EnumSequence playerSequence;
    private CardsInHand cardsInHand;
    private int winComb;
    
    public GoFishPlayer (String name, int sequence){
        super(name);
        playerSequence = EnumSequence.values()[sequence-1];
    }

    @Override
    public void play(Game newFishGame, Scanner sc) {
        ArrayList<Player> players = newFishGame.getPlayers();
        int currentIndex = players.indexOf(this);
        boolean goFish;
        int playerToAsk;
        do {
            goFish=true;
            if(players.size()>2){
                System.out.println("Player "+ getName() +": Pick a player you want to ask for card rank "
                        + "(Please select the number corresponds to your selection): ");
                int i =0;
                for (Player eachPlayer: players){
                    if (!eachPlayer.equals(this))
                        System.out.println(++i + ")" + eachPlayer.getName());
                }
                //error handling later
            playerToAsk = sc.nextInt()-1;
            if (playerToAsk>= currentIndex)
                playerToAsk += 1; 
            } else {
                playerToAsk = (currentIndex==0)? 1:0; 
            }               
            

            System.out.println("Player "+ getName() + ": What card rank would you like to "
                    + "ask "+ players.get(playerToAsk).getName() + "\nChoose the number "
                    + "coressponds to your choice \n1)ACE, 2)TWO, 3)THREE, 4)FOUR, "
                    + "5)FIVE, 6)SIX, 7)SEVEN, 8)EIGHT, 9)NINE, 10)TEN , 11)JACK, "
                    + "12)QUEEN, 13)KING");
            //do validity later of entry
            Value choice = Value.values()[sc.nextInt()-1];

            ArrayList<Card> otherPlayerCards = ((GoFishPlayer)players.get(playerToAsk)).getCardsInHand().getCards();

            //ArrayList<Card> toBeRemoved= new ArrayList();
            
            Iterator<Card> it = otherPlayerCards.iterator();
            while(it.hasNext()){
                Card eachCard = it.next();
                if(((StandardCard)eachCard).getValue().equals(choice)){
                   this.getCardsInHand().getCards().add(eachCard);
                   it.remove();
                   goFish = false;
                }
            }
    //        for (Card eachCard: otherPlayerCards){
    //            if(((StandardCard)eachCard).getValue().equals(choice)){
    //               this.getCardsInHand().getCards().add(eachCard);
    //               toBeRemoved.add(eachCard);
    //               goFish = false;
    //            }
    //            
    //        }
    //        otherPlayerCards.removeAll(toBeRemoved);
            if (goFish){
                System.out.println("Player " + getName() + " You didn't guess "
                        + "valid number in other player's cards, so you need to"
                        + " press enter to draw from pile");
                sc.nextLine();
                if (sc.nextLine().matches("")){};
                
                Card drawPile = GroupOfCardsFish.getDeck().get(0);
                System.out.println("Player " + getName() + ": you picked " + drawPile.toString());
                this.getCardsInHand().getCards().add(drawPile);
                GroupOfCardsFish.getDeck().remove(drawPile);
                if (((StandardCard)drawPile).getValue().equals(choice)){
                    System.out.println("You're lucky! you picked matching rank "
                            + "from pile, you get to keep your turn.");
                    goFish=false;
                }


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
    
    public void checkWinCombinations(){
       
        ArrayList<Card> thoseCards = this.getCardsInHand().getCards();

        ArrayList<Card> tempContainer = new ArrayList<>();
        boolean stillSearching;
        do{
        stillSearching = false;
        for (int i=0; i<thoseCards.size()-1; i++){
            tempContainer.removeAll(tempContainer);

            for (int j=i+1; j<thoseCards.size(); j++){
                if (((StandardCard)thoseCards.get(i)).getValue().equals(((StandardCard)thoseCards.get(j)).getValue())){
                    tempContainer.add(thoseCards.get(j));
                }
            }
            if (tempContainer.size() >= 3){
                tempContainer.add(thoseCards.get(i));
                Iterator<Card> iter = thoseCards.iterator();
            while(iter.hasNext()){
                Card eachCard = iter.next();
                if(((StandardCard)eachCard).getValue().equals(((StandardCard)thoseCards.get(i)).getValue())){
                   CardsOnGround.getCardsOnGround().add(eachCard);
                   iter.remove();
                   this.winComb +=1;
                   stillSearching = true;
                }
            }
            }
            if (stillSearching)
                break;
        }
        }while(stillSearching); 
        
    }

    /**
     * @return the winComb
     */
    public int getWinComb() {
        return winComb;
    }
}
