/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.sheridancollege.project;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Imanuel
 */
public class CardGame {
    public static int HAND_SIZE = 5;

   
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        ArrayList<Card> deck = DeckGenerator.generateDeck();
        
        System.out.println("How many players are in the game?");
        int players = input.nextInt();
     
        Player[] pList = new Player[players];
        
        /**
         * Deck Dealer
         * Takes the amount of players as a list (doesn't change) and will
         * assign a player number along with a hand of cards.
         * Will also remove the card from the deck in order to make it more
         * realistic.
         */
        for(int i = 0; i < players; i++){
            pList[i] = new Player(i + 1);
            System.out.printf("PLAYER %d ENTER NAME: ",i + 1);
            pList[i].setpName(input.next());
            System.out.println(pList[i].getpName() + " " + pList[i].getpNum());
            for(int x = 0; x < HAND_SIZE; x++){
                //Get random card from deck, get its value and suit, then remove it
                
                int randCard = (int)(Math.random() * deck.size());
                Value randVal = deck.get(randCard).getValue();
                Suit randSuit = deck.get(randCard).getSuit();
                deck.remove(randCard);
                
                pList[i].hand.add(new Card(randVal,randSuit));
                System.out.printf("%s of %s\n",pList[i].hand.get(x).getValue()
                        ,pList[i].hand.get(x).getSuit());
            }
        }
        
    }

}
