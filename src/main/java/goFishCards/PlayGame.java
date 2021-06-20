/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goFishCards;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jake M
 */
public class PlayGame {
    public static void main(String[] args) {
        CardGenerator c = new CardGenerator();
        
        Card[] deck = c.newDeck();
        List<Card> shuffled = new ArrayList<>();
        shuffled = c.shuffle(deck);
        for (int i=0; i<shuffled.size(); i++)
        System.out.println(shuffled.get(i));
        
    }
}
