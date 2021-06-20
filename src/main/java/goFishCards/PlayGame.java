/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goFishCards;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Jake M
 */
public class PlayGame {
    public static void main(String[] args) {  // Testing my shuffling methods
        CardGenerator c = new CardGenerator(); // and everything
        
        Scanner in = new Scanner(System.in);
        Card[] deck = c.newDeck();
        List<Card> shuffled = new ArrayList<>(); 
        shuffled = c.shuffle(deck);
        //for (int i=0; i<shuffled.size(); i++)
        //System.out.println(i+1 + ": " + shuffled.get(i));
        
        System.out.print("-----------------------------------\n" // Testing
                + "Go Fish \nSelect players (1 2 3 4): \n");
        // try {
            int numOfPlayers = in.nextInt();
        // } catch (Exception ex) {
            // System.err.println("You must enter the number of player 1-4");
        // }
        // if (numOfPlayers > 4)
            // System.err.println("You can only play with 4 players MAX!");
        
        
    }
} // Testing my shuffling algorithm
